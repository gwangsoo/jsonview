package com.xrfriends.jsonview.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link net.lotte.marketplace.domain.AffiliateIntroduce} entity.
 */
@Schema(description = "그룹계열사소개정보")
@SuppressWarnings("common-java:DuplicatedBlocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AffiliateIntroduceDTO extends AbstractAuditingDTO<String> implements Serializable {

    public class Views {
        public interface Id {}
        public interface Min extends Id {}
        public interface Summary extends Min {}
        public interface Detail extends Summary, CompanyMasterDTO.Views.Min {}
    }

    @Size(max = 36)
    @JsonView(Views.Id.class)
    private String id;
    
//    /**
//     * 소개구분코드
//     */
//    @Schema(description = "소개구분코드")
//    @JsonView(Views.Detail.class)
//    private IntroduceTypeCode introduceTypeCode;

    /**
     * 소개구분값순번
     */
    @NotNull
    @Schema(description = "소개구분값순번", required = true)
    @JsonView(Views.Detail.class)
    private Long introduceTypeValueTurn;

    // 필요시 보여주는 항목을 제외 시킬수 있음
//    @JsonIgnoreProperties(value = {"businessNumberAttachDocUuid", "representPhoneNumber", "homepageUrlAddress", "callCenterPhoneNumber", "chargerName", "chargerMobilePhoneNumber", "chargerEmailAddress", "chargerDepartmentName", "chargerJobPosition", "chargerJobPhoneNumber"}, allowSetters = true)
    @JsonView(CompanyMasterDTO.Views.Min.class)
    private CompanyMasterDTO companyMaster;

}
