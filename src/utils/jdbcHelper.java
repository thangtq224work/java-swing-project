/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thang
 */
public class jdbcHelper {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=EduSys";
    static String user = "sa";
    static String password = "thang1212";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps;
        if (sql.trim().startsWith("{")) {
            ps = con.prepareCall(sql);// proc
        } else {
            ps = con.prepareStatement(sql); // sql
        }
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1, args[i]);
        }
        return ps;
    }

    public static int update(String sql, Object... args) throws SQLException {
        try {
            PreparedStatement p = jdbcHelper.getStmt(sql, args);
            try {
                return p.executeUpdate();
            } finally {
                p.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement p = jdbcHelper.getStmt(sql, args);
        return p.executeQuery();
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

}
