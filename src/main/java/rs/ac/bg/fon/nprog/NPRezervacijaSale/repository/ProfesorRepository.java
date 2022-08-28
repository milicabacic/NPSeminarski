package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Profesor;
/**
 * Interfejs koji se odnosi na repozitorijum za domensku klasu Profesor
 * 
 * Implementira JpaRepository
 * 
 * @author Milica Bacic
 *
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
