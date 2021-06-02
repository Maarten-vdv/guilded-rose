package com.gildedrose;

public enum ItemType {
	SULFURAS("Sulfuras, Hand of Ragnaros"),
	BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
	AGED_BRIE("Aged Brie"),
	CONJURED_IDENTIFIER("conjured"),
	OTHER("other");

	private final String name;

	ItemType(java.lang.String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static ItemType fromName(String name) {
		if (SULFURAS.getName().equals(name)) {
			return SULFURAS;
		} else if (BACKSTAGE_PASS.getName().equals(name)) {
			return BACKSTAGE_PASS;
		} else if (AGED_BRIE.getName().equals(name)) {
			return AGED_BRIE;
		} else if (name != null && name.toLowerCase().contains(CONJURED_IDENTIFIER.getName())) {
			return CONJURED_IDENTIFIER;
		}
		return OTHER;
	}
}
