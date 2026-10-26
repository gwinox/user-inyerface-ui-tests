package pages.cookies;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {

    private final IButton noButton = getElementFactory().getButton(By.xpath("//button[contains(text(), 'no')]"),
            "No");

    public CookiesForm() {
        super(By.className("cookies"), "Cookies Form");
    }

    public void clickNoButton() {
        noButton.click();
    }
}