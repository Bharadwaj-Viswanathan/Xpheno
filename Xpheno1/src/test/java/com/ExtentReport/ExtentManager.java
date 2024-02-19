package com.ExtentReport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

		private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

		static ExtentTest getExtentTest() {
			return extTest.get();
		}

		static void setExtentTest(ExtentTest test) {
			extTest.set(test);
		}

		static void unload() {
			extTest.remove();
		}
	}
