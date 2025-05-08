package com.Htmlcourse.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Htmlcourse.project", "controller"})
@EntityScan("entity")
@EnableJpaRepositories("repository")

public class HtmlcourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlcourseApplication.class, args);
	}

}
