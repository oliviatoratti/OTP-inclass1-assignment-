import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DBConnectionTest {

    @Test
    void connectionWorks() throws java.lang.Exception {

        assertNotNull(
                DBConnection.connect()
        );
    }
}