package fr.dawan.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//pb de génération des tables avec el @manytoone : poste, typeContrat, manager

@Entity
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private TitrePoste titrePoste;

    @OneToOne
    private Salarie salarie;

    @ManyToOne
    private Poste poste;

    @ManyToOne
    private TypeContrat typeContrat;

    @Column(nullable = false, length = 255)
    private String compagnie; // voir s'il n'y a pas de class

    @Column(nullable = false, length = 255)
    private String implantation; // voir s'il n'y a pas de class

    @Column(nullable = false, length = 255)
    private Date dateDebut;

    @Column(length = 255)
    private Date dateFin;

    @Column(length = 255)
    private int volumeHoraire;

    @Column(length = 255)
    private int volumeJournalier;

    @ManyToOne
    private Salarie manager;

    @Column(nullable = false, length = 255)
    private String pj;

    public Poste() {
    }

    public Poste(long id, TitrePoste titrePoste, Salarie salarie, Poste poste, TypeContrat typeContrat,
            String compagnie, String implantation, Date dateDebut, Date dateFin, int volumeHoraire,
            int volumeJournalier, Salarie manager, String pj) {
        super();
        this.id = id;
        this.titrePoste = titrePoste;
        this.salarie = salarie;
        this.poste = poste;
        this.typeContrat = typeContrat;
        this.compagnie = compagnie;
        this.implantation = implantation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.volumeHoraire = volumeHoraire;
        this.volumeJournalier = volumeJournalier;
        this.manager = manager;
        this.pj = pj;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TitrePoste getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(TitrePoste titrePoste) {
        this.titrePoste = titrePoste;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public String getImplantation() {
        return implantation;
    }

    public void setImplantation(String implantation) {
        this.implantation = implantation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(int volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public int getVolumeJournalier() {
        return volumeJournalier;
    }

    public void setVolumeJournalier(int volumeJournalier) {
        this.volumeJournalier = volumeJournalier;
    }

    public Salarie getManager() {
        return manager;
    }

    public void setManager(Salarie manager) {
        this.manager = manager;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }
}
