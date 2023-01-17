package com.store.hulk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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

}
