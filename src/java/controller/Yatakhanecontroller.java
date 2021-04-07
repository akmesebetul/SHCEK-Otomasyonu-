/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.cocukDao;
import dao.yatakhaneDao;
import entity.Cocuk;
import entity.Yatakhane;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Casper
 */

@Named
@SessionScoped
public class Yatakhanecontroller implements Serializable {
  
    private Yatakhane Yatakhane;
    private List<Yatakhane> ylist;
    private yatakhaneDao yatakdao;
    private int page=1;
    private int pageSize=10;
    private int pageCount;
    
    private cocukDao cocukdao;
    private List<Cocuk> clist;
    
     public void delete(){
    this.getYatakdao().remove(this.Yatakhane);
     this.clearForm();
    
    }
      public void clearForm(){
      this.Yatakhane= new Yatakhane();
    }
    
    public void update() {
     this.getYatakdao().edit(this.Yatakhane);
      this.clearForm();
    }
      public void create() {
        this.getYatakdao().create(this.Yatakhane);
         this.clearForm();
        

    }
      public void next(){
        if (this.page==this.getPageCount()){
            this.page=1;}
        else{
    this.page++;}
    }
    public void previous(){
        if ( this.page==1)
            this.page=this.getPageCount();
        
        else
                 
        this.page--;
            
        
    }

    public Yatakhane getYatakhane() {
        if( this.Yatakhane==null)
            this.Yatakhane=new Yatakhane();
        return Yatakhane;
    }

    public void setYatakhane(Yatakhane Yatakhane) {
        this.Yatakhane = Yatakhane;
    }

    public List<Yatakhane> getYlist() {
        this.ylist= this.getYatakdao().findAll(page,pageSize);
        return ylist;
    }

    public void setYlist(List<Yatakhane> ylist) {
        this.ylist = ylist;
    }

    public yatakhaneDao getYatakdao() {
        return yatakdao;
    }

    public void setYatakdao(yatakhaneDao yatakdao) {
        this.yatakdao = yatakdao;
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getYatakdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

  

   

   public cocukDao getCocukdao(){
        if(this.cocukdao==null){
            this.cocukdao=new cocukDao();
        }
        return cocukdao;
    }

    public void setCocukdao(cocukDao cocukdao) {
        this.cocukdao = cocukdao;
    }

    public List<Cocuk> getClist() {
        this.clist = this.getCocukdao().getCocuk(page, pageSize);
        return clist;
    }

    public void setClist(List<Cocuk> clist) {
        this.clist = clist;
    }
    
    
    
    
}
