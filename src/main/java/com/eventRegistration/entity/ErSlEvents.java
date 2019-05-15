package com.eventRegistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ER_SL_EVENTS", schema = "ER")
@Check(constraints = "END_DATE >= START_DATE")
public class ErSlEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ER_EVENTS_SEQ")
    @SequenceGenerator(name = "ER_EVENTS_SEQ", schema = "ER")
    private Long id;

    @NotNull(message = "${error.emptyUserName}")
    @Column(name = "NAME", unique = true)
    private String name;

    @NotNull(message = "${error.emptyStartDate}")
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @NotNull(message = "${error.emptyEndDate}")
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;
}
