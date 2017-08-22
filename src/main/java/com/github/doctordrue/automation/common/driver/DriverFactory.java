package com.github.doctordrue.automation.common.driver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class DriverFactory {

	public static WebDriver getDriver(DriverType type, Architecture arch) {
		if (arch == null) {
			arch = Architecture.x32;
		}
		WebDriver driver = null;
		switch (type) {
			case FIREFOX_ESR:
				FirefoxOptions ffOptions = new FirefoxOptions()
				        .setLegacy(true)
				        .setLogLevel(Level.OFF);
				driver = new FirefoxDriver(ffOptions);
				break;
			case FIREFOX_LATEST:
				FirefoxDriverManager.getInstance().architecture(arch).setup();
				FirefoxOptions geckoOptions = new FirefoxOptions()
				        .addPreference("log", "{level: error}")
				        .addCapabilities(new DesiredCapabilities(
				                ImmutableMap.of("pageLoadStrategy", "eager")))
				        .setLogLevel(Level.SEVERE);
				driver = new FirefoxDriver(geckoOptions);
				break;
			case IE:
				InternetExplorerDriverManager.getInstance().architecture(arch).setup();
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				        false);
				driver = new InternetExplorerDriver(ieCapabilities);
				break;
			case EDGE:
				EdgeDriverManager.getInstance().architecture(arch).setup();
				driver = new EdgeDriver();
				break;
			case CHROME:
			default:
				ChromeDriverManager.getInstance().architecture(arch).setup();
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
				options.addArguments("--disable-extensions");
				options.addArguments("disable-infobars");

				Map<String, Object> prefs = new HashMap<>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
				break;
		}
		return new EventFiringWebDriver(driver);
	}
}
