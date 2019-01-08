package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static final Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public void updateQuality() {
        for (Item item : items) {
            logger.info(item.toString());
            item.decrementSelling();
            String typeItem = item.isType();
            switch (typeItem) {
                case "Conjured":
                    item.updateConjured();
                    break;
                case "Cheese":
                    item.updateCheese();
                    break;
                case "Concert":
                    item.updateConcert();
                    break;
                case "Legendary":
                    break;
                default:
                    item.updateNormal();
                    break;
            }
        }
    }

    public Item[] getItems() {
        return items;
    }
}