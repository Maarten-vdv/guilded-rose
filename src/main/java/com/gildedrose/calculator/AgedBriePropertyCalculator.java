package com.gildedrose.calculator;

public class AgedBriePropertyCalculator implements PropertyCalculator {

	@Override
	public int calculateQuality(int quality, int sellIn) {
		return Math.min(50, quality + (sellIn > 0 ? 1 : 2));
	}
}
