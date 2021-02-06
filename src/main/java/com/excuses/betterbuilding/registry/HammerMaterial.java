package com.excuses.betterbuilding.registry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class HammerMaterial implements ToolMaterial {
    public static HammerMaterial INSTANCE = new HammerMaterial();

    @Override
    public int getDurability() {
        return 512;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
