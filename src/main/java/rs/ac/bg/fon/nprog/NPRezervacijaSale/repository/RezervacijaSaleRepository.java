package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RezervacijaSale;
/**
 * Interfejs koji se odnosi na repozitorijum za domensku klasu RezervacijaSale
 * 
 * Implementira JpaRepository
 * 
 * @author Milica Bacic
 *
 */
@Repository
public interface RezervacijaSaleRepository extends JpaRepository<RezervacijaSale, Long>{

	List<RezervacijaSale> findByRaspored(long rasporedId);
	
}
