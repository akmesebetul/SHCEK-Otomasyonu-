/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bagis;
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
public class bagisDao {
    private DBConnection db;
    private Connection c;
    
    public List<Bagis> getBagis(int page, int pageSize){
        List<Bagis> bList=new ArrayList();
        
        int start=(page-1)* pageSize;
        
        try{
            PreparedStatement pst=this.getC().prepareStatement("select* from bagis");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Bagis tmp=new Bagis(rs.getLong("id_bagis"),rs.getString("turu"),rs.getString("miktar"),rs.getString("bagisci"),rs.getString("e_posta"),rs.getString("tel_no"));
                bList.add(tmp);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
       return bList; 
    }
    
    
    public int count(){
        int count=0;
        try{
            PreparedStatement pst=this.getC().prepareStatement("select count(id_bagis) as bagis_count from bagis");
             ResultSet rs= pst.executeQuery();
             rs.next();
             count=rs.getInt("bagis_count");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return count;    
}
    public Bagis find(Long id_bagis){
        Bagis bg=null;
        try{
            Statement st=this.getC().createStatement();
            ResultSet rs= st.executeQuery("select * from bagis where id_bagis"+id_bagis);
            
            rs.next();
            bg=new Bagis();
            bg.setId_bagis(rs.getLong("id_bagis"));
            bg.setTuru(rs.getString("turu"));
            bg.setMiktar(rs.getString("miktar"));
            bg.setBagisci(rs.getString("bagisci"));
            bg.setE_posta(rs.getString("e_posta"));
            bg.setTel_no(rs.getString("tel_no"));
            
        }
       catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return bg;
        
    }
    public void insert(Bagis bagis){//Bu modülde sadece ekleme işlemi yapılacağından diğer metodlar yazılmadı
        try{
         PreparedStatement pst=this.getC().prepareStatement("insert into bagis (turu,miktar,bagisci,e_posta,tel_no) values(?)");
         
         pst.setString(1, bagis.getTuru());
         pst.setString(2, bagis.getMiktar());
         pst.setString(3, bagis.getBagisci());
         pst.setString(4, bagis.getE_posta());
         pst.setString(5, bagis.getTel_no());
         
         pst.executeUpdate();
    }   catch (SQLException ex) {
            
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
