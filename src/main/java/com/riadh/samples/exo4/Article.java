package com.riadh.samples.exo4;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * @author Riadh MNASRI
 * 
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 4627569605725786994L;

    public Article() {
    }

    public Article(Integer articleId, String articleName, Double priceHT) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.priceHT = priceHT;
    }

    private Integer articleId;
    private String  articleName;
    private Double  priceHT;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Double getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(Double priceHT) {
        this.priceHT = priceHT;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
