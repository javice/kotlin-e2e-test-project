package com.avis.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class AvisSearchResultsPage(private val driver: WebDriver) {

    // Elementos de la página
    private val results: List<WebElement> get() = driver.findElements(By.xpath("//*[@id=\"gridview\"]/div[1]/div/div"))

    // Acciones de la página
    fun areResultsDisplayed(): Boolean {
        return results.isNotEmpty()
    }

    fun getNumberOfResults(): Int {
        return results.size
    }
}