package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "titrespostes")
@XmlAccessorType(XmlAccessType.FIELD)
public class TitrePosteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;
    
    @XmlElement
    private String intitule;
    
    @XmlElement
    private int version;

    public TitrePosteDto() {
    }
    
    public TitrePosteDto(long id, String intitule, int version) {
        this.id = id;
        this.intitule = intitule;
        this.version = version;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
}
