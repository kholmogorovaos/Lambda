import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageActions {
    private final String logoText = "Swag Labs";
    public void login(String username, String password) {
        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $(".btn_action").click();
    }
    public boolean isLoginPageDisplayed() {
        return  $(By.xpath(".//*[contains(@class, 'login_logo')]"))
                .shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text(logoText))
                .isDisplayed();
    }
}
