package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

class SpecsPage(driver: WebDriver) : BasePage(driver) {
    val fullSpecification get() = driver.findElement(Locators.fullSpecs)
    val topOffers get() = driver.findElements(Locators.topOffers)
    val recommendations get() = driver.findElements(Locators.recommentationItems)
}
