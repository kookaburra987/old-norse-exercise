package me.kookaburra987.onexer.parse;

import me.kookaburra987.onexer.translation.Translation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static me.kookaburra987.onexer.TestUtil.assertOneStringInArray;
import static me.kookaburra987.onexer.TestUtil.assertTwoStringsInArray;
import static me.kookaburra987.onexer.selector.Language.EN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CsvTranslationParserParseTest {

    private TranslationParser parser;

    @BeforeEach
    void setup(){
        parser = new CsvTranslationParser();
    }

    @Test
    void givenNullShouldReturnException(){
        Executable doParse = () -> parser.parse(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, doParse);

        assertEquals("lines is empty", exception.getMessage());
    }

    @Test
    void givenEmptyLinesShouldReturnException(){
        String[] lines = {};
        Executable doParse = () -> parser.parse(lines);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, doParse);

        assertEquals("lines is empty", exception.getMessage());
    }

    @Test
    void givenLinesWithBlankLineShouldReturnException(){
        String[] lines = {"\t "};
        Executable doParse = () -> parser.parse(lines);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, doParse);

        assertEquals("line is blank", exception.getMessage());
    }

    //scenario: þing, assembly (1 old norse word, 1 english word)
    @Test
    void givenSimpleLinesShouldReturnTranslations(){
        String[] lines = {"þing, assembly"};

        List<Translation> translations = parser.parse(lines);

        assertEquals(1, translations.size());
        Translation translation = translations.get(0);
        assertEquals(EN,translation.getOtherLanguage());

        assertOneStringInArray("þing", translation.getOldNorseWords());
        assertOneStringInArray("assembly", translation.getOtherLanguageWords());
    }

    //scenario: tunga, tongue; language (1 old nosrse word, 2 english words)
    @Test
    void givenLinesWithTwoOtherLanguageLinesShouldReturnTranslation(){
        String[] lines = {"tunga, tongue; language"};

        List<Translation> translations = parser.parse(lines);

        assertEquals(1, translations.size());
        Translation translation = translations.get(0);
        assertEquals(EN,translation.getOtherLanguage());

        assertOneStringInArray("tunga", translation.getOldNorseWords());
        assertTwoStringsInArray("tongue", "language", translation.getOtherLanguageWords());
    }
}
