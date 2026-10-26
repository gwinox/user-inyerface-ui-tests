package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        ISettingsFile environment = new JsonSettingsFile("config.json");
        String url = environment.getValue("/baseUrl").toString();
        AqualityServices.getBrowser().maximize();
        AqualityServices.getBrowser().goTo(url);

    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}