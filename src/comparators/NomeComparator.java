/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

/**
 *
 * @author mesas
 */
import java.util.Comparator;


/**
 *
 * @author Dimz
 */
public class NomeComparator implements Comparator<String>{

    @Override
    public int compare(String t, String t1) {
        return t.hashCode()-t1.hashCode();
    }
    
}
