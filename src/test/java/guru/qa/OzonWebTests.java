package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OzonWebTests {

    @CsvSource({
            "Электроника, Смартфоны",
            ", Психология"
    })
    @ParameterizedTest(name = "Проверка раздела меню: {0}")
    void ozonMenuItemsCheckTest(String menuItem, String subMenuItem) {
        open("https://www.ozon.ru/");
        $("[data-widget='catalogMenu']").click();
        $("[data-widget='catalogMenu']").$(byText(menuItem)).click();
        $("[data-widget='objectLine']").$(byText(subMenuItem)).shouldBe(Condition.visible);
    }

    @CsvFileSource(resources = "/source.csv", delimiter = ',')
    @ParameterizedTest(name = "Проверка раздела меню: {0}")
    void ozonMenuItemsCheckTest1(String menuItem, String subMenuItem) {
        open("https://www.ozon.ru/");
        $("[data-widget='catalogMenu']").click();
        $("[data-widget='catalogMenu']").$(byText(menuItem)).click();
        $("[data-widget='objectLine']").$(byText(subMenuItem)).shouldBe(Condition.visible);
    }

    static Stream<Arguments> dataProvider() {

        return Stream.of(
                Arguments.of("Электроника", List.of("Смартфоны", "Планшеты")),
                Arguments.of("Книги", List.of("Психология", "Саморазвитие"))
        );
    }

    @MethodSource("dataProvider")
    @ParameterizedTest(name = "Проверка раздела меню: {0}")
    void ozonMenuItemsCheckTest2(String menuItem, List<String> subMenuItem) {
        open("https://www.ozon.ru/");
        $("[data-widget='catalogMenu']").click();
        $("[data-widget='catalogMenu']").$(byText(menuItem)).click();
        subMenuItem.forEach(item -> {
            $("[data-widget='objectLine']").$(byText(item)).shouldBe(Condition.visible);
        });

    }

}
