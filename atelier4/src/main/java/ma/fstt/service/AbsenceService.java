package ma.fstt.service;

import ma.fstt.persistence.Absence;
import ma.fstt.repo.AbsenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {

    @Autowired
    AbsenceRepo absenceRepo;

    public Absence addAbsence(Absence absence){
        return absenceRepo.save(absence);
    }
    public List<Absence> findAllAbsence(){
        return absenceRepo.findAll();
    }
    public Absence updateAbsence(Absence absence){
        return absenceRepo.save(absence);
    }
    public Optional<Absence> findById(Long id_absence){
        return absenceRepo.findById(id_absence);
    }
    public void deleteAbsence(Long id_absence){
        absenceRepo.deleteById(id_absence);
    }
}
