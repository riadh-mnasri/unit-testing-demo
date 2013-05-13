package com.riadh.samples;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.riadh.samples.exo4.Article;
import com.riadh.samples.exo4.ArticleDAO;
import com.riadh.samples.exo4.ArticleDAOStubImpl;

/**
 * @author Riadh MNASRI
 * 
 */
public class ArticleServiceTest {

    private static final Integer ARTICLE_ID1 = 123456;
    private static final Integer ARTICLE_ID2 = 191919;

    private ArticleService       systemUnderTest;
    private ArticleDAO           mockedDependency;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        systemUnderTest = new ArticleServiceImpl();
        mockedDependency = mock(ArticleDAO.class);
        systemUnderTest.setArticleDAO(mockedDependency);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        systemUnderTest = null;
        mockedDependency = null;
    }

    @Test
    public void findArticle() {
        try {
            // Set expectations on mocks.
            Article articleExpected1 = new Article(ARTICLE_ID1, "ARTICLE_TEST1", new Double(1000));

            when(mockedDependency.getArticle(ARTICLE_ID1)).thenReturn(articleExpected1);

            // make the call
            systemUnderTest.findArticle(ARTICLE_ID1);
            // Verify behavior.
            verify(mockedDependency).getArticle(ARTICLE_ID1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void findArticleUsingClassImplementation() {
        try {
            ArticleService systemUnderTest2 = new ArticleServiceImpl();
            ArticleDAO mockedDependency2 = mock(ArticleDAOStubImpl.class);
            systemUnderTest2.setArticleDAO(mockedDependency2);

            // Set expectations on mocks.
            Article articleExpected1 = new Article(ARTICLE_ID1, "ARTICLE_TEST1", new Double(1000));

            when(mockedDependency2.getArticle(ARTICLE_ID1)).thenReturn(articleExpected1);

            // make the call
            systemUnderTest2.findArticle(ARTICLE_ID1);
            // Verify behavior.
            verify(mockedDependency2).getArticle(ARTICLE_ID1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void findArticleManyTimes() {
        try {
            // Set expectations on mocks.
            Article articleExpected1 = new Article(ARTICLE_ID1, "ARTICLE_TEST1", new Double(1000));

            when(mockedDependency.getArticle(ARTICLE_ID1)).thenReturn(articleExpected1);

            // make the call
            for (int i = 0; i < 3; i++) {
                systemUnderTest.findArticle(ARTICLE_ID1);
            }

            // Verify behavior.
            verify(mockedDependency, times(3)).getArticle(ARTICLE_ID1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void findArticleAnyTimes() {
        try {
            // Set expectations on mocks.
            Article articleExpected1 = new Article(ARTICLE_ID1, "ARTICLE_TEST1", new Double(1000));

            when(mockedDependency.getArticle(ARTICLE_ID1)).thenReturn(articleExpected1);

            // make the call
            for (int i = 0; i < 3; i++) {
                systemUnderTest.findArticle(ARTICLE_ID1);
            }

            // Verify behavior.
            verify(mockedDependency, atLeast(0)).getArticle(ARTICLE_ID1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void findArticleOrderChecked() {
        try {
            // Set expectations on mocks.
            Article articleExpected1 = new Article(ARTICLE_ID1, "ARTICLE_TEST1", new Double(1000));
            Article articleExpected2 = new Article(ARTICLE_ID2, "ARTICLE_TEST2", new Double(2000));

            when(mockedDependency.getArticle(ARTICLE_ID1)).thenReturn(articleExpected1);
            when(mockedDependency.getArticle(ARTICLE_ID2)).thenReturn(articleExpected2);

            // make the call
            systemUnderTest.findArticle(ARTICLE_ID1);
            systemUnderTest.findArticle(ARTICLE_ID2);

            // Verify behavior.
            verify(mockedDependency).getArticle(ARTICLE_ID1);
            verify(mockedDependency).getArticle(ARTICLE_ID2);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void findArticleErrorCase() {
        try {
            when(mockedDependency.getArticle(null)).thenThrow(new DAOException());

            // make the call
            systemUnderTest.findArticle(ARTICLE_ID1);

            // Verify behavior.
            verify(mockedDependency).getArticle(ARTICLE_ID1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
