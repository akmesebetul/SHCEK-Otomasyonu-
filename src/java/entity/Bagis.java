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
public class Bagis {
    private Long id_bagis;
    private String turu;
    private String miktar;
    private String bagisci;
    private String e_posta;
    private String tel_no;

    public Bagis(Long id_bagis, String turu, String miktar, String bagisci, String e_posta, String tel_no) {
        this.id_bagis = id_bagis;
        this.turu = turu;
        this.miktar = miktar;
        this.bagisci = bagisci;
        this.e_posta = e_posta;
        this.tel_no = tel_no;
    }

    public Bagis() {
        
    }
    
    

    public Long getId_bagis() {
        return id_bagis;
    }

    public void setId_bagis(Long id_bagis) {
        this.id_bagis = id_bagis;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getMiktar() {
        return miktar;
    }

    public void setMiktar(String miktar) {
        this.miktar = miktar;
    }

    public String getBagisci() {
        return bagisci;
    }

    public void setBagisci(String bagisci) {
        this.bagisci = bagisci;
    }

    public String getE_posta() {
        return e_posta;
    }

    public void setE_posta(String e_posta) {
        this.e_posta = e_posta;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    @Override
    public String toString() {
        return "Bagis{" + "id_bagis=" + id_bagis + ", turu=" + turu + ", miktar=" + miktar + ", bagisci=" + bagisci + ", e_posta=" + e_posta + ", tel_no=" + tel_no + '}';
    }
    
    
    
    
    
}
