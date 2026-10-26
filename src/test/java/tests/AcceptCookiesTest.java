package tests;

import aquality.selenium.browser.AqualityServices;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.cookies.CookiesForm;
import pages.datafill.EmailPage;

public class AcceptCookiesTest extends BaseTest {

    @Test
    public void testAcceptCookies() {
        MainPage mainPage = new MainPage();
        EmailPage emailPage = new EmailPage();
        CookiesForm cookiesForm = new CookiesForm();

        AqualityServices.getLogger().info("Открытие главной страницы");
        Assert.assertTrue(mainPage.state().waitForDisplayed(), String.format("The %s didn't open", mainPage.getName()));
        mainPage.clickNextLink();

        Assert.assertTrue(emailPage.state().waitForDisplayed(), String.format("The %s didn't open", emailPage.getName()));

        AqualityServices.getLogger().info("Принятие cookies");
        Assert.assertTrue(cookiesForm.state().waitForDisplayed(), String.format("The %s didn't appear", cookiesForm.getName()));
        cookiesForm.clickNoButton();

        AqualityServices.getLogger().info("Проверка закрытия формы cookies");
        Assert.assertTrue(cookiesForm.state().waitForNotDisplayed(), String.format("The %s is still displayed on the screen", cookiesForm.getName()));
    }
}