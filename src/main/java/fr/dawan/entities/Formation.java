package fr.dawan.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

    @Column(nullable = false, length = 255)
    private String titre;

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
    @JoinTable(name = "formation_salarie", joinColumns = @JoinColumn(name = "formation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "salarie_id", referencedColumnName = "id"))
    private List<Salarie> salaries;

    @ManyToMany
    @JoinTable(name = "formation_competence", joinColumns = @JoinColumn(name = "formation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "competence_id", referencedColumnName = "id"))
    private List<Competence> competences;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Domaine domaine;

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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
     * @return en heure
     */
    public float getDuree() {
        return duree;
    }

    /**
     * @param duree en heure
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

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
