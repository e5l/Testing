package ru.spbau.mit.testing.pages

import org.openqa.selenium.WebDriver
import ru.spbau.mit.testing.Locators

open class BasePage(val driver: WebDriver) {

    val name get() = driver.findElement(Locators.name)
    val image get() = driver.findElement(Locators.image)
    val price get() = driver.findElement(Locators.price)

    /* tabs */
    val descriptionTab get() = driver.findElement(Locators.descriptionTab)
    val specsTab get() = driver.findElement(Locators.specificationTab)
    val offersTab get() = driver.findElement(Locators.offersTab)
    val mapTab get() = driver.findElement(Locators.mapTab)
    val reviewsTab get() = driver.findElement(Locators.reviewsTab)
    val articlesTab get() = driver.findElement(Locators.articlesTab)
    val forumsTab get() = driver.findElement(Locators.forumsTab)

    val toCartButton get() = driver.findElement(Locators.toCartButton)
    val toWishlistButton get() = driver.findElement(Locators.wishlistButton)
    val toCompareButton get() = driver.findElement(Locators.toCompareButton)

    fun descriptionClick(): DescriptionPage {
        descriptionTab.click()
        return DescriptionPage(driver)
    }

    fun specificationsClick(): SpecsPage {
        specsTab.click()
        return SpecsPage(driver)
    }

    fun offersClick(): OffersPage {
        offersTab.click()
        return OffersPage(driver)
    }

    fun mapClick(): MapPage {
        mapTab.click()
        return MapPage(driver)
    }

    fun reviewsClick(): ReviewsPage {
        reviewsTab.click()
        return ReviewsPage(driver)
    }

    fun articlesClick(): ArticlesPage {
        articlesTab.click()
        return ArticlesPage(driver)
    }

    fun forumsClick(): ForumsPage {
        forumsTab.click()
        return ForumsPage(driver)
    }

    fun addToCart() {
        toCartButton.click()
    }

    fun addToWishList() {
        toWishlistButton.click()
    }

    fun addToCompare() {
        toCompareButton.click()
    }
}

