/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kaile;
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
public class kaileDao {
    private DBConnection db;
    private Connection c;
   
     public List<Kaile> getKaile(int page, int pageSize){
        List<Kaile> alist=new ArrayList();
        
        int start=(page-1)* pageSize;
        
        try{
            PreparedStatement pst=this.getC().prepareStatement("select* from kaile");
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Kaile tmp=new Kaile(rs.getLong("id_aile"),rs.getString("ebeveyn"),rs.getString("tc"),rs.getString("d_tarihi"),rs.getString("tel_no"),rs.getString("adres"));
                alist.add(tmp);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
       return alist; 
    }
    public int count(){
        int count=0;
        try{
            PreparedStatement pst=this.getC().prepareStatement("select count(id_aile) as kaile_count from kaile");
             ResultSet rs= pst.executeQuery();
             rs.next();
             count=rs.getInt("kaile_count");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return count;    
}
    public Kaile find(Long id_aile){
        Kaile a=null;
        try{
            Statement st=this.getC().createStatement();
            ResultSet rs= st.executeQuery("select * from kaile where id_aile"+id_aile);
            
            rs.next();
            a=new Kaile();
            a.setId_aile(rs.getLong("id_aile"));
            a.setEbeveyn(rs.getString("ebeveyn"));
            a.setTc(rs.getString("tc"));
            a.setD_tarihi(rs.getString("d_tarihi"));
            a.setTel_no(rs.getString("tel_no"));
            a.setAdres(rs.getString("adres"));
        }
       catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
        
    }
    public void insert(Kaile kaile){
        try{
         PreparedStatement pst=this.getC().prepareStatement("insert into kaile (ebeveyn,tc,d_tarihi,tel_no,adres) values(?)");
         
         pst.setString(1, kaile.getEbeveyn());
         pst.setString(2, kaile.getTc());
         pst.setString(3, kaile.getD_tarihi());
         pst.setString(4, kaile.getTel_no());
         pst.setString(5, kaile.getAdres());
         pst.executeUpdate();
    }   catch (SQLException ex) {
            
        }
    }
    public void delete(Kaile kaile){
       try{
           Statement st=this.getC().createStatement();
           st.executeLargeUpdate("delete from kaile where id_aile="+kaile.getId_aile());
       } catch (SQLException ex) { 
            
        } 
    }
    
    public void update(Kaile kaile){
        try{
           Statement st=this.getC().createStatement();
           st.executeLargeUpdate("update set kaile_ebeveyn='"+kaile.getEbeveyn()+"'kaile_tc="+kaile.getTc()+"'kalie_d_tarihi="+kaile.getD_tarihi()+"'kalie_tel_no="+kaile.getTel_no()+"'kalie_adres="+kaile.getAdres()+"'where id_aile="+kaile.getId_aile());
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
