
package ge.mziuri.dao;

import ge.mziuri.model.Event;
import java.util.List;

public interface EventDAO {
    
    List<Event> getAllEventBySubjectName(String name);
    void addEvent(Event event);
    
}
