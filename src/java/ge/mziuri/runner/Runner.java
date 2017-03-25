/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.runner;

import ge.mziuri.dao.ArticleElementDAOImpl;
import ge.mziuri.model.ArticleElement;
import java.util.ArrayList;

/**
 *
 * @author user_2
 */
public class Runner {
    public static void main(String[] args) {
       
        ArticleElement article_element = new ArticleElement();
        article_element.setIndex(1);
        ArrayList<String> text = new ArrayList();
        text.add("asddfgghj");
        text.add("123456");
        text.add("qwertryu");
        ArrayList<String> pictures = new ArrayList();
        pictures.add("gfd");
        pictures.add("dgsg");
        pictures.add("dgd");
        article_element.setTextList(text);
        article_element.setPicturesList(pictures);
        ArticleElementDAOImpl art = new ArticleElementDAOImpl();
        
        art.createArticleElement(article_element, 1);
        
    }
}
