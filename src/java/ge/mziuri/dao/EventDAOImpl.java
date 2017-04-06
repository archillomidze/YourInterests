package ge.mziuri.dao;

import ge.mziuri.model.Event;
import ge.mziuri.model.enums.SubjectTitle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {

    private Connection conn;
    private PreparedStatement pstmt;

    public EventDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public List<Event> getAllEventBySubjectName(String name) {
        List<Event> events = new ArrayList<>();
        try {
            String sql;
            if (name != null) {
                sql = "SELECT * FROM event WHERE subject_name = ?";
            } else {
                sql = "SELECT * FROM event";
            }
            pstmt = conn.prepareStatement(sql);
            if (name != null) {
                pstmt.setString(1, name);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String eventname = rs.getString("name");
                SubjectTitle Subject_title = SubjectTitle.valueOf(rs.getString("title"));
                Event event = new Event (name, Subject_title);
                events.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return events;
    }

    @Override
    public void addEvent(Event event) {
        try {
            String sql = "INSERT INTO event (name, subject_title) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getSubjectTitle().name());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
