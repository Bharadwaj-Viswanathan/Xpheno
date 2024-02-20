package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tests.BaseClass;

public class searchpom extends BaseClass {

	private By username = By.xpath("//input[@name='username']");
	private  By password = By.xpath("//input[@name='password']");
	private  By login = By.xpath("//button[@type='submit']");
	private  By searchcandidate = By.xpath("//span[text()='Candidate Search']");
	private  By searchbutton = By.xpath("//button[text()='Search']");
	private  By searchbar = By.xpath("//input[@placeholder='Search Keyword']");
	private  By randomdropdown = By.xpath(
			"//div[@class='search-result-body MuiBox-root css-0']//div//span//input//following::div//div[@class='search-result-candidate-name MuiBox-root css-0']");

	public  void search() {
		sendkeys(element(username), prop.getProperty("UN"));
		sendkeys(element(password), prop.getProperty("PW"));
		javascriptclick(element(login));
		wait3sec();
		javascriptclick(element(searchcandidate));
		randomname(element(searchbar), "keyword");
		sendkeywithbackspace(element(searchbar));
		javascriptclick(element(searchbutton));
		RandomDropDown(
				randomdropdown,
				"0");

	}
}
