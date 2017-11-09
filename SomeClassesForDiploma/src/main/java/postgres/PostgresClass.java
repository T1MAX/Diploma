package postgres;


import org.json.JSONObject;
import workWithJSON.Converter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PostgresClass {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        long totalTime = 0;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "");

            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "DROP TABLE sales ";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE sales (id INT, sale JSON)";
            stmt.executeUpdate(sql);

            c.setAutoCommit(false);

            System.out.println("Created table successfully");

            JSONObject json = Converter.convert("D:\\Загрузки\\contract.xml");
            long startTime = System.nanoTime();
            for (int i = 1; i <= 10; i++) {
                stmt = c.createStatement();
                sql = "INSERT INTO sales VALUES (?, ?::JSON)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt (1, i);
                ps.setObject (2, json);
                ps.executeUpdate();

            }
            stmt.close();
            c.commit();
            totalTime = System.nanoTime() - startTime;
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("10 inserts are success, total time: " + totalTime);
    }
}
