/**
 * Copyright Manpower
 */
package com.riadh.samples.exo4;

import com.riadh.samples.DAOException;

/**
 * @author Manpower
 * 
 */

public class ArticleDAOStubImpl implements ArticleDAO {

    public Article getArticle(Integer articleId) throws DAOException {
        Article articleResult = null;
        try {
            // Stub implementation
            articleResult = new Article(123456, "ARTICLE_TEST1", new Double(99));

        } catch (Exception e) {
            throw new DAOException();
        }
        return articleResult;
    }

    public Integer setArticle(Article article) throws DAOException {
        try {
            Article articleSaved = new Article(article.getArticleId(), article.getArticleName(), article.getPriceHT());
            return articleSaved.getArticleId();
        } catch (Exception e) {
            throw new DAOException();
        }
    }

}
