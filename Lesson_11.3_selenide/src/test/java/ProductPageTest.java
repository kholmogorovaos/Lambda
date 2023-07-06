import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPageTest {
    private SelenideElement productsLabel = $(".header_secondary_container");
    SelenideElement burgerButton = $(".bm-burger-button");
    private SelenideElement logoutButton = $("#logout_sidebar_link");

    public boolean isDisplayed() {
        return productsLabel.isDisplayed();
    }
    public void openBurgerMenu() {
        burgerButton.click();
    }
    public boolean isLogoutButtonDisplayed() {
        $(logoutButton).shouldBe(visible, Duration.ofSeconds(20));
        return logoutButton.isDisplayed();
    }
    public void logout() {
        logoutButton.click();
    }
}
