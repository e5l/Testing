package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

class ArticlesPage(driver: WebDriver) : BasePage(driver) {
    val articlesBlock get() = driver.findElement(Locators.articlesBlock)
}