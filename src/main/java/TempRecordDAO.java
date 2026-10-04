import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TempRecordDAO {

    public void saveRecord(double temperature, int unitId)
            throws Exception {

        Connection conn = DBConnection.connect();

        String sql =
                "INSERT INTO temp_record " +
                        "(temperature, unit_id) " +
                        "VALUES (?, ?)";

        PreparedStatement statement =
                conn.prepareStatement(sql);

        statement.setDouble(1, temperature);
        statement.setInt(2, unitId);

        statement.executeUpdate();

        statement.close();
        conn.close();
    }

    public String getAllRecords() throws Exception {

        Connection conn = DBConnection.connect();

        StringBuilder builder =
                new StringBuilder();

        String sql =
                "SELECT * FROM temp_record";

        PreparedStatement statement =
                conn.prepareStatement(sql);

        ResultSet rs =
                statement.executeQuery();

        while (rs.next()) {

            builder.append(
                            rs.getInt("record_id"))
                    .append(" | ");

            builder.append(
                            rs.getDouble("temperature"))
                    .append(" | ");

            builder.append(
                            rs.getInt("unit_id"))
                    .append("\n");
        }

        rs.close();
        statement.close();
        conn.close();

        return builder.toString();
    }
}