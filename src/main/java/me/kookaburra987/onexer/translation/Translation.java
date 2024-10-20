package me.kookaburra987.onexer.translation;

import lombok.Getter;
import me.kookaburra987.onexer.selector.Language;

import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static me.kookaburra987.oldnorse.utils.Assert.notEmpty;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;
import static me.kookaburra987.onexer.selector.Language.ON;

/**
 * Represents a translation of an old norse word to some other language.
 * Because there can be synonyms and multiple meanings/translations it
 * is represented by 2 arrays.
 */
public class Translation {

    @Getter
    private final String[] oldNorseWords;
    @Getter
    private final String[] otherLanguageWords;
    @Getter
    private final Language otherLanguage;

    public Translation(String[] oldNorseWords, String[] otherLanguageWords, Language otherLanguage) {
        notNull(otherLanguage, "otherLanguage is null");
        notEmpty(oldNorseWords, "oldNorseWords is empty");
        notEmpty(otherLanguageWords, "translations is empty");

        this.oldNorseWords = oldNorseWords;
        this.otherLanguageWords = otherLanguageWords;
        this.otherLanguage = otherLanguage;
    }

    /**
     * Method to return all words in the Translation class that are in the given language.
     * @param language language of the words to return
     * @return all the words of the given language in this translation
     */
    public Collection<String> getAllWords(Language language) {
        if (ON.equals(language)){
            return asList(oldNorseWords);
        }
        if (otherLanguage.equals(language)){
            return asList(otherLanguageWords);
        }
        return emptyList();
    }
}
