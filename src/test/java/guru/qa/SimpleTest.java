package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @BeforeAll
    void simpleTest1(){
        Assertions.assertTrue(3>2);
    }

    @Test
    void simpleTest(){
        Assertions.assertTrue(1>2);
    }

    @Test
    void simpleTest2(){
        throw new NullPointerException();
    }
}
