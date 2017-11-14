package postgres;


import org.json.JSONArray;
import org.postgresql.util.PGobject;
import workWithJSON.MyJSONParser;

import java.nio.file.Paths;
import java.sql.*;

public class PostgresClass {
    Connection c = null;

    public PostgresClass() throws SQLException {
        this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                                            "postgres", "");
        System.out.println("Opened database successfully");
    }

    public void createTable(String tableName) {
        try {
            Statement statement = c.createStatement();
            String sql = "CREATE TABLE " + tableName + " (id INT, contract JSON)";
            statement.executeUpdate(sql);
            System.out.println("Created table successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTable(String tableName) {
        try {
            Statement statement = c.createStatement();
            String sql = "DROP TABLE " + tableName;
            statement.executeUpdate(sql);
            System.out.println("Deleted table successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String path) {
        long totalTime = 0;
        try {
            c.setAutoCommit(false);
            long startTime = System.nanoTime();
            for (JSONArray contracts: MyJSONParser.parseJSON(path)) {
                for (int i = 0; i < contracts.length(); i++) {
                    String sql = "INSERT INTO contracts VALUES (?, ?::JSON)";
                    PreparedStatement ps = c.prepareStatement(sql);
                    PGobject jsonObject = new PGobject();
                    jsonObject.setType("json");
                    jsonObject.setValue(contracts.getJSONObject(i).toString());
                    ps.setInt (1, i + 1);
                    ps.setObject (2, jsonObject);
                    ps.executeUpdate();
                }
            }
            c.commit();
            c.close();
            totalTime = System.nanoTime() - startTime;
            System.out.println("Inserts were success, total time: " + totalTime);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(1);
        }
    }

    public void select() {
        try {
            long startTime = System.nanoTime();
            String sql = "SELECT COUNT(*) AS total FROM contracts WHERE (contract ->> 'oos:price')::text::real < 100000";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet result = preparedStatement.executeQuery();
            long estimatedTime = System.nanoTime() - startTime;
            result.next();
            System.out.printf("%d contracts with price less than 100000 RUB, time for select: %d.%n",
                                result.getInt("total"), estimatedTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
