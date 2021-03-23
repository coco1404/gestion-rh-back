package fr.dawan.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entretiens")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntretienDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @XmlElement
    private long id;

    @XmlElement
    private Date dateEntretien;

    @XmlElement
    private CompteRenduDto compteRendu;

    @XmlElement
    private SalarieEntretienDto salarie;
    
    @XmlElement
    private SalarieEntretienDto managerEntretien;

    public EntretienDto() {
    }

    public EntretienDto(long id, Date dateEntretien, CompteRenduDto compteRendu, SalarieEntretienDto salarie,
            SalarieEntretienDto managerEntretien) {
        this.id = id;
        this.dateEntretien = dateEntretien;
        this.compteRendu = compteRendu;
        this.salarie = salarie;
        this.managerEntretien = managerEntretien;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(Date dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public CompteRenduDto getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(CompteRenduDto compteRendu) {
        this.compteRendu = compteRendu;
    }

    public SalarieEntretienDto getSalarie() {
        return salarie;
    }

    public void setSalarie(SalarieEntretienDto salarie) {
        this.salarie = salarie;
    }

    public SalarieEntretienDto getManagerEntretien() {
        return managerEntretien;
    }

    public void setManagerEntretien(SalarieEntretienDto managerEntretien) {
        this.managerEntretien = managerEntretien;
    }

}
