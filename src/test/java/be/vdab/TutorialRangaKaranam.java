package be.vdab;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class TutorialRangaKaranam {

    // fixture: executed before every unit test in this test case
    /*@BeforeEach
    void beforeEach(TestInfo testInfo) {
        System.out.println("Initialize test data before " + testInfo.getDisplayName());
    }*/

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value = {"abc,3","defgh,5","'',0"})
    @DisplayName("length() gives correct length of string?")
    void length(String string,int expectedLength) {
        assertEquals(expectedLength,string.length());
    }

    @Test
    @DisplayName("if String is null, does length() throw NullPointerException?")
    void length_exception() {
        String s = null;
        assertThrows(
                NullPointerException.class,    // which exception is expected to be thrown
                ()->{s.length();}              // which method should throw the exception in this case
                );
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("does Math.min() generate correct minimum number?")
    void min() {
        double a = 12.123;
        double b = 12.456;
        double actualMin = Math.min(a,b);
        double expectedMin = 12.123;
        assertNotNull(actualMin);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void contains() {
        boolean isServerUp = true;
        assumeTrue(isServerUp,"server is not up");
        assertFalse("abcd".contains("ijk"));
    }

    @RepeatedTest(10)
    void split() {
        String[] expectedArray = {"abc","def"};
        String[] actualArray = "abc def".split(" ");
        assertArrayEquals(expectedArray,actualArray);
    }

    @ParameterizedTest
    @ValueSource(strings={"a","","abc","defg"})
    void length_greater_than_zero(String s) {
        assertTrue(s.length()>0);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,A","abc,ABC","'',''"})
    void toUpperCase(String word,String capitalizedWord) {
        assertEquals(capitalizedWord,word.toUpperCase());
    }

    @Test
    void performanceTest() {
        assertTimeout(Duration.ofSeconds(5), () -> {
            for (int i = 0; i < 1000000; i++) {
                int j = i;
                System.out.println(j);
            }
        });
    }

    @Nested
    class EmptyStringTests {

        String str;

        @BeforeEach
        void setEmptyString() {
            str = "";
        }

        @Test
        @DisplayName("length of empty string is zero?")
        void lengthIsZero() {
            assertEquals(0,str.length());
        }

        @Test
        @DisplayName("toUpperCase() of empty string is empty string?")
        void upperCaseIsEmpty() {
            assertEquals("",str.toUpperCase());
        }

    }

}
