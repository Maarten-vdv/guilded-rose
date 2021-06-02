package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	public static final String AGED_BRIE = "Aged Brie";
	public static final String CONJURED_ITEM1 = "conjured item 2";
	public static final String CONJURED_ITEM2 = "some conjured item";
	private String RANDOM_ITEM = "i am a random item";

	@Test
	void randomItems() {
		Item[] items = testItems(new Item(RANDOM_ITEM, 2, 10), new Item(RANDOM_ITEM, 0, 6));

		assertItem(items[0], RANDOM_ITEM, 1, 9);
		assertItem(items[1], RANDOM_ITEM, -1, 4);
	}

	@Test
	void qualityNotNegative() {
		Item[] items = testItems(new Item(RANDOM_ITEM, 2, 0));

		assertItem(items[0], RANDOM_ITEM, 1, 0);
	}

	@Test
	void spoiledItems() {
		RANDOM_ITEM = RANDOM_ITEM;
		Item[] items = testItems(
				new Item(RANDOM_ITEM, 0, 10),
				new Item(RANDOM_ITEM, -3, 10)
		);

		assertItem(items[0], RANDOM_ITEM, -1, 8);
		assertItem(items[1], RANDOM_ITEM, -4, 8);
	}

	@Test
	void brie() {
		Item[] items = testItems(
				new Item(AGED_BRIE, 5, 10),
				new Item(AGED_BRIE, 0, 6),
				new Item(AGED_BRIE, -2, 11)
		);

		assertItem(items[0], AGED_BRIE, 4, 11);
		assertItem(items[1], AGED_BRIE, -1, 8);
		assertItem(items[2], AGED_BRIE, -3, 13);
	}

	@Test
	void brieQualityMax50() {
		Item[] items = testItems(new Item(AGED_BRIE, 2, 50));

		assertItem(items[0], AGED_BRIE, 1, 50);
	}

	@Test
	void backstagePasses() {
		Item[] items = testItems(
				new Item(BACKSTAGE_PASS, 15, 10),
				new Item(BACKSTAGE_PASS, 7, 10),
				new Item(BACKSTAGE_PASS, 2, 10),
				new Item(BACKSTAGE_PASS, 0, 0),
				new Item(BACKSTAGE_PASS, -1, 0)
		);

		assertItem(items[0], BACKSTAGE_PASS, 14, 11);
		assertItem(items[1], BACKSTAGE_PASS, 6, 12);
		assertItem(items[2], BACKSTAGE_PASS, 1, 13);
		assertItem(items[3], BACKSTAGE_PASS, -1, 0);
		assertItem(items[4], BACKSTAGE_PASS, -2, 0);
	}

	@Test
	void backstagePassesQualityMax50() {
		Item[] items = testItems(
				new Item(BACKSTAGE_PASS, 15, 50),
				new Item(BACKSTAGE_PASS, 7, 50),
				new Item(BACKSTAGE_PASS, 2, 50)
		);

		assertItem(items[0], BACKSTAGE_PASS, 14, 50);
		assertItem(items[1], BACKSTAGE_PASS, 6, 50);
		assertItem(items[2], BACKSTAGE_PASS, 1, 50);
	}

	@Test
	void sulfurasIsEternal() {
		Item[] items = testItems(
				new Item(SULFURAS, -1, 80)
		);

		assertItem(items[0], SULFURAS, -1, 80);
	}

	@Test
	void conjuredSpoilsTwiceAsFast() {
		Item[] items = testItems(
				new Item(CONJURED_ITEM1, 3, 20),
				new Item(CONJURED_ITEM2, 3, 20)
		);

		assertItem(items[0], CONJURED_ITEM1, 2, 18);
		assertItem(items[1], CONJURED_ITEM2, 2, 18);
	}

	@Test
	void conjuredSpoiledSpoilsFourTimesAsFast() {
		Item[] items = testItems(
				new Item(CONJURED_ITEM1, -1, 15),
				new Item(CONJURED_ITEM2, -1, 15)
		);

		assertItem(items[0], CONJURED_ITEM1, -2, 11);
		assertItem(items[1], CONJURED_ITEM2, -2, 11);
	}

	private Item[] testItems(Item... items) {
		new GildedRose(items).updateQuality();
		return items;
	}

	private void assertItem(Item item, String name, int newSellIn, int newQuality) {
		assertEquals(name, item.name);
		assertEquals(newQuality, item.quality);
		assertEquals(newSellIn, item.sellIn);
		assertEquals(MessageFormat.format("{0}, {1}, {2}", name, newSellIn, newQuality), item.toString());
	}
}
