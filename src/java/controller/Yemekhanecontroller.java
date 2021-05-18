/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.yemekhaneDao;
import entity.Yemekhane;
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
public class Yemekhanecontroller implements Serializable{
    
    private List <Yemekhane> ymlist;
    private Yemekhane yemekhane;
    private yemekhaneDao ymkDao;
    
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
    
    public Yemekhanecontroller() {
        this.ymlist=new ArrayList();
        ymkDao=new yemekhaneDao();
    }
    
    
    
    public List<Yemekhane> getymlist() {
        this.ymlist=this.getYmkDao().getYemekhane(page, pageSize);
        return ymlist;
    }

    public void setymlist(List<Yemekhane> ymlist) {
        this.ymlist = ymlist;
    }

    public Yemekhane getYemekhane() {
        if(this.yemekhane==null){
           this.yemekhane= new Yemekhane();
        }
        return yemekhane;
    }

    public void setYemekhane(Yemekhane yemekhane) {
        this.yemekhane = yemekhane;
    }

    public yemekhaneDao getYmkDao() {
        if(this.ymkDao==null){
            this.ymkDao=new yemekhaneDao();
        }
        return ymkDao;
    }

    public void setYmkkDao(yemekhaneDao ymkDao) {
        this.ymkDao = ymkDao;
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
        this.pageCount = (int) Math.ceil(this.getYmkDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public String updateForm(Yemekhane yemekhane){
        this.yemekhane= yemekhane;
        return "yemekhane";
    }
    public String clearForm(Yemekhane yemekhane){
        this.yemekhane=new Yemekhane();
        return "yemekhane";
        
    }
    public String delete(){
        this.getYmkDao().delete(this.yemekhane);
        this.yemekhane=new Yemekhane();
        return "yemekhane";
    }
    public String update(){
        this.getYmkDao().update(this.yemekhane);
        this.yemekhane=new Yemekhane();
        return "yemekhane";
    }
    public String create(){
        this.getYmkDao().insert(this.yemekhane);
        this.yemekhane=new Yemekhane();
        return "yemekhane";
    }
   
    
}
