package be.vdab;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNameGenerator {

    //Unit test sayMyName()
    @Test
    @Disabled
    @DisplayName("testMyName")
    public void testMyName() {
        NameGenerator nameGenerator = new NameGenerator();
        String result = nameGenerator.sayMyName();
        assertTrue("elias".equalsIgnoreCase(result), "should return elias");
    }

}
