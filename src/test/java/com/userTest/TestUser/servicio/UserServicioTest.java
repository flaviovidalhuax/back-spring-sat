package com.userTest.TestUser.servicio;

import com.userTest.TestUser.entity.UserEntity;
import com.userTest.TestUser.repository.UserRepository;
import com.userTest.TestUser.service.UserService;
import com.userTest.TestUser.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;  //importacion manual
import static org.assertj.core.api.Assertions.assertThat; //importacion manual
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServicioTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
//------------------------------------------
    private UserEntity user1;
    @BeforeEach
    void setup(){
        user1=UserEntity.builder()
                .id(9L)
                .name("juan")
                .lastName("perez")
                .email("juan12@gmail.com")
                .build();
    }

    @DisplayName("Test servicio guardar empleados")
    @Test
    void testGuardarEmpleado(){
        //given
        given(userRepository.findByEmail(user1.getEmail()))
                .willReturn(Optional.empty());
        given(userRepository.save(user1)).willReturn(user1);
        //when
        UserEntity userGuardado= userService.saveUser(user1);
        //then
        assertThat(userGuardado).isNotNull();

    }


    @DisplayName("Test para listar empleados Service")
    @Test
    void testListarUser(){
        //given
        UserEntity user2=UserEntity.builder()
                .id(11L)
                .name("lolita")
                .lastName("pacheco")
                .email("lolita@gmail.com")
                .build();
        given(userRepository.findAll()).willReturn(List.of(user2, user1));
        //when
        List<UserEntity> userGardado= userService.getAllUSers();
        //then
        assertThat(userGardado).isNotNull();
        assertThat(userGardado.size()).isEqualTo(2);
    }
    @DisplayName("test lista vacia Service")
    @Test
    void testListVaciaServ(){
        //given
        UserEntity user2=UserEntity.builder()
                .id(11L)
                .name("lolita")
                .lastName("pacheco")
                .email("lolita@gmail.com")
                .build();
        given(userRepository.findAll()).willReturn(Collections.emptyList());
        //when
        List<UserEntity>  listaUser=userService.getAllUSers();
        //then
        assertThat(listaUser).isEmpty();
        assertThat(listaUser.size()).isEqualTo(0);
    }
    @DisplayName("test empleado por id")
    @Test
    void testPorId(){
        //given
        given(userRepository.findById(9L)).willReturn(Optional.of(user1));
        //when
        UserEntity userioGuardado=userService.getUserById(user1.getId()).get();
        //then
        assertThat(userioGuardado).isNotNull();
    }

    @DisplayName("test acualizar empleado service")
    @Test
    void testActualizaUser(){
        //given
        given(userRepository.save(user1)).willReturn(user1);
        user1.setName("que loco");
        user1.setLastName("atorado");
        user1.setEmail("loco@gmail.com");
        //when
        UserEntity userActualizado=userService.updateUser(user1);
        //then
        assertThat(userActualizado.getEmail()).isEqualTo("loco@gmail.com");
    }

    @DisplayName("test eliminar empleado")
    @Test
    void testEliminarUser(){
        //given
        long userId=9L;
        willDoNothing().given(userRepository).deleteById(userId);
        //when
        userService.deleteUser(userId);
        //then
        verify(userRepository, times(1)).deleteById(userId);
    }
}
