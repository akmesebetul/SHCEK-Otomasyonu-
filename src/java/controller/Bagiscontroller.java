/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.bagisDao;
import entity.Bagis;
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
public class Bagiscontroller implements Serializable{
    
    private List<Bagis> bList;
    private Bagis bagis;
    private bagisDao baDao;
    
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

    public Bagiscontroller() {
        this.bList=new ArrayList();
        baDao=new bagisDao();
    }
    
    
    public List<Bagis> getbList() {
        this.bList=this.getBaDao().getBagis(page, pageSize);
        return bList;
    }

    public void setbList(List<Bagis> bList) {
        this.bList = bList;
    }

    public Bagis getBagis() {
        if(this.bagis==null){
            this.bagis=new Bagis();
        }
        return bagis;
    }

    public void setBagis(Bagis bagis) {
        this.bagis = bagis;
    }

    public bagisDao getBaDao() {
        if(baDao==null){
           this.baDao=new bagisDao();
            
        }
        return baDao;
    }

    public void setBaDao(bagisDao baDao) {
        this.baDao = baDao;
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
        this.pageCount = (int) Math.ceil(this.getBaDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public String create(){
        this.getBaDao().insert(this.bagis);
        this.bagis=new Bagis();
        return "bagis";
    }
}
