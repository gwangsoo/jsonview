package com.xrfriends.jsonview.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractAuditingDTO<String> implements Serializable {
    @Schema(description = "아이디")
    @JsonView(Views.Id.class)
    private String id;

    @Schema(description = "명칭")
    @JsonView(Views.Min.class)
    private String name;

    @Schema(description = "전번")
    @JsonView(Views.Detail.class)
    private String telno;

    @Schema(description = "설명")
    private String description;

    @JsonView(GroupDTO.Views.Id.class)
    private GroupDTO group;

    @JsonView(BookDTO.Views.Detail.class)
    private Set<BookDTO> books;

    public interface Views {
        interface Id {}
        interface Min extends Id {}
        interface Detail extends Min, GroupDTO.Views.Id, BookDTO.Views.Detail {}
    }
}
