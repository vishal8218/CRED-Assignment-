package weblocators;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class AlertsHandling {
	
	WebDriver driver;
	public AlertsHandling(WebDriver driver)
	
	{
		this.driver=driver;
	}
	
	public void simpleAlert() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#regform > div > ul > li:nth-child(5) > b > a")).click();
		driver.findElement(By.name("commit")).click();
		Alert simplealert = driver.switchTo().alert();
		String expectedResult="Have a nice day!!!";
		Assert.assertEquals(expectedResult,simplealert.getText());
		Thread.sleep(5000);
		simplealert.accept();
		driver.switchTo().defaultContent();
	}
	
	public void submitDelay() throws Throwable
	{
		driver.findElement(By.xpath("//*[@id=\"delayalert\"]")).click();
		Thread.sleep(5000);
		Alert submitAlert=driver.switchTo().alert();
		String expectedResult="I appeared after 5 seconds!";
		Assert.assertEquals(expectedResult,submitAlert.getText());
		submitAlert.accept();
		driver.switchTo().defaultContent();
		
	}
	public void promptAlert(String inputData) throws Throwable
	{
		driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();
		Alert promtAlert=driver.switchTo().alert();
		promtAlert.sendKeys(inputData);
		Thread.sleep(5000);
		promtAlert.accept();
		driver.switchTo().defaultContent();
	}
	public void userSelectionAlert(String choice)
	{
		driver.findElement(By.cssSelector("#confirm")).click();
		Alert userAlert=driver.switchTo().alert();
		if(choice.equalsIgnoreCase("ok"))
		{
			userAlert.accept();
			String expectedResult="You pressed OK!";
			driver.switchTo().defaultContent();
			Assert.assertEquals(expectedResult,driver.findElement(By.xpath("//*[@id=\"Parademo\"]")).getText());
		}
		else
		{
			userAlert.dismiss();
			String expectedResult="You pressed Cancel!";
			driver.switchTo().defaultContent();
			Assert.assertEquals(expectedResult,driver.findElement(By.xpath("//*[@id=\"Parademo\"]")).getText());

		}

	}

}
