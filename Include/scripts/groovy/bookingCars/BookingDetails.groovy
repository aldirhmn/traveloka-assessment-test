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

class BookingDetails {
	
	static ObjectLocators object = new ObjectLocators()
	
	@Given("User already booking car and in Detail Booking Page")
	def bookingDetailsPage() {
		
		mobile.waitForElementPresent(object.mobileId("com.traveloka.android.rental_impl:id/text_tap_to_see"), 10)
		mobile.verifyElementExist(object.mobileId("com.traveloka.android.rental_impl:id/text_tap_to_see"), 10)
		mobile.takeScreenshot()
		
	}

	@When("User fill Contact Details and Driver Details")
	def contactDetails() {
		
		
		def device_Height = mobile.getDeviceHeight()
		def device_Width = mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.30
		int endY = device_Height * 0.70
		mobile.swipe(startX, endY, endX, startY)
		
		mobile.takeScreenshot()
		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = 'CONTINUE' or . = 'CONTINUE') and @resource-id = 'com.traveloka.android.trip_impl:id/text_view_see_below_view']"), 3)
		mobile.tap(object.mobileXpath("//*[(@text = 'CONTINUE' or . = 'CONTINUE') and @resource-id = 'com.traveloka.android.trip_impl:id/text_view_see_below_view']"), 1)
	}
		
	@And("User fill Special Request and Check All Rental Requirement")
	def specialRequest() {
		
		mobile.takeScreenshot()
		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = 'Car Rental Special Request (optional)' or . = 'Car Rental Special Request (optional)')]"), 3)
		mobile.tap(object.mobileXpath("//*[@class = 'android.widget.TextView' and (@text = 'Add a special request' or . = 'Add a special request')]"), 1)
		
		mobile.takeScreenshot()
		mobile.sendKeys(object.mobileId("com.traveloka.android.rental_impl:id/edit_text_special_request"), "AUTOMATION TESTING")
		mobile.takeScreenshot()
		mobile.tap(object.mobileId("com.traveloka.android.rental_impl:id/button_save"), 2)
		mobile.takeScreenshot()
		
		mobile.tap(object.mobileXpath("//*[@class = 'android.widget.TextView' and (@text = 'Tap to check the requirements.*' or . = 'Tap to check the requirements.*')]"), 1)
		mobile.takeScreenshot()
		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android.rental_impl:id/check_box'])[1]"), 1)
		
		def device_Height = mobile.getDeviceHeight()
		def device_Width = mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.30
		int endY = device_Height * 0.70
		mobile.swipe(startX, endY, endX, startY)
		
		mobile.takeScreenshot()
		mobile.waitForElementPresent(object.mobileXpath("//*[(@text = 'Done' or . = 'Done') and @resource-id = 'com.traveloka.android.rental_impl:id/button_save']"), 3)
		mobile.tap(object.mobileXpath("//*[(@text = 'Done' or . = 'Done') and @resource-id = 'com.traveloka.android.rental_impl:id/button_save']"), 1)
		
		
		mobile.takeScreenshot()

		mobile.swipe(startX, endY, endX, startY)
		
		mobile.tap(object.mobileId("com.traveloka.android.trip_impl:id/button_continue"), 1)
		mobile.takeScreenshot()
		mobile.tap(object.mobileId("com.traveloka.android:id/widget_button_blue"), 1)
	}

	@And("User select payment method and process payment")
	def selectPaymentMethod() {
		
//		mobile.waitForElementPresent(object.mobileId("com.traveloka.android:id/text_view_selected_payment_method"), 20)
//		mobile.takeScreenshot()
//		mobile.tap(object.mobileId("com.traveloka.android:id/button_pay_now"), 1)
	}
	
	@Then("User successfully Booking a Car")
	def succesfully() {
		
//		mobile.waitForElementPresent(object.mobileId("com.traveloka.android:id/text_view_selected_payment_method"), 20)
//		mobile.verifyElementExist(object.mobileId("com.traveloka.android:id/text_view_selected_payment_method"), 20)
//		mobile.takeScreenshot()
	}
}