package blogGroup.blog.dtos;

public class CommentRequestDTO {
    private Long articleId;
    private Long authorId;
    private String content;

    public CommentRequestDTO() {
    }

    public CommentRequestDTO(Long articleId, Long authorId, String content) {
        this.articleId = articleId;
        this.authorId = authorId;
        this.content = content;
    }

    public Long getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentRequestDTO{" +
                "articleId=" + articleId +
                ", authorId=" + authorId +
                ", content='" + content + '\'' +
                '}';
    }
}
