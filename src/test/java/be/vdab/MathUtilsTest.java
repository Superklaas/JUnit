package be.vdab;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    void computeCircleArea() {

        double radius = 10;

        double expected = Math.PI*100;
        double actual = mathUtils.computeCircleArea(radius);

        assertEquals(expected,actual);

    }



}
