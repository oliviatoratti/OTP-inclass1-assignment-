import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        try {

            Connection conn =
                    DBConnection.connect();

            System.out.println("Database connected!");

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}