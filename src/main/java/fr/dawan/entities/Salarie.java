package fr.dawan.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "salarie")
public class Salarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(nullable = false, length = 255)
    private String prenom;

    @Column(nullable = false, length = 255)
    private String motDePasse;

    @Column(length = 50)
    private String telPersonnel;

    @Column(length = 50)
    private String mobilPersonnel;

    @Column(nullable = false, length = 255)
    private String adresse;

    @Column(nullable = false, length = 255)
    private Date dateNaissance;

    @Column(length = 50)
    private String telProfessionnel;

    @Column(length = 50)
    private String mobileProfessionnel;

    @ManyToOne
    private Domaine domaine;

    @ManyToMany
    private List<Role> role;

    @Version
    private int version;

    public Salarie() {}
    public Salarie(long id, String nom, String prenom, String motDePasse, String telPersonnel, String mobilPersonnel,
            String adresse, Date dateNaissance, String telProfessionnel, String mobileProfessionnel, Domaine domaine,
            List<Role> role, int version) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.telPersonnel = telPersonnel;
        this.mobilPersonnel = mobilPersonnel;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.telProfessionnel = telProfessionnel;
        this.mobileProfessionnel = mobileProfessionnel;
        this.domaine = domaine;
        this.role = role;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
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

    public List<Role> getRole() {
        return role;
    }
    public void setRole(List<Role> role) {
        this.role = role;
    }
    
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
