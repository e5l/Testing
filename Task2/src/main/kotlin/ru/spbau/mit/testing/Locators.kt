package ru.spbau.mit.testing

import org.openqa.selenium.By

object Locators {
    val name = By.xpath("//h1[@itemprop=\"name\"]")

    val price = By.className("price")

    val image = By.xpath("//img[@itemprop=\"image\"]")

    val specifications = By.className("n-product-spec-list")

    val descriptionTab = By.xpath("""//li[@data-name="product"]/a""")

    val specificationTab = By.xpath("""//li[@data-name="spec"]/a""")

    val offersTab = By.xpath("""//li[@data-name="offers"]/a""")

    val mapTab = By.xpath("""//li[@data-name="geo"]/a""")

    val reviewsTab = By.xpath("""//li[@data-name="reviews"]/a""")

    val articlesTab = By.xpath("""//li[@data-name="articles"]/a""")

    val forumsTab = By.xpath("""//li[@data-name="forums"]/a""")

    val toCartButton = By.className("""button2_to_cart""")

    val wishlistButton = By.className("wishlist-control")

    val toCompareButton = By.className("product-action-compare")

    val pricesList = By.xpath("""//*[@class="price" and not(@class="price_unactual_yes")]""")

    val sortPricesButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[3]/a")

    val fullSpecs = By.className("n-product-spec-wrap")

    val offersBlock = By.className("i-product-offers")

    val mapBlock = By.className("n-geo")

    val reviewsBlock = By.className("reviews-layout")

    val articlesBlock = By.className("product-articles")

    val commentsBlock = By.className("product-forums")

    val topOffers = By.className("n-product-top-offer")

    val recommentationItems = By.className("n-w-product-recipes-list__item")

    val pricesNextButton = By.className("n-pager__button-next")

    val preloader = By.className("preloadable__preloader")
}
