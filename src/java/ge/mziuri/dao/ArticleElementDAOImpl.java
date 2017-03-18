/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.dao;

import ge.mziuri.model.ArticleElement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user_2
 */
public class ArticleElementDAOImpl implements ArticleElementDAO{
    
    private static final String SPLITTER = "#@~";
    private Connection conn;
    private PreparedStatement pstmt;

    public ArticleElementDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }
    
    @Override
    public void createArticleElement(List<String> textLists, List<String> picturesLists) {
        try {
            
            
 //           pstmt = con.prepareStatement("INSERT INTO test (question_type, question, possible_answers, correct_answer_indexes, correct_open_answers, contest_id) VALUES (?,?,?,?,?,?)");
//            String answers = "";
//            for (int i = 0; i < test.getAnswers().size(); i++) {
//                answers = answers + test.getAnswers().get(i);
//                if (i != test.getAnswers().size() - 1) {
//                    answers = answers + SPLITTER;
//               }
//           }
            
            
            
            String sql = "INSERT INTO system_user (index, text, pictures) VALUES (?,?,?)";
            ArticleElement article_element = new ArticleElement();
            String text = "";
            for(int i = 0; i < article_element.getTextList().size(); i++){
                text = text + article_element.getTextList().get(i);
                if(i != article_element.getTextList().size() - 1){
                    text = text + SPLITTER;
                }
            }
            
            String pictures = "";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, article_element.getIndex());
//            pstmt.setString(2, article_element.getTextList());
//            pstmt.setString(3, user.getUsername());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
