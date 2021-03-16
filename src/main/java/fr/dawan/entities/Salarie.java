package fr.dawan.entities;

import java.util.Date;

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
    private String MobilPersonnel;
    
    @Column(nullable = false, length = 255)
    private String adresse;
    
    @Column(nullable = false, length = 255)
    private Date dateNaissance;
    
    @ManyToOne
    private TitrePoste poste;
    
    @ManyToOne
    private TypeContrat typeContrat;
    
    @ManyToOne
    private Salarie manager;
    
    @Column(length = 50)
    private String telProfessionnel;
    
    @Column(length = 50)
    private String mobileProfessionnel;
    
    @Column(length = 255)
    private String Compagnie; //voir s'il n'y a pas de class
    
    @Column(length = 255)
    private String Implantation; //voir s'il n'y a pas de class
    
    @ManyToMany
    private Domaine domaine;
    
    @ManyToMany
    private Role role;
    
    @Version
    private int version;
    
    public Salarie() {}
    public Salarie(long id, String nom, String prenom, String motDePasse, String telPersonnel, String mobilPersonnel,
            String adresse, Date dateNaissance, TitrePoste poste, TypeContrat typeContrat, Salarie manager,
            String telProfessionnel, String mobileProfessionnel, String compagnie, String implantation, Domaine domaine,
            Role role, int version) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.telPersonnel = telPersonnel;
        MobilPersonnel = mobilPersonnel;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.poste = poste;
        this.typeContrat = typeContrat;
        this.manager = manager;
        this.telProfessionnel = telProfessionnel;
        this.mobileProfessionnel = mobileProfessionnel;
        Compagnie = compagnie;
        Implantation = implantation;
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
        return MobilPersonnel;
    }
    public void setMobilPersonnel(String mobilPersonnel) {
        MobilPersonnel = mobilPersonnel;
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
    
    public TitrePoste getPoste() {
        return poste;
    }
    public void setPoste(TitrePoste poste) {
        this.poste = poste;
    }
    
    public TypeContrat getTypeContrat() {
        return typeContrat;
    }
    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }
    
    public Salarie getManager() {
        return manager;
    }
    public void setManager(Salarie manager) {
        this.manager = manager;
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
    
    public String getCompagnie() {
        return Compagnie;
    }
    public void setCompagnie(String compagnie) {
        Compagnie = compagnie;
    }
    
    public String getImplantation() {
        return Implantation;
    }
    public void setImplantation(String implantation) {
        Implantation = implantation;
    }
    
    public Domaine getDomaine() {
        return domaine;
    }
    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
    
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
