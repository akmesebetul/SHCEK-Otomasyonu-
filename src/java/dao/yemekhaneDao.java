/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yemekhane;
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
public class yemekhaneDao {
    private DBConnection db;
    private Connection c;
    
    
     public List<Yemekhane> getYemekhane(int page, int pageSize){
        List<Yemekhane> ymlist=new ArrayList();
        
        int start=(page-1)* pageSize;
        
        try{
            PreparedStatement pst=this.getC().prepareStatement("select* from yemekhane");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Yemekhane tmp=new Yemekhane(rs.getLong("id_ymk"),rs.getString("gunler"),rs.getString("vakitler"),rs.getString("yemekler"));
                ymlist.add(tmp);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
       return ymlist; 
    }
    public int count(){
        int count=0;
        try{
            PreparedStatement pst=this.getC().prepareStatement("select count(id_ymk) as yemekhane_count from yemekhane");
             ResultSet rs= pst.executeQuery();
             rs.next();
             count=rs.getInt("yemekhane_count");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return count;    
}
    public Yemekhane find(Long id_ymk){
        Yemekhane y=null;
        try{
            Statement st=this.getC().createStatement();
            ResultSet rs= st.executeQuery("select * from yemekhane where id_ymk"+id_ymk);
            
            rs.next();
            y=new Yemekhane();
            y.setId_ymk(rs.getLong("id_ymk"));
            y.setGunler(rs.getString("gunler"));
            y.setVakitler(rs.getString("vakitler"));
            y.setYemekler(rs.getString("yemekler"));
        }
       catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return y;
        
    }
    public void insert(Yemekhane yemekhane){
        try{
         PreparedStatement pst=this.getC().prepareStatement("insert into yemekhane (gunler,vakitler,yemekler) values(?)");
         
         pst.setString(1, yemekhane.getGunler());
         pst.setString(2, yemekhane.getVakitler());
         pst.setString(3, yemekhane.getYemekler());
         pst.executeUpdate();
    }   catch (SQLException ex) {
            
        }
    }
    public void delete(Yemekhane yemekhane){
       try{
           Statement st=this.getC().createStatement();
           st.executeLargeUpdate("delete from yemekhane where id_ymk="+yemekhane.getId_ymk());
       } catch (SQLException ex) { 
            
        } 
    }
    
    public void update(Yemekhane yemekhane){
        try{
           Statement st=this.getC().createStatement();
           st.executeLargeUpdate("update set yemekhane_gunler='"+yemekhane.getGunler()+"'yemekhane_vakitler="+yemekhane.getVakitler()+"'yemekhane_yemekler="+yemekhane.getYemekler()+"'where id_ymk="+yemekhane.getId_ymk());
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
