package prj5;
//Virginia Tech Honor Code Pledge:
//Project 5 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Brendan Riordan (brior0506)

/**
 * Comparator for sorting data by traditional engagement rate.
 * 
 * @author Brendan Riordan
 * @version Nov 19, 2024
 */
public class TraditionalEngagementRateComparator
    extends DataComparator
{

    @Override
    public int compare(UserData a, UserData b)
    {
        return Double.compare(
            b.getTraditionalEngagementRate(),
            a.getTraditionalEngagementRate());
    }
}
