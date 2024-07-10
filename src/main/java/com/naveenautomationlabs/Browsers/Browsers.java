package com.naveenautomationlabs.Browsers;

public enum Browsers {
	
	CHROME("Google Chrome"),
	FIREFOX("Mozilla Firefox"),
	EDGE("Microsoft Edge"),
	SAFARI("Mac Safari");

	private String browserNameWithCompanies;
	
	Browsers(String browserName) {
	this.browserNameWithCompanies = browserName;
	}

	public String getBrowserNameWithCompanies() {
		return browserNameWithCompanies;
	}
	
	

}
