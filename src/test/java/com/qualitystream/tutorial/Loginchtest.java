package com.qualitystream.tutorial;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginchtest {
	
	private WebDriver driver;
	By imailLocator = By.id("mat-input-0");
	By passwordLocator = By.id("mat-input-1");
	By msm01 = By.id("mat-error-2");
	//texto = driver.findElement(msm01).getText();
	
	//By val = msm01;
	By iniciosesionLocator = By.className("card-text-link");
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ciopenaut.com/login");
		
	}

	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}

	
	@Test
	public void loginuser() throws InterruptedException {
		
		driver.findElement(imailLocator).sendKeys("#%%");
		driver.findElement(passwordLocator).sendKeys("Jcarlos2021&");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		if(driver.findElement(msm01).isDisplayed()) {
			System.out.println("Vamos bien");
			System.out.println("Mensaje Mostrado:");
			System.out.println(driver.findElement(msm01).getText());
			System.out.println("Mensaje Esperado:");
			System.out.println("Es necesario capturar un correo electrónico válido");
			assertEquals("Es necesario capturar un correo electrónico válido", driver.findElement(msm01).getText());
		}
		
		else {
			System.out.print("No se mostró mensaje");
		}	
					
	}

	
	
	/*@Test
	public void loginuser() throws InterruptedException {
		
		driver.findElement(imailLocator).sendKeys("#%%");
		driver.findElement(passwordLocator).sendKeys("Jcarlos2021&");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

		if(driver.findElement(msm01).isDisplayed()) {
			assertEquals("Es necesario capturar un correo electrónico válido", driver.findElement(msm01).getText());
		}
		
		else {
			System.out.print("No se mostró mensaje");
		}
					
	}*/
	
	

}
