package by.teachmeskills.diplom.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "work_experience")
    private String workExperience;
    @Column(name = "education")
    private String education;
    @Column(name = "courses")
    private String courses;
    @Column(name = "language")
    private String language;
    @Column(name = "abilities")
    private String abilities;
    @Column(name = "about_me")
    private String aboutMe;
}
