package com.eventRegistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ER_USERS", schema = "ER")
public class ErUsers {

    @Id
    @GeneratedValue(generator = "ER_USERS_SEQ", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ER_USERS_SEQ", schema = "ER")
    private Long id;

    @NotNull(message = "${error.emptyUserName}")
    @Column(name = "NAME")
    private String name;

    @NotNull(message = "${error.emptySurname}")
    @Column(name = "SURNAME")
    private String surname;
}
