package com.xrfriends.jsonview;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class CommonBean {
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        mapper.registerModule(new JavaTimeModule());
//        mapper.enable(MapperFeature.DEFAULT_VIEW_INCLUSION);
//        return mapper;
//    }
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer configure_Jackson2ObjectMapperBuilder() {
        return new Jackson2ObjectMapperBuilderCustomizer() {

            @Override
            public void customize(Jackson2ObjectMapperBuilder builder) {
                builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                // ignore missing filters
                builder.filters(new SimpleFilterProvider().setDefaultFilter(SimpleBeanPropertyFilter.serializeAll()));
                // ignore missing view
                builder.defaultViewInclusion(true);
            }
        };
    }
}
