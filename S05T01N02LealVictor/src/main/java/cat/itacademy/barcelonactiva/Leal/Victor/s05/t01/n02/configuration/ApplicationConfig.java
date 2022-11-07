package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

   @Bean
   public ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper;
   }
}