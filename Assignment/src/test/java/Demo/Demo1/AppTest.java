package Demo.Demo1;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import weblocators.AlertsHandling;
import weblocators.Delay;
import weblocators.DragAndDrop;
import weblocators.Iframes;
import weblocators.SignUpForm;


public class AppTest 
{
	WebDriver driver=null;
	SignUpForm signUp;
	Iframes iframe;
	DragAndDrop drag;
	Delay delay;
	AlertsHandling alert;
          
    @Before
    public void accessUrl()
    {
    	driver =new FirefoxDriver();
        driver.get("https://qavbox.github.io/demo/");
        driver.manage().window().maximize();
        signUp=new SignUpForm(driver);
    }
    @Test()
    public void signUpTest() throws AWTException 
   {
   	String fullName="Vishal Kumar";  
    	String email="vishal32@yopmail.com";
    	String phoneNumber="+918218394110";
    	String gender="Male";
    	String filePath="C:\\Users\\vishal\\Downloads\\Vishal-Kumar-FlowCV-Resume-20240210 (2).pdf"; //for Uploading a file
    	int numberOfYearEx=4;
    	
     String skills[]=new String[] {"ManualTesting","Java"};
     driver.findElement(By.xpath("/html/body/form/fieldset/div/ul/li[1]/b/a")).click();
     signUp.fillBasicDetails(fullName,email,phoneNumber,gender,numberOfYearEx);
     signUp.uploadFile(filePath);
     signUp.skillSelection(skills);
     signUp.automationTool("CodedUI");
   }
    
    @Test
    public void iframe()
    {
    	
    	iframe =new Iframes (driver);
    	iframe.frame();
    	
    }
    
    @Test
    public void dragAndDrop()
    {
    	drag =new DragAndDrop (driver);
    	drag.dragDrop();
    }
    
    @Test
    public void delay() throws Exception
    
    {
    	delay=new Delay(driver);
    	delay.delay();
    }
    
    @Test
    public void AlertHandling() throws Throwable
    {
    	String choice="Ok";
    	alert=new AlertsHandling(driver);
    	alert.simpleAlert();
    	alert.promptAlert("Vishal");
    	alert.userSelectionAlert(choice);
    	driver.quit();
    }
    
}
