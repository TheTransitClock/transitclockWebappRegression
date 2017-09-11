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

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

/**
 * @author Sean Óg Crudden
 * Test the API end points.

 *
 */
public class APITest {
	private WebDriver driver;
	private String baseUrl="http://127.0.0.1:8080/web";

	/**
	 * This goes to the API screen and selects "Agencies" and then reads the json result to check there is at least one agency.
	 * @throws InterruptedException
	 */
	@Test
	public void getAgencies() {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Agencies")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray agencies = objResult.getJSONArray("agency");

		Assert.assertTrue(agencies.length()>0);
	}
	/**
	 * This goes to the API screen and selects "Routes" and then reads the json result to check there is at least one route.
	 * @throws InterruptedException
	 */
	@Test
	public void getRouteInfo()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Routes")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray routes = objResult.getJSONArray("routes");

		Assert.assertTrue(routes.length()>0);
	}

	/**
	 * This goes to the API screen and selects "Vehicles" and then reads the json result to check there is at least one vehicle.
	 * @throws InterruptedException
	 */
	@Test
	public void getVehicleInfo()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Vehicles")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray vehicles = objResult.getJSONArray("vehicles");

		Assert.assertTrue(vehicles.length()>0);
	}
	/**
	 * This goes to the API screen and selects "Vehicle Configurations" and then reads the json result to check there is at least one vehicles configuration.
	 * @throws InterruptedException
	 */
	@Test
	public void getVehicleConfigurationInfo()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Vehicle Configurations")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray vehicleConfigurations = objResult.getJSONArray("vehicleConfig");

		Assert.assertTrue(vehicleConfigurations.length()>0);
	}
	/**
	 * This goes to the API screen and selects "Blocks" and then reads the json result to check there is at least one block configuration.
	 * @throws InterruptedException
	 */
	@Test
	public void getBlockInfo()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Block")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray blocks = objResult.getJSONArray("block");

		Assert.assertTrue(blocks.length()>0);
	}
	/**
	 * This goes to the API screen and selects "Block details" and then reads the json result to check there is at least one block.
	 * @throws InterruptedException
	 */
	@Test
	public void getBlockDetails()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Block Details")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray blocks = objResult.getJSONArray("block");

		Assert.assertTrue(blocks.length()>0);
	}

	/**
	 * This goes to the API screen and selects "Service ID" and then reads the json result to check there is at least one service id configuration.
	 * @throws InterruptedException
	 */
	@Test
	public void getServiceInfo()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Service IDs")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray ids = objResult.getJSONArray("ids");

		Assert.assertTrue(ids.length()>0);
	}
	/**
	 * This goes to the API screen and selects "GTFS-Realtime trip updates" and then reads the json result to check there is at least one update.
	 * @throws InterruptedException
	 */
	@Test
	public void getGTFSRealtimeUpdateDetails()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("GTFS-realtime Trip Updates")).click();

		//select second option to be human readable format
		driver.findElements(By.name("format")).get(1).click();

		driver.findElement(By.id("submit")).click();

		String text = driver.findElement(By.tagName("body")).getText();

		Assert.assertTrue(text.contains("header"));
	}
	/**
	 * This goes to the API screen and selects "GTFS-Realtime vehicle positions" and then reads the json result to check there is at least one vehicle position.
	 * @throws InterruptedException
	 */
	@Test
	public void getGTFSRealtimeVehiclePositions()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("GTFS-realtime Vehicle Positions")).click();

		//select second option to be human readable format
		driver.findElements(By.name("format")).get(1).click();

		driver.findElement(By.id("submit")).click();

		String text = driver.findElement(By.tagName("body")).getText();

		Assert.assertTrue(text.contains("ent	ity"));
	}
	/**
	 * This goes to the API screen and selects "SIRI Vehicle Monitoring" and then reads the json result to check there is ServiceDelivery.
	 * @throws InterruptedException
	 */
	@Test
	public void getSIRIVehicleMonitoring()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("SIRI Vehicle Monitoring")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONObject objServiceDelivery = objResult.getJSONObject("ServiceDelivery");

		String responseTimestamp = objServiceDelivery.getString("ResponseTimestamp");

		Assert.assertTrue(responseTimestamp != null);
	}

	/**
	 * This goes to the API screen and selects "Schedule for Route, stops horizontal" and then reads the json result to check there is at least one schedule.
	 * @throws InterruptedException
	 */
	@Test
	public void getScheduleForRouteHorizontal()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Schedule for Route, stops horizontal")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray vehicles = objResult.getJSONArray("schedule");

		Assert.assertTrue(vehicles.length()>0);
	}

	/**
	 * This goes to the API screen and selects "Schedule for Route, stops vertical" and then reads the json result to check there is at least one schedule.
	 * @throws InterruptedException
	 */
	@Test
	public void getScheduleForRouteVertical()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Schedule for Route, stops vertical")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray schedules = objResult.getJSONArray("schedule");

		Assert.assertTrue(schedules.length()>0);
	}
	/**
	 * This goes to the API screen and selects "Vehicles" and then reads the json result to check there is at least one vehicle.
	 * @throws InterruptedException
	 */
	@Test
	public void getVehicleDetails()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Vehicles")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray vehicles = objResult.getJSONArray("vehicles");

		Assert.assertTrue(vehicles.length()>0);
	}

	/**
	 * This goes to the API screen and selects "Route Details" and then reads the json result to check there is at least one route.
	 * @throws InterruptedException
	 */
	@Test
	public void getRouteDetails()  {
		driver.get(baseUrl);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Agencies"));

		driver.findElement(By.partialLinkText("API")).click();

		driver.findElement(By.partialLinkText("Route Details")).click();

		driver.findElement(By.id("submit")).click();;

		String jsonResult=driver.findElement(By.tagName("body")).getText();

		JSONObject objResult = new JSONObject(jsonResult);

		JSONArray routes = objResult.getJSONArray("routes");

		Assert.assertTrue(routes.length()>0);
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
