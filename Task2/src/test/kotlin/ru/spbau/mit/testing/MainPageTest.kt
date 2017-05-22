package ru.spbau.mit.testing

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import ru.spbau.mit.testing.pages.BasePage
import java.net.URL
import java.util.concurrent.TimeUnit

class MainPageTest {
    val url = "https://market.yandex.ru/product/1720217048/offers?hid=91491&how=aprice&local-offers-first=0&deliveryincluded=0"
    val browser = RemoteWebDriver(URL("http://localhost:9515"), DesiredCapabilities.chrome())

    @Before
    fun init() {
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(5, TimeUnit.SECONDS).setScriptTimeout(5, TimeUnit.SECONDS)
        browser.get(url)
    }

    @Test
    fun presenceTest() {
        BasePage(browser)
                .descriptionClick()
                .apply {
                    checkBasePage()
                    assert(shortSpecification.isDisplayed)
                    assert(topOffers.isNotEmpty())
                }.specificationsClick()
                .apply {
                    checkBasePage()
                    assert(fullSpecification!!.isDisplayed)
                    assert(topOffers.isNotEmpty())
                    assert(recommendations.isNotEmpty())
                }.offersClick()
                .apply {
                    checkBasePage()
                    assert(offersBlock.isDisplayed)
                }.mapClick()
                .apply {
                    checkBasePage()
                    assert(mapBlock.isDisplayed)
                }.reviewsClick()
                .apply {
                    checkBasePage()
                    assert(reviewsBlock.isDisplayed)
                    assert(topOffers.isNotEmpty())
                }.articlesClick()
                .apply {
                    checkBasePage()
                    assert(articlesBlock.isDisplayed)
                    assert(topOffers.isNotEmpty())
                }.forumsClick()
                .apply {
                    checkBasePage()
                    assert(commentsBlock.isDisplayed)
                    assert(topOffers.isNotEmpty())
                }
    }

    @Test
    fun sortedPricesTest() {
        var offersPage = BasePage(browser).offersClick()
        offersPage.sortPrices()

        val prices = mutableListOf<Int>()
        while (offersPage.driver.findElements(Locators.pricesNextButton).isNotEmpty()) {
            var current: List<Int>? = null
            while (current == null) {
                try {
                     current = offersPage.prices.map { it.text.split("руб.")[0].filterNot { it == ' ' }.toInt() }
                } catch (e: StaleElementReferenceException) {}
            }
            prices.addAll(current.subList(1, current.size))
            offersPage = offersPage.loadNextPage()
        }

        val page = offersPage.prices.map { it.text.split("руб.")[0].filterNot { it == ' ' }.toInt() }
        prices.addAll(page.subList(1, page.size))

        assert(prices.isSorted())
    }

    @After
    fun cleanup() {
        browser.close()
    }

}

private fun <E : Comparable<E>> List<E>.isSorted(): Boolean {
    return (0..size - 2).none { get(it) < get(it + 1) }
}

private fun BasePage.checkBasePage() {
    val items = listOf(name, image, price, descriptionTab, specsTab, offersTab, mapTab, reviewsTab, articlesTab,
            forumsTab, toCartButton, toWishlistButton, toCompareButton)

    items.forEach { assert(it!!.isDisplayed, { "Check for: $it" }) }

    checkPrice(price!!)
}

private fun checkPrice(price: WebElement) {
    assert(price.text.endsWith("руб."))
    assert(price.text.split("руб.")[0].filterNot { it == ' ' }.toInt() > 0)
}

