/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.etkinlikDao;
import entity.Etkinlikler;
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
public class Etkinlikcontroller implements Serializable{
    private List <Etkinlikler> eList;
    private Etkinlikler etkinlikler;
    private etkinlikDao etkDao;
    
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
    
    public Etkinlikcontroller() {
        this.eList=new ArrayList();
        etkDao=new etkinlikDao();
    }
    
    
    
    public List<Etkinlikler> geteList() {
        this.eList=this.getEtkDao().getEtkinlikler(page, pageSize);
        return eList;
    }

    public void seteList(List<Etkinlikler> eList) {
        this.eList = eList;
    }

    public Etkinlikler getEtkinlikler() {
        if(this.etkinlikler==null){
           this.etkinlikler= new Etkinlikler();
        }
        return etkinlikler;
    }

    public void setEtkinlikler(Etkinlikler etkinlikler) {
        this.etkinlikler = etkinlikler;
    }

    public etkinlikDao getEtkDao() {
        if(this.etkDao==null){
            this.etkDao=new etkinlikDao();
        }
        return etkDao;
    }

    public void setEtkDao(etkinlikDao etkDao) {
        this.etkDao = etkDao;
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
        this.pageCount = (int) Math.ceil(this.getEtkDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public String updateForm(Etkinlikler etkinlikler){
        this.etkinlikler= etkinlikler;
        return "etkinlikler";
    }
    public String clearForm(Etkinlikler etkinlikler){
        this.etkinlikler=new Etkinlikler();
        return "etkinlikler";
        
    }
    public String delete(){
        this.getEtkDao().delete(this.etkinlikler);
        this.etkinlikler=new Etkinlikler();
        return "etkinlikler";
    }
    public String update(){
        this.getEtkDao().update(this.etkinlikler);
        this.etkinlikler=new Etkinlikler();
        return "etkinlikler";
    }
    public String create(){
        this.getEtkDao().insert(this.etkinlikler);
        this.etkinlikler=new Etkinlikler();
        return "etkinlikler";
    }
}
