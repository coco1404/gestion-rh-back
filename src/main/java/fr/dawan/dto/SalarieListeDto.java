package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "salaries")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalarieListeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long salarieId;

    @XmlElement
    private String salarieNom;

    @XmlElement
    private String salariePrenom;

    @XmlElement
    private DomaineDto domaine;

    @XmlElement
    private EntrepriseDto entreprise;

    @XmlElement
    private TitrePosteDto posteActuel;

    public SalarieListeDto() {
    }

    public SalarieListeDto(long salarieId, String salarieNom, String salariePrenom, DomaineDto domaine,
            EntrepriseDto entreprise, TitrePosteDto posteActuel) {
        super();
        this.salarieId = salarieId;
        this.salarieNom = salarieNom;
        this.salariePrenom = salariePrenom;
        this.domaine = domaine;
        this.entreprise = entreprise;
        this.posteActuel = posteActuel;
    }

    public long getSalarieId() {
        return salarieId;
    }

    public void setSalarieId(long salarieId) {
        this.salarieId = salarieId;
    }

    public String getSalarieNom() {
        return salarieNom;
    }

    public void setSalarieNom(String salarieNom) {
        this.salarieNom = salarieNom;
    }

    public String getSalariePrenom() {
        return salariePrenom;
    }

    public void setSalariePrenom(String salariePrenom) {
        this.salariePrenom = salariePrenom;
    }

    public DomaineDto getDomaine() {
        return domaine;
    }

    public void setDomaine(DomaineDto domaine) {
        this.domaine = domaine;
    }

    public EntrepriseDto getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseDto entreprise) {
        this.entreprise = entreprise;
    }

    public TitrePosteDto getPosteActuel() {
        return posteActuel;
    }

    public void setPosteActuel(TitrePosteDto posteActuel) {
        this.posteActuel = posteActuel;
    }
}
