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
public class Etkinlikler {
    private Long id_etk;
    private String etkinlik;
    private String icerik;
    private String tarih;

    public Etkinlikler() {
    }
    public Etkinlikler(Long id_etk, String etkinlik, String icerik, String tarih) {
        this.id_etk = id_etk;
        this.etkinlik = etkinlik;
        this.icerik = icerik;
        this.tarih = tarih;
    }
    public Long getId_etk() {
        return id_etk;
    }

    public void setId_etk(Long id_etk) {
        this.id_etk = id_etk;
    }

    public String getEtkinlik() {
        return etkinlik;
    }

    public void setEtkinlik(String etkinlik) {
        this.etkinlik = etkinlik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "Etkinlikler{" + "id_etk=" + id_etk + ", etkinlik=" + etkinlik + ", icerik=" + icerik + ", tarih=" + tarih + '}';
    }
    
    
}
