package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Параметризованный тест")
public class ProDoctorovWithCSVsourceTest extends TestBase{


    @CsvSource(value = {
            "Смирнов * Врачи (101)",
            "Крутов * Врачи (13)",
            "Кирпичев * Врачи (6)"
    }, delimiter = '*')
    @ParameterizedTest(name = "Для поискового запроса {0} должено быть найдено  {1}")
    @Tags({
            @Tag("WEB"),
            @Tag ("REGRESS")
    })
    void countDoctorInCityTest(String searchQuery, String name) {
        open("/moskva");
        $(".text-field__input").setValue(searchQuery).pressEnter();
        $(".b-content-grid__section-title").shouldHave(text(name));
    }


}
