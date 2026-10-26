package pages.help;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    private static final int MIN_FORM_HEIGHT = 10;

    private final IButton sendToBottomButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'send-to-bottom-button')]"), "Send To Bottom");
    private final ILabel helpFormElement = getElementFactory().getLabel(By.className("help-form"), "Help Form");

    public HelpForm() {
        super(By.className("help-form"), "Help Form");
    }

    public void clickSendToBottomButton() {
        sendToBottomButton.click();
    }

    public boolean isFormHidden() {
        return AqualityServices.getConditionalWait().waitFor(() -> helpFormElement.getElement().getSize().getHeight() <= MIN_FORM_HEIGHT);
    }
}