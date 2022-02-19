package com.model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
public class ShotHistory {
    private final ArrayList<Shot> history;

    public static ShotHistory readFromSession(HttpSession session, String attribute){
        Object attr = session.getAttribute(attribute);
        if (attr == null){
            return new ShotHistory();
        }
        else{
            return (ShotHistory) attr;
        }
    }

    public ShotHistory(){
        this.history = new ArrayList<>();
    }

    public void pushShot(Shot shot){

        this.history.add(0,shot);
    }

    public ArrayList<Shot> getHistory(){
        return history;
    }

}