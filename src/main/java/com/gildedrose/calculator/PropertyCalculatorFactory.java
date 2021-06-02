package com.gildedrose.calculator;

import com.gildedrose.ItemType;

import java.util.EnumMap;
import java.util.Map;

public class PropertyCalculatorFactory {

	private final Map<ItemType, PropertyCalculator> cache = new EnumMap<>(ItemType.class);

	public PropertyCalculator getCalculator(ItemType type) {
		if (!cache.containsKey(type)) {
			cache.put(type, create(type));
		}
		return cache.get(type);
	}

	private PropertyCalculator create(ItemType type) {
		switch (type) {
			case SULFURAS:
				return new SulfurasPropertyCalculator();
			case BACKSTAGE_PASS:
				return new BackstagePassPropertyCalculator();
			case AGED_BRIE:
				return new AgedBriePropertyCalculator();
			case CONJURED_IDENTIFIER:
				return new ConjuredItemPropertyCalculator();
			case OTHER:
			default:
				return new StandardPropertyCalculator();
		}
	}
}
