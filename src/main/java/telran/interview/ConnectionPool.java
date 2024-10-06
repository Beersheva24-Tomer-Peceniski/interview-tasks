package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ConnectionPool {
    // work out data structure
    // Connection pool comprises of some number of connections
    // It canot contains more than the predefined number of connection
    // You should define some Connection Pool policy so that if number of
    // connections
    // is going to exceed the limit a connection should be removed from the
    // connection
    // Policy should take in consideration the order of adding connections in pool
    // and using connection
    private LinkedHashMap<String, Connection> map;
    
    public ConnectionPool(int size) {
        map = new LinkedHashMap<>(size * 2, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> entry) {
                return size() > size;
            };
        };
    }

    public void addConnection(Connection connection) {
        if(map.containsKey(connection.connectionId())) {
            throw new IllegalStateException();
        }
        map.put(connection.connectionId(), connection);
    }

    public Connection getConnection(String connectionId) {
        Connection result = map.get(connectionId);
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public Set<String> idSet() {
        return map.keySet();
    }
}