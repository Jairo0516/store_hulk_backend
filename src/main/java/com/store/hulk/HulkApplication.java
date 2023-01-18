package com.store.hulk;


import com.store.hulk.util.Utils;
import org.modelmapper.AbstractCondition;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HulkApplication  extends SpringBootServletInitializer {
    private static Class <HulkApplication> hulkApplicationClass = HulkApplication.class;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(hulkApplicationClass);
    }

	public static void main(String[] args) {
		SpringApplication.run(HulkApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.addConverter(ctx -> ctx.getSource() != null
                ? Utils.convertToString(ctx.getSource())
                : null, Date.class, String.class);

        modelMapper.addConverter(ctx -> ctx.getSource() != null
                ? Utils.stringToDateOrNull(ctx.getSource())
                : null, String.class, Date.class);

        Condition<?, ?> isStringBlank = new AbstractCondition<Object, Object>() {
            @Override
            public boolean applies(MappingContext<Object, Object> context) {
                if (context.getSource() instanceof String) {
                    return null != context.getSource() && !"".equals(context.getSource());
                } else {
                    return context.getSource() != null;
                }
            }
        };

        modelMapper.getConfiguration().setPropertyCondition(isStringBlank);

        return modelMapper;
    }
}
