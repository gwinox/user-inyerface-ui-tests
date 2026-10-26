package tests;

import aquality.selenium.browser.AqualityServices;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.datafill.EmailPage;
import pages.help.HelpForm;

public class HideHelpFormTest extends BaseTest {

    @Test
    public void testHideHelpForm() {
        MainPage mainPage = new MainPage();
        EmailPage emailPage = new EmailPage();
        HelpForm helpForm = new HelpForm();

        AqualityServices.getLogger().info("Открытие главной страницы");
        Assert.assertTrue(mainPage.state().waitForDisplayed(), String.format("The %s didn't open", mainPage.getName()));
        mainPage.clickNextLink();

        AqualityServices.getLogger().info("Скрытие формы помощи");
        Assert.assertTrue(emailPage.state().waitForDisplayed(), String.format("The %s didn't open", emailPage.getName()));
        helpForm.clickSendToBottomButton();

        AqualityServices.getLogger().info("Проверка скрытия формы помощи");
        Assert.assertTrue(helpForm.isFormHidden(), String.format("The %s is still displayed on the screen", helpForm.getName()));
    }
}