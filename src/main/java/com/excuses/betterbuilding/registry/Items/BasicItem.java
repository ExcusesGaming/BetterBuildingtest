package com.excuses.betterbuilding.registry.Items;

import com.excuses.betterbuilding.BetterBuilding;
import net.minecraft.item.Item;

public class BasicItem extends Item {

    public BasicItem() {
        super(new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    }

}
