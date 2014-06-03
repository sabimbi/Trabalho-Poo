/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;
import users.*;
import java.util.*;
/**
 *
 * @author Mesas
 */
public class NameComparator implements Comparator<User> {
    public int compare(User a,User b){
        return (a.getEmail().hashCode())-(b.getEmail().hashCode());
    }
}
