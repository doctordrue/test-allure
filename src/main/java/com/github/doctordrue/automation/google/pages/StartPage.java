package com.github.doctordrue.automation.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.doctordrue.automation.common.pageobjects.WebPage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class StartPage extends WebPage {

	public StartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "q")
	@Name("Search Input")
	public TextInput searchInput;

	public SearchResultsPage search(String text) {
		searchInput.clear();
		searchInput.sendKeys(text);
		searchInput.sendKeys(Keys.ENTER);
		return new SearchResultsPage(driver);
	}

	@Override
	protected void waitPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchInput));
	}

}
