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
public class Kaile {
    private Long id_aile;
    private String ebeveyn;
    private String tc;
    private String d_tarihi;
    private String tel_no;
    private String adres;

    public Kaile() {
    }

    public Kaile(Long id_aile, String ebeveyn, String tc, String d_tarihi, String tel_no, String adres) {
        this.id_aile = id_aile;
        this.ebeveyn = ebeveyn;
        this.tc = tc;
        this.d_tarihi = d_tarihi;
        this.tel_no = tel_no;
        this.adres = adres;
    }

    public Long getId_aile() {
        return id_aile;
    }

    public void setId_aile(Long id_aile) {
        this.id_aile = id_aile;
    }

    public String getEbeveyn() {
        return ebeveyn;
    }

    public void setEbeveyn(String ebeveyn) {
        this.ebeveyn = ebeveyn;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getD_tarihi() {
        return d_tarihi;
    }

    public void setD_tarihi(String d_tarihi) {
        this.d_tarihi = d_tarihi;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Kaile{" + "id_aile=" + id_aile + ", ebeveyn=" + ebeveyn + ", tc=" + tc + ", d_tarihi=" + d_tarihi + ", tel_no=" + tel_no + ", adres=" + adres + '}';
    }
    
    
}
