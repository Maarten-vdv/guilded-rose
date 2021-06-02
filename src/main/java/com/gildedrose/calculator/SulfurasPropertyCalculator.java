package com.gildedrose.calculator;

public class SulfurasPropertyCalculator implements PropertyCalculator {

	@Override
	public int calculateQuality(int quality, int sellIn) {
		return quality;
	}

	@Override
	public int calculateSellIn(int sellIn) {
		return sellIn;
	}
}
