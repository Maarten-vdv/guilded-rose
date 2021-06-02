package com.gildedrose.calculator;

public interface PropertyCalculator {

	default int calculateQuality(int quality, int sellIn) {
		return Math.max(0, quality - (sellIn > 0 ? 1 : 2));
	}

	default int calculateSellIn(int sellIn) {
		return sellIn - 1;
	}
}
