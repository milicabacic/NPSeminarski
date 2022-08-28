package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Sala;
/**
 * Interfejs koji se odnosi na repozitorijum za domensku klasu Sala
 * 
 * Implementira JpaRepository
 * 
 * @author Milica Bacic
 *
 */
@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{

}
