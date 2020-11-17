package org.hbrs.se.ws20.uebung2;

public class Factory implements Member{
    int id;
    public Factory(int id){
        this.id = id;
    }

    public Integer getID() {
        return id;
    }
    public String toString(){
        return "Member (ID = " + id + ")";
    }
}
