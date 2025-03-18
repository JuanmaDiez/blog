package blogGroup.blog.dtos;

public class ArticleRequestDTO {
    private String title;
    private String content;

    public ArticleRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ArticleRequestDTO() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleRequestDTO{" +
                "title='" + this.title + '\'' +
                ", content='" + this.content + '\'' +
                '}';
    }
}
