package me.kookaburra987.onexer.parse;

import me.kookaburra987.onexer.translation.Translation;

import java.util.List;

/**
 * Interface for classes responsible for reading a String
 * and converting it into a Translation.
 */
public interface TranslationParser {
    /**
     * Parses a list of lines to a list of Translations.
     * @param lines lines to parse
     * @return the list of Translations
     */
    List<Translation> parse(String[] lines);
}
