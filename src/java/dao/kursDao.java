/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kurs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Casper
 */
public class kursDao {
     private DBConnection db;
    private Connection c;
    private cocukDao cocukDao;
    private egitmenDao egitmenDao;
   

    public List<Kurs> getKurs(int page, int pageSize) {
        List<Kurs> kList = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from Kurs order by id_kurs asc limit "+start + "," + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
               
                Kurs tmp = new Kurs();
                tmp.setId_kurs(rs.getLong("id_kurs"));
                tmp.setStart(rs.getString("start"));
                tmp.setFinish(rs.getString("finish"));
                rs.getLong("id_cocuk");
                tmp.setKursiyer(this.getCocukDao().find(rs.getLong("id_cocuk")));
                rs.getLong("id_egitmen");
                tmp.setE(this.getEgitmenDao().find(rs.getLong("id_egitmen")));
               
                kList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kList;

    }

    public int count() {
        int count = 0;      
        try {

            PreparedStatement pst = this.getC().prepareStatement("select count(id_kurs)as Kurs_count from Kurs");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("Kurs_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }
    public void delete(Kurs Kurs) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from Kurs where id_kurs=?");
            pst.setLong(1, Kurs.getId_kurs());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void create(Kurs Kurs) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into Kurs (start,finish ,id_cocuk ,id_egitmen) values (?,?,?,?)");
            pst.setString(1, Kurs.getStart());
            pst.setString(2, Kurs.getFinish());
            pst.setLong(3, Kurs.getKursiyer().getId_cocuk());
            pst.setLong(4, Kurs.getE().getId_egitmen());
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void edit(Kurs Kurs) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into Kurs (start,finish ,id_cocuk ,id_egitmen,id_kurs) values (?,?,?,?)");
            pst.setString(1, Kurs.getStart());
            pst.setString(2, Kurs.getFinish());
            pst.setLong(3, Kurs.getKursiyer().getId_cocuk());
            pst.setLong(4, Kurs.getE().getId_egitmen());
            pst.setLong(5, Kurs.getId_kurs());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

    public cocukDao getCocukDao() {
        if (this.cocukDao == null) {
            this.cocukDao = new cocukDao();
        }
        return cocukDao;
    }

    public void setCocukDao(cocukDao cocukDao) {
        this.cocukDao = cocukDao;
    }

    public egitmenDao getEgitmenDao() {
        if (this.egitmenDao == null) {
            this.egitmenDao = new egitmenDao();
        }
        return egitmenDao;
    }

    public void setEgitmenDao(egitmenDao egitmenDao) {
        this.egitmenDao = egitmenDao;
    }

    
    public void setDb(DBConnection db) {
        this.db = db;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    
   
    
}
    

