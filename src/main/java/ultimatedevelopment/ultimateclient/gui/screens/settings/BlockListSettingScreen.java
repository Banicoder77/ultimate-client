/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.screens.settings;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.screens.settings.base.CollectionListSettingScreen;
import ultimatedevelopment.ultimateclient.gui.widgets.WWidget;
import ultimatedevelopment.ultimateclient.settings.BlockListSetting;
import ultimatedevelopment.ultimateclient.utils.misc.Names;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;

public class BlockListSettingScreen extends CollectionListSettingScreen<Block> {
    public BlockListSettingScreen(GuiTheme theme, BlockListSetting setting) {
        super(theme, "Select Blocks", setting, setting.get(), Registries.BLOCK);
    }

    @Override
    protected boolean includeValue(Block value) {
        if (Registries.BLOCK.getId(value).getPath().endsWith("_wall_banner")) {
            return false;
        }

        Predicate<Block> filter = ((BlockListSetting) setting).filter;

        if (filter == null) return value != Blocks.AIR;
        return filter.test(value);
    }

    @Override
    protected WWidget getValueWidget(Block value) {
        return theme.itemWithLabel(value.asItem().getDefaultStack(), Names.get(value));
    }

    @Override
    protected String[] getValueNames(Block value) {
        return new String[]{
            Names.get(value),
            Registries.BLOCK.getId(value).toString()
        };
    }

    @Override
    protected Block getAdditionalValue(Block value) {
        String path = Registries.BLOCK.getId(value).getPath();
        if (!path.endsWith("_banner")) return null;

        return Registries.BLOCK.get(Identifier.ofVanilla(path.substring(0, path.length() - 6) + "wall_banner"));
    }
}
