/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karatekid;

import java.util.Comparator;

/**
 *
 * @author Efrem
 */
public class SortByAge implements Comparator<KarateFighter> {

    @Override
    public int compare(KarateFighter o1, KarateFighter o2) {
        return o1.getAge() - o2.getAge();
    }
    
    
}
