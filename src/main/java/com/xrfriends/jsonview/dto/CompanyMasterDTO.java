package com.xrfriends.jsonview.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link net.lotte.marketplace.domain.CompanyMaster} entity.
 */
@Schema(description = "기업그룹사원부")
@SuppressWarnings("common-java:DuplicatedBlocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyMasterDTO extends AbstractAuditingDTO<String> implements Serializable {

    public class Views {
        public interface Id {}
        public interface Min extends Id {}
        public interface Summary extends Min {}
        public interface Detail extends Summary {}
    }

    @Size(max = 36)
    @JsonView(Views.Id.class)
    private String id;

    /**
     * 기업그룹사명
     */
    @Size(max = 300)
    @Schema(description = "기업그룹사명", required = true)
    @JsonView(Views.Min.class)
    private String companyName;

//    /**
//     * 기업형태구분코드
//     */
//    @Schema(description = "기업형태구분코드", required = true)
//    @JsonView(Views.Summary.class)
//    private ComplanyTypeCode companyTypeCode;
//
//    /**
//     * 기업그룹구분코드
//     */
//    @Schema(description = "기업그룹구분코드", required = true)
//    @JsonView(Views.Summary.class)
//    private ComplanyFormCode companyFormCode;

    /**
     * 대표자명
     */
    @Size(max = 300)
    @Schema(description = "대표자명", required = true)
    @JsonView(Views.Summary.class)
    private String representerName;

    /**
     * 사업자등록번호
     */
    @Size(max = 36)
    @Schema(description = "사업자등록번호")
    @JsonView(Views.Summary.class)
    private String businessNumber;

    /**
     * 법인등록번호
     */
    @JsonView(Views.Summary.class)
    @Size(max = 20)
    @Schema(description = "법인등록번호")
    private String corporateNumber;

    /**
     * 사업자등록증첨부문서UUID
     */
    @Size(max = 36)
    @Schema(description = "사업자등록증첨부문서UUID")
    @JsonView(Views.Summary.class)
    private String businessNumberAttachDocUuid;

    /**
     * 대표전화번호
     */
    @Size(max = 12)
    @Schema(description = "대표전화번호")
    @JsonView(Views.Summary.class)
    private String representPhoneNumber;

    /**
     * 홈페이지URL주소
     */
    @Size(max = 300)
    @Schema(description = "홈페이지URL주소")
    @JsonView(Views.Summary.class)
    private String homepageUrlAddress;

    /**
     * 고객센터전화번호
     */
    @Size(max = 12)
    @Schema(description = "고객센터전화번호")
    @JsonView(Views.Summary.class)
    private String callCenterPhoneNumber;

    /**
     * 담당자명
     */
    @Size(max = 300)
    @Schema(description = "담당자명")
    @JsonView(Views.Summary.class)
    private String chargerName;

    /**
     * 담당자모바일전화번호
     */
    @Size(max = 12)
    @Schema(description = "담당자모바일전화번호")
    @JsonView(Views.Summary.class)
    private String chargerMobilePhoneNumber;

    /**
     * 담당자이메일주소
     */
    @Email
    @Size(max = 100)
    @Schema(description = "담당자이메일주소")
    @JsonView(Views.Summary.class)
    private String chargerEmailAddress;

    /**
     * 담당자부서명
     */
    @Size(max = 100)
    @Schema(description = "담당자부서명")
    @JsonView(Views.Summary.class)
    private String chargerDepartmentName;

    /**
     * 담당자직책
     */
    @Size(max = 100)
    @Schema(description = "담당자직책")
    @JsonView(Views.Summary.class)
    private String chargerJobPosition;

    /**
     * 담당자직장전화번호
     */
    @Size(max = 12)
    @Schema(description = "담당자직장전화번호")
    @JsonView(Views.Summary.class)
    private String chargerJobPhoneNumber;

    /**
     * 메타기업그룹사ID
     */
    @Size(max = 20)
    @Schema(description = "메타기업그룹사ID")
    @JsonView(Views.Summary.class)
    private String metaCompanyId;

}
