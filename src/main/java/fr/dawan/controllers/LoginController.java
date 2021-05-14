package fr.dawan.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.TokenSaver;
import fr.dawan.dto.LoginDto;
import fr.dawan.dto.LoginResponseDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.services.SalarieService;
import fr.dawan.tools.HashTools;
import fr.dawan.tools.JwtTokenUtil;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private SalarieService salarieService;
    
//  @Autowired
//  private AuthenticationManager authenticationManager;
//  
//  @Autowired
//  private UserDetailsService jwtInMemoryUserDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @PostMapping(value="/authenticate", consumes = "application/json")
    public ResponseEntity<?> checkLogin(@RequestBody LoginDto loginObj) throws Exception{
        SalarieDto cDto = salarieService.findByEmail(loginObj.getEmail());
        String hashedPwd = HashTools.hashSHA512(loginObj.getPassword());
        if(cDto !=null && cDto.getMotDePasse().contentEquals(hashedPwd)) {
            
            //Fabrication du token en utilisant jjwt (librairie incluse dans le pom)
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("email", cDto.getEmail());
            //ajouter les données que l'on souhaite
            String token = jwtTokenUtil.doGenerateToken(claims, loginObj.getEmail());
            TokenSaver.tokensByEmail.put(loginObj.getEmail(), token);
            
            return ResponseEntity.ok(new LoginResponseDto(token,cDto.getEmail()));
        }else
            throw new Exception("Erreur : identifiants incorrects !");
        
        
        //authentification
//      authenticate(loginObj.getEmail(), loginObj.getPassword());
//      
//      UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(loginObj.getEmail());
//      System.out.println(">>pwd >>>" + userDetails.getPassword());
//      
//      //générer le token
//      String token = jwtTokenUtil.generateToken(userDetails);
//      
//      //retourner la réponse
//      return ResponseEntity.ok(new LoginResponseDto(token));

        
    }

}
