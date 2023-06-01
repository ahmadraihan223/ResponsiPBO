/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.Connector;
import model.Lomba;

/**
 *
 * @author Lab Informatika
 */
public class LombaLagu {
    Connection con;
    private static String select = "SELECT * FROM datalomba";
    private static String insert = "INSERT INTO `datalomba` ( `judul`, `alur`, `orisinalitas`, `pemilihankata`, `nilai`, ) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static String update = "UPDATE `datalomba` SET `judul` = ?, `alur` = ?, `orisinalitas` = ?, `pemilihankata` = ?, `nilai` = ? WHERE `datalomba`.`id` = ?";
    private static String delete = "DELETE FROM datalomba WHERE `id` = ?";
    private static String query;
    
    public LombaLagu() {
        con = Connector.connection();
    }
    
    public void insert(Lomba p) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getAlur());
            statement.setString(3, p.getOrisinalitas());
            statement.setString(4, p.getPemilihanKata());
            statement.setString(5, p.getNilai());
            statement.setInt(6, p.getStock());
            statement.executeUpdate();
        } catch(SQLException ex) {
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public List<Lomba> getAll() {
        List<Lomba> p = null;
        try {
            p = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
                Lomba data = new Lomba();
                data.setJudul(rs.getString("judul"));
                data.setAlur(rs.getString("alur"));
                data.setorisinalitas(rs.getString("Orisinalitas"));
                data.setPemilihanKata(rs.getString("pemilihankata"));
                data.setNilai(rs.getString("nilai"));
                data.setStock(rs.getInt("stock"));
                p.add(data);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return p;
    }
    
    public List<Lomba> getAll(int cari, String keyword) {
        List<Lomba> p = null;
        System.out.println(cari);
        switch(cari) {
            case 1:
                query = "SELECT * FROM datalomba WHERE judul like \"" + keyword + "\"";
                break;
            case 2:
                query = "SELECT * FROM datalomba WHERE alur like \"" + keyword + "\"";
                break;
            case 3:
                query = "SELECT * FROM datalomba WHERE orisinalitas like \"" + keyword + "\"";
                break;
            case 4:
                query = "SELECT * FROM datalomba WHERE pemilihankata like \"" + keyword + "\"";
                break;
            case 5:
                query = "SELECT * FROM datalomba WHERE nilai like \"" + keyword + "\"";
                break;
            default:
                query = null;
        }
        System.out.println(query);
        try {
            p = new ArrayList<Lomba>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Lomba data = new Lomba();
                data.setJudul(rs.getString("judul"));
                data.setAlur(rs.getString("alur"));
                data.setOrisinalitas(rs.getString("orisinalitas"));
                data.setPemilihanKata(rs.getString("emilihankata"));
                data.setNilai(rs.getString("nilai"));
                p.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return p;
    }
    
    public void update(Lomba p) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getAlur());
            statement.setString(3, p.getorisinalitas());
            statement.setString(4, p.getpemilihankata());
            statement.setString(5, p.getnilai());
            statement.setInt(6, p.getStock());
            statement.setInt(7, p.getId());
            statement.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
