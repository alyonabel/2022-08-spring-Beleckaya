package hwShell;

import hwShell.config.ApplicationProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableConfigurationProperties(ApplicationProps.class)
public class SpringBoot {

    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
    context = SpringApplication.run(SpringBoot.class, args);
    }
}