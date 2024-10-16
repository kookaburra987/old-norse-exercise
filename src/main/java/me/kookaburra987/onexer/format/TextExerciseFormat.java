package me.kookaburra987.onexer.format;

import me.kookaburra987.onexer.exercise.Exercise;
import org.apache.commons.lang3.StringUtils;

import static me.kookaburra987.oldnorse.utils.Assert.notNull;
import static org.apache.commons.lang3.StringUtils.length;

/**
 * Class responsible for turning {@link me.kookaburra987.onexer.exercise.Exercise}
 * into a text (String).
 */
public class TextExerciseFormat {

    public String toText(Exercise exercise){
        notNull(exercise, "exercise is null");

        StringBuilder sb = new StringBuilder();

        appendTaskDescription(exercise, sb);
        appendLines(exercise, sb);

        return sb.toString();
    }

    private void appendTaskDescription(Exercise exercise, StringBuilder sb) {
        String taskDescription = exercise.getTask().getDescription();

        sb.append(taskDescription);
        sb.append("\n");

        sb.append(StringUtils.repeat("-", length(taskDescription)));
        sb.append("\n");
    }


    private void appendLines(Exercise exercise, StringBuilder sb) {
        int amount = exercise.amountOfLines();
        for (int i = 0; i < amount; i++) {
            String line = exercise.getLine(i);
            sb.append(i+1).append(". ").append(line).append("\n");
        }
    }
}
