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
                sql = "SELECT * FROM event WHERE subject_title = ?";
            } else {
                sql = "SELECT * FROM event";
            }
            pstmt = conn.prepareStatement(sql);
            if (name != null) {
                pstmt.setString(1, name);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String eventname = rs.getString("name");
                SubjectTitle Subject_title = SubjectTitle.valueOf(rs.getString("subject_title"));
                Event event = new Event(eventname, Subject_title);
                event.setId(id);
                events.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return events;
    }

    @Override
    public int addEvent(Event event) {
        try {
            String sql = "INSERT INTO event (name, subject_title) VALUES (?,?) RETURNING id";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getSubjectTitle().name());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            return id;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public Event getEventbySubjectTitleAndEventName(SubjectTitle subjecttitle, String eventname) {
        EventDAO eventDAO = new EventDAOImpl();
        Event event = null;
        try {
            String sql = "SELECT * FROM event WHERE subject_title = ? AND name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, subjecttitle.name());
            pstmt.setString(2, eventname);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                event = new Event();
                int id = rs.getInt("id");
                event.setName(eventname);
                event.setSubjectTitle(subjecttitle);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return event;
    }
}
