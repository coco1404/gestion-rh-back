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
    private Object subObject;

    public LoginResponseDto() {
        
    }
    
    
    public LoginResponseDto(String token) {
        super();
        this.token = token;
    }

    public LoginResponseDto(String token, Object subObject) {
        this.token = token;
        this.subObject = subObject;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Object getSubObject() {
        return subObject;
    }


    public void setSubObject(Object subObject) {
        this.subObject = subObject;
    }
      
    
    
}
