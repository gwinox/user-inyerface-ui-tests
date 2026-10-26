package tests;

import aquality.selenium.browser.AqualityServices;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.datafill.EmailPage;
import pages.timer.TimerForm;
import utils.ConfigManager;

public class TimerTest extends BaseTest {

    @Test
    public void testTimerStartsAtZero() {
        MainPage mainPage = new MainPage();
        EmailPage emailPage = new EmailPage();
        TimerForm timerForm = new TimerForm();

        AqualityServices.getLogger().info("Открытие главной страницы");
        Assert.assertTrue(mainPage.state().waitForDisplayed(), String.format("The %s didn't open", mainPage.getName()));
        mainPage.clickNextLink();

        Assert.assertTrue(emailPage.state().waitForDisplayed(), String.format("The %s didn't open", emailPage.getName()));
        AqualityServices.getLogger().info("Проверка начального значения таймера");

        String actualTimerText = timerForm.getTimerText();
        String expectedTimerText = ConfigManager.getValue("/timerExpectedTime");
        Assert.assertTrue(actualTimerText.startsWith(expectedTimerText),
                String.format("Таймер не начался с %s. Фактическое время: '%s'", expectedTimerText, actualTimerText));
    }
}