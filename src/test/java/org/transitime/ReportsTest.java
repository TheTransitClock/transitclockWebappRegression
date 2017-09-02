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
 * Test the reports.
 * 
 * 
 * 
 *
 */
public class ReportsTest {
	private WebDriver driver;
	private String baseUrl="http://127.0.0.1:8080/web";
	
	
	/**
	 * This looks at the last avl report screen and confirms vehicle report for today for at least one vehicle.
	 * @throws InterruptedException
	 */
	@Test
	public void lastAVLReport() throws InterruptedException {
		
		
		
		driver.get(baseUrl);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Agencies"));
		
		driver.findElement(By.partialLinkText("Reports")).click();
		
		driver.findElement(By.partialLinkText("Last GPS Report by Vehicle")).click();										
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//TODO make this be a wait for table to load
		Thread.sleep(5000);
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		Assert.assertTrue(driver.getPageSource().contains(date));
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		
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
