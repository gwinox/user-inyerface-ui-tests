package pages.datafill;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomInt;

import java.util.List;

public class EmailPage extends Form {

    private final ITextBox passwordInput = getElementFactory().getTextBox(By.xpath("//*[@class = 'login-form__field-row']//input"), "Password");
    private final ITextBox emailInput = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'email')]"), "Email");
    private final ITextBox domainInput = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"), "Domain");
    private final IButton dropdownOpener = getElementFactory().getButton(By.className("dropdown__opener"), "Dropdown Opener");
    private final ICheckBox termsNConditionsCheckbox = getElementFactory().getCheckBox(By.className("checkbox__box"), "Terms and Conditions");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//*[@class = 'button--secondary']"), "Next");
    private final By domainOptionsLocator = By.xpath("//*[contains(@class, 'dropdown__list-item') and text() != 'other']");

    public EmailPage() {
        super(By.xpath("//*[@class = 'login-form']"), "Email Page");
    }

    public void insertPassword(String password) {
        passwordInput.clearAndType(password);
    }

    public void insertEmailDomain(String domain) {
        domainInput.clearAndType(domain);
    }

    public void insertEmail(String email) {
        emailInput.clearAndType(email);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void uncheckTermsNConditionsCheckbox() {
        termsNConditionsCheckbox.click();
    }

    public void selectRandomDomain() {
        dropdownOpener.click();

        List<ILabel> domainList = getElementFactory().findElements(domainOptionsLocator, ElementType.LABEL);

        int randomIndex = RandomInt.getRandomInt(domainList.size());

        domainList.get(randomIndex).click();
    }
}