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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "formations")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    
    /**
     * durée en heure
     */
    @Column(precision = 2)
    private float duree;

    @Column(nullable = false, precision = 2)
    private float prix;

    @ManyToMany
    private List<Salarie> salaries;

    @ManyToMany(mappedBy = "formations")
    private List<Competence> competences;

    @Version
    private int version;

    public Formation() {
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
    
    /**
     * @return durée en heure
     */
    public float getDuree() {
        return duree;
    }
    
    /**
     * @param duree heure
     */
    public void setDuree(float duree) {
        this.duree = duree;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public List<Salarie> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salarie> salaries) {
        this.salaries = salaries;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
