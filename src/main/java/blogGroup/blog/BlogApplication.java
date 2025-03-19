package blogGroup.blog;

import blogGroup.blog.seeders.DataSeeder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BlogApplication.class, args);
        Environment env = context.getEnvironment();
        boolean activateSeeder = Boolean.parseBoolean(env.getProperty("seeder.activate"));
        if (activateSeeder) {
            DataSeeder seeder = context.getBean(DataSeeder.class);
            seeder.addData();
        }

    }

}
