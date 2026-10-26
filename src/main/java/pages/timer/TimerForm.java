package pages.timer;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TimerForm extends Form {

    private final ILabel timerValue = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'timer')]"), "Timer");

    public TimerForm() {
        super(By.xpath("//*[contains(@class, 'timer')]"), "Timer Form");
    }

    public String getTimerText() {
        return timerValue.getText();
    }
}