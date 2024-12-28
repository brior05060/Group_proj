package prj5;
// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Brendan Riordan (brior0506)

/**
 * Object for storing users data based on each month
 * 
 * @author Brendan Riordan
 * @version Nov 19, 2024
 */
public class MonthData
{
    // ~ Fields ................................................................
    private String month;
    private String mainTopic;
    private int totalLikes;
    private int totalFollowers;
    private int totalComments;
    private int totalViews;

    // ~ Constructors ..........................................................
    /**
     * constructor for MonthData
     * 
     * @param month
     *            the month the data represents
     * @param mainTopic
     *            main topic on social media for the month
     * @param totalLikes
     *            total likes for the month
     * @param totalFollowers
     *            total followers for the month
     * @param totalComments
     *            total comments for the month
     * @param totalViews
     *            total views for the month
     */
    public MonthData(
        String month,
        String mainTopic,
        int totalLikes,
        int totalFollowers,
        int totalComments,
        int totalViews)
    {
        this.month = month;
        this.mainTopic = mainTopic;
        this.totalLikes = totalLikes;
        this.totalFollowers = totalFollowers;
        this.totalComments = totalComments;
        this.totalViews = totalViews;
    }


    // ~Public Methods ........................................................
    /**
     * @return String returns this.month
     */
    public String getMonth()
    {
        return this.month;
    }


    /**
     * @return String returns this.mainTopic
     */
    public String getMainTopic()
    {
        return this.mainTopic;
    }


    /**
     * @return int returns the total likes
     */
    public int getTotalLikes()
    {
        return this.totalLikes;
    }


    /**
     * @return int returns total followers
     */
    public int getTotalFollowers()
    {
        return this.totalFollowers;
    }


    /**
     * @return int returns total comments
     */
    public int getTotalComments()
    {
        return this.totalComments;
    }


    /**
     * @return int returns total views
     */
    public int getTotalViews()
    {
        return this.totalViews;
    }
}
