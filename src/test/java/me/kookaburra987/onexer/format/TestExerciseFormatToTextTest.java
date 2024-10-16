package me.kookaburra987.onexer.format;

import me.kookaburra987.oldnorse.utils.ResourceReader;
import me.kookaburra987.onexer.exercise.Exercise;
import me.kookaburra987.onexer.exercise.Task;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.io.IOException;

import static me.kookaburra987.onexer.exercise.Task.TRANSLATE_TO_ENGLISH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestExerciseFormatToTextTest {

    private TextExerciseFormat format;

    @BeforeEach
    void setup(){
        format = new TextExerciseFormat();
    }

    @Test
    void givenExerciseNullShouldThrowException(){
        Executable doToText = () -> format.toText(null);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doToText);

        assertEquals("exercise is null", e.getMessage());
    }

    @Test
    void givenExerciseWithOneLineShouldReturnText() {
        Exercise exercise = mock(Exercise.class);
        when(exercise.getTask()).thenReturn(TRANSLATE_TO_ENGLISH);
        when(exercise.amountOfLines()).thenReturn(1);
        when(exercise.getLine(0)).thenReturn("line");

        String text = format.toText(exercise);

        assertEquals("Translate to English\n--------------------\n1. line\n", text);
    }
}
