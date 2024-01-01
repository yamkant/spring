package hello.springapi;

import hello.springapi.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "hello.springapi.app")
public class SpringapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringapiApplication.class, args);
	}

}
