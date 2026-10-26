package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final ILink nextLink = getElementFactory().getLink(By.xpath("//*[contains(@href, 'game')]"), "Next Page");

    public MainPage() {
        super(By.xpath("//*[contains(@href, 'game')]"), "Main Page");
    }

    public void clickNextLink() {
        nextLink.click();
    }
}