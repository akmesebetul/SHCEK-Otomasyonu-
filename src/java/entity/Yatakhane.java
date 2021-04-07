/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Casper
 */
public class Yatakhane {
    private Long id_ytk;
    private int kat_no;
    private int oda_no;
    private Cocuk Cocuk;

    public Yatakhane() {
    }

    public Yatakhane(Long id_ytk, int kat_no, int oda_no, Cocuk Cocuk) {
        this.id_ytk = id_ytk;
        this.kat_no = kat_no;
        this.oda_no = oda_no;
        this.Cocuk = Cocuk;
    }

    public Long getId_ytk() {
        return id_ytk;
    }

    public void setId_ytk(Long id_ytk) {
        this.id_ytk = id_ytk;
    }

    public int getKat_no() {
        return kat_no;
    }

    public void setKat_no(int kat_no) {
        this.kat_no = kat_no;
    }

    public int getOda_no() {
        return oda_no;
    }

    public void setOda_no(int oda_no) {
        this.oda_no = oda_no;
    }

    public Cocuk getCocuk() {
        return Cocuk;
    }

    public void setCocuk(Cocuk Cocuk) {
        this.Cocuk = Cocuk;
    }

    @Override
    public String toString() {
        return "Yatakhane{" + "id_ytk=" + id_ytk + ", kat_no=" + kat_no + ", oda_no=" + oda_no + ", Cocuk=" + Cocuk + '}';
    }
    
    
    
}
