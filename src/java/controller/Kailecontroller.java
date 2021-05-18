/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.kaileDao;
import entity.Kaile;
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
public class Kailecontroller implements Serializable {
    
    private List <Kaile> alist;
    private Kaile kaile;
    private kaileDao aileDao;
    
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
    
    public Kailecontroller() {
        this.alist=new ArrayList();
        aileDao=new kaileDao();
    }
    
    
    
    public List<Kaile> getalist() {
        this.alist=this.getAileDao().getKaile(page, pageSize);
        return alist;
    }

    public void setalist(List<Kaile> alist) {
        this.alist = alist;
    }

    public Kaile getKaile() {
        if(this.kaile==null){
           this.kaile= new Kaile();
        }
        return kaile;
    }

    public void setKaile(Kaile kaile) {
        this.kaile = kaile;
    }

    public kaileDao getAileDao() {
        if(this.aileDao==null){
            this.aileDao=new kaileDao();
        }
        return aileDao;
    }

    public void setAileDao(kaileDao aileDao) {
        this.aileDao = aileDao;
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
        this.pageCount = (int) Math.ceil(this.getAileDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public String updateForm(Kaile kaile){
        this.kaile= kaile;
        return "kaile";
    }
    public String clearForm(Kaile kaile){
        this.kaile=new Kaile();
        return "kaile";
        
    }
    public String delete(){
        this.getAileDao().delete(this.kaile);
        this.kaile=new Kaile();
        return "kaile";
    }
    public String update(){
        this.getAileDao().update(this.kaile);
        this.kaile=new Kaile();
        return "kaile";
    }
    public String create(){
        this.getAileDao().insert(this.kaile);
        this.kaile=new Kaile();
        return "kaile";
    }
 
    
}
