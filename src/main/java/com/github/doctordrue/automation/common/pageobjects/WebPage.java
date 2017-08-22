package com.github.doctordrue.automation.common.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class WebPage {
	protected WebDriver driver;

	public WebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
		waitPageLoad();
	}

	protected abstract void waitPageLoad();
}
