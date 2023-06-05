package com.xrfriends.jsonview.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.xrfriends.jsonview.dto.AffiliateIntroduceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Api(tags = "그룹계열사소개정보 API")
@RestController
@RequestMapping("/api")
public class AffiliateIntroduceResource {
    private final Logger log = LoggerFactory.getLogger(AffiliateIntroduceResource.class);

    private static final String ENTITY_NAME = "affiliateIntroduce";

    @ApiOperation("신규생성1")
    @JsonView(AffiliateIntroduceDTO.Views.Detail.class)
    @PostMapping("/affiliate-introduces:1")
    public ResponseEntity<AffiliateIntroduceDTO> createAffiliateIntroduce1(@Valid @RequestBody @JsonView(AffiliateIntroduceDTO.Views.Detail.class) AffiliateIntroduceDTO affiliateIntroduceDTO)
            throws URISyntaxException {
        log.debug("REST request to save AffiliateIntroduce : {}", affiliateIntroduceDTO);
        return ResponseEntity
                .created(new URI("/api/affiliate-introduces/" + affiliateIntroduceDTO.getId()))
                .body(affiliateIntroduceDTO);
    }

    @ApiOperation("신규생성2")
    @JsonView(AffiliateIntroduceDTO.Views.Detail.class)
    @PostMapping("/affiliate-introduces:2")
    public ResponseEntity<AffiliateIntroduceDTO> createAffiliateIntroduce2(@Valid @RequestBody AffiliateIntroduceDTO affiliateIntroduceDTO)
            throws URISyntaxException {
        log.debug("REST request to save AffiliateIntroduce : {}", affiliateIntroduceDTO);
        return ResponseEntity
                .created(new URI("/api/affiliate-introduces/" + affiliateIntroduceDTO.getId()))
                .body(affiliateIntroduceDTO);
    }
}
