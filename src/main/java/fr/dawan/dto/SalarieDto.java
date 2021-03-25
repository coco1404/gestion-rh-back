package fr.dawan.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@XmlRootElement(name = "salaries")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalarieDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String nom;

    @XmlElement
    private String prenom;

    @XmlElement
    private String email;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String motDePasse;

    @XmlElement
    private String telPersonnel;

    @XmlElement
    private String mobilPersonnel;

    @XmlElement
    private AdresseDto adresse;

    @XmlElement
    private Date dateNaissance;

    @XmlElement
    private String telProfessionnel;

    @XmlElement
    private String mobileProfessionnel;

    @XmlElement
    private DomaineDto domaine;

    @XmlElement
    private List<RoleDto> roles;

    @XmlElement
    private List<CompetenceDto> competences;

    @XmlElement
    private boolean siManager;

    @XmlElement
    private EntrepriseDto entreprise;

    @XmlElement
    private List<FormationDto> formations;

    @XmlElement
    private List<PosteDto> postes;
    
    @XmlElement
    private int version;

    public SalarieDto() {
    }

    public SalarieDto(long id, String nom, String prenom, String email, String motDePasse, String telPersonnel,
            String mobilPersonnel, AdresseDto adresse, Date dateNaissance, String telProfessionnel,
            String mobileProfessionnel, DomaineDto domaine, List<RoleDto> roles, List<CompetenceDto> competences,
            boolean siManager, EntrepriseDto entreprise, List<FormationDto> formations, List<PosteDto> postes,
            int version) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telPersonnel = telPersonnel;
        this.mobilPersonnel = mobilPersonnel;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.telProfessionnel = telProfessionnel;
        this.mobileProfessionnel = mobileProfessionnel;
        this.domaine = domaine;
        this.roles = roles;
        this.competences = competences;
        this.siManager = siManager;
        this.entreprise = entreprise;
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

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
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

    public DomaineDto getDomaine() {
        return domaine;
    }

    public void setDomaine(DomaineDto domaine) {
        this.domaine = domaine;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public List<CompetenceDto> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDto> competences) {
        this.competences = competences;
    }

    public boolean isSiManager() {
        return siManager;
    }

    public void setSiManager(boolean siManager) {
        this.siManager = siManager;
    }

    public EntrepriseDto getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseDto entreprise) {
        this.entreprise = entreprise;
    }

    public List<FormationDto> getFormations() {
        return formations;
    }

    public void setFormations(List<FormationDto> formations) {
        this.formations = formations;
    }

    public List<PosteDto> getPostes() {
        return postes;
    }

    public void setPostes(List<PosteDto> postes) {
        this.postes = postes;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
