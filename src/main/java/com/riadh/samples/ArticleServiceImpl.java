package com.riadh.samples;

import com.riadh.samples.exo4.Article;
import com.riadh.samples.exo4.ArticleDAO;

/**
 * @author Riadh MNASRI
 * 
 */

public class ArticleServiceImpl implements ArticleService {

    private ArticleDAO articleDAO;

    public Article findArticle(Integer articleId) throws BusinessException {
        if (articleId == null) {
            throw new BusinessException("articleId should not be null !! ");
        }
        try {
            return articleDAO.getArticle(articleId);
        } catch (DAOException e) {
            throw new BusinessException(e);
        }
    }

    public Integer saveArticle(Article article) throws BusinessException {
        if (article == null) {
            throw new BusinessException("article should not be null !! ");
        }
        try {
            return articleDAO.setArticle(article);
        } catch (DAOException e) {
            throw new BusinessException(e);
        }
    }

    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

}
