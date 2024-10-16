package me.kookaburra987.onexer.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static me.kookaburra987.onexer.exercise.Task.TRANSLATE_TO_ENGLISH;
import static org.junit.jupiter.api.Assertions.*;

class ExerciseConstructorTest {

    @Test
    void givenTaskNullShouldThrowException(){
        Executable doCreateExercise = () -> new Exercise(null, List.of("line1"));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doCreateExercise);

        assertEquals("task is null", e.getMessage());
    }

    @Test
    void givenLinesNullShouldThrowException(){
        Executable doCreateExercise = () -> new Exercise(TRANSLATE_TO_ENGLISH, null);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doCreateExercise);

        assertEquals("lines is empty", e.getMessage());
    }

    @Test
    void givenLinesEmptyListShouldThrowException(){
        Executable doCreateExercise = () -> new Exercise(TRANSLATE_TO_ENGLISH, new ArrayList<>());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doCreateExercise);

        assertEquals("lines is empty", e.getMessage());
    }

    @Test
    void given101LinesShouldThrowException(){
        Executable doCreateExercise = () -> {
            ArrayList<String> lines = new ArrayList<>();
            for (int i = 0; i < 101; i++) {
                lines.add("line");
            }
            new Exercise(TRANSLATE_TO_ENGLISH, lines);
        };

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doCreateExercise);

        assertEquals("max lines is 100", e.getMessage());
    }

    @Test
    void givenOneLineShouldCreateExercise(){
        Exercise exercise = new Exercise(TRANSLATE_TO_ENGLISH, List.of("line1"));

        assertEquals(TRANSLATE_TO_ENGLISH, exercise.getTask());
        assertEquals(1, exercise.amountOfLines());
        assertEquals("line1", exercise.getLine(0));
        assertNull(exercise.getLine(1));
    }
}
