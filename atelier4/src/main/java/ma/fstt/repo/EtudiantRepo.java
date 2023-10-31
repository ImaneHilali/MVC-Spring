package ma.fstt.repo;

import ma.fstt.persistence.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByClasseId(Long idClasse);
}

