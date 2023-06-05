package com.xrfriends.jsonview.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO extends AbstractAuditingDTO<String> implements Serializable {
    @Schema(description = "아이디")
    @JsonView(Views.Id.class)
    private String id;

    @Schema(description = "명칭")
    @JsonView(Views.Min.class)
    private String name;

    @Schema(description = "설명")
    @JsonView(Views.Detail.class)
    private String description;

    public interface Views {
        interface Id {}
        interface Min extends Id {}
        interface Detail extends Min {}
    }
}
