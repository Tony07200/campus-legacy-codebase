package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                //simple item
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Elixir of the Mongoose", 5, 7),
                //cheese
                new Item("Aged Brie", 2, 0), //
                //legendary
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                //concert
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                //conjured
                new Item("Almost Conjured but cheaper Mana Cake", 3, 25),
                new Item("Like Conjured but cheaper Mana Cake", 3, 25),
                new Item("Conjured Mana Cake", 3, 25),
                new Item("Conjured sausage", 5,5),
                new Item("Aging Red Wine", 10,10)
        };

        GildedRose app = new GildedRose(items);

        int days = 300;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
