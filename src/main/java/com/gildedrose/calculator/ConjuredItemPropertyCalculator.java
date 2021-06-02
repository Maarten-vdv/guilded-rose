package com.gildedrose.calculator;

public class ConjuredItemPropertyCalculator implements PropertyCalculator {

	@Override
	public int calculateQuality(int quality, int sellIn) {
		return sellIn > 0 ? quality - 2 : quality - 4;
	}
}
