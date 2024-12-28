package prj5;

import static org.junit.Assert.*;
//Virginia Tech Honor Code Pledge:
//Project 5 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
 *  tests MonthData methods
 * 
 *  @author brend
 *  @version Nov 20, 2024
 */

public class MonthDataTest extends student.TestCase
{
    //~ Fields ................................................................
    private MonthData m1;
    private MonthData m2;
    //~ Constructors ..........................................................
    /**
     *initializes data fields
     */
    public void setUp() {
        m1 = new MonthData("January", "cars", 10000, 300, 7700, 45000);
        m2 = new MonthData("May", "videogames", 2000, 155, 1180, 10000);
        
    }
    //~Public  Methods ........................................................
    /**
     * tests getMianTopic method
     */
    public void testGetMainTopic() {
        assertEquals("cars", m1.getMainTopic());
        assertEquals("videogames", m2.getMainTopic());
    }
    /**
     * tests getMonth method
     */
    public void testGetMonth() {
        assertEquals("January", m1.getMonth());
        assertEquals("May", m2.getMonth());
        
    }
    /**
     * tests getTotalComments method
     */
    public void testGetTotalComments() {
        assertEquals(7700, m1.getTotalComments());
        assertEquals(1180, m2.getTotalComments());
    }
    /**
     * tests getTotalFollowers method
     */
    public void testGetTotalFollowers() {
        assertEquals(300, m1.getTotalFollowers());
        assertEquals(155, m2.getTotalFollowers());
        
    }
    /**
     * tests getTotalLikes method
     */
    public void testGetTotalLikes() {
        assertEquals(10000, m1.getTotalLikes());
        assertEquals(2000, m2.getTotalLikes());
    }
    /**
     * tests getTotalViews
     */
    public void testGetTotalViews() {
        assertEquals(45000, m1.getTotalViews());
        assertEquals(10000, m2.getTotalViews());
        
    }
    
}
