package project.stas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StasApplication {

	public static void main(String[] args) {
		SpringApplication.run(StasApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("project.stas")).build();
	}
	/*
	 * @Bean CommandLineRunner init(StudentDao studentDao) { return args -> {
	 * Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(firstName
	 * -> { Student student = new Student(firstName, firstName.toLowerCase() +
	 * "@domain.com"); studentDao.add(student); });
	 * studentDao.getAll().forEach(System.out::println); }; }
	 */

}
