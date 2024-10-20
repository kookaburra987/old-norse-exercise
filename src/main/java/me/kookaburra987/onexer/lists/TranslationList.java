package me.kookaburra987.onexer.lists;

import me.kookaburra987.onexer.parse.CsvTranslationParser;
import me.kookaburra987.onexer.parse.TranslationParser;
import me.kookaburra987.onexer.translation.Translation;
import me.kookaburra987.onexer.utils.ResourceReader;

import java.util.List;

/**
 * Class to retrieve a list of translations
 */
public class TranslationList {

    public List<Translation> allTranslations(){
        ResourceReader resourceReader = new ResourceReader();
        String[] lines = resourceReader.readLinesOfTextFile("translations/en/nouns.csv");
        TranslationParser parser = new CsvTranslationParser();

        return parser.parse(lines);
    }
}
