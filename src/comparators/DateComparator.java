/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import activities.GeneralActivity;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 *
 * @author Dimz
 */
public class DateComparator implements Comparator<GeneralActivity> {

    @Override
    public int compare(GeneralActivity t, GeneralActivity t1) {
        if (t1.getData().after(t.getData())) {
            return 1;
        } else if (t1.getData().before(t.getData())) {
            return -1;
        }

        return 0;
    }

}
