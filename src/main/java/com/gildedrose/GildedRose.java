package com.gildedrose;

import com.gildedrose.calculator.PropertyCalculatorFactory;

class GildedRose {
	private final Item[] items;
	private final ItemUpdater updater;

	public GildedRose(Item[] items) {
		this.items = items;
		updater = new ItemUpdater(new PropertyCalculatorFactory());
	}

	public void updateQuality() {
		for (Item item : items) {
			updater.updateItem(item);
		}
	}
}
