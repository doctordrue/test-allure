package com.github.doctordrue.automation.google.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.doctordrue.automation.common.pageobjects.WebPage;
import com.github.doctordrue.automation.google.blocks.ResultBlock;

import ru.yandex.qatools.htmlelements.element.TextBlock;

public class SearchResultsPage extends WebPage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "resultStats")
	public TextBlock stats;

	@FindBy(css = "div#search div.g div[data-hveid]")
	public List<ResultBlock> results;

	@Override
	protected void waitPageLoad() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(stats));
	}

}
