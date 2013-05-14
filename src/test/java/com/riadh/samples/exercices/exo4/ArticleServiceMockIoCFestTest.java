package com.riadh.samples.exercices.exo4;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.riadh.samples.ArticleService;
import com.riadh.samples.ArticleServiceImpl;
import com.riadh.samples.DAOException;
import com.riadh.samples.exo4.Article;
import com.riadh.samples.exo4.ArticleDAO;

/**
 * @author Riadh MNASRI
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceMockIoCFestTest {

    private static final Double  EXPECTED_PRICE = new Double(1000);

    private static final Integer ARTICLE_ID1    = 123456;

    @Mock
    private ArticleDAO           articleDAO;

    @InjectMocks
    private ArticleService       pricingService = new ArticleServiceImpl();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void initMocks() {
        Article articleExpected1 = new Article(ARTICLE_ID1, "ARTICLE_TEST1", EXPECTED_PRICE);
        try {
            when(articleDAO.getArticle(ARTICLE_ID1)).thenReturn(articleExpected1);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        articleDAO = null;
    }

    @Test
    public void findArticle() {
        try {
            // make the call
            Article articleRetrieved = pricingService.findArticle(ARTICLE_ID1);
            // Verify behavior.
            verify(articleDAO).getArticle(ARTICLE_ID1);
            assertThat(articleRetrieved).isNotNull();
            assertThat(articleRetrieved.getPriceHT()).isEqualTo(EXPECTED_PRICE);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
