import java.sql.Connection;
import java.sql.PreparedStatement;

public class TemperatureUnitDAO {

    public void saveUnit(String unitName) throws Exception {

        Connection conn = DBConnection.connect();

        String sql =
                "INSERT INTO temperature_unit(unit_name) VALUES (?)";

        PreparedStatement stmt =
                conn.prepareStatement(sql);

        stmt.setString(1, unitName);

        stmt.executeUpdate();

        conn.close();
    }
}