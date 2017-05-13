package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

class MapPage(driver: WebDriver) : BasePage(driver) {
    val mapBlock get() = driver.findElement(Locators.mapBlock)
}