
package ge.mziuri.model;

import java.util.ArrayList;
import java.util.List;

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
