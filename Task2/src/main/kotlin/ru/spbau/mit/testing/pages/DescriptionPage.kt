package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

class DescriptionPage(driver: WebDriver) : BasePage(driver) {
    /* items */
    val shortSpecification get() = driver.findElement(Locators.specifications)
    val topOffers get() = driver.findElements(Locators.topOffers)

    /* actions */

}

