package me.kookaburra987.onexer.lists;

import me.kookaburra987.onexer.translation.Translation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslationListAllTranslationsTest {

    private TranslationList translationList;

    @BeforeEach
    void setup(){
        translationList = new TranslationList();
    }

    //test only counts that the total amount of translations is correct
    @Test
    void shouldReturnAllTranslations(){
        List<Translation> translations = translationList.allTranslations();

        assertEquals(8, translations.size());
    }
}
