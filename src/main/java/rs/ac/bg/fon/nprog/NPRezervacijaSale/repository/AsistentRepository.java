package rs.ac.bg.fon.nprog.NPRezervacijaSale.repository;

import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.domain.Asistent;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AsistentRepository extends JpaRepository<Asistent, Long>{

}
