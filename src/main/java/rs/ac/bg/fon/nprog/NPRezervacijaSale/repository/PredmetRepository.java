package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;
/**
 * Interfejs koji se odnosi na repozitorijum za domensku klasu Predmet
 * 
 * Implementira JpaRepository
 * 
 * @author Milica Bacic
 *
 */
public interface PredmetRepository extends JpaRepository<Predmet, Long> {

}
