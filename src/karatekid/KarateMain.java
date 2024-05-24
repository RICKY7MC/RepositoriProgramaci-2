/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package karatekid;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eblazquez
 */
public class KarateMain {

    private KarateSchool miyagiDo;
    private KarateSchool cobraKai;
    private KarateFighter miyagiDoF;
    private KarateFighter cobraKaiF;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KarateMain ka = new KarateMain();
        ka.run();
    }
    
    public void run(){
        //TO DO Create Schools 
        //TO DO Load members
        Scanner sc = new Scanner(System.in);
        //Create school
        miyagiDo = new KarateSchool("Miyagi Do");
        //Load members
        if(miyagiDo!= null){
            loadMembersMiyagiDo();
        }
        
        //Create School
        cobraKai = new KarateSchool("Cobra Kai");
        
        //Load Members
        if(cobraKai != null){
            loadMemberscobraKai();
        }
        
        //Init Tournament prints schools and fighters
        System.out.println("Schools " + miyagiDo.getName()+ " and "
                + cobraKai.getName()+ " ready to fight with teams: ");
        
        listMembers(miyagiDo);
        listMembers(cobraKai);
        
        //nextFight allows the user to choose new fighter
        boolean nextFight = true;
        boolean exit = false;
        
        //Choose first fighter for cobraKai
        cobraKaiF = cobraKai.getListMembers().get(0);
        
        try{
            do{
                //User can change the fighter after fighter KO. 
                if(nextFight){
                    listMembersByAge(miyagiDo);
                    System.out.println("Wich fighter do you choose?");

                    //TO DO Change the currentFighter by ID 
                    int id = sc.nextInt();

                    try {
                        miyagiDoF = miyagiDo.changeFighter(id);
                        nextFight = false;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                //MiyagiDO Fighter turn.
                if (!miyagiDoF.isKO()) {
                    miyagiDoF.karateAttack(cobraKaiF);
                }
                //cobraKai Fighter turn.
                if(!cobraKaiF.isKO()){
                    cobraKaiF.karateAttack(miyagiDoF);
                }

                //Remove from list 
                if (miyagiDoF.isKO()) {
                    miyagiDo.removeFighter(miyagiDoF);
                    nextFight = true;
                }

                if (cobraKaiF.isKO()) {
                    cobraKai.removeFighter(cobraKaiF);
                    cobraKaiF = cobraKai.getListMembers().get(0);
                    System.out.println("Next Fighter " + cobraKaiF.getName());             
                }

            }while(!exit);
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        
        //Show win School
        if(cobraKai.getListMembers().isEmpty()){
            System.out.println("Miyagi Do WON!");
        }else{
            System.out.println("Cobra Kai WON!");
        }
    }
    
    public void loadMembersMiyagiDo(){
        miyagiDo.addFighter(new KarateFighter("Michael", 10, 0));
        miyagiDo.addFighter(new KarateFighter("Selena", 17, 1));
        miyagiDo.addFighter(new KarateFighter("Lia", 13, 2));
        miyagiDo.addFighter(new KarateFighter("Ge", 11, 3));
        miyagiDo.addFighter(new KarateFighter("Joey", 15, 4));
    }
    
    public void loadMemberscobraKai(){
        cobraKai.addFighter(new KarateFighter("Yo", 10, 0));
        cobraKai.addFighter(new KarateFighter("Mi", 11, 1));
        cobraKai.addFighter(new KarateFighter("Lou", 15, 2));
       
    }
    
    public void listMembers(KarateSchool ks){
        System.out.println(ks.getName() + " Fighters\n");
        System.out.println("Name\tAge\tID");
        
        for(KarateFighter k : ks.getListMembers()){
            System.out.println(k.toString());
        }
        
        System.out.println("\n");
    }
    
    public void listMembersByAge(KarateSchool ks){
        List<KarateFighter> list = ks.getListMembers();
        Collections.sort(list, new SortByAge()); 
        System.out.println(ks.getName() + " Fighters\n");
        System.out.println("Name\tAge\tID");
        
        for(KarateFighter k : list){
            System.out.println(k.toString());
        }
        
        System.out.println("\n");
    }
}
