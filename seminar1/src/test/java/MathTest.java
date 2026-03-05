import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathTest {
    @Test
    public void addSmallNumbers() {
        Math mt = new Math();
        assertEquals(5 ,Math.add(2, 3));
        assertThrows(IllegalAccessError.class, () -> Math.abs(2));
    }
    // dawer rom yvela dafaros
}
