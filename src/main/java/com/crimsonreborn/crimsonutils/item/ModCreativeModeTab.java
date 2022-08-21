package com.crimsonreborn.crimsonutils.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * Created by Furt on 08/21/2022
 */
public class ModCreativeModeTab {
    public static final CreativeModeTab CRIMSONUTILS_TAB = new CreativeModeTab("crimsonutilstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.HEARTHSTONE.get());
        }
    };
}
