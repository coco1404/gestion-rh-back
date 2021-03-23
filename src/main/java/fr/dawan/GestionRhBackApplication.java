package fr.dawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fr.dawan.interceptors.TokenInterceptor;

@SpringBootApplication
public class GestionRhBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRhBackApplication.class, args);
	}
	
	@Autowired
	private TokenInterceptor tokenInterceptor;
	
	@Bean
    public WebMvcConfigurer myMvcConfigurer() {

        return new WebMvcConfigurer() {

            // CROSS ORIGIN
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // registry.addMapping("/api/contacts").allowedMethods("GET").allowedOrigins("*");
                // registry.addMapping("/api/contacts").allowedMethods("POST","PUT").allowedOrigins("jehann.fr");
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }

//             CONVERTERS
//            @Override
//            public void addFormatters(FormatterRegistry registry) {
//                registry.addConverter(new fr.dawan.myapi1.dto.StringToContactDtoConverter());
//            }
            
            // Intercepteurs
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(tokenInterceptor);
            }

            // MATRIX
        };
    }

}
