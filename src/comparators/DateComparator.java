/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 *
 * @author Dimz
 */
public class DateComparator implements Comparator<GregorianCalendar>{

    @Override
    public int compare(GregorianCalendar t, GregorianCalendar t1) {
        if(t1.after(t))
            return 1;
        else if(t1.before(t))
            return -1;
        
        return 0;
    }
    
}
