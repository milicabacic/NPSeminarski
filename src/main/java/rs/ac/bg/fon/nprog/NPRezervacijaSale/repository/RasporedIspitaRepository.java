package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.RasporedIspita;

@Repository
public interface RasporedIspitaRepository extends JpaRepository<RasporedIspita, Long>{

}
