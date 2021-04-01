/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import java.sql.Date;
import java.util.Objects;


/**
 *
 * @author Casper
 */
public class Bakici {
    private Long id_bakici;
    private String isim;
    private String tc;
    private String d_tarihi;
    private String tel_no;
    private List<Cocuk> cocuklar;

    public Bakici(Long id_bakici, String isim, String tc, String d_tarihi, String tel_no, List<Cocuk> cocuklar) {
        this.id_bakici = id_bakici;
        this.isim = isim;
        this.tc = tc;
        this.d_tarihi = d_tarihi;
        this.tel_no = tel_no;
        this.cocuklar = cocuklar;
    }

    public Bakici() {
    }

    public Long getId_bakici() {
        return id_bakici;
    }

    public void setId_bakici(Long id_bakici) {
        this.id_bakici = id_bakici;
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

    public List<Cocuk> getCocuklar() {
        return cocuklar;
    }

    public void setCocuklar(List<Cocuk> cocuklar) {
        this.cocuklar = cocuklar;
    }

    @Override
    public String toString() {
        return "Bakici{" + "id_bakici=" + id_bakici + ", isim=" + isim + ", tc=" + tc + ", d_tarihi=" + d_tarihi + ", tel_no=" + tel_no + ", cocuklar=" + cocuklar + '}';
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
        final Bakici other = (Bakici) obj;
        if (!Objects.equals(this.id_bakici, other.id_bakici)) {
            return false;
        }
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
