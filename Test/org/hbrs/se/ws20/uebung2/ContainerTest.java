package org.hbrs.se.ws20.uebung2;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Container c;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        c = new Container();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        c = null;
    }

    @org.junit.jupiter.api.Test
    void addMember() {
        Member m = new Factory(1);
        Member d = new Factory(2);
        try {
            c.addMember(m);
            c.addMember(d);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        assertEquals(2, c.size());
    }

    @org.junit.jupiter.api.Test
    void deleteMember() {
        Member m = new Factory(1);
        try {
            c.addMember(m);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        assertEquals("1", c.deleteMember(m.getID()));
        assertEquals("Die ID 2 ist nicht enthalten", c.deleteMember(2));
    }

    @org.junit.jupiter.api.Test
    void dump() {
    }

    @org.junit.jupiter.api.Test
    void size() {
        Member m = new Factory(1);
        try {
            c.addMember(m);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        assertEquals(1, c.size());
    }
}