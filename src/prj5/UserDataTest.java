// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Baz Atiyeh (90632952)

package prj5;

import student.TestCase;

/**
 * Test class for UserData.
 * 
 * @author Baz Atiyeh
 * @version Nov 20, 2024
 */
public class UserDataTest
    extends TestCase
{
    private UserData userData;
    private MonthData januaryData;
    private MonthData februaryData;
    private MonthData marchData;

    /**
     * Sets up the test cases.
     */
    public void setUp()
    {
        userData = new UserData("testUser", "testChannel", "US");

        januaryData =
            new MonthData("January", "Gaming", 1000, 5000, 100, 10000);
        februaryData =
            new MonthData("February", "Gaming", 2000, 6000, 200, 20000);
        marchData = new MonthData("March", "Gaming", 3000, 7000, 300, 30000);
    }


    /**
     * Tests the constructor and basic getters.
     */
    public void testConstructorAndGetters()
    {
        assertEquals("testUser", userData.getUsername());
        assertEquals("testChannel", userData.getChannelName());
        assertEquals("US", userData.getCountry());
        assertTrue(userData.getMonthDataList().isEmpty());
    }


    /**
     * Tests adding month data.
     */
    public void testAddMonthData()
    {
        userData.addMonthData(januaryData);
        assertEquals(1, userData.getMonthDataList().size());
        assertEquals(januaryData, userData.getMonthDataList().get(0));
    }


    /**
     * Tests traditional engagement rate with only January data.
     */
    public void testTraditionalEngagementRateJanuaryOnly()
    {
        userData.addMonthData(januaryData);
        assertEquals(22.0, userData.getTraditionalEngagementRate(), 0.1);
    }


    /**
     * Tests traditional engagement rate with all Q1 months.
     */
    public void testTraditionalEngagementRateFullQ1()
    {
        userData.addMonthData(januaryData);
        userData.addMonthData(februaryData);
        userData.addMonthData(marchData);
        assertEquals(94.29, userData.getTraditionalEngagementRate(), 0.1);
    }


    /**
     * Tests traditional engagement rate with no March data.
     */
    public void testTraditionalEngagementRateNoMarch()
    {
        userData.addMonthData(januaryData);
        userData.addMonthData(februaryData);
        assertEquals(55.0, userData.getTraditionalEngagementRate(), 0.1);
    }


    /**
     * Tests reach engagement rate with only January data.
     */
    public void testReachEngagementRateJanuaryOnly()
    {
        userData.addMonthData(januaryData);
        assertEquals(11.0, userData.getReachEngagementRate(), 0.1);
    }


    /**
     * Tests reach engagement rate with all Q1 months.
     */
    public void testReachEngagementRateFullQ1()
    {
        userData.addMonthData(januaryData);
        userData.addMonthData(februaryData);
        userData.addMonthData(marchData);
        assertEquals(11.0, userData.getReachEngagementRate(), 0.1);
    }


    /**
     * Tests traditional engagement rate with zero followers.
     */
    public void testTraditionalEngagementRateZeroFollowers()
    {
        MonthData zeroData =
            new MonthData("March", "Gaming", 1000, 0, 100, 10000);
        userData.addMonthData(zeroData);
        assertEquals(0.0, userData.getTraditionalEngagementRate(), 0.1);
    }


    /**
     * Tests reach engagement rate with zero views.
     */
    public void testReachEngagementRateZeroViews()
    {
        MonthData zeroData =
            new MonthData("March", "Gaming", 1000, 5000, 100, 0);
        userData.addMonthData(zeroData);
        assertEquals(0.0, userData.getReachEngagementRate(), 0.1);
    }


    /**
     * Tests engagement rates with non-Q1 months.
     */
    public void testEngagementRatesWithNonQ1Data()
    {
        MonthData aprilData =
            new MonthData("April", "Gaming", 4000, 8000, 400, 40000);
        userData.addMonthData(januaryData);
        userData.addMonthData(aprilData);

        assertEquals(22.0, userData.getTraditionalEngagementRate(), 0.1);
        assertEquals(11.0, userData.getReachEngagementRate(), 0.1);
    }


    /**
     * Tests engagement rates with empty data.
     */
    public void testEngagementRatesWithNoData()
    {
        assertEquals(0.0, userData.getTraditionalEngagementRate(), 0.1);
        assertEquals(0.0, userData.getReachEngagementRate(), 0.1);
    }


    /**
     * Tests monthly traditional engagement rate for January.
     */
    public void testMonthTraditionalEngagementRateJanuary()
    {
        userData.addMonthData(januaryData);
        userData.addMonthData(februaryData);
        userData.addMonthData(marchData);
        assertEquals(
            22.0,
            userData.getMonthTraditionalEngagementRate("January"),
            0.1);
    }


    /**
     * Tests monthly traditional engagement rate for non-existent month.
     */
    public void testMonthTraditionalEngagementRateNonExistent()
    {
        userData.addMonthData(januaryData);
        assertEquals(
            0.0,
            userData.getMonthTraditionalEngagementRate("April"),
            0.1);
    }


    /**
     * Tests monthly traditional engagement rate with zero followers.
     */
    public void testMonthTraditionalEngagementRateZeroFollowers()
    {
        MonthData zeroData =
            new MonthData("February", "Gaming", 1000, 0, 100, 10000);
        userData.addMonthData(zeroData);
        assertEquals(
            0.0,
            userData.getMonthTraditionalEngagementRate("February"),
            0.1);
    }


    /**
     * Tests monthly reach engagement rate for March.
     */
    public void testMonthReachEngagementRateMarch()
    {
        userData.addMonthData(januaryData);
        userData.addMonthData(februaryData);
        userData.addMonthData(marchData);
        assertEquals(11.0, userData.getMonthReachEngagementRate("March"), 0.1);
    }


    /**
     * Tests monthly reach engagement rate for non-existent month.
     */
    public void testMonthReachEngagementRateNonExistent()
    {
        userData.addMonthData(januaryData);
        assertEquals(0.0, userData.getMonthReachEngagementRate("April"), 0.1);
    }


    /**
     * Tests monthly reach engagement rate with zero views.
     */
    public void testMonthReachEngagementRateZeroViews()
    {
        MonthData zeroData =
            new MonthData("February", "Gaming", 1000, 5000, 100, 0);
        userData.addMonthData(zeroData);
        assertEquals(
            0.0,
            userData.getMonthReachEngagementRate("February"),
            0.1);
    }

}
