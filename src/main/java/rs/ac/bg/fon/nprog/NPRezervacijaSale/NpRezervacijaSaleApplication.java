package rs.ac.bg.fon.nprog.NPRezervacijaSale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * Klasa koja predstavlja spring boot aplikaciju i sluzi za njeno pokretanje
 * 
 * @author Milica Bacic
 */
@SpringBootApplication
@ComponentScan(basePackages = "rs.ac.bg.fon.nprog.NPRezervacijaSale")
@EntityScan("rs.ac.bg.fon.nprog.NPRezervacijaSale.domain")
@EnableJpaRepositories("rs.ac.bg.fon.nprog.NPRezervacijaSale.repository")
public class NpRezervacijaSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpRezervacijaSaleApplication.class, args);
	}

}
