package prj5;
//Virginia Tech Honor Code Pledge:
//Project 5 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
 *  tests all comparators
 * 
 *  @author brend
 *  @version Nov 20, 2024
 */
public class ComparatorTest extends student.TestCase
{
    //~ Fields ................................................................
    private NameComparator c1;
    private ReachEngagementRateComparator c2;
    private TraditionalEngagementRateComparator c3;
    private UserData d1;
    private UserData d2;
    private UserData d4;
    private UserData d3;
    private UserData d5;
    
    //~ Constructors ..........................................................
    /**
     * initializes data fields
     */
    public void setUp() {
        c1 = new NameComparator();
        c2 = new ReachEngagementRateComparator();
        c3 = new TraditionalEngagementRateComparator();
        d1 = new UserData("brior0506", "cars101", "Ireland");
        d2 = new UserData("at11", "gym444", "USA");
        d3 = new UserData("Jadd", "cars101", "Lebenon");
        d4 = new UserData("at11", "Zills442", "USA");
        d5 = new UserData("Jadd", "101cars", "Lebenon");
        MonthData m1 = new MonthData("January", "cars", 
            10000, 300, 7700, 45000);
        MonthData m2 = new MonthData("February", "videogames", 
            7500, 2000, 5000, 9000);
        MonthData m3 = new MonthData("May", "cats", 8200, 3100, 6400, 9500);
        MonthData m4 = new MonthData("March", "dogs", 2000, 155, 1180, 10000);
        MonthData m5 = new MonthData("January", "toys", 1145, 40, 900, 6000);
        MonthData m6 = new MonthData("February", "toys", 
            6700, 1500, 4200, 8000);
        MonthData m7 = new MonthData("September", "toys", 
            9100, 2900, 6500, 9800);
        d1.addMonthData(m1);
        d1.addMonthData(m7);
        d1.addMonthData(m6);
        d1.addMonthData(m4);
        d2.addMonthData(m5);
        d2.addMonthData(m4);
        d2.addMonthData(m7);
        d3.addMonthData(m2);
        d3.addMonthData(m3);
        d3.addMonthData(m6);
        d4.addMonthData(m2);
        d4.addMonthData(m3);
        d4.addMonthData(m6);
        
       
        
    }
    //~Public  Methods ........................................................
    /**
     * tests compare method for NameComparator
     */
    
    public void testNameComparatorCompare() {
        
        assertTrue(c1.compare(d1, d2) < 0);
        assertEquals(0, c1.compare(d1, d3));
        assertTrue(c1.compare(d2, d4) < 0);
        assertTrue(c1.compare(d3, d5) > 0);
        
    }
    
    /**
     * tests compare method for ReachEngagement
     * RateCompaarator
     */
    
    public void testReachEngagementRateComparatorCompare() {
     
     
        assertTrue(c2.compare(d2, d1) > 0);
        assertTrue(c2.compare(d3, d4) < 0);
        assertTrue(c2.compare(d3, d1) < 0);
    }
    
    /**
     * tests compare method for TraditionalEngagementRateComparator
     */
    
    public void testsTraditionalEngagementRateComparatorCompare() {
      
        assertEquals(0, c3.compare(d4, d3));
        assertTrue( c3.compare(d2, d1) > 0);
        assertTrue(c3.compare(d1, d3) < 0);
        assertTrue(c3.compare(d2, d3) < 0);
        
        
    }
}
