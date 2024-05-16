package bookingCars
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import helpers.ObjectLocators



class SearchCarProduct {

	static ObjectLocators object = new ObjectLocators()

	static openApplication() {

		'ProjectDirectory'
		String projectDir = RunConfiguration.getProjectDir()

		mobile.startApplication("$projectDir/APK/traveloka_app.apk", true)
	}

	static firstInstall() {

		'Wait Element Location'
		mobile.waitForElementPresent(object.mobileId("com.traveloka.android:id/edit_text_field"), 10)

		'Take Screenshot'
		mobile.takeScreenshot()

		'Input Location'
		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android:id/edit_text_field'])[1]"), 10)

		'Take Screenshot'
		mobile.takeScreenshot()

		'Tap Prefered Country'
		mobile.tap(object.mobileXpath("//*[@resource-id = 'com.traveloka.android:id/country_name' and (@text = 'Indonesia' or . = 'Indonesia')]"), 5)

		'Take Screenshot'
		mobile.takeScreenshot()

		'Tap Prefered Language'
		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android:id/edit_text_field'])[2]"), 5)
		
		if(mobile.waitForElementPresent(object.mobileId("com.traveloka.android:id/buttonJoin"), 5)) {
			
			'Tap Join Traveloka'
			mobile.tap(object.mobileId("com.traveloka.android:id/buttonJoin"), 5)
			
			
		} else {
			'Take Screenshot'
			mobile.takeScreenshot()
	
			'Choose Prefered Language'
			mobile.tap(object.mobileXpath("//*[(@text = 'English' or . = 'English') and @resource-id = 'com.traveloka.android:id/language_name']"), 5)
	
			'Take Screenshot'
			mobile.takeScreenshot()
	
			'Tap Continue Button'
			mobile.tap(object.mobileId("com.traveloka.android:id/on_board_button_continue"), 5)
	
			'Take Screenshot'
			mobile.takeScreenshot()
	
			'Tap Skip Intro'
			mobile.tap(object.mobileId("com.traveloka.android:id/text_skip"), 5)
	
			'Take Screenshot'
			mobile.takeScreenshot()
	
			'Tap Skip Login'
			mobile.tap(object.mobileId("com.traveloka.android:id/text_skip"), 5)
		}
	}

	@Given("User already login and navigate to Cars Menu")
	def inHomePage() {
		
		mobile.startExistingApplication(GlobalVariable.ApplicationID)
		mobile.waitForElementPresent(object.mobileId("com.traveloka.android:id/text_view_product_text"), 10)
		mobile.takeScreenshot()
		mobile.tap(object.mobileXpath("//*[(@text = 'Cars' or . = 'Cars') and @resource-id = 'com.traveloka.android:id/text_view_product_text']"), 10)
		mobile.takeScreenshot()
	}

	@When("User choose {string}")
	def chooseTypeDrive(String driveType) {
		
		mobile.takeScreenshot()
		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = 'With Driver' or . = 'With Driver') and @resource-id = 'com.traveloka.android.rental_impl:id/text_label']"), 10)
		mobile.tap(object.mobileXpath("//*[(@text = '$driveType' or . = '$driveType') and @resource-id = 'com.traveloka.android.rental_impl:id/text_label']"), 3)
		mobile.takeScreenshot()
		
	}
	
	@And("User input the Pick Up Location {string} , PickUp Date {string} Days After , Dropoff Date {string} Days After")
	def fillDataBook(String location, String pickUp, String dropOff) {
		
		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = '$location' or . = '$location') and @resource-id = 'com.traveloka.android:id/edit_text_field']"), 3)
		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android:id/edit_text_field'])[2]"), 3)
		
		Date dt = new Date()
		def todaysDate = dt.getDate()
		int pickUpDate = todaysDate + pickUp.toInteger()
		int dropOffDate = pickUpDate + dropOff.toInteger()
		
		mobile.waitForElementPresent(object.mobileId("com.traveloka.android:id/calendar_date_text"), 10)
		mobile.takeScreenshot()
		mobile.tap(object.mobileXpath("//*[@content-desc='${pickUpDate.toString()}']"), 3)
		mobile.tap(object.mobileXpath("//*[@content-desc='${dropOffDate.toString()}']"), 3)
		mobile.takeScreenshot()	 
	}
	
	@And("User tap btn Search")
	def btnSearch() {
		
		mobile.tap(object.mobileId("com.traveloka.android.rental_impl:id/button_done"), 5)
		mobile.takeScreenshot()
		mobile.tap(object.mobileId("com.traveloka.android.rental_impl:id/button_rental_search"), 5)
		mobile.takeScreenshot()
	}

	@Then("User successfully Get List Cars Provider")
	def successGetListCar() {
		
		mobile.waitForElementPresent(object.mobileId("com.traveloka.android.rental_impl:id/layout_rental_item"), 10)
		mobile.verifyElementExist(object.mobileId("com.traveloka.android.rental_impl:id/layout_rental_item"), 10)
		mobile.takeScreenshot()		
	}
}