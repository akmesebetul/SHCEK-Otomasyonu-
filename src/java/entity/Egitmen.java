/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Casper
 */
public class Egitmen {
    private Long id_egitmen;
    private String isim;
    private String tc;
    private String d_tarihi;
    private String tel_no;

    public Egitmen() {
    }

    public Egitmen(Long id_egitmen, String isim, String tc, String d_tarihi, String tel_no) {
        this.id_egitmen = id_egitmen;
        this.isim = isim;
        this.tc = tc;
        this.d_tarihi = d_tarihi;
        this.tel_no = tel_no;
    }
    
    
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
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
    public Long getId_egitmen() {
        return id_egitmen;
    }

    public void setId_egitmen(Long id_egitmen) {
        this.id_egitmen = id_egitmen;
    }

    @Override
    public String toString() {
        return "Egitmen{" + "id_egitmen=" + id_egitmen + ", isim=" + isim + ", tc=" + tc + ", d_tarihi=" + d_tarihi + ", tel_no=" + tel_no + '}';
    }

    @Override
    public boolean equals(Object obj) {
       
         if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Egitmen other = (Egitmen) obj;
        if (!Objects.equals(this.id_egitmen, other.id_egitmen)) {
            return false;
        }
        return true;
    }
        

   

    @Override
    public int hashCode() {
        
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_egitmen);
        return hash;
        

    }
    
    
    
}
