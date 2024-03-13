package com.userTest.TestUser.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userTest.TestUser.entity.UserEntity;
import com.userTest.TestUser.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.xml.transform.Result;

import java.awt.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;  //importacion manual
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class userControlerTest {
    @Autowired
    private MockMvc mockMvc;
    //@MockBean
    private UserEntity userEntity;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserService userService;
//throws Exception
    @Test
    @Disabled()
    void testGuardarUser()  {
    //given
//        UserEntity user1= UserEntity.builder()
//                .id(9L)
//                .name("tontin")
//                .lastName("pitufo")
//                .email("toton@gmail.com")
//                .build();
//        given(userService.saveUser(any(UserEntity.class)))
//                .willAnswer((invocation)-> invocation.getArgument(0));
    //when
//        ResultActions response=mockMvc.perform(post("/api/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(user1))
//        );
    //then
//        response.andDo(print());
//        response.andExpect(status().isCreated());
//        response.andExpect((ResultMatcher) jsonPath("$.nombre", is(user1.getName())));
//        response.andExpect((ResultMatcher) jsonPath("$.nombre", is(user1.getLastName())));
//        response.andExpect((ResultMatcher) jsonPath("$.nombre", is(user1.getEmail())));
    }

}
