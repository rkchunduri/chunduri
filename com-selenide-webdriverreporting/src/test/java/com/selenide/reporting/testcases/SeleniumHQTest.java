package com.selenide.reporting.testcases;

import static com.codeborne.selenide.Selenide.open;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.codeborne.selenide.WebDriverRunner;
import com.selenide.reporting.pageobjects.SeleniumHQPage;

import ch.vorburger.webdriver.reporting.LoggingTestWatchman;
import ch.vorburger.webdriver.reporting.LoggingWebDriverEventListener;
import ch.vorburger.webdriver.reporting.TestCaseReportWriter;

public class SeleniumHQTest {

	static private final TestCaseReportWriter LOG_FILE_WRITER = new TestCaseReportWriter();

	@Rule
	public MethodRule logRule = new LoggingTestWatchman(LOG_FILE_WRITER);

	@Test
	public void seleniumHQTest() throws FileNotFoundException {
		EventFiringWebDriver driverWithReporting;
		{

			WebDriverEventListener loggingListener = new LoggingWebDriverEventListener(LOG_FILE_WRITER);
			driverWithReporting = new EventFiringWebDriver(WebDriverRunner.getWebDriver());
			driverWithReporting.register(loggingListener);
		}
		WebDriverRunner.setWebDriver(driverWithReporting);

		SeleniumHQPage seleniumHQPage = open("http://docs.seleniumhq.org/", SeleniumHQPage.class);
		seleniumHQPage.downloadPage();

	}
}