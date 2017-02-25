/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.model;

import ge.mziuri.model.enums.SubjectTitle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user_2
 */
public class Subject {
    
    private int id;
    private SubjectTitle  subjecttitle;
    private List<Event> EventsList = new ArrayList<>(); 

    public Subject() {
    }

    public Subject(int id, SubjectTitle subjecttitle) {
        this.id = id;
        this.subjecttitle = subjecttitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubjectTitle getSubjecttitle() {
        return subjecttitle;
    }

    public void setSubjecttitle(SubjectTitle subjecttitle) {
        this.subjecttitle = subjecttitle;
    }

    public List<Event> getEventsList() {
        return EventsList;
    }

    public void setEventsList(List<Event> EventsList) {
        this.EventsList = EventsList;
    }
    
    
    
}
