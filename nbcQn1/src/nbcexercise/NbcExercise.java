/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2022

 *  Created on 20 Sep 2022
 */
package nbcexercise;

import java.util.Arrays;

/**
 *
 * @author A243345
 */
public class NbcExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Elements :");
        int a[] = {5, 4, 3, 2, 1};
        System.out.println(a);
        System.out.println("Sum : " + sum(a));
    }

    public static int sum(int[] a) throws Exception {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                a[i] = 0;
            }
        }
        if (a.length <= 5) {
            System.out.println("Before sort : " + Arrays.toString(a));
            Arrays.sort(a);
            System.out.println("After sort : " + Arrays.toString(a));
            int s = a[0];
            int l = a[a.length - 1];
            System.out.println("Min : " + s);
            System.out.println("Max : " + l);
            return s + l;
        } else {
            throw new Exception("Maximum element reached");
        }
    }

}
