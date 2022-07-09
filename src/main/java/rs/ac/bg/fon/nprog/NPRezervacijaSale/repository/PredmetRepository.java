package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Predmet;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {

}
