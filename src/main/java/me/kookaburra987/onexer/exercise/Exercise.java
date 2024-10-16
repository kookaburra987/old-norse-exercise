package me.kookaburra987.onexer.exercise;

import lombok.Getter;

import java.util.List;

import static me.kookaburra987.oldnorse.utils.Assert.notEmpty;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;
import static org.apache.commons.collections4.CollectionUtils.size;

/**
 * A list of lines for which the user has to do the {@link Task}.
 */
public class Exercise {
    @Getter
    private Task task;

    private List<String> lines;

    public Exercise(Task task, List<String> lines) {
        notNull(task, "task is null");
        notEmpty(lines, "lines is empty");

        this.task = task;
        this.lines = lines;
    }

    /**
     * Counts the amount of lines.
     * @return amount of lines
     */
    public int amountOfLines(){
        return size(lines);
    }

    /**
     * Method to fetch a specific line. Line numbers start at 0.
     * @param line number of line to fetch
     * @return the line for which the user has to do the {@link Task}, or null if the line does not exist
     */
    public String getLine(int line){
        if (size(lines) <= line){
            return null;
        }
        return lines.get(line);
    }
}
