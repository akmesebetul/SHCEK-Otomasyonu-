/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Casper
 */
public class Cocuk {
   private Long id_cocuk;
   private String isim;
   private String tc;
   private String d_tarihi;
   private String k_tarihi;
   private List<Bakici> bakicilar;

    public Cocuk(Long id_cocuk, String isim, String tc, String d_tarihi, String k_tarihi,List<Bakici> bakicilar) {
        this.id_cocuk = id_cocuk;
        this.isim = isim;
        this.tc = tc;
        this.d_tarihi = d_tarihi;
        this.k_tarihi = k_tarihi;
        this.bakicilar = bakicilar;
    }

    public Cocuk() {
    }
    

    public Long getId_cocuk() {
        return id_cocuk;
    }

    public void setId_cocuk(Long id_cocuk) {
        this.id_cocuk = id_cocuk;
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

    public String getK_tarihi() {
        return k_tarihi;
    }

    public void setK_tarihi(String k_tarihi) {
        this.k_tarihi = k_tarihi;
    }

    public List<Bakici> getBakicilar() {
        return bakicilar;
    }

    public void setBakicilar(List<Bakici> bakicilar) {
        this.bakicilar = bakicilar;
    }

   
    
    @Override
    public String toString() {
        return "Cocuk{" + "id_cocuk=" + id_cocuk + ", isim=" + isim + ", tc=" + tc + ", d_tarihi=" + d_tarihi + ", k_tarihi=" + k_tarihi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id_cocuk);
        return hash;
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
        final Cocuk other=(Cocuk) obj;
        if(!Objects.equals(this.id_cocuk, other.id_cocuk)){
            return false;
        }
        return true; //To change body of generated methods, choose Tools | Templates.
    }

}
