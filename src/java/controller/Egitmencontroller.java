/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.egitmenDao;
import entity.Egitmen;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Casper
 */
@Named
@SessionScoped
public class Egitmencontroller implements Serializable{
    private List<Egitmen> elist;
    private Egitmen egitmen;
    private egitmenDao eDao;
    
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

    public Egitmencontroller() {
        this.elist=new ArrayList();
        eDao=new egitmenDao();
    }
    
    public List<Egitmen> getElist() {
        this.elist=this.geteDao().getEgitmen(page, pageSize);
        return elist;
    }

    public void setElist(List<Egitmen> elist) {
        this.elist = elist;
    }

    public Egitmen getEgitmen() {
        if(this.egitmen==null){
            this.egitmen=new Egitmen();
        }
        return egitmen;
    }

    public void setEgitmen(Egitmen egitmen) {
        this.egitmen = egitmen;
    }

    public egitmenDao geteDao() {
        if(this.eDao==null){
            this.eDao=new egitmenDao();
        }
        return eDao;
    }

    public void seteDao(egitmenDao eDao) {
        this.eDao = eDao;
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
         this.pageCount = (int) Math.ceil(this.geteDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    
     public String updateForm(Egitmen egitmen) {

        this.egitmen = egitmen;
        return "egitmen";
    }
    public String clearForm(){
    this.egitmen=new Egitmen();
    return "egitmen";
    
    }
    public String delete() {
        this.geteDao().delete(this.egitmen);
        this.egitmen=new Egitmen();
        return "egitmen";
    }

    public String update() {
        this.geteDao().update(this.egitmen);
                this.egitmen=new Egitmen();

        return "egitmen";
    }

    public String create() {
        this.geteDao().insert(this.egitmen);
                this.egitmen=new Egitmen();

        return "egitmen";
    }

    
}
