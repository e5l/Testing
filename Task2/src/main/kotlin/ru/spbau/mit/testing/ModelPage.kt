package ru.spbau.mit.testing

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ModelPage(val driver: WebDriver) {
    /* stats */
    val name
        get() = getByXPath("//h1[@itemprop=\"name\"]")

    val price
        get() = driver.findElement(By.className("price"))!!

    val image
        get() = getByXPath("//img[@itemprop=\"image\"]")

    val specsList
        get() = driver.findElement(By.className("n-product-spec-list"))

    /* tabs */
    val description
        get() = getByXPath("""//li[@data-name="product"]/a""")

    val specification
        get() = getByXPath("""//li[@data-name="spec"]/a""")

    val offers
        get() = getByXPath("""//li[@data-name="offers"]/a""")

    val map
        get() = getByXPath("""//li[@data-name="geo"]/a""")

    val reviews
        get() = getByXPath("""//li[@data-name="reviews"]/a""")

    val articles
        get() = getByXPath("""//li[@data-name="articles"]/a""")

    val forums
        get() = getByXPath("""//li[@data-name="forums"]/a""")

    /* buttons */
    val 

    private fun getByXPath(path: String) = driver.findElement(By.xpath(path))!!
}

