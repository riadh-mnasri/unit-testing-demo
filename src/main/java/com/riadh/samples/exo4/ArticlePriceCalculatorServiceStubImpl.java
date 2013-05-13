package com.riadh.samples.exo4;

import org.springframework.beans.factory.annotation.Autowired;

import com.riadh.samples.BusinessException;
import com.riadh.samples.DAOException;

/**
 * @author Riadh MNASRI
 * 
 */
public class ArticlePriceCalculatorServiceStubImpl implements ArticlePriceCalculatorService {

    private static final Double RATE = new Double(0.125);

    @Autowired
    private ArticleDAO          articleDAO;

    public Double calculatePrice(Integer articleId) throws BusinessException {
        if (articleId == null) {
            throw new BusinessException("An article id should be provided, it should be not be null !");
        }
        Double calculatedPrice;
        try {
            Article article = articleDAO.getArticle(articleId);
            Double taxAmount = article.getPriceHT() * RATE;
            calculatedPrice = article.getPriceHT() + taxAmount;
        } catch (DAOException e) {
            throw new BusinessException(e);
        }

        return calculatedPrice;

    }

    public ArticleDAO getArticleDAO() {
        return articleDAO;
    }

    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

}
