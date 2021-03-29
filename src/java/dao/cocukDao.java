/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cocuk;
import entity.Bakici;
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
public class cocukDao {
    private DBConnection db;
    private Connection c;
    private bakiciDao bakiciDao;
    
    public List <Cocuk> getCocuk(int page,int pageSize){
        List <Cocuk> clist=new ArrayList<>();
        
        int start=(page-1)*pageSize;
        try{
            
            PreparedStatement pst = this.getC().prepareStatement("select * from Cocuk order by id_cocuk asc limit "+start + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                Cocuk tmp = new Cocuk();
                tmp.setId_cocuk(rs.getLong("id_cocuk"));
                tmp.setIsim(rs.getString("isim"));
                tmp.setTc(rs.getString("tc"));
                tmp.setD_tarihi(rs.getString("d_tarihi"));
                tmp.setK_tarihi(rs.getString("k_tarihi"));
                tmp.setBakicilar(this.getBakiciDao().getBakicilar(tmp.getId_cocuk()));
               
                clist.add(tmp);
    }
        
    }   catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    return clist;
 }
    public int count() {
        int count = 0;        // TODO code application logic here
        try {

            PreparedStatement pst = this.getC().prepareStatement("select count(id_Cocuk)as Cocuk_count from Cocuk");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("Cocuk_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;

    }
   public Cocuk find(Long id_cocuk) {
        Cocuk c = null;
        try {

            PreparedStatement st = this.getC().prepareStatement("select * from Cocuk where id_cocuk=?");
            st.setLong(1, id_cocuk);
            ResultSet rs = st.executeQuery();
            rs.next();
            c = new Cocuk();
            c.setId_cocuk(rs.getLong("id_cocuk"));
            c.setIsim(rs.getString("isim"));
            c.setTc(rs.getString("tc"));
            c.setD_tarihi(rs.getString("d_tarihi"));
            c.setK_tarihi(rs.getString("k_tarihi"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }
    
   public List<Cocuk> getCocuklar(Long id_bakici) {
        List<Cocuk> cocuklar = new ArrayList<>();

        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from bakici_cocuk where id_bakici=" + id_bakici);
            while (rs.next()) {
                cocuklar.add(this.find(rs.getLong("id_cocuk")));

            }
        } catch (SQLException ex) {
        }

        return cocuklar;
    }
   
    public void insert(Cocuk Cocuk) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into Cocuk(isim ,tc ,d_tarihi ,k_tarihi) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, Cocuk.getIsim());
            pst.setString(2, Cocuk.getTc());
            pst.setString(3, Cocuk.getD_tarihi());
            pst.setString(4, Cocuk.getK_tarihi());

            pst.executeUpdate();
            Long id_cocuk = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id_cocuk = gk.getLong(1);

            }
            for (Bakici b : Cocuk.getBakicilar()) {

                pst = this.getC().prepareStatement("insert into yatakhane (id_cocuk , id_bakici) values (?,?)");
                pst.setLong(1, id_cocuk);
                pst.setLong(2, b.getId_bakici());
                pst.executeUpdate();
   }
          } catch (SQLException ex) {
        }
    }
    
     public void edit(Cocuk Cocuk) {
        try {
            
            PreparedStatement pst = this.getC().prepareStatement("update Cocuk set isim=? ,tc =? ,d_tarihi=?,k_tarihi=?  where id_cocuk=?");
            pst.setString(1, Cocuk.getIsim());
            pst.setString(2,Cocuk.getTc());
            pst.setString(3, Cocuk.getD_tarihi());
            pst.setString(4, Cocuk.getK_tarihi());
            pst.setLong(5, Cocuk.getId_cocuk());

            pst.executeUpdate();
            pst = this.getC().prepareStatement("delete from bakici_cocuk where id_cocuk=?");
            pst.setLong(1, Cocuk.getId_cocuk());
            pst.executeUpdate();

            for (Bakici b : Cocuk.getBakicilar()) {
                pst = this.getC().prepareStatement("insert into bakici_cocuk (id_cocuk , id_bakici) values (?,?)");
                pst.setLong(1, Cocuk.getId_cocuk());
                pst.setLong(2, b.getId_bakici());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
        }
    }
    
      public void delete(Cocuk Cocuk) {
        try {

            PreparedStatement pst = this.getC().prepareStatement("delete from bakici_cocuk where id_cocuk=?");
            pst.setLong(1,Cocuk.getId_cocuk());
            pst.executeUpdate();
            pst = this.getC().prepareStatement("delete from Cocuk where id_cocuk=?");
            pst.setLong(1, Cocuk.getId_cocuk());
            pst.executeUpdate();

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
     public bakiciDao getBakiciDao() {
        if(this.bakiciDao==null){
            this.bakiciDao= new bakiciDao();
            
        }
        return bakiciDao;
    }

    
}
