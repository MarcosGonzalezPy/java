/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author konecta
 */
public final class MyStaticClass {
    private static int maxValue = 7;
    private MyStaticClass () { // private constructor
        myStaticMember = 1;
    }
    private static int myStaticMember;
    public static void setMyStaticMember(int val) {
        myStaticMember = val;
    }
    public static Integer getMyStaticMember() {
        if(myStaticMember<= 7)
            return myStaticMember++;
        return null;
    }
    public static int squareMyStaticMember() {
        return myStaticMember * myStaticMember;
    }
}
