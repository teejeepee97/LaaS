//package LaaS.ProjectLaaS.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class SimpleCORSFilter implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8082")  // Add your frontend origin(s) here
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//        		.allowedHeaders("*")
//        		.allowCredentials(true);  // Allow credentials (cookies, authorization headers, etc.)
//
//    }
//}

package LaaS.ProjectLaaS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SimpleCORSFilter implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500", "https://red-smoke-07c837103.5.azurestaticapps.net") // Add your frontend origin(s) here
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);  // Allow credentials (cookies, authorization headers, etc.)
    }
}