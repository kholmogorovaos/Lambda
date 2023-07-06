import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DynamicLoadingTest {
    private final String pageUrl = "http://the-internet.herokuapp.com/dynamic_loading/1";
    private final String logoText = "Hello World";
    private SelenideElement buttonStart = $("#start > button");
    private SelenideElement finishElement = $("#finish");


    @Test
    @DisplayName("Test for lesson 11.3_3 - Проверка загрузки страницы the-internet.herokuapp.com/dynamic_loading/1")

    public void testDynamicLoading() {
        open(pageUrl);

        $(finishElement).shouldNotHave(Condition.text(logoText));

        $(buttonStart).click();

        $(finishElement).shouldBe(visible, Duration.ofSeconds(40)).shouldHave(text(logoText));
    }
}
