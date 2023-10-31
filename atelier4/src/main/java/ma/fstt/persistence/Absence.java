package ma.fstt.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "absence")
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long idAbsence;

    @Column(nullable = true)
    private LocalDate date;

    @Column(nullable = true)
    private LocalTime heure;

    @ManyToOne
    @JoinColumn(name = "idEtudiant")
    private Etudiant etudiant;

}
