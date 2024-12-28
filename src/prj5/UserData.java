// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Baz Atiyeh (90632952)

package prj5;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the data for a user across multiple months.
 * 
 * @author Baz Atiyeh
 * @version Nov 19, 2024
 */
public class UserData
{
    private String username;
    private String channelName;
    private String country;
    private List<MonthData> monthDataList;

    /**
     * Constructor for UserData.
     * 
     * @param username
     *            The username of the influencer.
     * @param channelName
     *            The channel name of the influencer.
     * @param country
     *            The country of the influencer.
     */
    public UserData(String username, String channelName, String country)
    {
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.monthDataList = new ArrayList<>();
    }


    /**
     * Adds monthly data for the user.
     * 
     * @param data
     *            The MonthData object to add.
     */
    public void addMonthData(MonthData data)
    {
        monthDataList.add(data);
    }


    /**
     * Retrieves the username.
     * 
     * @return The username.
     */
    public String getUsername()
    {
        return username;
    }


    /**
     * Retrieves the channel name.
     * 
     * @return The channel name.
     */
    public String getChannelName()
    {
        return channelName;
    }


    /**
     * Retrieves the country.
     * 
     * @return The country.
     */
    public String getCountry()
    {
        return country;
    }


    /**
     * Retrieves the list of MonthData.
     * 
     * @return The list of MonthData.
     */
    public List<MonthData> getMonthDataList()
    {
        return monthDataList;
    }


    /**
     * Gets the traditional engagement rate for a specific month
     * 
     * @param month
     *            the month to calculate for
     * @return The traditional engagement rate for the specified month
     */
    public double getMonthTraditionalEngagementRate(String month)
    {
        int likes = 0;
        int comments = 0;
        int followers = 0;

        for (MonthData monthData : monthDataList)
        {
            if (monthData.getMonth().equalsIgnoreCase(month))
            {
                likes = monthData.getTotalLikes();
                comments = monthData.getTotalComments();
                followers = monthData.getTotalFollowers();
                break;
            }
        }

        return (followers > 0)
            ? ((double)(likes + comments) / followers) * 100
            : 0.0;
    }


    /**
     * Gets the reach engagement rate for a specific month
     * 
     * @param month
     *            the month to calculate for
     * @return The reach engagement rate for the specified month
     */
    public double getMonthReachEngagementRate(String month)
    {
        int likes = 0;
        int comments = 0;
        int views = 0;

        for (MonthData monthData : monthDataList)
        {
            if (monthData.getMonth().equalsIgnoreCase(month))
            {
                likes = monthData.getTotalLikes();
                comments = monthData.getTotalComments();
                views = monthData.getTotalViews();
                break;
            }
        }

        return (views > 0) ? ((double)(likes + comments) / views) * 100 : 0.0;
    }


    /**
     * Calculates and returns the traditional engagement rate for the user.
     * 
     * @return The traditional engagement rate
     */
    public double getTraditionalEngagementRate()
    {
        int likes = 0;
        int comments = 0;
        int followers = getFinalMonthFollowers();

        for (MonthData month : monthDataList)
        {
            String monthName = month.getMonth();
            if (monthName.equalsIgnoreCase("January")
                || monthName.equalsIgnoreCase("February")
                || monthName.equalsIgnoreCase("March"))
            {

                likes += month.getTotalLikes();
                comments += month.getTotalComments();
            }
        }

        return (followers > 0)
            ? ((double)(likes + comments) / followers) * 100
            : 0.0;
    }


    /**
     * Calculates and returns the reach engagement rate for the user.
     * 
     * @return The reach engagement rate
     */
    public double getReachEngagementRate()
    {
        int likes = 0;
        int comments = 0;
        int views = 0;

        for (MonthData month : monthDataList)
        {
            String monthName = month.getMonth();
            if (monthName.equalsIgnoreCase("January")
                || monthName.equalsIgnoreCase("February")
                || monthName.equalsIgnoreCase("March"))
            {

                likes += month.getTotalLikes();
                comments += month.getTotalComments();
                views += month.getTotalViews();
            }
        }

        return (views > 0) ? ((double)(likes + comments) / views) * 100 : 0.0;
    }


    /**
     * Retrieves the follower count for the final month in Q1.
     * 
     * @return The follower count for the final month
     */
    private int getFinalMonthFollowers()
    {
        int followers = 0;
        for (MonthData month : monthDataList)
        {
            if (month.getMonth().equalsIgnoreCase("March"))
            {
                return month.getTotalFollowers();
            }
        }
        for (MonthData month : monthDataList)
        {
            if (month.getMonth().equalsIgnoreCase("February"))
            {
                followers = month.getTotalFollowers();
            }
        }
        if (followers == 0)
        {
            for (MonthData month : monthDataList)
            {
                if (month.getMonth().equalsIgnoreCase("January"))
                {
                    followers = month.getTotalFollowers();
                }
            }
        }
        return followers;
    }
}
