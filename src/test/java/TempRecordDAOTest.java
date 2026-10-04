import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TempRecordDAOReadTest {

    @Test
    void getAllRecordsWorks() throws Exception {

        TempRecordDAO dao =
                new TempRecordDAO();

        assertNotNull(
                dao.getAllRecords());
    }
}