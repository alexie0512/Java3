import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssertion {

    @Test
    void assertion(){
        assertAll("demo assertions",
                ()-> assertEquals(1,2),
                ()-> assertEquals(1,1),
                ()-> assertEquals(1,3));
    }
}
