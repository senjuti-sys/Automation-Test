package com.Rough;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList <String> name=new ArrayList<String>();
        name.add("Muntasir");
        name.add("Abdullah");
        name.add("muntasir@mail.com");

        Iterator<String> it= name.iterator();
        String FirstName=it.next();
        String LastName=it.next();
        String Email=it.next();

        System.out.println(FirstName);
        System.out.println(LastName);
        System.out.println(Email);
    }
}
