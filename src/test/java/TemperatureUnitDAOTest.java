import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TemperatureUnitDAOTest {

    @Test
    void saveUnitWorks() {

        TemperatureUnitDAO dao = new TemperatureUnitDAO();

        assertDoesNotThrow(() ->
                dao.saveUnit("Celsius"));
    }
}