package com.avis.tests

import com.avis.pages.AvisHomePage
import com.avis.utils.WebDriverUtils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.WebDriver

class AvisHomePageTest {

    private lateinit var driver: WebDriver
    private lateinit var homePage: AvisHomePage

    @BeforeEach
    fun setUp() {
        driver = WebDriverUtils.getDriver()
        homePage = AvisHomePage(driver)
        homePage.navigateToHomePage()
    }

    @Test
    fun testAcceptCookies() {
        homePage.acceptCookiesButton()
        //assertTrue(homePage.areCookiesAccepted(), "No se aceptaron las cookies")
    }

    @Test
    fun testHomePageTitle() {
        val title = homePage.getPageTitle()
        assertTrue(title.contains("Avis"), "El título de la página no es correcto")
    }

    @Test
    fun testSearchBarIsDisplayed() {
        assertTrue(homePage.isSearchBarDisplayed(), "La barra de búsqueda no está visible")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}