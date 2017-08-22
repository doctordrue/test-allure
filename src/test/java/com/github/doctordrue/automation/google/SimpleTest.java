package com.github.doctordrue.automation.google;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.doctordrue.automation.common.driver.DriverFactory;
import com.github.doctordrue.automation.common.driver.DriverType;
import com.github.doctordrue.automation.google.pages.SearchResultsPage;
import com.github.doctordrue.automation.google.pages.StartPage;

import io.github.bonigarcia.wdm.Architecture;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class SimpleTest {

	private StartPage startPage;
	private SearchResultsPage searchResultsPage;

	protected WebDriver driver;

	@BeforeTest(description = "Open browser and go to URL")
	public void setUp() {
		// TODO: Tests config
		WebDriver driver = DriverFactory.getDriver(DriverType.CHROME, Architecture.x32);
		this.driver = driver;
		driver.get("http://google.ru");
		startPage = new StartPage(driver);
	}

	@Step("Search for {text}")
	public void searchForText(String text) {
		searchResultsPage = startPage.search(text);
	}

	@Test(description = "Check search works")
	@Description("Search for text and check results")
	public void checkSearch() {
		searchForText("Selenium");
		// searchResultsPage.results.stream().anyMatch(e ->
		// e.header.getText().contains("Selenium"));
		assertFalse(true);
	}

	@AfterTest(description = "Close browser")
	public void tearDown() {
		driver.quit();
	}

}
