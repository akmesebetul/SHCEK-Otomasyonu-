/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.cocukDao;
import entity.Cocuk;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Casper
 */
public class Cocukcontroller {
    private List<Cocuk> clist;
    private cocukDao cdao;
    private Cocuk Cocuk;
    
    @Inject
    private Bakicicontroller bakicicontroller;
    
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

    public List<Cocuk> getClist() {
        this.clist = this.getCdao().getCocuk(page, pageSize);
        return clist;
    }

    public void setClist(List<Cocuk> clist) {
        this.clist = clist;
    }

    public cocukDao getCdao(){
        if(this.cdao==null){
            this.cdao=new cocukDao();
        }
        return cdao;
    }

    public void setCdao(cocukDao cdao) {
        this.cdao = cdao;
    }

    public Cocuk getCocuk() {
        if(this.Cocuk==null){
           this.Cocuk=new Cocuk();
        }
        return Cocuk;
    }

    public void setCocuk(Cocuk Cocuk) {
        this.Cocuk = Cocuk;
    }

    public Cocukcontroller() {
        this.clist = new ArrayList();
        cdao = new cocukDao();
    }
    public Bakicicontroller getBakicicontroller() {
        return bakicicontroller;
    }

    public void setBakicicontroller(Bakicicontroller bakicicontroller) {
        this.bakicicontroller = bakicicontroller;
    }
    
    
    
}
