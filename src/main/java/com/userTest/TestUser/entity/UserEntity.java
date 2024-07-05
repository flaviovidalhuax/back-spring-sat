package com.userTest.TestUser.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity              //jpa
@Data               //lombok
@AllArgsConstructor //lombok
@NoArgsConstructor  //lombok
@Builder            //lombok
@Component
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")           //jpa
    private Long id;
    // el nombre no se repita nullable = false
    @Column(name = "Nombre", nullable = false, unique = true)
    private String name;

    @Column(name = "Apellido", nullable = false)
    private String lastName;

    @Email(message = "El correo electrónico debe ser válido")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "El correo electrónico no cumple con el formato requerido")
    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Fecha nacimiento", nullable = false)
    private String born;
    @Column(name = "Telefono", nullable = false)
    private String cell;
    @Column(name = "Edad", nullable = false)
    private String age;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ChildEntity hijo;

}
