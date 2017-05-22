package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import ru.spbau.mit.testing.Locators

class OffersPage(driver: WebDriver) : BasePage(driver) {
    private val wait = WebDriverWait(driver, 10)
    val offersBlock get() = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(Locators.offersBlock)))
    val prices get() = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.pricesList)))
    val sortButton get() = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(Locators.sortPricesButton)))
    val nextButton get() = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(Locators.pricesNextButton)))

    fun sortPrices() {
        Actions(driver).moveToElement(sortButton).click().perform()
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.preloader))
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Locators.preloader))
    }

    fun loadNextPage(): OffersPage {
        Actions(driver).moveToElement(nextButton).click().perform()
        return OffersPage(driver)
    }
}