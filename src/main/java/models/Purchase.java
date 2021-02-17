package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Purchaselist")
@Data
@ToString(exclude = "id")
public class Purchase {

    @EmbeddedId
    private Id id;

    @Column(name = "student_name", updatable = false, insertable = false)
    private String studentName;

    @Column(name = "course_name", updatable = false, insertable = false)
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionsDate;

    @Embeddable
    @Data
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Id implements Serializable {

        @Column(name = "student_name")
        private String studentName;

        @Column(name = "course_name")
        private String courseName;

    }
}
