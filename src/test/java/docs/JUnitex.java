package docs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JUnitex {

   @BeforeAll
    static void beforeAll()
    {
        System.out.println("==Smth before all tests");
    }
    @Test
    void firstTest()
    {
        System.out.println("=====Started first test");
    }

    @Test
    void secondTest()
    {
        System.out.println("=====Started first test");
    }

    @AfterAll
    static void afterAll()
    {
        System.out.println("==Smth after all tests");
    }
}
