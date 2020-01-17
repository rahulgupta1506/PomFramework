package com.prac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prac.qa.base.TestBase;

public class Login extends TestBase{
	
	   //Page Factory - OR:
		@FindBy(name = "username")
		WebElement username;
		
		@FindBy(name = "password")
		WebElement password;
		
        @FindBy(css = "Input[@type='Submit']")
        WebElement loginbtn;
        
        @FindBy(css = "a[@Contains(text(),'Register')]")
        WebElement RegBtn;
        
        @FindBy(css="a[@Conatins(text(),'Forgot login info?']")
        WebElement forgotbtn;
        
      //Initializing the Page Objects:
        public Login()
        {
        	PageFactory.initElements(driver, this);
        }
        
        public String validateTitle()
        {
        	return driver.getTitle();
        }
}
