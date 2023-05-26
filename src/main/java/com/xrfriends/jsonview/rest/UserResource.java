package com.xrfriends.jsonview.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.xrfriends.jsonview.dto.BookDTO;
import com.xrfriends.jsonview.dto.GroupDTO;
import com.xrfriends.jsonview.dto.LibraryDTO;
import com.xrfriends.jsonview.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class UserResource {

    private List<UserDTO> users;

    public UserResource() {
        users = new ArrayList<>();

        LibraryDTO libraryDTO1 = LibraryDTO.builder().id("l01").name("합정도서관").description("서울시 마포구 합정동").build();
        LibraryDTO libraryDTO2 = LibraryDTO.builder().id("l02").name("홍대도서관").description("서울시 마포구 홍대동").build();

        UserDTO user = UserDTO.builder()
                .id("1")
                .name("gwangsoo")
                .telno("010-1234-1234")
                .group(GroupDTO.builder().id("g01").name("group01").description("스터디그룹").build())
                .books(Set.of(
                        BookDTO.builder().id("b01").name("book01").description("그림책1").library(libraryDTO1).build(),
                        BookDTO.builder().id("b02").name("book02").description("그림책2").library(libraryDTO1).build(),
                        BookDTO.builder().id("b03").name("book03").description("그림책3").library(libraryDTO2).build()
                        ))
                .build();

        users.add(user);
    }

    @GetMapping("/users:id")
    @JsonView(UserDTO.Views.Id.class)
    public ResponseEntity<List<UserDTO>> getUsersId() {
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users:min")
    @JsonView(UserDTO.Views.Min.class)
    public ResponseEntity<List<UserDTO>> getUsersMin() {
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users:self")
    @JsonView(UserDTO.Views.Detail.class)
    public ResponseEntity<List<UserDTO>> getUsersSelf() {
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users:detail")
    @JsonView(UserDTO.Views.Detail.class)
    public ResponseEntity<List<UserDTO>> getUsersDetail() {
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/users")
    @JsonView(UserDTO.Views.Detail.class)
    public ResponseEntity<UserDTO> getUser(
            @RequestBody @JsonView(value = {UserDTO.Views.Detail.class}) UserDTO newUser
    ) {
        users.add(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
