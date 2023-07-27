import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest {
    private final String pageUrl = "https://www.saucedemo.com";
    private final String pageUrls = "http://the-internet.herokuapp.com/dynamic_loading/1";
    private final String logoTexts = "Hello World";


    @Test
    @DisplayName ("Test for lesson 11.3_1 - Проверка открытия страницы www.saucedemo.com")
    public void LoginPage() {
        open(pageUrl);

        LoginPageActions loginPageActions = new LoginPageActions();
        loginPageActions.isLoginPageDisplayed();

    }

    @Test
    @DisplayName ("Test for lesson 11.3_2 - Проверка переходов по кнопкам страницы www.saucedemo.com")
    public void checkingPage() {
        LoginPageActions loginPageActions = new LoginPageActions();
        ProductPage productPage = new ProductPage();

        open(pageUrl);

        loginPageActions.login("standard_user", "secret_sauce");

        productPage.isDisplayed();

        productPage.burgerIsDisplayed();

        productPage.openBurgerMenu();

        productPage.isLogoutButtonDisplayed();

        productPage.logout();

        loginPageActions.isLoginPageDisplayed();
    }

    @Test
    @DisplayName("Test for lesson 11.3_4 - Проверка загрузки страницы the-internet.herokuapp.com/dynamic_loading/1")

    public void testDynamicLoading() {
        open(pageUrls);

        $("#finish").shouldNotHave(Condition.text(logoTexts));

        $("#start > button").click();

        $("#finish").shouldBe(visible, Duration.ofSeconds(40)).shouldHave(text(logoTexts));
    }

}
