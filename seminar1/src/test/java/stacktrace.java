import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class stacktrace {
    MyStack<Integer> stack;
    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }
    @Test
    public void testEmpty() {
        assertEquals(0, stack.size());
    }

    @Test
    public void addOneElement() {
        assertEquals(0, stack.size());
        stack.add(20);
        assertEquals(1, stack.size());
    }


}
