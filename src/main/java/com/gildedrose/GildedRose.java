package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (!isCheese(item) && !isBackstage(item)) {
                if (item.quality > 0) {
                    if (!isLegendary(item)) {
                        decreaseQuality(item);
                        if (isConjured(item)){
                            decreaseQuality(item);
                        }
                    }
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);
                    if (isBackstage(item)) {
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }
                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            }
            if (!isLegendary(item)) {
                item.sellIn = item.sellIn - 1;
            }
            if (item.sellIn < 0) {
                if (!isCheese(item)) {
                    if (!isBackstage(item)) {
                        if (item.quality > 0) {
                            if (!isLegendary(item)) {
                                decreaseQuality(item);
                                if (isConjured(item)){
                                    decreaseQuality(item);
                                }
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                       increaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item){
        item.quality --;
        if (item.quality <= 0) item.quality = 0;
    }

    private void increaseQuality(Item item){
        if(item.quality <= 0) item.quality = 0;
        item.quality ++;
        if(item.quality >=50) item.quality = 50;
    }

    private boolean isConjured(Item item){
        return item.name.contains("Conjured");
    }

    private boolean isCheese(Item item){
        return item.name.contains("Aged") || item.name.contains("Brie");
    }

    private boolean isBackstage(Item item){
        return item.name.contains("Backstage") || item.name.contains("pass") || item.name.contains("concert");
    }

    private boolean isLegendary(Item item){
        return item.name.contains("Legend") || item.name.contains("Sulfuras") || item.name.contains("Ragnaros");
    }

    public Item[] getItems() {
        return items;
    }
}