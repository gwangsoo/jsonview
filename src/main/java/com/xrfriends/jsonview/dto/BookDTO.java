package com.xrfriends.jsonview.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @JsonView(Views.Id.class)
    private String id;
    @JsonView(Views.Min.class)
    private String name;
    @JsonView(Views.Detail.class)
    private String description;

    @JsonView(LibraryDTO.Views.Min.class)
    private LibraryDTO library;

    public static interface Views {
        public static interface Id {}
        public static interface Min extends Id {}
        public static interface Detail extends Min, LibraryDTO.Views.Min {}
    }
}