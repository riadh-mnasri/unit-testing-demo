/**
 * Copyright Manpower
 */
package com.riadh.samples.exercices.exo4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.riadh.samples.BusinessException;
import com.riadh.samples.DAOException;
import com.riadh.samples.exo4.Article;
import com.riadh.samples.exo4.ArticleDAO;
import com.riadh.samples.exo4.ArticlePriceCalculatorService;
import com.riadh.samples.exo4.ArticlePriceCalculatorServiceStubImpl;

@RunWith(MockitoJUnitRunner.class)
public class WhenCalculatingArticlePrice {

    private static final Double           EXPECTED_PRICE = new Double(1125);
    private static final Double           ARTICLE_PRICE  = new Double(1000);
    private static final Integer          ARTICLE_ID     = 123456;

    @InjectMocks
    private ArticlePriceCalculatorService pricingService = new ArticlePriceCalculatorServiceStubImpl();

    @Mock
    private ArticleDAO                    articleDAO;

    private Article                       articleExpected;
    private Double                        calulatedPrice;

    @Before
    public void initMocks() throws Exception {
        articleExpected = new Article(ARTICLE_ID, "ARTICLE_TEST", ARTICLE_PRICE);
        try {
            when(articleDAO.getArticle(ARTICLE_ID)).thenReturn(articleExpected);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void clean() throws Exception {
        articleExpected = null;
        articleDAO = null;
        calulatedPrice = null;
    }

    @Test
    public void shouldPriceCalculationBeCorrect() throws Exception {
        calulatedPrice = pricingService.calculatePrice(ARTICLE_ID);
        assertThat(EXPECTED_PRICE, equalTo(calulatedPrice));
    }

    @Test(expected = BusinessException.class)
    public void shouldPriceCalculationThrowExceptionWhenNullArguments() throws Exception {
        pricingService.calculatePrice(null);
        fail();
    }

}
