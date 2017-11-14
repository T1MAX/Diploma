package postgres;


import org.json.JSONArray;
import org.postgresql.util.PGobject;
import workWithJSON.MyJSONParser;

import java.nio.file.Paths;
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

            String sql = "DROP TABLE contracts";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE contracts (id INT, contract JSON)";
            stmt.executeUpdate(sql);

            c.setAutoCommit(false);

            System.out.println("Created table successfully");

            //JSONArray contracts = MyJSONParser.parseJSON(Paths.get("contract.xml"));
            long startTime = System.nanoTime();
//            for (int i = 0; i < contracts.length(); i++) {
//                stmt = c.createStatement();
//                sql = "INSERT INTO contracts VALUES (?, ?::JSON)";
//                PreparedStatement ps = c.prepareStatement(sql);
//                PGobject jsonObject = new PGobject();
//                jsonObject.setType("json");
//                jsonObject.setValue(contracts.getJSONObject(i).toString());
//                ps.setInt (1, i + 1);
//                ps.setObject (2, jsonObject);
//                ps.executeUpdate();
//            }
            stmt.close();
            c.commit();
            totalTime = System.nanoTime() - startTime;
            c.close();
            //System.out.println(contracts.length() + " inserts are success, total time: " + totalTime);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }
}
