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
public class Kurs {
    private Long id_kurs;
    private String kurslar;
    private String start;
    private String finish;
    private Cocuk kursiyer;
    private Egitmen e;

    public Kurs() {
    }

    public Kurs(Long id_kurs, String kurslar, String start, String finish, Cocuk kursiyer, Egitmen e) {
        this.id_kurs = id_kurs;
        this.kurslar = kurslar;
        this.start = start;
        this.finish = finish;
        this.kursiyer = kursiyer;
        this.e = e;
    }

    public Long getId_kurs() {
        return id_kurs;
    }

    public void setId_kurs(Long id_kurs) {
        this.id_kurs = id_kurs;
    }

    public String getKurslar() {
        return kurslar;
    }

    public void setKurslar(String kurslar) {
        this.kurslar = kurslar;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public Cocuk getKursiyer() {
        return kursiyer;
    }

    public void setKursiyer(Cocuk kursiyer) {
        this.kursiyer = kursiyer;
    }

    public Egitmen getE() {
        return e;
    }

    public void setE(Egitmen e) {
        this.e = e;
    }
    
    

    

    @Override
    public String toString() {
        return "Kurs{" + "id_kurs=" + id_kurs + ", kurslar=" + kurslar + ", start=" + start + ", finish=" + finish + ", kursiyer=" + kursiyer + ", e=" + e + '}';
    }
    
}
