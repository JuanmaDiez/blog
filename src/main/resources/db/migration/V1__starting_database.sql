CREATE TABLE blog.users (
	id BIGINT auto_increment NOT NULL,
	firstname varchar(255) NOT NULL,
	lastname varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	created_at DATETIME NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_unique UNIQUE KEY (email)
);

CREATE TABLE blog.articles (
	id BIGINT auto_increment NOT NULL,
	title varchar(255) NOT NULL,
	content TEXT NOT NULL,
	user_id BIGINT NOT NULL,
	created_at DATETIME NOT NULL,
	CONSTRAINT articles_pk PRIMARY KEY (id),
	CONSTRAINT articles_users_FK FOREIGN KEY (user_id) REFERENCES blog.users(id) ON DELETE CASCADE
);

CREATE TABLE blog.comments (
    id BIGINT auto_increment NOT NULL,
	content TEXT NOT NULL,
	user_id BIGINT NOT NULL,
	article_id BIGINT NOT NULL,
	created_at DATETIME NOT NULL,
	CONSTRAINT comments_pk PRIMARY KEY (id),
	CONSTRAINT comments_users_FK FOREIGN KEY (user_id) REFERENCES blog.users(id) ON DELETE CASCADE,
	CONSTRAINT comments_articles_FK FOREIGN KEY (article_id) REFERENCES blog.articles(id) ON DELETE CASCADE
);
