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
public class LibraryDTO {

    @JsonView(Views.Id.class)
    private String id;
    @JsonView(Views.Min.class)
    private String name;
    @JsonView(Views.Detail.class)
    private String description;

    public static interface Views {
        public static interface Id {}
        public static interface Min extends Id {}
        public static interface Detail extends Min {}
    }
}
