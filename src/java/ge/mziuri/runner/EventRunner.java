
package ge.mziuri.runner;

import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Event;
import ge.mziuri.model.enums.SubjectTitle;

public class EventRunner {
    public static void main(String[] args) {
        
        Event event = new Event();
        event.setName("gogi");
        event.setSubjectTitle(SubjectTitle.ART);
        
        EventDAOImpl eventdaoimpl = new EventDAOImpl();
        eventdaoimpl.addEvent(event);
        
    }
    
}
