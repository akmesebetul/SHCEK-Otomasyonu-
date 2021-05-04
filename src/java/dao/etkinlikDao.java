/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Etkinlikler;
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
public class etkinlikDao {
    private DBConnection db;
    private Connection c;
    
    public List<Etkinlikler> getEtkinlikler(int page, int pageSize){
        List<Etkinlikler> eList=new ArrayList();
        
        int start=(page-1)* pageSize;
        
        try{
            PreparedStatement pst=this.getC().prepareStatement("select* from etkinlikler");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Etkinlikler tmp=new Etkinlikler(rs.getLong("id_etk"),rs.getString("etkinlikler"),rs.getString("icerik"),rs.getString("tarih"));
                eList.add(tmp);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
       return eList; 
    }
    public int count(){
        int count=0;
        try{
            PreparedStatement pst=this.getC().prepareStatement("select count(id_etk) as etkinlikler_count from etkinlikler");
             ResultSet rs= pst.executeQuery();
             rs.next();
             count=rs.getInt("etkinlikler_count");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return count;    
}
    public Etkinlikler find(Long id_etk){
        Etkinlikler et=null;
        try{
            Statement st=this.getC().createStatement();
            ResultSet rs= st.executeQuery("select * from etkinlikler where id_etk"+id_etk);
            
            rs.next();
            et=new Etkinlikler();
            et.setId_etk(rs.getLong("id_etk"));
            et.setEtkinlik(rs.getString("etkinlik"));
            et.setIcerik(rs.getString("icerik"));
            et.setTarih(rs.getString("tarih"));
        }
       catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return et;
        
    }
    public void insert(Etkinlikler etkinlikler){
        try{
         PreparedStatement pst=this.getC().prepareStatement("insert into etkinlikler (etkinlikler,icerik,tarih) values(?)");
         
         pst.setString(1, etkinlikler.getEtkinlik());
         pst.setString(2, etkinlikler.getIcerik());
         pst.setString(3, etkinlikler.getTarih());
         pst.executeUpdate();
    }   catch (SQLException ex) {
            
        }
    }
    public void delete(Etkinlikler etkinlikler){
       try{
           Statement st=this.getC().createStatement();
           st.executeLargeUpdate("delete from etkinlikler where id_etk="+etkinlikler.getId_etk());
       } catch (SQLException ex) { 
            
        } 
    }
    
    public void update(Etkinlikler etkinlikler){
        try{
           Statement st=this.getC().createStatement();
           st.executeLargeUpdate("update set etkinlikler_etkinlik='"+etkinlikler.getEtkinlik()+"'etkinlikler_icerik="+etkinlikler.getIcerik()+"'etkinlikler_tarih="+etkinlikler.getTarih()+"'where id_etk="+etkinlikler.getId_etk());
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
