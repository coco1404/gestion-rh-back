package fr.dawan.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, length = 255)
    private Date dateDebut;
    
    @Column(nullable = false, length = 255)
    private Date dateFin;
    
    @Column(length = 255)
    private float volumeHoraire;

    @Column(length = 255)
    private float volumeJournalier;
    
    @Column(nullable = false, length = 255)
    private float prix;
    
    @ManyToMany
    private List<Salarie> salarieInscrit;
    
    @ManyToMany
    private List<Competence> competenceApportee;
    
    @Version
    private int version;
    
    public Formation() {}
    public Formation(long id, Date dateDebut, Date dateFin, float volumeHoraire, float volumeJournalier, float prix,
            List<Salarie> salarieInscrit, List<Competence> competenceApportee, int version) {
        super();
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.volumeHoraire = volumeHoraire;
        this.volumeJournalier = volumeJournalier;
        this.prix = prix;
        this.salarieInscrit = salarieInscrit;
        this.competenceApportee = competenceApportee;
        this.version = version;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    
    public float getVolumeHoraire() {
        return volumeHoraire;
    }
    public void setVolumeHoraire(float volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }
    
    public float getVolumeJournalier() {
        return volumeJournalier;
    }
    public void setVolumeJournalier(float volumeJournalier) {
        this.volumeJournalier = volumeJournalier;
    }
    
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    public List<Salarie> getSalarieInscrit() {
        return salarieInscrit;
    }
    public void setSalarieInscrit(List<Salarie> salarieInscrit) {
        this.salarieInscrit = salarieInscrit;
    }
    
    public List<Competence> getCompetenceApportee() {
        return competenceApportee;
    }
    public void setCompetenceApportee(List<Competence> competenceApportee) {
        this.competenceApportee = competenceApportee;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
