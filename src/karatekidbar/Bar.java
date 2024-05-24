/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package karatekidbar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author eblazquez
 */
public class Bar {
    
    private  Map<String,Double> menu;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        Bar b = new Bar();
        b.run();
    }
    
    public void run(){
        loadMenu();
        boolean exit = false;
        while(!exit){
            switch(options()){
                case 0:
                    exit = true;
                    break;
                case 1:
                    double res = requestProduct();
                    System.out.println("You have to pay " + res + "$");
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
                    
            }
        }
       
       
        
        
    }
    
    public void loadMenu(){
        menu = new HashMap<>();
        menu.put("kaiSandwitch",4.00);
        menu.put("kaiCola",2.50);
        menu.put("kaiBeer",2.55);
        menu.put("kaiWater",2.00);
        menu.put("kaiBurrito",5.55);
        
    }
    
    public void showMenu(){
        for(String s : menu.keySet()){
            System.out.format("%s --> %.2f $\n",s,menu.get(s));
        }
    }
    
    public double requestProduct(){
        System.out.println("Wich product do you choose?");
        showMenu();
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        System.out.println("How much?");
        int number = sc.nextInt();
        
        return menu.get(key)*number;
        
        
           
        
    }
    
    public int options(){
        System.out.println("Options");
        System.out.println("0. Exit");
        System.out.println("1. Request Product");
        int op = -1;
        Scanner sc = new Scanner(System.in);
        try{
            op = sc.nextInt();
        }catch(Exception e){
            System.out.println("Not valid int");
        }
        return op;
        
    }
    
}
