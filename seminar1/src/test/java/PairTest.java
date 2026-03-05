import org.junit.jupiter.api.Test;
import seminar3.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairTest {
    @Test
    public void testSetValue() {
        Pair<String, Integer> pr = new Pair<>("key", 5);
        pr.setValue(55);
        assertEquals(55, pr.getValue());
    }

    @Test
    public void testSetKey() {
        Pair<String, Integer> pr = new Pair<>("key", 5);
        pr.setKey("aa");
        assertEquals("aa", pr.getKey());
    }

    @Test
    public void testGetValue() {
        Pair<String, Integer> pr = new Pair<>("key", 5);
        assertEquals("key", pr.getKey());
    }

    @Test
    public void testGetKey() {
        Pair<String, Integer> pr = new Pair<>("key", 5);
        assertEquals(5, pr.getValue());
    }

    @Test
    public void testEqual() {
        Pair<Integer, String> pr1 = new Pair<>(1, "a");
        Pair<Integer, String> pr2 = new Pair<>(1, "a");
        assertEquals(pr1, pr2);
        assertEquals(pr2, pr1);

    }
}
