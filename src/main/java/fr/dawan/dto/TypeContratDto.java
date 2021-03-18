package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "typescontrats")
@XmlAccessorType(XmlAccessType.FIELD)
public class TypeContratDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String type;

    public TypeContratDto() {
    }

    public TypeContratDto(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
