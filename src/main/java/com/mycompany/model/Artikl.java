package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knjige")
public class Artikl implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "knjiga_id")
    private int knjiga_id;
    
    @Column(name = "knjiga_naziv")
    private String knjiga_naziv;
    
    @Column(name = "knjiga_cena")
    private int knjiga_cena;
    
    @Column(name = "knjiga_opis")
    private String knjiga_opis;
    
    @Column(name = "knjiga_slika")
    private String knjiga_slika;

    public int getKnjiga_id() {
        return knjiga_id;
    }

    public void setKnjiga_id(int knjiga_id) {
        this.knjiga_id = knjiga_id;
    }

    public String getKnjiga_naziv() {
        return knjiga_naziv;
    }

    public void setKnjiga_naziv(String knjiga_naziv) {
        this.knjiga_naziv = knjiga_naziv;
    }

    public int getKnjiga_cena() {
        return knjiga_cena;
    }

    public void setKnjiga_cena(int knjiga_cena) {
        this.knjiga_cena = knjiga_cena;
    }

    public String getKnjiga_opis() {
        return knjiga_opis;
    }

    public void setKnjiga_opis(String knjiga_opis) {
        this.knjiga_opis = knjiga_opis;
    }

    public String getKnjiga_slika() {
        return knjiga_slika;
    }

    public void setKnjiga_slika(String knjiga_slika) {
        this.knjiga_slika = knjiga_slika;
    }

    @Override
    public String toString() {
        return "Artikl{" + "knjiga_id=" + knjiga_id + ", knjiga_naziv=" + knjiga_naziv
                + ", knjiga_cena=" + knjiga_cena + ", knjiga_opis=" + knjiga_opis + ", knjiga_slika=" + knjiga_slika + '}';
    }

}
