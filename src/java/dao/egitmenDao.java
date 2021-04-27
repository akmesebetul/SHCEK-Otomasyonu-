/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import converter.egitmen;
import entity.Egitmen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Casper
 */
public class egitmenDao {
    private DBConnection db;
    private Connection c;
     
    public List<Egitmen> getEgitmen(int page, int pageSize) {
        List<Egitmen> elist= new ArrayList();
        int start = (page - 1) * pageSize;
        
        try{
            PreparedStatement pst = this.getC().prepareStatement("select * from egitmen");
            ResultSet rs = pst.executeQuery();
          
            while(rs.next()){
                Egitmen tmp= new Egitmen(rs.getLong("id_egitmen"),rs.getString("isim"),rs.getString("tc"),rs.getString("d_tarihi"),rs.getString("tel_no")); 
                elist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return elist;
    }
    
    public int count() {
        int count = 0; 
        try {

            PreparedStatement pst = this.getC().prepareStatement("select count(id_egitmen)as egitmen_count from egitmen");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("egitmen_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }
    
     public Egitmen find(Long id_egitmen) {
        Egitmen e = null;
        try {

            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from egitmen where id_egitmen=" + id_egitmen);
            rs.next();
            e = new Egitmen();
            e.setId_egitmen(rs.getLong("id_bolum"));
            e.setIsim(rs.getString("isim"));
            e.setTc(rs.getString("tc"));
            e.setD_tarihi(rs.getString("d_tarihi"));
            e.setTel_no(rs.getString("tel_no"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;

    }

    
      public void insert(Egitmen egitmen) {
        try {

            PreparedStatement pst = this.getC().prepareStatement("insert into egitmen (isim,tc,d_tarihi,tel_no) values (?)");
            pst.setString(1, egitmen.getIsim());
            pst.setString(2,egitmen.getTc());
            pst.setString(3,egitmen.getD_tarihi());
            pst.setString(4,egitmen.getTel_no());
            pst.executeUpdate();

           
        } catch (SQLException ex) {
        }

    }

    public void delete(Egitmen egitmen) {

        try {

            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from egitmen where id_egitmen=" + egitmen.getId_egitmen());

        } catch (SQLException ex) {
        }

    }

    public void update(Egitmen egitmen) {

        try {

            Statement st = this.getC().createStatement();
            st.executeUpdate("update  egitmen set egitmen_isim='" + egitmen.getIsim() + "' egitmen_tc=" +egitmen.getTc()+"' egitmen_d_tarihi=" +egitmen.getD_tarihi()+"' egitmen_tel_no" +egitmen.getTel_no()+"' where id_egitmen= " + egitmen.getId_egitmen());

        } catch (SQLException ex) {
        }

    }
     
    
    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }

    public void setC(Connection c) {
        this.c = c;
    }
}
