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
public class Yemekhane {
    private Long id_ymk;
    private String gunler;
    private String vakitler;
    private String yemekler;

    public Yemekhane() {
    }

    public Yemekhane(Long id_ymk, String gunler, String vakitler, String yemekler) {
        this.id_ymk = id_ymk;
        this.gunler = gunler;
        this.vakitler = vakitler;
        this.yemekler = yemekler;
    }

    public Long getId_ymk() {
        return id_ymk;
    }

    public void setId_ymk(Long id_ymk) {
        this.id_ymk = id_ymk;
    }

    public String getGunler() {
        return gunler;
    }

    public void setGunler(String gunler) {
        this.gunler = gunler;
    }

    public String getVakitler() {
        return vakitler;
    }

    public void setVakitler(String vakitler) {
        this.vakitler = vakitler;
    }

    public String getYemekler() {
        return yemekler;
    }

    public void setYemekler(String yemekler) {
        this.yemekler = yemekler;
    }

    @Override
    public String toString() {
        return "Yemekhane{" + "id_ymk=" + id_ymk + ", gunler=" + gunler + ", vakitler=" + vakitler + ", yemekler=" + yemekler + '}';
    }
    
    
}
