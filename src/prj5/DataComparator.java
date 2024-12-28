// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Baz Atiyeh (90632952)

package prj5;

import java.util.Comparator;

/**
 * Abstract parent comparator for sorting social media data. Subclasses define
 * specific sorting criteria.
 * 
 * @author baz atiyeh
 * @version Nov 19, 2024
 */
public abstract class DataComparator
    implements Comparator<UserData>
{

    @Override
    public abstract int compare(UserData a, UserData b);
}
