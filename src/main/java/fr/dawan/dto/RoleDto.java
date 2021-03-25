package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "roles")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;
    
    @XmlElement
    private String titre;
    
    @XmlElement
    private int version;

    public RoleDto() {
    }

    public RoleDto(long id, String titre, int version) {
        this.id = id;
        this.titre = titre;
        this.version = version;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
