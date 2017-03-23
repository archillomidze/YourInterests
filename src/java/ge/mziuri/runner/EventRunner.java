/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.runner;

import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Event;
import ge.mziuri.model.enums.SubjectTitle;

/**
 *
 * @author user_2
 */
public class EventRunner {
    public static void main(String[] args) {
        
        Event event = new Event();
        event.setName("gogi");
        event.setSubjectTitle(SubjectTitle.ART);
        
        EventDAOImpl eventdaoimpl = new EventDAOImpl();
        eventdaoimpl.addEvent(event);
        
    }
    
}
