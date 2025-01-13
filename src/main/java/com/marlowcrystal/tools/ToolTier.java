package com.marlowcrystal.tools;

import lombok.Getter;

/**
 * Represents the tier levels of tools.
 */
@Getter
public enum ToolTier {
    NONE(0),
    WOOD(1),
    STONE(2),
    IRON(3),
    GOLD(4),
    DIAMOND(5),
    NETHERITE(6);

    private final int level;

    ToolTier(int level) {
        this.level = level;
    }

}
