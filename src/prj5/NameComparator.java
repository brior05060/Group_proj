// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Brendan Riordan (brior0506)

package prj5;

import java.util.Comparator;

/**
 * Comparator for sorting data by channel name.
 * 
 * @author Brendan Riordan
 * @version Nov 19, 2024
 */

public class NameComparator
    implements Comparator<UserData>
{

    /**
     * compares two userDatas by channel name
     * 
     * @param a
     * @param b
     * @return int returns positive number if b's name precedes a's name
     *             in alphabetical order. returns 0 if names are equals.
     *             return negative number if a's name precedes b's in
     *             alphabetical order
     */
    @Override
    public int compare(UserData a, UserData b)
    {
        return a.getChannelName().compareToIgnoreCase(b.getChannelName());
    }
}
