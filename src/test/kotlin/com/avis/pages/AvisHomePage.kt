package com.avis.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.html5.Location
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import java.util.*


class AvisHomePage(private val driver: WebDriver) {

    // Elementos de la página
    //private val searchButton: WebElement get() = driver.findElement(By.id("searchButton"))
    private val acceptCookiesButton: WebElement get() = driver.findElement(By.id("consent_prompt_accept"))
    private val rbtnCar: WebElement get() = driver.findElement(By.id("fleet-car"))
    private val rbtnVan: WebElement get() = driver.findElement(By.id("fleet-van"))
    private val pickupLocation: WebElement get() = driver.findElement(By.id("hire-search"))
    //private val chkReturnLocation: WebElement get() = driver.findElement(By.xpath("//*[@id=\"trigger-return-location\"]"))
    private val chkReturnLocation: WebElement get() = driver.findElement(By.xpath("//label[@for='trigger-return-location']"))
    //findElement(By.id("trigger-return-location"))
    //*[@id="trigger-return-location"]
    private val returnLocation: WebElement get() = driver.findElement(By.id("return-search"))
    private val cmbPickupDate: WebElement get() = driver.findElement(By.id("date-from-display"))
    private val cmbPickupTime: WebElement get() = driver.findElement(By.id("time-from-display"))
    private val cmbReturnDate: WebElement get() = driver.findElement(By.id("date-to-display"))
    private val cmbReturnTime: WebElement get() = driver.findElement(By.id("time-to-display"))
    private val rbtnLeisure: WebElement get() = driver.findElement(By.xpath("//*[@id=\"getAQuote\"]/div[4]/ul/li[1]/label"))
    //private val rbtnLeisure: WebElement get() = driver.findElement(By.id("radio-item-1"))
    //*[@id="getAQuote"]/div[4]/ul/li[1]/label
    private val btnSearch: WebElement get() = driver.findElement(By.ByCssSelector("#getAQuote > div.standard-form__actions > button"))

    // Acciones de la página
    fun navigateToHomePage() {
        driver.get("https://www.avis.es")
    }

    fun getPageTitle(): String {
        return driver.title
    }

    fun acceptCookiesButton() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consent_prompt_accept")))
        acceptCookiesButton.click()
    }

    fun isSearchBarDisplayed(): Boolean {
        return pickupLocation.isDisplayed
    }

    fun selectLocation(driver: WebDriver, location: String) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        val locationButton: WebElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@data-station-code='$location']")
        ))
        locationButton.click()
    }

    fun selectDate(driver: WebDriver, day: Int, pickup: Int) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        val defDay = day -12
        if (pickup == 0) {
            val dayButton: WebElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"getAQuote\"]/div[3]/div[1]/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[$day]/button")
                //*[@id="getAQuote"]/div[3]/div[1]/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[3]/button
            ))
            dayButton.click()
        } else{
            val dayButton: WebElement = wait.until(ExpectedConditions.elementToBeClickable(
                //*[@id="getAQuote"]/div[3]/div[2]/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[4]/button
                By.xpath("//*[@id=\"getAQuote\"]/div[3]/div[2]/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[$defDay]/button")

            ))
            dayButton.click()
        }

    }
    //*[@id="getAQuote"]/div[3]/div[2]/div/div[1]/div/div/div[1]/table/tbody/tr[3]/td[1]/button
    fun selectTime(driver: WebDriver, hour: Int, pickup: Int) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        if (pickup == 0){
            val hourSelect: WebElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"getAQuote\"]/div[3]/div[1]/div/div[2]/div/div/ul/li[($hour*2)+1]")
                //*[@id="getAQuote"]/div[3]/div[2]/div/div[2]/div/div[2]/ul/li[35]
            ))
            hourSelect.click()
        } else {
            val hourSelect: WebElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"getAQuote\"]/div[3]/div[2]/div/div[2]/div/div/ul/li[($hour*2)+1]")
            ))
            hourSelect.click()
        }
    }


    fun searchFor(pickupStation: String, returnStation: String, pickupDate: Int, pickupTime: Int, returnDate: Int, returnTime: Int) {

        pickupLocation.sendKeys(pickupStation)
        selectLocation(driver, pickupStation)
        chkReturnLocation.click()
        returnLocation.sendKeys(returnStation)
        selectLocation(driver, returnStation)
        cmbPickupDate.click()
        selectDate(driver, pickupDate,0)
        cmbPickupTime.click()
        selectTime(driver, pickupTime,0)
        cmbReturnDate.click()
        selectDate(driver, returnDate,1)
        cmbReturnTime.click()
        selectTime(driver, returnTime,1)
        rbtnLeisure.click()
        btnSearch.click()
    }
}