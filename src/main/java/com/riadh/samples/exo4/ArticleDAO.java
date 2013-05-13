package com.riadh.samples.exo4;

import com.riadh.samples.DAOException;

/**
 * @author Riadh MNASRI
 * 
 */
public interface ArticleDAO {

    Article getArticle(Integer articleId) throws DAOException;

    Integer setArticle(Article article) throws DAOException;
}
