package bookingCars
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
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

class PickingLocation {

	static ObjectLocators object = new ObjectLocators()

	@Given("User already choose cars and pick {string} to Pick-up Location")
	def pickupLocation(String pickupLocation) {

		mobile.waitForElementPresent(object.mobileId("com.traveloka.android.rental_impl:id/text_title"), 10)
		mobile.verifyElementExist(object.mobileId("com.traveloka.android.rental_impl:id/text_title"), 10)

		mobile.takeScreenshot()
		
		def device_Height = mobile.getDeviceHeight()
		def device_Width = mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.30
		int endY = device_Height * 0.70
		mobile.swipe(startX, endY, endX, startY)
		
		mobile.waitForElementPresent(object.mobileXpath("//*[@resource-id='com.traveloka.android.rental_impl:id/text_title' and (@text ='$pickupLocation')]"), 1)
		mobile.tap(object.mobileXpath("//*[@resource-id='com.traveloka.android.rental_impl:id/text_title' and (@text ='$pickupLocation')]"), 1)
	}

	@When("User choose detail Pick-up Location")
	def detailPickup() {

		mobile.takeScreenshot()
		mobile.waitForElementPresent(object.mobileXpath("(//*[@resource-id='com.traveloka.android.rental_impl:id/container'])[1]"), 1)
		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android.rental_impl:id/container'])[1]"), 1)
		mobile.takeScreenshot()
		mobile.tap(object.mobileXpath("//*[(@text = 'Select' or . = 'Select') and @resource-id = 'com.traveloka.android.rental_impl:id/button_action']"), 1)
	}

	@And("User input Drop-Off Location {string}")
	def dropLocation(String dropLocation) {

		mobile.takeScreenshot()
		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = 'Select Drop-off Location' or . = 'Select Drop-off Location') and @resource-id = 'com.traveloka.android.rental_impl:id/button_select']"), 1)
		mobile.tap(object.mobileXpath("//*[(@text = 'Select Drop-off Location' or . = 'Select Drop-off Location') and @resource-id = 'com.traveloka.android.rental_impl:id/button_select']"), 1)

		mobile.takeScreenshot()
		
		def device_Height = mobile.getDeviceHeight()
		def device_Width = mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.30
		int endY = device_Height * 0.70
		mobile.swipe(startX, endY, endX, startY)
		 
		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = 'Other Location' or . = 'Other Location') and @resource-id = 'com.traveloka.android.rental_impl:id/text_title']"), 1)
		mobile.tap(object.mobileXpath("//*[(@text = 'Other Location' or . = 'Other Location') and @resource-id = 'com.traveloka.android.rental_impl:id/text_title']"), 1)

		Random rand = new Random()
		int randIndex = rand.nextInt(2)+1

		mobile.takeScreenshot()
		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android.rental_impl:id/text_view_title'])[${randIndex}]"), 1)
	}

	@And("User input notes in Pick-up and Drop-off Location")
	def inputNotes() {
		mobile.takeScreenshot()
		mobile.sendKeys(object.mobileXpath("//*[@class = 'android.widget.EditText' and (@text = 'Add the details of your location (optional)' or . = 'Add the details of your location (optional)') and @resource-id = 'com.traveloka.android:id/edit_text_field']"), "TESTING")
		mobile.takeScreenshot()
	}

	@Then("User successfully Picking Location Car")
	def successPickingLocation() {

		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = 'Continue' or . = 'Continue') and @resource-id = 'com.traveloka.android.rental_impl:id/button_action']"), 1)
		mobile.tap(object.mobileXpath("//*[(@text = 'Continue' or . = 'Continue') and @resource-id = 'com.traveloka.android.rental_impl:id/button_action']"), 1)
	}
}