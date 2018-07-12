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
public class TestMyStaticClass {
     public static void main(String []args){
        MyStaticClass.setMyStaticMember(5);
        //System.out.println("Static value: " + MyStaticClass.getMyStaticMember());
        //System.out.println("Value squared: " + MyStaticClass.squareMyStaticMember());
        // MyStaticClass x = new MyStaticClass(); // results in compile time error
        //MyStaticClass.setMyStaticMember(2);
        System.out.println("Static value: " + MyStaticClass.getMyStaticMember());
        System.out.println("Static value: " + MyStaticClass.getMyStaticMember());
        System.out.println("Static value: " + MyStaticClass.getMyStaticMember());
        System.out.println("Static value: " + MyStaticClass.getMyStaticMember());
        //System.out.println("Value squared: " + MyStaticClass.squareMyStaticMember());
     }
}
