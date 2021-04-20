/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.cocukDao;
import dao.egitmenDao;
import dao.kursDao;
import entity.Cocuk;
import entity.Egitmen;
import entity.Kurs;
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
public class Kurscontroller implements Serializable{
    private List<Kurs> kList;
    private kursDao kDao;
    private Kurs Kurs;
    private cocukDao cocukDao;
    private List<Cocuk> clist;
    private egitmenDao egitmenDao;
    private List<Egitmen> elist;
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    
    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public List<Kurs> getkList() {
        this.kList = this.getkDao().getKurs(page, pageSize);
        return kList;
    }

    public void setkList(List<Kurs> kList) {
        this.kList = kList;
    }

    public kursDao getkDao() {
        if(this.kDao==null){
           this.kDao= new kursDao();
            
        }
        return kDao;
    }

    public void setkDao(kursDao kDao) {
        this.kDao = kDao;
    }

    public Kurs getKurs() {
        if(this.Kurs==null){
           this.Kurs=new Kurs();
        }
        return Kurs;
    }

    public void setKurs(Kurs Kurs) {
        this.Kurs = Kurs;
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

    public List<Cocuk> getClist() {
        this.clist = this.getCocukDao().getCocuk(1, 10);
        return clist;
    }

    public void setClist(List<Cocuk> clist) {
        this.clist = clist;
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

    public List<Egitmen> getElist() {
        this.elist = this.getEgitmenDao().getEgitmen(1, 10);
        return elist;
    }

    public void setElist(List<Egitmen> elist) {
        this.elist = elist;
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
        this.pageCount = (int) Math.ceil(this.getkDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
     public void updateForm(Kurs Kurs) {

        this.Kurs = Kurs;
       
    }
    public void update(){
        this.getkDao().edit(this.Kurs);
        this.clearForm();

}

    public void clearForm() {
        this.Kurs= new Kurs();

    }

   public void delete() {
        this.getkDao().delete(this.Kurs);
               this.clearForm();


    }

    public void create() {
        this.getkDao().create(this.Kurs);
               this.clearForm();

    }
    
    
    
}
