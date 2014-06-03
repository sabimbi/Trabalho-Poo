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
public class DateComparator implements Comparator<GregorianCalendar> {

    @Override
    public int compare(GregorianCalendar a,GregorianCalendar b) {
        if (a.after(b)) {
            return 1;
        } else if (a.before(b)) {
            return -1;
        }

        return 0;
    }

}
