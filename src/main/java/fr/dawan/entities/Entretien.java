package fr.dawan.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "entretien")
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, length = 255)
    private Date dateEntretien;
    
    @OneToOne
    private CompteRendu compteRendu;
    
    @OneToMany
    private List<Salarie> salarie;
    
    @ManyToOne
    private Salarie manager;
    
    @ManyToOne
    private Salarie rh;    
    
    @Version
    private int version;
    
    public Entretien() {}
    public Entretien(long id, Date dateEntretien, CompteRendu compteRendu, List<Salarie> salarie, Salarie manager,
            Salarie rh, int version) {
        super();
        this.id = id;
        this.dateEntretien = dateEntretien;
        this.compteRendu = compteRendu;
        this.salarie = salarie;
        this.manager = manager;
        this.rh = rh;
        this.version = version;
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
    
    public List<Salarie> getSalarie() {
        return salarie;
    }
    public void setSalarie(List<Salarie> salarie) {
        this.salarie = salarie;
    }
    
    public Salarie getManager() {
        return manager;
    }
    public void setManager(Salarie manager) {
        this.manager = manager;
    }
    
    public Salarie getRh() {
        return rh;
    }
    public void setRh(Salarie rh) {
        this.rh = rh;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
