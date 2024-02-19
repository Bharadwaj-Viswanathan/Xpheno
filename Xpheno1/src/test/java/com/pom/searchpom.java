package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tests.BaseClass;

public class searchpom extends BaseClass {

	public searchpom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath = "//span[text()='Candidate Search']")
	private  WebElement searchcandidate;
	@FindBy(xpath = "//button[text()='Search']")
	private  WebElement searchbutton;
	
	@FindBy(xpath="//input[@placeholder='Search Keyword']")
	private WebElement searchbar;
	public void search() {
		sendkeys(username, prop.getProperty("UN"));
		sendkeys(password,prop.getProperty("PW"));
		javascriptclick(login);
		wait3sec();
		javascriptclick(searchcandidate);
		randomname(searchbar, "keyword");
		sendkeywithbackspace(searchbar);
		javascriptclick(searchbutton);
		RandomDropDown("//div[@class='search-result-body MuiBox-root css-0']//div//span//input//following::div//div[@class='search-result-candidate-name MuiBox-root css-0']","0");
	
	}
}
