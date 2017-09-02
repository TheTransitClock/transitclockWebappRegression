package org.transitime;
/*-
 * #%L
 * transiTimeWebappRegression
 * %%
 * Copyright (C) 2017 Sean Óg Crudden
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/**
 * @author Sean Óg Crudden
 * 
 * Check the status of the server. 
 * 
 */
public class StatusTest {
	private WebDriver driver;
	private String baseUrl = "http://127.0.0.1:8080/web";

	/**
	 * This checks the the systems is connected to the database.
	 */
	@Test
	public void databaseConnectivity() {
		driver.get(baseUrl);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Status")).click();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.findElement(By.partialLinkText("Server Status")).click();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		Assert.assertTrue(driver.getPageSource().contains("Successfully read and wrote to database."));

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();

		if (System.getProperty("baseurl") != null && System.getProperty("baseurl").length() > 0) {
			this.baseUrl = System.getProperty("baseurl");
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
