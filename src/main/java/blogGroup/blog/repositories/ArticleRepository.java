package blogGroup.blog.repositories;

import blogGroup.blog.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE :filter IS NULL or LOWER(a.title) LIKE LOWER(CONCAT('%', :filter, '%')) OR LOWER(a.author.firstname) LIKE LOWER(CONCAT('%', :filter, '%')) OR LOWER(a.author.lastname) LIKE LOWER(CONCAT('%', :filter, '%'))  ORDER BY a.createdAt DESC ")
    List<Article> findArticlesForHome(@Param("filter") String filter);
}
