package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;
/**
 * Interfejs koji se odnosi na repozitorijum za domensku klasu RasporedIspita
 * 
 * Implementira JpaRepository
 * 
 * @author Milica Bacic
 *
 */
@Repository
public interface RasporedIspitaRepository extends JpaRepository<RasporedIspita, Long>{

}
