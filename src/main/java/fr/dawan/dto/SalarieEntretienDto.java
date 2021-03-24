package fr.dawan.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "salaries-entretien")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalarieEntretienDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String nom;

    @XmlElement
    private String prenom;

    @XmlElement
    private String email;

    @XmlElement
    private DomaineDto domaine;

    @XmlElement
    private List<RoleDto> roles;

    @XmlElement
    private EntrepriseDto entreprise;

    public SalarieEntretienDto() {
    }

    public SalarieEntretienDto(long id, String nom, String prenom, String email, DomaineDto domaine,
            List<RoleDto> roles, EntrepriseDto entreprise) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.domaine = domaine;
        this.roles = roles;
        this.entreprise = entreprise;
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

    public EntrepriseDto getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseDto entreprise) {
        this.entreprise = entreprise;
    }

}
