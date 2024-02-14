package weblocators;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iframes {
	
	WebDriver driver;
	public Iframes(WebDriver driver)
	{
		this.driver=driver;
	}
	public void frame()
	{
		String expectedResult="I am inside Frame";
		driver.findElement(By.cssSelector("#regform > div > ul > li:nth-child(4) > b > a")).click();
		driver.findElement(By.cssSelector("#input1")).sendKeys("Vishal");
		driver.switchTo().frame(0);     //#Frame1
		String actualResult=driver.findElement(By.xpath("//*[@id=\"frametext\"]")).getText();
		
		Assert.assertEquals(expectedResult, actualResult);
        expectedResult="Enter something!";
		System.out.println(actualResult);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);    //#Frame2
		 actualResult=driver.findElement(By.xpath("//*[@id=\"frameinputtext\"]")).getText();
		Assert.assertEquals(expectedResult, actualResult);

		driver.findElement(By.xpath("//*[@id=\"frameinput\"]")).sendKeys("Vishal kumar");
		driver.quit();
		

	}

}
