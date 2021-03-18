package fr.dawan.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "entretiens")
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEntretien;

    @ManyToOne
    private CompteRendu compteRendu;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Salarie salarie;
    
    /**
     * manager ou RH qui fait l'entretien du salarié
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Salarie managerEntretien;

    @Version
    private int version;

    public Entretien() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(Date dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public CompteRendu getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(CompteRendu compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public Salarie getManagerEntretien() {
        return managerEntretien;
    }

    public void setManagerEntretien(Salarie managerEntretien) {
        this.managerEntretien = managerEntretien;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
