package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "LinkedPurchaseList")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class LinkedPurchase {

    @EmbeddedId
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", unique = true, nullable = false)
    private Id id;

    @ManyToOne
    @JoinColumn(name = "student_id", updatable = false, insertable = false, nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", updatable = false, insertable = false, nullable = false)
    private Course course;


    @Embeddable
    @Data
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Id implements Serializable {

        @ManyToOne
        @JoinColumn(name = "student_id", updatable = false, insertable = false)
        private Student student;

        @ManyToOne
        @JoinColumn(name = "course_id", updatable = false, insertable = false)
        private Course course;

    }
}