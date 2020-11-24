package org.hbrs.se.ws20.uebung2;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.io.FileOutputStream;


import java.util.LinkedList;


public class Container {

    LinkedList<Member> list;
    private static final Container c =  new Container();
    private persistenceStrategyStream<Member> pss;
    public Container(){
        list = new LinkedList<Member>();

    }
    public static Container getInstance(){
        return c;
    }
    public void addMember(Member member) throws ContainerException{
            for(Member member1: list) {
                if(member1.getID()== member.getID()){
                    throw new ContainerException(member.getID());
                }
            }
            list.add(member);
    }
    public String deleteMember(Integer ID){
        Member n = null;
        for(Member member: list) {
            if (ID == member.getID()) {
                n = member;
                list.remove(member);
                return "" + n.getID();
            }
        }

            return "Die ID " + ID + " ist nicht enthalten";
    }
   /* public void dump(){
        for(Member member: list){
            System.out.println(member.toString());
        }
    }*/
    public int size(){
        return list.size();
    }

    public void store()throws PersistenceException{
        if(pss == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Strategy verfügbar");
        }
        pss.save(list);
    }
    public void load()throws PersistenceException {
        try {
            FileInputStream file = new FileInputStream("file.txt");
            ObjectInputStream object = new ObjectInputStream(file);
            object.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
    public LinkedList<Member> getCurrentList() {
        return list;
    }
}
