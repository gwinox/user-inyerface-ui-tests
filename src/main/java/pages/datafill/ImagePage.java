package pages.datafill;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;

public class ImagePage extends Form {

    private final ICheckBox unselectAllCheckbox = getElementFactory().getCheckBox(By.xpath("//span[text()='Unselect all']/..//label"), "Unselect All");
    private final IButton uploadButton = getElementFactory().getButton(By.xpath("//*[contains(@class, 'avatar-and-interests__upload-button')]"), "Upload");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[contains(text(), 'Next')]"), "Next");
    private final By interestLocator = By.xpath("//label[not(contains(@for, 'selectall'))]");

    public ImagePage() {
        super(By.xpath("//*[@class = 'avatar-and-interests']"), "Image Page");
    }

    public void unselectAll() {
        unselectAllCheckbox.check();
    }

    public void selectRandomInterests(int interestCount) {
        List<ICheckBox> checkBoxList = getElementFactory().findElements(interestLocator, ElementType.CHECKBOX);

        Collections.shuffle(checkBoxList);

        for (int i = 0; i < interestCount; i++) {
            checkBoxList.get(i).check();
        }
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }
}