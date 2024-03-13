package com.userTest.TestUser.repository;

import com.userTest.TestUser.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity1;
    @BeforeEach
    void setup(){
         userEntity1=UserEntity.builder()
                .name("juan")
                .lastName("perez")
                .email("juan@gmail.com")
                .build();
    }

    @DisplayName("Test guardar usuario")
    @Test
    void testGuardarUser(){
        //given   condicion
        UserEntity user1=UserEntity.builder()
                .name("pepe")
                .lastName("bonilla")
                .email("pepe@gmail.com")
                .build();
        //when    accion
        UserEntity userGuardado=userRepository.save(user1);
        //then    verificacion
        assertThat(userGuardado).isNotNull();
        assertThat(userGuardado.getId()).isGreaterThan(0);
    }
    @DisplayName("Test listar todos Usuarios")
    @Test
    void TestlistarUsuario(){
        //given   condicion
        UserEntity user1=UserEntity.builder()
                .name("pepe")
                .lastName("bonilla")
                .email("pepe@gmail.com")
                .build();
        userRepository.save(user1);
        userRepository.save(userEntity1);
        //when
        List<UserEntity> listaUsuarios= userRepository.findAll();
        //then
        assertThat(listaUsuarios.size()).isNotNull();
        assertThat(listaUsuarios.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener usuario por ID")
    @Test
    void testObteberusuarioById(){
        userRepository.save(userEntity1);
        //when comportamiento
        UserEntity userDB =userRepository.findById(userEntity1.getId()).get();
        //then
        assertThat(userDB).isNotNull();

    }

    @DisplayName("Test actualizar empleado")
    @Test
    void testActualizarUsuario(){
        userRepository.save(userEntity1);
        //when
        UserEntity userGuardado=userRepository.findById(userEntity1.getId()).get();
        userGuardado.setName("fredy");
        userGuardado.setLastName("creger");
        userGuardado.setEmail("fredy@gmail.com");
        UserEntity userActualizado=userRepository.save(userGuardado);

        //then
        assertThat(userActualizado.getEmail()).isEqualTo("fredy@gmail.com");
        assertThat(userActualizado.getName()).isEqualTo("fredy");
    }

    @DisplayName("Test elimininar usuario")
    @Test
    void testEliminarUsuario(){
        userRepository.save(userEntity1);
        //when
        userRepository.deleteById(userEntity1.getId());
        Optional<UserEntity> userOpcional=userRepository.findById(userEntity1.getId());
        //then
        assertThat(userOpcional).isEmpty();
    }

}
