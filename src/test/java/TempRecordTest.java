import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TempRecordTest {

    @Test
    void constructorWorks() {

        TempRecord record =
                new TempRecord(
                        1,
                        25.5,
                        1
                );

        assertEquals(
                1,
                record.getRecordId());

        assertEquals(
                25.5,
                record.getTemperature());

        assertEquals(
                1,
                record.getUnitId());
    }
}