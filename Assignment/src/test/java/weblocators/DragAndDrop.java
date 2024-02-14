package weblocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	WebDriver driver;
	public DragAndDrop(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void dragDrop()
	{
		driver.findElement(By.cssSelector("#regform > div > ul > li:nth-child(7) > b > a")).click();
		Actions action=new Actions(driver);
		WebElement src=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));  //Drag Source
		WebElement dest=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));   //Drop Source
		
		action.clickAndHold(src).moveToElement(dest).release().build().perform();
		driver.quit();
	}

}
