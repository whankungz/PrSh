package com.example.whankung.navigity.services.Article;

/**
 * Created by Whankung on 13/3/2560.
 */

public class ArRequest {
    private String articleName;
    private String article;
    private String articleCredit;
    private String articleID;

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticleCredit() {
        return articleCredit;
    }

    public void setArticleCredit(String articleCredit) {
        this.articleCredit = articleCredit;
    }
}
