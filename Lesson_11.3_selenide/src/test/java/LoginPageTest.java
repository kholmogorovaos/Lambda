import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest {
    private final String pageUrl = "https://www.saucedemo.com";
    private final String logoText = "Swag Labs";
    private SelenideElement usernameField = $("#user-name");
    private SelenideElement passwordField = $("#password");
    private SelenideElement loginButton = $(".btn_action");

    @Test
    @DisplayName ("Test for lesson 11.3_1 - Проверка открытия страницы www.saucedemo.com")
    public void LoginPage() {
        open(pageUrl);

        $x(".//*[contains(@class, 'login_logo')]").shouldBe(Condition.visible).shouldHave(text(logoText));
    }

    @Test
    @DisplayName ("Test for lesson 11.3_2 - Проверка переходов по кнопкам страницы www.saucedemo.com")
    public void checkingPage() {

        LoginPageTest loginPage = open(pageUrl, LoginPageTest.class);

        loginPage.login("standard_user", "secret_sauce");

        ProductPageTest productsPage = page(ProductPageTest.class);

        assert productsPage.isDisplayed();

        assert productsPage.burgerButton.isDisplayed();

        productsPage.openBurgerMenu();

        assert productsPage.isLogoutButtonDisplayed();

        productsPage.logout();

        assert loginPage.isLoginPageDisplayed();
    }
    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }
    public boolean isLoginPageDisplayed() {
        return  $(By.xpath(".//*[contains(@class, 'login_logo')]"))
                 .shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text(logoText))
                 .isDisplayed();
    }
}
