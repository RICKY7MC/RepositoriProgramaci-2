/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karatekid;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Efrem
 */
public class KarateSchool {
    private List<KarateFighter> listMembers;
    private String name; 
    private KarateFighter currentFighter;
    
    public KarateSchool(String name){
        this.name = name;
        this.listMembers = new ArrayList<> ();
    }

    public List<KarateFighter> getListMembers() {
        return listMembers;
    }

    public String getName() {
        return name;
    }

    public KarateFighter getCurrentFighter() {
        return currentFighter;
    }
    
    /**
     * Allows add KarateFighter kf into the list if the kf doesn't already exist
     * if kf exists doesn't complete the action and returns false.
     * @param kf
     * @return
     */
    public boolean addFighter(KarateFighter kf){
        boolean am = true; 
        if(kf != null){
            for(KarateFighter lKf : listMembers){
                if(lKf.equals(kf)){
                    am = false;
                    break;
                }
            } 
            
            if(am){
                listMembers.add(kf);
            }
        }
        
        return am; 
    }
    
    /**
     * It returns the KarateFighter depending on the id, if the id doesn't 
     * exists it throws an exception. 
     * @param id
     * @return
     * @throws Exception
     */
    public KarateFighter changeFighter(int id) throws Exception {
        
        KarateFighter kf = null;
        int ix = listMembers.indexOf(new KarateFighter(id));
        if(ix >= 0){
            kf = listMembers.get(ix);
        }else{
            throw new Exception("Index not found exception");
        }
        return kf;
    }
    
    /**
     * It removes the KarateFighter kf from the list. If the list it's empty after
     * removing an item it throws an Exception
     * @param kf
     * @return
     * @throws java.lang.Exception
     */
    public boolean removeFighter(KarateFighter kf) throws Exception{
        boolean remove=false;
        remove=listMembers.remove(kf);
        
        if(listMembers.isEmpty()){
            throw new Exception("No more fighters...");
        }
        return remove;
       
    }
}
