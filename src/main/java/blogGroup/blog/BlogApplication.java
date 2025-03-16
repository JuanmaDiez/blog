package blogGroup.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BlogApplication.class, args);
//        ArticleService service = context.getBean(ArticleService.class);
//        service.addArticles();
    }

}
