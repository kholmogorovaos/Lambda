import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    public boolean isDisplayed() {
        return $(".header_secondary_container")
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    public boolean burgerIsDisplayed() {
        return $(".bm-burger-button")
                .shouldBe(Condition.visible)
                .isDisplayed();
    }
    public void openBurgerMenu() {
        $(".bm-burger-button").click();
    }
    public boolean isLogoutButtonDisplayed() {
        return $("#logout_sidebar_link")
                .shouldBe(visible, Duration.ofSeconds(20))
                .isDisplayed();
    }
    public void logout() {
        $("#logout_sidebar_link").click();
    }
}
