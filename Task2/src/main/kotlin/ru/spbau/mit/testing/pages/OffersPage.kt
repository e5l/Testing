package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

class OffersPage(driver: WebDriver) : BasePage(driver) {
    val offersBlock get() = driver.findElement(Locators.offersBlock)
    val prices get() = driver.findElements(Locators.pricesList)
    val sortButton get() = driver.findElement(Locators.sortPricesButton)

    fun sortPrices() {
        sortButton.click()
    }
}