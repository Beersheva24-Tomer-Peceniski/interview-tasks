package telran.interview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {
    ConnectionPool cp = new ConnectionPool(3);
    
    void setUp() {
        cp.addConnection(new Connection("id1"));
        cp.addConnection(new Connection("id2"));
        cp.addConnection(new Connection("id3"));
    }

    @Test 
    void firstOrderTest() {
        setUp();
        String[] expected = {"id1", "id2", "id3"};
        assertArrayEquals(expected, cp.idSet().toArray(String[]::new));
    }

    @Test 
    void addingErrorTest() {
        setUp();
        assertThrowsExactly(IllegalStateException.class, () -> cp.addConnection(new Connection("id1")));
    }

    @Test
    void newOrderTest() {
        setUp();
        cp.addConnection(new Connection("id4"));
        String[] expected = {"id2", "id3", "id4"};
        assertArrayEquals(expected, cp.idSet().toArray(String[]::new));
        cp.getConnection("id2");
        cp.addConnection(new Connection("id5"));
        String[] expected2 = {"id4", "id2", "id5"};
        assertArrayEquals(expected2, cp.idSet().toArray(String[]::new));
    }
}