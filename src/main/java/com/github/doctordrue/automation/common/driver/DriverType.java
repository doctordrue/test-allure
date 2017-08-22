package com.github.doctordrue.automation.common.driver;

public enum DriverType {
	FIREFOX_ESR("firefox-esr"),
	FIREFOX_LATEST("firefox-gecko"),
	CHROME("chrome"),
	EDGE("edge"),
	IE("ie");

	private String browser;

	private DriverType(String browser) {
		this.browser = browser;
	}

	@Override
	public String toString() {
		return browser;
	}

}
