package com.riadh.samples;

import com.riadh.samples.exo4.Article;
import com.riadh.samples.exo4.ArticleDAO;

/**
 * @author Riadh MNASRI
 * 
 */
public interface ArticleService {

    Article findArticle(Integer articleId) throws BusinessException;

    Integer saveArticle(Article article) throws BusinessException;

    void setArticleDAO(ArticleDAO articleDAO);
}
