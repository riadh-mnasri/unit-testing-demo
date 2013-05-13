/**
 * Copyright Manpower
 */
package com.riadh.samples.exo4;

import com.riadh.samples.BusinessException;

/**
 * @author Manpower
 * 
 */
public interface ArticlePriceCalculatorService {

    Double calculatePrice(Integer articleId) throws BusinessException;

    void setArticleDAO(ArticleDAO articleDAO);
}
