/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.systems.modules;

import ultimatedevelopment.ultimateclient.addons.AddonManager;
import ultimatedevelopment.ultimateclient.addons.UltimateAddon;
import net.minecraft.item.Items;

public class Categories {
    public static final Category Combat = new Category("Combat", Items.GOLDEN_SWORD.getDefaultStack());
    public static final Category Player = new Category("Player", Items.ARMOR_STAND.getDefaultStack());
    public static final Category Movement = new Category("Movement", Items.DIAMOND_BOOTS.getDefaultStack());
    public static final Category Render = new Category("Render", Items.GLASS.getDefaultStack());
    public static final Category World = new Category("World", Items.GRASS_BLOCK.getDefaultStack());
    public static final Category Exploit = new Category("Exploit", Items.COMMAND_BLOCK.getDefaultStack());
    public static final Category Fun = new Category("Fun", Items.JUKEBOX.getDefaultStack());
    public static final Category Misc = new Category("Misc", Items.LAVA_BUCKET.getDefaultStack());

    public static boolean REGISTERING;

    public static void init() {
        REGISTERING = true;

        // Ultimate
        Modules.registerCategory(Combat);
        Modules.registerCategory(Player);
        Modules.registerCategory(Movement);
        Modules.registerCategory(Render);
        Modules.registerCategory(World);
        Modules.registerCategory(Exploit);
        Modules.registerCategory(Fun);
        Modules.registerCategory(Misc);

        // Addons
        AddonManager.ADDONS.forEach(UltimateAddon::onRegisterCategories);

        REGISTERING = false;
    }
}
