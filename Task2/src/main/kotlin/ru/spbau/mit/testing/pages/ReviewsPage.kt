package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

class ReviewsPage(driver: WebDriver) : BasePage(driver) {
    val reviewsBlock get() = driver.findElement(Locators.reviewsBlock)

}