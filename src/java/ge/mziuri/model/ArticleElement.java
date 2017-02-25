/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Text;

/**
 *
 * @author user_2
 */
public class ArticleElement {
    
    private int id;
    private int index;
    private List<String> TextList = new ArrayList<>();
    private List<String> PicturesList = new ArrayList<>();

    public ArticleElement() {
    }

    public ArticleElement(int id, int index) {
        this.id = id;
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<String> getTextList() {
        return TextList;
    }

    public void setTextList(List<String> TextList) {
        this.TextList = TextList;
    }

    public List<String> getPicturesList() {
        return PicturesList;
    }

    public void setPicturesList(List<String> PicturesList) {
        this.PicturesList = PicturesList;
    }
    
    
    
}
