package com.github.doctordrue.automation.google.blocks;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class ResultBlock extends HtmlElement {
	@FindBy(css = "h3.r>a")
	public Link header;

	@FindBy(css = "div.s span.st")
	public TextBlock description;
}
