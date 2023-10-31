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
@Table(name = "classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long idClasse;

    @Column(nullable = true)
    private String nom;

    @Column(nullable = true)
    private String niveau;

    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiantList;

}
