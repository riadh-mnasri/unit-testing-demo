package com.riadh.samples.exo4;

import com.riadh.samples.BusinessException;

/**
 * @author Riadh MNASRI
 * 
 */
public interface ArticlePriceCalculatorService {

    Double calculatePrice(Integer articleId) throws BusinessException;

    void setArticleDAO(ArticleDAO articleDAO);
}
