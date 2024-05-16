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

class ChooseCar {

	static ObjectLocators object = new ObjectLocators()

	@Given("User already in List Cars Provider and Choose Cars to Book")
	def chooseCars() {

		mobile.waitForElementPresent(object.mobileId("com.traveloka.android.rental_impl:id/layout_rental_item"), 10)
		mobile.verifyElementExist(object.mobileId("com.traveloka.android.rental_impl:id/layout_rental_item"), 10)

		Random rand = new Random()
		int randomIndex = rand.nextInt(3) + 1

		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android.rental_impl:id/layout_rental_item'])[${randomIndex.toString()}]"), 3)
		mobile.takeScreenshot()
	}

	@When("User choose Cars Provider")
	def carProvider() {

		mobile.waitForElementPresent(object.mobileXpath("(//*[@resource-id='com.traveloka.android.rental_impl:id/layout_rental_item'])[1]"), 10)
		mobile.tap(object.mobileXpath("(//*[@resource-id='com.traveloka.android.rental_impl:id/layout_rental_item'])[1]"), 3)
		mobile.takeScreenshot()
	}

	@Then("User success choosing Cars")
	def successChoosing() {
		
		mobile.waitForElementPresent(object.mobileId("com.traveloka.android.rental_impl:id/text_car_type"), 10)
		mobile.tap(object.mobileXpath("//*[(@text = 'Continue' or . = 'Continue') and @resource-id = 'com.traveloka.android.rental_impl:id/button_action']"), 3)		
	}
}