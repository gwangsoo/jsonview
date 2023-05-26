package com.xrfriends.jsonview.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @JsonView(Views.Id.class)
    private String id;
    @JsonView(Views.Min.class)
    private String name;
    @JsonView(Views.Detail.class)
    private String telno;
    private String description;

    @JsonView(GroupDTO.Views.Id.class)
    private GroupDTO group;
    @JsonView(BookDTO.Views.Detail.class)
    private Set<BookDTO> books;

    public static interface Views {
        public static interface Id {}
        public static interface Min extends Id {}
        public static interface Detail extends Min, GroupDTO.Views.Id, BookDTO.Views.Detail {}
    }
}
