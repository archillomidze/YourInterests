/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.dao;

import ge.mziuri.model.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user_2
 */
public class EventDAOImpl implements EventDAO{
    
    private Connection conn;
    
    private PreparedStatement pstmt;
    
    public EventDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public ArrayList<Event> getAllEventBySubjectName(String name) {
        try {
            String sql = "SELECT * FROM event WHERE subject_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getSubjectTitle().name());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addEvent(Event event) {
        try {
            String sql = "INSERT INTO event (name, subject_name) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getSubjectTitle().name());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
