package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "adresses")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdresseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String numero;

    @XmlElement
    private String voie;

    @XmlElement
    private String ville;

    @XmlElement
    private String complementAdresse;

    @XmlElement
    private String codePostal;

    @XmlElement
    private String pays;
    
    @XmlElement
    private int version;

    public AdresseDto() {
    }

    public AdresseDto(long id, String numero, String voie, String ville, String complementAdresse, String codePostal,
            String pays, int version) {
        this.id = id;
        this.numero = numero;
        this.voie = voie;
        this.ville = ville;
        this.complementAdresse = complementAdresse;
        this.codePostal = codePostal;
        this.pays = pays;
        this.version = version;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
