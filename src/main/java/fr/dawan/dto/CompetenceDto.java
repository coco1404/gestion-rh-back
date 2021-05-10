package fr.dawan.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "competences")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompetenceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String nom;

    @XmlElement
    private List<DomaineDto> domaines;

    @XmlElement
    private int version;

    public CompetenceDto() {
    }

    public CompetenceDto(long id, String nom, List<DomaineDto> domaines, int version) {
        super();
        this.id = id;
        this.nom = nom;
        this.domaines = domaines;
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

    public List<DomaineDto> getDomaines() {
        return domaines;
    }

    public void setDomaines(List<DomaineDto> domaines) {
        this.domaines = domaines;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
