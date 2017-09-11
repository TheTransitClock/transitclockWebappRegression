package org.transitime;

/*-
 * #%L
 * transitimeWebappRegression
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

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.awt.AWTException;
import java.awt.Robot;
/**
 * @author Sean Óg Crudden
 * First go at using selenium to test transiTime web interface.
 *
 *
 *
 *
 */
public class MapsTest {
	private WebDriver driver;
	private String baseUrl="http://127.0.0.1:8080/web";


	/**
	 * This goes to the maps page and looks at the "Map for Selected Route" page and checks if there is at least one route option avialable.
	 * @throws InterruptedException
	 */
	@Test
	public void routeOnMap() throws InterruptedException {

		driver.get(baseUrl);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Maps")).click();


		driver.findElement(By.partialLinkText("Map for Selected Route")).click();


		driver.findElement(By.id("select2-routes-container")).click();

		WebElement searchElement = driver.findElement(By.className("select2-search__field"));

		// TODO need to get this to read route from API to enter here.
		searchElement.sendKeys("471");
		// Create object of Robot class
		Robot object=new Robot();
		// Press Enter
		object.keyPress(KeyEvent.VK_ENTER);
		// Release Enter
		object.keyRelease(KeyEvent.VK_ENTER);

		//wait after enter key press
		Thread.sleep(2000);
		//contains icon with map
		Assert.assertTrue(driver.getPageSource().contains("leaflet-clickable"));
	}
	/**
	 * This goes to the schedule adherence map and finds a circle.
	 */
	@Test
	public void scheduleAdherence()
	{
		driver.get(baseUrl);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Maps")).click();

		driver.findElement(By.partialLinkText("Schedule Adherence Map")).click();

		WebElement marker = driver.findElement(By.className("leaflet-marker-pane"));

		Assert.assertTrue(marker != null);

	}
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		if(System.getProperty("baseurl")!=null&&System.getProperty("baseurl").length()>0)
		{
			this.baseUrl=System.getProperty("baseurl");
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
