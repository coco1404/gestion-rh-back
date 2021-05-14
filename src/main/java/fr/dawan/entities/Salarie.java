package fr.dawan.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "salaries")
public class Salarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(nullable = false, length = 255)
    private String prenom;
    
    @Column(nullable = false, length = 255,unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String motDePasse;

    @Column(length = 50)
    private String telPersonnel;

    @Column(length = 50)
    private String mobilPersonnel;
    
    @OneToMany(mappedBy = "salarie", fetch = FetchType.LAZY)
    @JsonIgnore
    @OrderBy("id DESC")
    private List<Poste> postes;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Adresse adresse;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(length = 50)
    private String telProfessionnel;

    @Column(length = 50)
    private String mobileProfessionnel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Domaine domaine;

    @ManyToMany
    @JoinTable(
            name="salarie_role",
            joinColumns=
            @JoinColumn( name="salarie_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
    private List<Role> roles;

    @ManyToMany
    @JoinTable(
            name="salarie_competence",
            joinColumns=
            @JoinColumn( name="salarie_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="competence_id", referencedColumnName="id"))
    private List<Competence> competences;

    @Column(nullable = false)
    private boolean siManager;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Entreprise entreprise;

    @ManyToMany(mappedBy = "salaries")
    private List<Formation> formations;

    @Version
    private int version;

    public Salarie() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getTelPersonnel() {
        return telPersonnel;
    }

    public void setTelPersonnel(String telPersonnel) {
        this.telPersonnel = telPersonnel;
    }

    public String getMobilPersonnel() {
        return mobilPersonnel;
    }

    public void setMobilPersonnel(String mobilPersonnel) {
        this.mobilPersonnel = mobilPersonnel;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelProfessionnel() {
        return telProfessionnel;
    }

    public void setTelProfessionnel(String telProfessionnel) {
        this.telProfessionnel = telProfessionnel;
    }

    public String getMobileProfessionnel() {
        return mobileProfessionnel;
    }

    public void setMobileProfessionnel(String mobileProfessionnel) {
        this.mobileProfessionnel = mobileProfessionnel;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public boolean isSiManager() {
        return siManager;
    }

    public void setSiManager(boolean siManager) {
        this.siManager = siManager;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public List<Poste> getPostes() {
        return postes;
    }
    
    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }
    
    
}
