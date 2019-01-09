package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose_Tony {
    Item_Tony[] items;

    public GildedRose_Tony(Item_Tony[] items) {
        this.items = items;
    }

    public static final Logger logger = LoggerFactory.getLogger(GildedRose_Tony.class);

    public void updateQuality() {
        for (Item_Tony item : items) {
            logger.info(item.toString());
            item.decrementSelling();
            chooseAction(item);
        }
    }

    public void chooseAction(Item_Tony item){
        String typeItem = item.isType();
        switch (typeItem) {
            case "Conjured": item.updateConjured(); break;
            case "Cheese": item.updateCheese(); break;
            case "Concert": item.updateConcert(); break;
            case "Legendary": item.updateLegendary(); break;
            default: item.updateNormal(); break;
        }
    }

    public Item_Tony[] getItems() {
        return items;
    }
}