/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient;

import ultimatedevelopment.ultimateclient.addons.AddonManager;
import ultimatedevelopment.ultimateclient.addons.UltimateAddon;
import ultimatedevelopment.ultimateclient.events.game.OpenScreenEvent;
import ultimatedevelopment.ultimateclient.events.ultimate.KeyEvent;
import ultimatedevelopment.ultimateclient.events.ultimate.MouseClickEvent;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.gui.GuiThemes;
import ultimatedevelopment.ultimateclient.gui.WidgetScreen;
import ultimatedevelopment.ultimateclient.gui.tabs.Tabs;
import ultimatedevelopment.ultimateclient.systems.Systems;
import ultimatedevelopment.ultimateclient.systems.config.Config;
import ultimatedevelopment.ultimateclient.systems.hud.screens.HudEditorScreen;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.misc.DiscordPresence;
import ultimatedevelopment.ultimateclient.utils.PostInit;
import ultimatedevelopment.ultimateclient.utils.PreInit;
import ultimatedevelopment.ultimateclient.utils.ReflectInit;
import ultimatedevelopment.ultimateclient.utils.Utils;
import ultimatedevelopment.ultimateclient.utils.misc.Version;
import ultimatedevelopment.ultimateclient.utils.misc.input.KeyAction;
import ultimatedevelopment.ultimateclient.utils.misc.input.KeyBinds;
import ultimatedevelopment.ultimateclient.utils.network.OnlinePlayers;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.EventHandler;
import meteordevelopment.orbit.EventPriority;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.io.File;
import java.lang.invoke.MethodHandles;

public class UltimateClient implements ClientModInitializer {
    public static final String MOD_ID = "ultimate-client";
    public static final ModMetadata MOD_META;
    public static final String NAME;
    public static final Version VERSION;
    public static final String BUILD_NUMBER;

    public static UltimateClient INSTANCE;
    public static UltimateAddon ADDON;

    public static MinecraftClient mc;
    public static final IEventBus EVENT_BUS = new EventBus();
    public static final File FOLDER = FabricLoader.getInstance().getGameDir().resolve(MOD_ID).toFile();
    public static final Logger LOG;

    static {
        MOD_META = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().getMetadata();

        NAME = MOD_META.getName();
        LOG = LoggerFactory.getLogger(NAME);

        String versionString = MOD_META.getVersion().getFriendlyString();
        if (versionString.contains("-")) versionString = versionString.split("-")[0];

        // When building and running through IntelliJ and not Gradle it doesn't replace the version so just use a dummy
        if (versionString.equals("${version}")) versionString = "0.0.0";

        VERSION = new Version(versionString);
        BUILD_NUMBER = MOD_META.getCustomValue(UltimateClient.MOD_ID + ":build_number").getAsString();
    }

    @Override
    public void onInitializeClient() {
        if (INSTANCE == null) {
            INSTANCE = this;
            return;
        }

        // Global minecraft client accessor
        mc = MinecraftClient.getInstance();

        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            LOG.info("Force loading mixins");
            MixinEnvironment.getCurrentEnvironment().audit();
        }

        LOG.info("Initializing {}", NAME);

        // Pre-load
        if (!FOLDER.exists()) {
            FOLDER.getParentFile().mkdirs();
            FOLDER.mkdir();
            Systems.addPreLoadTask(() -> Modules.get().get(DiscordPresence.class).enable());
        }

        // Register addons
        AddonManager.init();

        // Register event handlers
        AddonManager.ADDONS.forEach(addon -> {
            try {
                EVENT_BUS.registerLambdaFactory(addon.getPackage(), (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
            } catch (AbstractMethodError e) {
                throw new RuntimeException("Addon \"%s\" is too old and cannot be ran.".formatted(addon.name), e);
            }
        });

        // Register init classes
        ReflectInit.registerPackages();

        // Pre init
        ReflectInit.init(PreInit.class);

        // Register module categories
        Categories.init();

        // Load systems
        Systems.init();

        // Subscribe after systems are loaded
        EVENT_BUS.subscribe(this);

        // Initialise addons
        AddonManager.ADDONS.forEach(UltimateAddon::onInitialize);

        // Sort modules after addons have added their own
        Modules.get().sortModules();

        // Load configs
        Systems.load();

        // Post init
        ReflectInit.init(PostInit.class);

        // Save on shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            OnlinePlayers.leave();
            Systems.save();
            GuiThemes.save();
        }));
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.currentScreen == null && mc.getOverlay() == null && KeyBinds.OPEN_COMMANDS.wasPressed()) {
            mc.setScreen(new ChatScreen(Config.get().prefix.get(), true));
        }
    }

    @EventHandler
    private void onKey(KeyEvent event) {
        if (event.action == KeyAction.Press && KeyBinds.OPEN_GUI.matchesKey(event.input)) {
            toggleGui();
        }
    }

    @EventHandler
    private void onMouseClick(MouseClickEvent event) {
        if (event.action == KeyAction.Press && KeyBinds.OPEN_GUI.matchesMouse(event.click)) {
            toggleGui();
        }
    }

    private void toggleGui() {
        if (Utils.canCloseGui()) mc.currentScreen.close();
        else if (Utils.canOpenGui()) Tabs.get().getFirst().openScreen(GuiThemes.get());
    }

    // Hide HUD

    private boolean wasWidgetScreen, wasHudHiddenRoot;

    @EventHandler(priority = EventPriority.LOWEST)
    private void onOpenScreen(OpenScreenEvent event) {
        if (event.screen instanceof WidgetScreen) {
            if (!wasWidgetScreen) wasHudHiddenRoot = mc.options.hudHidden;
            if (GuiThemes.get().hideHUD() || wasHudHiddenRoot) {
                // Always show the MC HUD in the HUD editor screen since people like
                // to align some items with the hotbar or chat
                mc.options.hudHidden = !(event.screen instanceof HudEditorScreen);
            }
        } else {
            if (wasWidgetScreen) mc.options.hudHidden = wasHudHiddenRoot;
            wasHudHiddenRoot = mc.options.hudHidden;
        }

        wasWidgetScreen = event.screen instanceof WidgetScreen;
    }

    public static Identifier identifier(String path) {
        return Identifier.of(UltimateClient.MOD_ID, path);
    }
}
