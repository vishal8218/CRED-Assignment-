package weblocators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpForm {
	
	
	
	WebDriver driver=null;
	
	public SignUpForm(WebDriver driver) {
		this.driver=driver;
	}

	public void fillBasicDetails(String fullName,String email,String tel,String gender,int numberOfYear)
	{
		driver.findElement(By.name("uname")).sendKeys(fullName);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("#tel")).sendKeys(tel);		
		driver.findElement(By.name("sgender")).click();
		if(gender.equalsIgnoreCase("male"))
			driver.findElement(By.xpath("/html/body/form/fieldset/div/div/div[7]/select/option[2]")).click();
		else if(gender.equalsIgnoreCase("female"))
			driver.findElement(By.xpath("/html/body/form/fieldset/div/div/div[7]/select/option[3]")).click();
		else
			driver.findElement(By.xpath("/html/body/form/fieldset/div/div/div[7]/select/option[4]")).click();

		String experience="";
		if(numberOfYear>=1&&numberOfYear<=7)
		{
			numberOfYear++;
			experience="#container > div:nth-child(17) > input[type=radio]:nth-child" + '('+numberOfYear+')';
		}
		else
			experience="#container > div:nth-child(17) > input[type=radio]:nth-child(9)";
		
		driver.findElement(By.cssSelector(experience)).click();
		

	}
	public void uploadFile(String path) throws AWTException
	{
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[6]/input")).sendKeys(path);
		System.out.println("file Upload Successfully");
	}
	public void skillSelection(String skills[])
	{
		HashMap<String,Integer>skill=new HashMap<String,Integer>();
		skill.put("ManualTesting",1);
		skill.put("AutomationTesting",2);
		skill.put("TestNG",3);
		skill.put("API",4);
		skill.put("HTML",5);
		skill.put("Java",6);
		skill.put("C#",7);
		for(int i=0;i<skills.length;i++)
		{
			int tem=skill.get(skills[i]);
			driver.findElement(By.xpath("/html/body/form/fieldset/div/div/div[9]/input"+'['+tem+']')).click();
		}
		skill.clear();
	}
	public void automationTool(String toolName)
	{
		HashMap<String,Integer>skill=new HashMap<String,Integer>();
		skill.put("Selenium",1);
		skill.put("Cypress",2);
		skill.put("WebdriverIO",3);
		skill.put("Protractor",4);
		skill.put("Jenkins",5);
		skill.put("Docker",6);
		skill.put("Postman",7);
		skill.put("TestStackWhite",8);
		skill.put("JMeter",9);
	    skill.put("CodedUI",10);
	    driver.findElement(By.xpath("//*[@id=\"tools\"]/option"+'['+skill.get(toolName)+']')).click();
	   
	    driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	    driver.quit();
	    skill.clear();
	}

}
