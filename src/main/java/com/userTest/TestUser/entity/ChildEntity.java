package com.userTest.TestUser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity              //jpa
@Data               //lombok
@AllArgsConstructor //lombok
@NoArgsConstructor  //lombok
@Builder            //lombok
@Component
public class ChildEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHILD")           //jpa
    private Long id;

    @Column(name = "Nombre", nullable = false, unique = true)
    private String child_name;
    @Column(name = "Edad", nullable = false)
    private String age;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;


}
