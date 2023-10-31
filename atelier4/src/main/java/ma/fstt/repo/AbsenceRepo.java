package ma.fstt.repo;

import ma.fstt.persistence.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepo extends JpaRepository<Absence,Long> {
}
