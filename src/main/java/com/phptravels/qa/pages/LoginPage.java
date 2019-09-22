package com.phptravels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Page Factory---OR

	@FindBy(name = "userName")
	WebElement userName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(name = "login")
	WebElement loginBtn;
	@FindBy(linkText = "REGISTER")
	WebElement Registerlink;
	@FindBy(linkText = "SUPPORT")
	WebElement Supportlink;
	@FindBy(linkText = "CONTACT")
	WebElement Contactlink;
	@FindBy(linkText = "Home")
	WebElement Homelink;
	@FindBy(xpath = "//IMG[@src='/images/nav/logo.gif']")
	WebElement logo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLoginPageLogo() {
		return logo.isDisplayed();
	}

	public HomePage login(String usr,String pwd) {

		userName.sendKeys(usr);
		Password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}
