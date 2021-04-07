/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yatakhane;
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
public class yatakhaneDao {
    
     private DBConnection db;
     private Connection c ;
     private cocukDao cocukdao;
     

    public List<Yatakhane> findAll(int page, int pageSize) {
        List<Yatakhane> ylist = new ArrayList<>();
        int start =(page-1)*pageSize;
        try {
        PreparedStatement pst = this.getC().prepareStatement("select * from Yatakhane order by id_ytk asc limit "+start+" ,"+pageSize);
         ResultSet rs = pst.executeQuery();
         while ( rs.next()){
        Yatakhane tmp = new Yatakhane();
         tmp.setId_ytk(rs.getLong("id_ytk"));
         tmp.setKat_no(rs.getInt("kat_no"));
         tmp.setOda_no(rs.getInt("oda_no"));
        
         tmp.setCocuk(this.getCocukDao().find(rs.getLong("id_cocuk")));
        
         ylist.add(tmp);
         } 
        }catch(SQLException ex){
          System.out.println(ex.getMessage());
        }
        
       return ylist;
    }
      public int count () {
         int count=0;
        try {
         Statement st = this.getC().createStatement();
         ResultSet rs = st.executeQuery( "select count(id_ytk)as Yatakhane_count from Yatakhane");
         rs.next();
         count = rs.getInt("Yatakhane_count");
        
         } 
        catch(SQLException ex){
          System.out.println(ex.getMessage());
        }
        
       return count;
    }

   public cocukDao getCocukDao() {
        if(this.cocukdao==null){
           this.cocukdao=new cocukDao();
        }
        return cocukdao;
    }

   
    

    
    public DBConnection getDb() {
        if ( this.db==null)
            this.db= new DBConnection();
        return db;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }

    public Connection getC() {
         if ( this.c==null)
            this.c= this.getDb().connect();
        return c;
    }

    public void create(Yatakhane Yatakhane) {
         try {

            PreparedStatement pst = this.getC().prepareStatement("insert into Yatakhane(kat_no ,oda_no ,id_cocuk) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, Yatakhane.getKat_no());
            pst.setInt(2, Yatakhane.getOda_no());
            pst.setLong(3,Yatakhane.getCocuk().getId_cocuk());
            

            pst.executeUpdate();
            Long id_ytk = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id_ytk = gk.getLong(1);

            }
            
        } catch (SQLException ex) {
        }
    }

    public void edit(Yatakhane Yatakhane) {
        try {

            PreparedStatement pst = this.getC().prepareStatement("update Yatakhane set kat_no=? ,oda_no=? ,id_cocuk=? where id_ytk=? ");
            pst.setInt(1, Yatakhane.getKat_no());
            pst.setInt(2, Yatakhane.getOda_no());
            pst.setLong(3,Yatakhane.getCocuk().getId_cocuk());
            pst.setLong(4, Yatakhane.getId_ytk());

            pst.executeUpdate();
           
            
            
        } catch (SQLException ex) {
        }
    }

    public void remove(Yatakhane Yatakhane) {
        try{
           PreparedStatement pst = this.getC().prepareStatement(" delete Yatakhane where id_ytk=? ");
            pst.setLong(1, Yatakhane.getId_ytk());
            pst.executeUpdate();
       }catch (SQLException ex){
        System.out.println(ex.getMessage());
       }  
    }
    
}
