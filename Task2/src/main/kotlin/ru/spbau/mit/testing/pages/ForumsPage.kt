package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators
class ForumsPage(driver: WebDriver) : BasePage(driver) {
    val commentsBlock get() = driver.findElement(Locators.commentsBlock)
    val topOffers get() = driver.findElements(Locators.topOffers)
}