package ma.fstt.persistence;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idEtudiant;

    @Column(nullable = true)
    private String nom;

    @Column(nullable = true)
    private String prenom;

    @Column(nullable = true)
    private String date_naissance;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    Classe classe;

    @OneToMany(mappedBy = "etudiant")
    List<Absence> absenceList;
}
