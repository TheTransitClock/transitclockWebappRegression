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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities.CapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * @author Sean Óg Crudden
 * Test the reports.
 *
 */
public class ReportsTest {
	private WebDriver driver;
	private String baseUrl="http://127.0.0.1:8080/web";


	/**
	 * This looks at the last avl report and confirms vehicle report for today for at least one vehicle.
	 * @throws InterruptedException
	 */
	@Test
	public void lastAVLReport() throws InterruptedException {

		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Reports")).click();

		driver.findElement(By.partialLinkText("Last GPS Report by Vehicle")).click();

		//TODO make this be a wait for table to load
		Thread.sleep(5000);

		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		Assert.assertTrue(driver.getPageSource().contains(date));
	}
	@Test
	public void predictionAccuracyScatterPlot()
	{
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Reports")).click();

		driver.findElement(By.partialLinkText("Prediction Accuracy Scatter Plot")).click();

		WebElement button = driver.findElement(By.id("submit"));

		button.submit();

		Assert.assertTrue(driver.getPageSource().contains("Prediction Time"));
	}
	@Test
	public void predictionAccuracyRangeChart()
	{
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Reports")).click();

		driver.findElement(By.partialLinkText("Prediction Accuracy Range Chart")).click();

		WebElement button = driver.findElement(By.id("submit"));

		button.submit();

		Assert.assertTrue(driver.getPageSource().contains("Prediction Length"));
	}
	@Test
	public void scheduleAdherenceEarlyLate()
	{
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Reports")).click();

		driver.findElement(By.partialLinkText("Schedule Adherence by how Early/Late")).click();

		WebElement button = driver.findElement(By.id("submit"));

		button.submit();

		Assert.assertTrue(driver.getPageSource().contains("Minutes vehicle late (negative) or early (positive)"));
	}
	@Test
	public void scheduleAdherenceByRoute()
	{
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Reports")).click();

		driver.findElement(By.partialLinkText("Schedule Adherence by Route")).click();

		WebElement button = driver.findElement(By.id("submit"));

		button.submit();

		Assert.assertTrue(driver.getPageSource().contains("On Time"));
	}

	@Test
	public void predictionAccuracyCSVDownload()
	{
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("Reports")).click();

		driver.findElement(By.partialLinkText("Prediction Accuracy CSV Download")).click();

		WebElement button = driver.findElement(By.id("submit"));

		button.submit();

		try {
			// Create object of Robot class
			Robot object=new Robot();
			// Press Enter
			object.keyPress(KeyEvent.VK_ENTER);
			// Release Enter
			object.keyRelease(KeyEvent.VK_ENTER);
		} catch ( AWTException exception ){
			System.out.println("AWT Exception: " + exception);
		}
		//Assert.assertTrue(driver.getPageSource().contains("pred_length_secs"));
	}

	@BeforeTest
	public void beforeTest() {
		String downloadFilepath = "/home/onebusaway";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", downloadFilepath);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", chromePrefs);
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	cap.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(cap);
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
