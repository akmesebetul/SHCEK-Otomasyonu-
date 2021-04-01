/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.bakiciDao;
import entity.Bakici;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Casper
 */
@Named
@SessionScoped
public class Bakicicontroller implements Serializable {
    private List<Bakici> bList;
    private bakiciDao bdao;
    private Bakici Bakici;
    
    private List<Long> selectedcck;
    
    @Inject
     private Cocukcontroller cocukcontroller;
    
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

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
        this.pageCount=(int) Math.ceil(this.getBdao().count() /(double) pageSize);
        return pageCount;    
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
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
 public void updateForm(Bakici Bakici) {

        this.Bakici = Bakici;
    }

    public void clearForm() {
        this.Bakici = new Bakici();

    }

    public void update() {
        this.getBdao().edit(this.Bakici);
        this.clearForm();
    }

    public void delete() {
        this.getBdao().delete(this.Bakici);
        this.clearForm();
    }

    public void create() {
        this.getBdao().insert(this.Bakici);
        this.clearForm();
    }
    public Bakicicontroller() {
        this.bList = new ArrayList();
        bdao = new bakiciDao();
    }

    public List<Bakici> getbList() {
        this.bList = this.getBdao().getBakici(page, pageSize);
        return bList;
    }

    public void setbList(List<Bakici> bList) {
        this.bList = bList;
    }

    public bakiciDao getBdao() {
        if(this.bdao==null){
            this.bdao= new bakiciDao();
        }
        return bdao;
    }

    public void setBdao(bakiciDao bdao) {
        this.bdao = bdao;
    }

    public Bakici getBakici() {
        if(this.Bakici==null){
           this.Bakici=new Bakici();
        }
        return Bakici;
    }

    public void setBakici(Bakici Bakici) {
        this.Bakici = Bakici;
    }

    public Cocukcontroller getCocukcontroller() {
        return cocukcontroller;
    }

    public void setCocukcontroller(Cocukcontroller cocukcontroller) {
        this.cocukcontroller = cocukcontroller;
    }

    public List<Long> getSelectedcck() {
        return selectedcck;
    }

    public void setSelectedcck(List<Long> selectedcck) {
        this.selectedcck = selectedcck;
    }

    
}
