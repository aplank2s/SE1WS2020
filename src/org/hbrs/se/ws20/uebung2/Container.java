package org.hbrs.se.ws20.uebung2;
import java.util.LinkedList;

public class Container {

    LinkedList<Member> list;
    public Container(){
         list = new LinkedList<Member>();
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
    public void dump(){
        for(Member member: list){
            System.out.println(member.toString());
        }
    }
    public int size(){
        return list.size();
    }
}
