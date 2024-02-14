package weblocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import static org.junit.Assert.*;


public class Delay {
	
	WebDriver driver;
	public Delay(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void delay() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#regform > div > ul > li:nth-child(8) > b > a")).click();
		driver.findElement(By.name("commit")).click();
		String expectedResult="I am here!";
        Thread.sleep(5000);
        Assert.assertEquals(expectedResult, driver.findElement(By.xpath("//*[@id=\"two\"]")).getText());
        driver.quit();
        

	}

}
