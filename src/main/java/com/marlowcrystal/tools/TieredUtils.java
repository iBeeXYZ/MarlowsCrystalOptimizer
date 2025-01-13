package com.marlowcrystal.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility methods for tool tier operations.
 */
public final class TieredUtils {

    private static final Map<Item, ToolTier> ITEM_TO_TIER_MAP = new HashMap<>();

    static {
        registerToolTiers();
    }

    private TieredUtils() {
        // Prevent instantiation
    }

    /**
     * Registers tool tiers for items.
     */
    private static void registerToolTiers() {
        // Wooden tools
        registerTier(Items.WOODEN_AXE, ToolTier.WOOD);
        registerTier(Items.WOODEN_PICKAXE, ToolTier.WOOD);
        registerTier(Items.WOODEN_SHOVEL, ToolTier.WOOD);
        registerTier(Items.WOODEN_HOE, ToolTier.WOOD);
        registerTier(Items.WOODEN_SWORD, ToolTier.WOOD);

        // Stone tools
        registerTier(Items.STONE_AXE, ToolTier.STONE);
        registerTier(Items.STONE_PICKAXE, ToolTier.STONE);
        registerTier(Items.STONE_SHOVEL, ToolTier.STONE);
        registerTier(Items.STONE_HOE, ToolTier.STONE);
        registerTier(Items.STONE_SWORD, ToolTier.STONE);

        // Iron tools
        registerTier(Items.IRON_AXE, ToolTier.IRON);
        registerTier(Items.IRON_PICKAXE, ToolTier.IRON);
        registerTier(Items.IRON_SHOVEL, ToolTier.IRON);
        registerTier(Items.IRON_HOE, ToolTier.IRON);
        registerTier(Items.IRON_SWORD, ToolTier.IRON);

        // Golden tools
        registerTier(Items.GOLDEN_AXE, ToolTier.GOLD);
        registerTier(Items.GOLDEN_PICKAXE, ToolTier.GOLD);
        registerTier(Items.GOLDEN_SHOVEL, ToolTier.GOLD);
        registerTier(Items.GOLDEN_HOE, ToolTier.GOLD);
        registerTier(Items.GOLDEN_SWORD, ToolTier.GOLD);

        // Diamond tools
        registerTier(Items.DIAMOND_AXE, ToolTier.DIAMOND);
        registerTier(Items.DIAMOND_PICKAXE, ToolTier.DIAMOND);
        registerTier(Items.DIAMOND_SHOVEL, ToolTier.DIAMOND);
        registerTier(Items.DIAMOND_HOE, ToolTier.DIAMOND);
        registerTier(Items.DIAMOND_SWORD, ToolTier.DIAMOND);

        // Netherite tools
        registerTier(Items.NETHERITE_AXE, ToolTier.NETHERITE);
        registerTier(Items.NETHERITE_PICKAXE, ToolTier.NETHERITE);
        registerTier(Items.NETHERITE_SHOVEL, ToolTier.NETHERITE);
        registerTier(Items.NETHERITE_HOE, ToolTier.NETHERITE);
        registerTier(Items.NETHERITE_SWORD, ToolTier.NETHERITE);
    }

    /**
     * Associates an item with a tool tier.
     *
     * @param item The item to register.
     * @param tier The tool tier.
     */
    private static void registerTier(Item item, ToolTier tier) {
        ITEM_TO_TIER_MAP.put(item, tier);
    }

    /**
     * Gets the tier of the given item.
     *
     * @param item The item to check.
     * @return The tool tier, or NONE if not found.
     */
    public static ToolTier getTier(Item item) {
        return ITEM_TO_TIER_MAP.getOrDefault(item, ToolTier.NONE);
    }
}