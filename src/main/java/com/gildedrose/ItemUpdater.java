package com.gildedrose;

import com.gildedrose.calculator.PropertyCalculator;
import com.gildedrose.calculator.PropertyCalculatorFactory;

public class ItemUpdater {

	private final PropertyCalculatorFactory factory;

	public ItemUpdater(PropertyCalculatorFactory factory) {
		this.factory = factory;
	}

	public void updateItem(Item item) {
		ItemType type = ItemType.fromName(item.name);
		PropertyCalculator updater = factory.getCalculator(type);
		item.quality = updater.calculateQuality(item.quality, item.sellIn);
		item.sellIn = updater.calculateSellIn(item.sellIn);
	}
}
