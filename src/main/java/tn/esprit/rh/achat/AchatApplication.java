package tn.esprit.rh.achat;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AchatApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
    public static void main(String[] args) {
        SpringApplication.run(AchatApplication.class, args);
    }

}
