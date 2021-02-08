package com.excuses.betterbuilding.registry.Entities.Block;

import com.excuses.betterbuilding.registry.Interfaces.ImplementedInventory;
import com.excuses.betterbuilding.registry.ModBlockEntities;
import com.excuses.betterbuilding.registry.ScreenHandlers.OvenScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SmokerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class OvenBlockEntity extends AbstractFurnaceBlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public OvenBlockEntity() {
        super(ModBlockEntities.OVEN_BLOCK_ENTITY, RecipeType.SMOKING);
    }

    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) / 2;
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new OvenScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected Text getContainerName() {
        return  new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }
}