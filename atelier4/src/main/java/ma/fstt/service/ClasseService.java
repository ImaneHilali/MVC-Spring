package ma.fstt.service;

import ma.fstt.persistence.Classe;
import ma.fstt.persistence.Etudiant;
import ma.fstt.repo.ClasseRepo;
import ma.fstt.repo.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    ClasseRepo classeRepo;

    @Autowired
    EtudiantRepo etudiantRepo;

    public Classe addClasse(Classe classe){
        return classeRepo.save(classe);
    }
    public List<Classe> findAllClasses(){
        return classeRepo.findAll();
    }
    public Classe updateClasse(Classe classe){
        return classeRepo.save(classe);
    }
    public Classe findById(Long idClasse){
        return classeRepo.findById(idClasse).get();
    }
    public void deleteClasse(Long idClasse){
        classeRepo.deleteById(idClasse);
    }

    public void addEtudiantsToClasse(Long idClasse,List<Long> etudiants){
        Classe classe = classeRepo.findById(idClasse).get();

        for (Long idEtudiant : etudiants){
            Etudiant etudiant = etudiantRepo.findById(idEtudiant).get();

            classe.getEtudiantList().add(etudiant);
        }
        classeRepo.save(classe);
    }
    public void addEtudiantToClasse(Long idClasse, Long idEtudiant) {
        Classe classe = classeRepo.findById(idClasse).orElse(null);
        Etudiant etudiant = etudiantRepo.findById(idEtudiant).orElse(null);

        if (classe != null && etudiant != null) {
            etudiant.setClasse(classe);
            etudiantRepo.save(etudiant);
        }
    }
}
