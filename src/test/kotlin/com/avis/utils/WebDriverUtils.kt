package com.avis.utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import io.github.bonigarcia.wdm.WebDriverManager

object WebDriverUtils {
    fun getDriver(): WebDriver {
        WebDriverManager.chromedriver().setup()
        return ChromeDriver()
    }
}