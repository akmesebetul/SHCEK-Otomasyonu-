/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bakici;
import entity.Cocuk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Casper
 */
public class bakiciDao {
   private DBConnection db;
   private Connection c;
   private cocukDao cocukdao;
   
   
   public List<Bakici> getBakici(int page, int pageSize) {
        List<Bakici> blist = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from Bakici order by id_bakici asc limit " + start + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               
                Bakici tmp = new Bakici();
                tmp.setId_bakici(rs.getLong("id_bakici"));
                tmp.setIsim(rs.getString("isim"));
                tmp.setTc(rs.getString("tc"));
                tmp.setTel_no(rs.getString("tel_no"));
                tmp.setCocuklar(this.getCocukDao().getCocuklar(tmp.getId_bakici()));
                blist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return blist;

    }
     public int count() {
        int count = 0; 
        try {
            PreparedStatement pst = this.getC().prepareStatement("select count(id_bakici)as Bakici_count from Bakici");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("Bakici_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }
     public Bakici find(Long id_bakici) {
        Bakici b = null;
        try {

           PreparedStatement st = this.getC().prepareStatement("select * from Bakici where id_bakici=?");
            st.setLong(1, id_bakici);
            ResultSet rs = st.executeQuery();
            rs.next();
            b = new Bakici();
            b.setId_bakici(rs.getLong("id_bakici"));
            b.setIsim(rs.getString("isim"));
            b.setTc(rs.getString("tc"));
            b.setTel_no(rs.getString("tel_no"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return b;
    }
      public void insert(Bakici Bakici) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into Bakici(isim ,tc,tel_no) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, Bakici.getIsim());
            pst.setString(2, Bakici.getTc());
            pst.setString(3, Bakici.getTel_no());

            pst.executeUpdate();
            Long id_bakici = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id_bakici = gk.getLong(1);

            }
            for (Cocuk c : Bakici.getCocuklar()) {
                pst = this.getC().prepareStatement("insert into bakici_cocuk (id_bakici , id_cocuk) values (?,?)");
                pst.setLong(1, id_bakici);
                pst.setLong(2, c.getId_cocuk());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
        }
    }
      public void edit(Bakici Bakici) {
        try {
            
            PreparedStatement pst = this.getC().prepareStatement("update Bakici set isim=? ,tc =? ,tel_no=?  where id_bakici=?");
            pst.setString(1, Bakici.getIsim());
            pst.setString(2, Bakici.getTc());
            pst.setString(3, Bakici.getTel_no());
            pst.setLong(4,Bakici.getId_bakici());

            pst.executeUpdate();
            pst = this.getC().prepareStatement("delete from bakici_cocuk where id_bakici=?");
            pst.setLong(1,Bakici.getId_bakici());
            pst.executeUpdate();

            for (Cocuk c : Bakici.getCocuklar()) {
                pst = this.getC().prepareStatement("insert into bakici_cocuk(id_bakici , id_cocuk) values (?,?)");
                pst.setLong(1, Bakici.getId_bakici());
                pst.setLong(2, c.getId_cocuk());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
        }
    }
       public void delete(Bakici Bakici) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from bakici_cocuk where id_cocuk=?");
            pst.setLong(1, Bakici.getId_bakici());
            pst.executeUpdate();

            pst = this.getC().prepareStatement("delete from Bakici where id_bakici=?");
            pst.setLong(1, Bakici.getId_bakici());
            pst.executeUpdate();

        } catch (SQLException ex) {
        }
       }
    
       List<Bakici> getBakicilar(Long id_cocuk) {
        List<Bakici> bakicilar = new ArrayList<>();
        try{
           
             Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from bakici_cocuk where id_cocuk=" + id_cocuk);
            while (rs.next()) {
                bakicilar.add(this.find(rs.getLong("id_bakici")));

            }
        } catch (SQLException ex) {
        }

        return bakicilar;
           
       
    
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

   public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }

    public cocukDao getCocukDao() {
        if(this.cocukdao==null){
           this.cocukdao=new cocukDao();
        }
        return cocukdao;
    }
     public void setCocukDao(cocukdao cocukdao) {
        this.cocukdao = cocukdao;
    }
    
}
