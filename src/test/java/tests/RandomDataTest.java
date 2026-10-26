package tests;

import aquality.selenium.browser.AqualityServices;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.datafill.EmailPage;
import pages.datafill.ImagePage;
import pages.MainPage;
import pages.datafill.PersonalDetailsPage;
import utils.RandomDataGenerator;
import utils.RobotUtils;
import utils.ConfigManager;

import java.io.File;

public class RandomDataTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage();
        EmailPage emailPage = new EmailPage();
        ImagePage imagePage = new ImagePage();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();

        AqualityServices.getLogger().info("Открытие главной страницы");
        Assert.assertTrue(mainPage.state().waitForDisplayed(), String.format("The %s didn't open", mainPage.getName()));

        AqualityServices.getLogger().info("Переход к регистрации");
        mainPage.clickNextLink();

        AqualityServices.getLogger().info("Генерация случайных тестовых данных");
        String emailPrefix = RandomDataGenerator.getRandomEmailPrefix();
        String emailDomain = RandomDataGenerator.getRandomEmailDomain();
        String password = RandomDataGenerator.getRandomPassword(emailPrefix);

        Assert.assertTrue(emailPage.state().waitForDisplayed(), String.format("The %s didn't open", emailPage.getName()));

        AqualityServices.getLogger().info("Заполнение данных учётной записи");
        emailPage.insertPassword(password);
        emailPage.insertEmail(emailPrefix);
        emailPage.insertEmailDomain(emailDomain);
        emailPage.selectRandomDomain();
        emailPage.uncheckTermsNConditionsCheckbox();
        emailPage.clickNextButton();

        Assert.assertTrue(imagePage.state().waitForDisplayed(), String.format("The %s didn't open", imagePage.getName()));

        int interestsCount = ConfigManager.getInt("/interestsCount");
        AqualityServices.getLogger().info("Выбор интересов и загрузка аватара");
        imagePage.unselectAll();
        imagePage.selectRandomInterests(interestsCount);

        String relativePath = ConfigManager.getValue("/imagePath");
        String absolutePathPicture = new File(relativePath).getAbsolutePath();
        imagePage.clickUploadButton();
        RobotUtils.uploadFile(absolutePathPicture);
        imagePage.clickNextButton();

        AqualityServices.getLogger().info("Проверка перехода к личным данным");
        Assert.assertTrue(personalDetailsPage.state().waitForDisplayed(), String.format("The %s didn't open", personalDetailsPage.getName()));
    }
}