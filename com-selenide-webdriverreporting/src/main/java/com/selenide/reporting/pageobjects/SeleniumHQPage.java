package com.selenide.reporting.pageobjects;

import static com.codeborne.selenide.Selenide.$;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

public class SeleniumHQPage {

	public void downloadPage() throws FileNotFoundException {

		$(By.linkText("Download")).click();
		$(By.xpath("//h2[text()='Downloads']")).should(Condition.appear);
		$(By.linkText("Documentation")).click();
		$(By.xpath("//h1[text()='Selenium Documentation']")).should(Condition.appear);
		$(By.linkText("Support")).click();
		$(By.linkText("Download")).click();
		$(By.xpath("//a[text()='2.46.0']")).should(Condition.appear);


	}

}
