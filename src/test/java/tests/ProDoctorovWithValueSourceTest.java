package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Параметризованный тест")
public class ProDoctorovWithValueSourceTest extends TestBase{

    @ValueSource(strings = {
            "Лор", "Хирург"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен быть первым ")
    @Tags({
            @Tag("WEB"),
            @Tag ("REGRESS")
    })
    void successSearchDoctor(String searchQuery) {
        open("/moskva");
        $(".text-field__input").setValue(searchQuery).pressEnter();
        $("h1").shouldHave(text("Результаты поиска в Москве по запросу " + "«" + searchQuery +"»"));
        sleep(2000);
    }



}
