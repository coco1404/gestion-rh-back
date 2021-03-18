package fr.dawan.dto;

import java.io.Serializable;
import java.util.List;

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
    private List<SalarieDto> salaries;

    public RoleDto() {
    }

    public RoleDto(long id, List<SalarieDto> salaries) {
        super();
        this.id = id;
        this.salaries = salaries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SalarieDto> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<SalarieDto> salaries) {
        this.salaries = salaries;
    }

}
