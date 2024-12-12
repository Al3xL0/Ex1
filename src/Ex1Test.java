import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2", " "};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        // implement this test
        assertEquals(Ex1.int2Number(0, 2), "0b2");
        assertEquals(Ex1.int2Number(2,3), "2b3" );
        assertEquals(Ex1.int2Number(5,2), "101b2" );
        assertEquals(Ex1.int2Number(256,16), "100bG" );
        assertEquals(Ex1.int2Number(65535, 16), "FFFFbG");
        assertEquals(Ex1.int2Number(8,8),"10b8");
    }
    @Test
    void maxIndexTest() {
        // implement this test
        String[][] test_cases = {{"1b2", "0", "1b2"}, {"2b3", "3b4"}, {" "}, {"3","5","101b2","100b3"}};
        assertEquals(Ex1.maxIndex(test_cases[0]), 0);
        assertEquals(Ex1.maxIndex(test_cases[1]), 1);
        assertEquals(Ex1.maxIndex(test_cases[2]), 0);
        assertEquals(Ex1.maxIndex(test_cases[3]), 3);
    }

    // Add additional test functions - test as much as you can.

    // Test to number2Int function
    @Test
    void number2IntTest() {
        assertEquals(Ex1.number2Int("1b2"), 1);
        assertEquals(Ex1.number2Int("0"), 0);
        assertEquals(Ex1.number2Int("10"), 10);
        assertEquals(Ex1.number2Int("FbG"), 15);
        assertEquals(Ex1.number2Int("11b3"), 4);
        assertEquals(Ex1.number2Int(" "), -1);
    }
}