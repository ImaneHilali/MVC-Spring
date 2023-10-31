package ma.fstt.service;

import ma.fstt.persistence.Etudiant;
import ma.fstt.repo.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    EtudiantRepo etudiantRepo;

    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }
    public List<Etudiant> findAllEtudiants() {
        return etudiantRepo.findAll();
    }
    public Optional<Etudiant> findById(Long idEtudiant) {
        return etudiantRepo.findById(idEtudiant);
    }
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }
    public Etudiant updateEmployee(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }
    public List<Etudiant> findByClasseId(Long idClasse) {
        return etudiantRepo.findByClasseId(idClasse);
    }
}
