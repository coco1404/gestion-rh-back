package fr.dawan.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "competences")
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String nom;

    @ManyToMany
    @JoinTable(name = "competences_domaines", joinColumns = @JoinColumn(name = "competence_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "domaine_id", referencedColumnName = "id"))
    private List<Domaine> domaines;

    @ManyToMany(mappedBy = "competences")
    private List<Salarie> salaries;

    @ManyToMany(mappedBy = "competences")
    private List<Formation> formations;

    @ManyToMany(mappedBy = "competencesRequises")
    private List<Poste> postes;

    @Version
    private int version;

    public Competence() {
    }

    public Competence(long id, String nom, List<Domaine> domaines, List<Salarie> salaries, List<Formation> formations,
            List<Poste> postes, int version) {
        super();
        this.id = id;
        this.nom = nom;
        this.domaines = domaines;
        this.salaries = salaries;
        this.formations = formations;
        this.postes = postes;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Salarie> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salarie> salaries) {
        this.salaries = salaries;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
