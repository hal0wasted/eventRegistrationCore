package com.eventRegistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ER_EVENT_REGISTRATIONS", uniqueConstraints = {
        @UniqueConstraint(name = "ER_EVENT_REGISTRATIONS_UQ", columnNames = {"EVENT_ID", "USER_ID"})
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErEventRegistrations {

    @Id
    @GeneratedValue(generator = "ER_EVENT_REGISTRATIONS_SEQ", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ER_EVENT_REGISTRATIONS_SEQ", schema = "ER")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "EVENT_ID",
            nullable = false,
            foreignKey = @ForeignKey(name = "EVENT_REGISTRATIONS_EVENT_FK"))
    private ErSlEvents event;

    @ManyToOne()
    @JoinColumn(name = "USER_ID",
            nullable = false,
            foreignKey = @ForeignKey(name = "EVENT_REGISTRATIONS_USER_FK"))
    private ErUsers user;

}
