package fr.dawan.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "comptesrendus")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompteRenduDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String compteRendu;

    @XmlElement
    private Date dateCreation;
    
    @XmlElement
    private int version;

    public CompteRenduDto() {
    }

    public CompteRenduDto(long id, String compteRendu, Date dateCreation, int version) {
        this.id = id;
        this.compteRendu = compteRendu;
        this.dateCreation = dateCreation;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
