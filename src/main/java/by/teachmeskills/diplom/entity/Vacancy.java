package by.teachmeskills.diplom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "vacancy_name", nullable = false)
    private String name;
    @Column(name = "requirements", nullable = false)
    private String requirements;
    @Column(name = "abilities", nullable = false)
    private String abilities;
    @Column(name = "proposition", nullable = false)
    private String proposition;
    @OneToMany
    private Set<Resume> resumeList;
}
