package prj5;
//Virginia Tech Honor Code Pledge:
//Project 5 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Brendan Riordan (brior0506)

/**
 * Comparator for sorting data by engagement rate by reach.
 * 
 * @author Brendan Riordan
 * @version Nov 19, 2024
 */
public class ReachEngagementRateComparator
    extends DataComparator
{
    @Override
    public int compare(UserData a, UserData b)
    {
        double rateA = a.getReachEngagementRate();
        double rateB = b.getReachEngagementRate();

        // If rates are different, sort by rate in descending order
        if (rateA != rateB)
        {
            return Double.compare(rateB, rateA);
        }

        // If rates are equal, sort by channel name alphabetically
        return a.getChannelName().compareToIgnoreCase(b.getChannelName());
    }
}
