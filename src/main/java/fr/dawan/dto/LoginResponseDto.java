package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "login-reponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResponseDto implements Serializable{

    private String token;
    private SalarieDto salarie;

    public LoginResponseDto() {
        
    }
    
    public LoginResponseDto(String token) {
        super();
        this.token = token;
    }

    public LoginResponseDto(String token, SalarieDto salarie) {
        this.token = token;
        this.salarie = salarie;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public SalarieDto getSalarie() {
        return salarie;
    }


    public void setSalarie(SalarieDto salarie) {
        this.salarie = salarie;
    }
    
    
}
