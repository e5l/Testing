package ru.spbau.mit.testing

import org.junit.After
import org.junit.Before
import org.junit.Test
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
        browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        browser.get(url)
    }

    @Test
    fun presenceTest() {
        BasePage(browser)
                .descriptionClick()
                .apply {
                    checkBasePage()
                    assert(shortSpecification.isDisplayed)
                }.specificationsClick()
                .apply {
                    checkBasePage()
                }.offersClick()
                .apply {
                    checkBasePage()
                }.mapClick()
                .apply {
                    checkBasePage()
                }.reviewsClick()
                .apply {
                    checkBasePage()
                }.forumsClick()
                .apply {
                    checkBasePage()
                }
    }

    @Test
    fun sortedPricesTest() {
        val offersPage = BasePage(browser).offersClick()
        offersPage.sortPrices()
        Thread.sleep(2000)

        val prices = offersPage.prices.map { it.text.split(" ").dropLast(1).joinToString("").toInt() }
        assert(prices.subList(1, prices.size).isSorted())
    }

    @After
    fun cleanup() {
        browser.close()
    }

}

private fun <E : Comparable<E>> List<E>.isSorted(): Boolean {
    return (0..size-2).none { get(it) < get(it + 1) }
}

private fun BasePage.checkBasePage() {
    val items = listOf(name, image, price, descriptionTab, specsTab, offersTab, mapTab, reviewsTab, articlesTab,
            forumsTab, toCartButton, toWishlistButton, toCompareButton)

    items.forEach { assert(it!!.isDisplayed, { "Check for: $it" }) }
}

