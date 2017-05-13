package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

class SpecsPage(driver: WebDriver) : BasePage(driver) {
    val fullSpecification get() = driver.findElement(Locators.fullSpecs)
}
