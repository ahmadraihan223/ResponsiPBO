/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class Connector {
    static Connection con;
    public static Connection connection() {
        if(con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("lomba");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("koneksi berhasil");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("koneksi gagal");
            }
        }
        
        return con;
    }
}
