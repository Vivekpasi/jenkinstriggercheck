package com.inforcepro.app;

import java.io.IOException;

import org.testng.annotations.Test;

public class logincheck {
  
	@Test
 public void checkingtestserverworking()  {
  
	  try 
	  {
	  testserverpageloading testserverpage	= new testserverpageloading();
	  
	  testserverpage.testserverpageloads();
	  
	  }catch(Exception e){}
  
  }

	@Test(priority=1)

public void Checkingloginworking()
{
	
    try 
    {
    	testserverpageloading loginchecking = new testserverpageloading();
    	loginchecking.loginchecks();
    	
    }catch(Exception e) {}
	
}

}
