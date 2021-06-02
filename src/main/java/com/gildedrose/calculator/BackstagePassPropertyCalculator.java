package com.gildedrose.calculator;

public class
BackstagePassPropertyCalculator implements PropertyCalculator {

	@Override
	public int calculateQuality(int quality, int sellIn) {
		if (sellIn <= 0) {
			return 0;
		}

		int result;
		if (sellIn > 11) {
			result = quality + 1;
		} else if (sellIn > 5) {
			result = quality + 2;
		} else {
			result = quality + 3;
		}
		return Math.min(50, result);
	}
}
