package com.tests;

import org.testng.annotations.Test;

import com.browser.DriverManager;
import com.pom.searchpom;

public class Search extends BaseClass {

	@Test
	void cadidatesearch() {
		searchpom s=new searchpom(DriverManager.getDriver());
		s.search();
	}
}
