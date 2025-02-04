package com.avis.tests

import com.avis.pages.AvisHomePage
import com.avis.pages.AvisSearchResultsPage
import com.avis.utils.WebDriverUtils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.WebDriver
import java.time.LocalDate
import java.time.LocalTime


class AvisSearchTest {

    private lateinit var driver: WebDriver
    private lateinit var homePage: AvisHomePage
    private lateinit var searchResultsPage: AvisSearchResultsPage

    @BeforeEach
    fun setUp() {
        driver = WebDriverUtils.getDriver()
        homePage = AvisHomePage(driver)
        homePage.navigateToHomePage()
    }

    @Test
    fun testSearchFunctionality() {
        val currenDate = LocalDate.now().dayOfMonth
        val futureDate = currenDate + 2
        val currentHour = LocalTime.now().hour
        val futureHour = currentHour + 1
        homePage.acceptCookiesButton()
        homePage.searchFor("MAD", "BCN", currenDate,currentHour ,futureDate, futureHour)
        searchResultsPage = AvisSearchResultsPage(driver)
        assertTrue(searchResultsPage.areResultsDisplayed(), "No se encontraron resultados de búsqueda")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}