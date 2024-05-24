/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karatekid;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Efrem
 */
public class KarateFighter {
    static final int MIN_LIFE = 20;
    static final int MIN_ATTACK = 10;
    
    private int lifePoints;
    private String name; 
    private int age;
    private int uID; 
    private boolean KO; 

    /**
     * Constructor fo KarateFighter, sets MIN_LIFE plus age
     * @param name
     * @param age
     * @param uID
     */
    public KarateFighter (String name, int age, int uID){
        this.name = name; 
        this.age = age; 
        this.lifePoints = MIN_LIFE + age;
        this.KO = false;
        this.uID = uID;
       
    }
    
    public KarateFighter(int uID){
        this.uID = uID;
        this.KO = false;
    }
    
    public int getLifePoints() {
        return lifePoints;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getuID() {
        return uID;
    }

    public boolean isKO() {
        return KO;
    }
    
    /**
     * Attacks to the oponent kf using recieveAttack method
     * @param kf
     */
    public void karateAttack(KarateFighter kf){
        Random rd = new Random();
        int attackForce = rd.nextInt(MIN_ATTACK, age+1);
        kf.recieveAttack(attackForce);
        kf.showLifeMessage();
    }
    
    /**
     * Decreases lifePoints depending on attack force
     * @param force
     */
    public void recieveAttack(int force){
        lifePoints -= force;
        lifePoints = Math.max(0, lifePoints);
        if(lifePoints == 0){
            KO = true;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.uID);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KarateFighter other = (KarateFighter) obj;
        return Objects.equals(this.uID, other.uID);
        
        
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.name);
        sb.append("\t").append(this.age);
        sb.append("\t").append(this.uID);
        
        return sb.toString();
    }
    
    /**
     * Shows fighter name and lifePoints
     */
    public void showLifeMessage(){
        System.out.println("Fighter "+ this.name + " has "+ this.lifePoints + " lifePoins");
    }

    
    
    
    
}
