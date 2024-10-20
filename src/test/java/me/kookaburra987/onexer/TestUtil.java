package me.kookaburra987.onexer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestUtil {
    private TestUtil() {
    }

    public static void assertOneStringInArray(String expected, String[] array){
        assertEquals(1, array.length);
        assertEquals(expected, array[0]);
    }

    public static void assertTwoStringsInArray(String firstExpected, String secondExpected, String[] array){
        assertEquals(2, array.length);
        assertEquals(firstExpected, array[0]);
        assertEquals(secondExpected, array[1]);
    }
}
