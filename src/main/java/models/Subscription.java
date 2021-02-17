package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Subscriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class Subscription {

    @EmbeddedId
    private Id id;

    @ManyToOne
    @JoinColumn(name = "student_id", updatable = false, insertable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", updatable = false, insertable = false)
    private Course course;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;


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

