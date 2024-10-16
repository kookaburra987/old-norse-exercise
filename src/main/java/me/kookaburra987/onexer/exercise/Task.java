package me.kookaburra987.onexer.exercise;

import lombok.Getter;

/**
 * The task that has to be completed for every line of an Exercise.
 */
public enum Task {
    TRANSLATE_TO_ENGLISH("Translate to English");

    @Getter
    private String description;

    Task(String description) {
        this.description = description;
    }
}
