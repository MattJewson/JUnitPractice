import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHW {

    @Test
    public void testSayHello(){
        CodeHW code = new CodeHW();
        assertEquals("Hello world!", code.sayHello());
    }
}
