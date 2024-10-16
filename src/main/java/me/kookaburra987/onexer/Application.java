package me.kookaburra987.onexer;

import static org.apache.commons.lang3.ArrayUtils.getLength;

/**
 * Class responsible for running the Old Norse Exercise command line tool.
 */
public class Application {
    public static void main(String[] args) {
        if (getLength(args) == 1){
            processSingleArgument(args[0]);
        }
    }

    private static void processSingleArgument(String arg) {
        if (arg.equals("-v") || arg.equals("--version")){
            showVersion();
        }
    }

    private static void showVersion() {
        System.out.println("Old Norse Exercise 0.0.1-SNAPSHOT");
    }
}
