package me.kookaburra987.onexer.parse;

import me.kookaburra987.onexer.translation.Translation;

import java.util.ArrayList;
import java.util.List;

import static me.kookaburra987.oldnorse.utils.Assert.*;
import static me.kookaburra987.onexer.selector.Language.EN;

public class CsvTranslationParser implements TranslationParser {

    @Override
    public List<Translation> parse(String[] lines) {
        notEmpty(lines, "lines is empty");

        List<Translation> translations = new ArrayList<>();

        for (String line : lines) {
            Translation translation = parse(line);
            translations.add(translation);
        }

        return translations;
    }

    private Translation parse(String line){
        notBlank(line, "line is blank");
        String[] split = line.split(",");

        isFalse(split.length != 2, "invalid translation line");

        String[] oldNorseWords = splitWordList(split[0]) ;
        String[] translationWords = splitWordList(split[1]) ;

        return new Translation(oldNorseWords, translationWords, EN);
    }

    /**
     * Word lists are separated by semicolon ';'.
     * This method splits the words and trims every word.
     * @param words a string with all words separated by semicolon
     * @return array of words
     */
    private String[] splitWordList(String words){
        notNull(words, "words is null");

        if (!words.contains(";")){
            String[] split = new String[1];
            split[0] = words.trim();
            return split;
        }

        String[] split = words.split(";");
        for (int i = 0; i < split.length; i++) {
             split[i] = split[i].trim();
        }
        return split;
    }
}
