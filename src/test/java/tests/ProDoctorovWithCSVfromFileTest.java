package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Параметризованный тест")
public class ProDoctorovWithCSVfromFileTest extends TestBase{


    @CsvFileSource(resources = "/test_data/countDoctorInCityTest.csv")
    @ParameterizedTest(name = "Для поискового запроса {0} должено быть найдено  {1}")
    @Tags({
            @Tag("WEB"),
            @Tag ("REGRESS")
    })
    void countDoctorInCityTest(String searchQuery, String name) {
        open("/moskva");
        $(".text-field__input").setValue(searchQuery).pressEnter();
        $(".b-content-grid__section-title").shouldHave(text(name));
        sleep(2000);
    }
}
