
package ge.mziuri.dao;

import ge.mziuri.model.Event;
import ge.mziuri.model.enums.SubjectTitle;
import java.util.List;

public interface EventDAO {
    
    List<Event> getAllEventBySubjectName(String name);
    void addEvent(Event event);
    Event getEventbySubjectTitleAndEventName(SubjectTitle subjecttitle, String eventname);
}
