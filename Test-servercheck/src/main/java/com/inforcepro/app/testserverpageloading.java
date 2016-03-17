package com.inforcepro.app;
import java.io.IOException;

import org.openqa.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;


public class testserverpageloading extends send_email_api_output {
	
  static WebDriver driver = new FirefoxDriver();
	
	public void testserverpageloads () throws IOException
	{
		try {
			name = new Object(){}.getClass().getEnclosingMethod().getName();
			
			String Expected_title = "Administrative Section";			
			driver.get("https://mars.inforcepro.com/system/admin/admin.php");
		   String Actual_title = driver.getTitle();
		   
		   System.out.println(Actual_title);
		   if(Actual_title.equals(Expected_title))
		   {
			   System.out.println("Test server working fine");
			 //  driver.close();
			   
		   }
			
		   else 
		   {
			   System.out.println("Test server page not found ");
			
			 sb_email_text.append("Test server is not loading");
			   send_email_api_output.auto_email();
			
		   }
		
		}	catch(Exception e) {exception_method(e);}
		
	
		
	}

	/* Login check */
	public void loginchecks () throws IOException
	{
	//	driver.get("https://mars.inforcepro.com/system/admin/admin.php");
		try {
			name = new Object(){}.getClass().getEnclosingMethod().getName();
		driver.findElement(By.name("username")).sendKeys("vivek@inforcepro.com");
		driver.findElement(By.name("password")).sendKeys("TubheOcVes2");
		driver.findElement(By.name("password")).submit();
		
		boolean outputfetch = (driver.getPageSource().contains("Welcome Admin!"));
		System.out.println(outputfetch);
		if(outputfetch)
		{
			
			System.out.println("Login Successfully");
			 sb_email_text.append("Successfully login");
			   send_email_api_output.auto_email();
			   driver.close();
		}

		 else 
		   {
			   System.out.println("Not able to login ");
			
			 sb_email_text.append("Unable to login from test server");
			   send_email_api_output.auto_email();
			
		   }
		
		}	catch(Exception e) {exception_method(e);}
		
		
	}
	public static void main (String args[]) throws IOException
  {
	testserverpageloading pageloads = new testserverpageloading();
	pageloads.testserverpageloads();
	
	pageloads.loginchecks();
   }
	
}
