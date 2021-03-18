package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entreprises")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntrepriseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    
}
