package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProDoctorovWithMethodSourceTest extends TestBase {




    static Stream<Arguments> selenideSite(){
        return Stream.of(
        Arguments.of(
                List.of("О компании", "О проекте", "Редакция и юрлицо", "О нас говорят",
                        "Выступления", "Битва за отзывы","Вакансии", "Соцсети", "Контакты")
        )
        );
    }

    @MethodSource
    @ParameterizedTest
    void selenideSite(List<String> expectedB){
        open("/info/about-us/");
        $$(".b-sidebar__list li").filter(visible).shouldHave(texts(expectedB));

    }

}
