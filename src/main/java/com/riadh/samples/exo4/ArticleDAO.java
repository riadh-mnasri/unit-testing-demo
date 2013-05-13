/**
 * Copyright Manpower
 */
package com.riadh.samples.exo4;

import com.riadh.samples.DAOException;

/**
 * @author Manpower
 * 
 */
public interface ArticleDAO {

    Article getArticle(Integer articleId) throws DAOException;

    Integer setArticle(Article article) throws DAOException;
}
