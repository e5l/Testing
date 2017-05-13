package ru.spbau.mit.testing

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

/* TODO
1. Base elements on pages
2. Write existing test
3. Write sequence sorted test
 */

fun main(args: Array<String>) {
    val browser = RemoteWebDriver(URL("http://localhost:9515"), DesiredCapabilities.chrome())
    val url = "https://market.yandex.ru/product/1720217048/offers?hid=91491&how=aprice&local-offers-first=0&deliveryincluded=0"

    browser.get(url)
    browser.close()
}


