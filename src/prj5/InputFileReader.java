// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Parth Mehta (906697132)
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Processes input files for the rest of the program.
 * 
 * @author Parth Mehta
 * @version Nov 19, 2024
 * @param <UserData>
 */
public class InputFileReader
{
    private LinkedList<UserData> userDataList;

    /**
     * Constructor for InputFileReader.
     * 
     * @param fileName
     *            name of input file
     * @throws FileNotFoundException
     *             if file is not found
     */
    public InputFileReader(String fileName)
        throws FileNotFoundException
    {
        userDataList = new LinkedList<>();
        readFile(fileName);
    }


    /**
     * Reads and processes the input file.
     * 
     * @param fileName
     *            name of input file
     * @throws FileNotFoundException
     *             if file is not found
     */
    private void readFile(String fileName)
        throws FileNotFoundException
    {
        File file = new File(fileName);
        Scanner inStream = new Scanner(file);

        if (inStream.hasNextLine())
        {
            inStream.nextLine();
        }

        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().trim();
            String[] values = line.split(",");

            if (values.length < 10)
            {
                continue;
            }

            String month = values[0].trim();
            String username = values[1].trim();
            String channelName = values[2].trim();
            String country = values[3].trim();
            String mainTopic = values[4].trim();
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            if (!isValidMonth(month))
            {
                continue;
            }

            MonthData monthData = new MonthData(
                month,
                mainTopic,
                likes,
                followers,
                comments,
                views);

            UserData userData =
                findOrCreateUserData(username, channelName, country);
            userData.addMonthData(monthData);
        }

        inStream.close();
    }


    /**
     * Finds or creates a UserData object for a given username.
     */
    private UserData findOrCreateUserData(
        String username,
        String channelName,
        String country)
    {
        for (UserData userData : userDataList)
        {
            if (userData.getUsername().equals(username))
            {
                return userData;
            }
        }

        UserData newUserData = new UserData(username, channelName, country);
        userDataList.add(newUserData);
        return newUserData;
    }


    /**
     * Converts a string to an integer.
     * 
     * @param str
     *            the string to convert
     * @return converted int value or 0 if conversion fails
     */
    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }


    /**
     * Checks & validates if the month is in Q1.
     * 
     * @param month
     *            the month to validate
     * @return boolean if month is valid or not
     */
    private boolean isValidMonth(String month)
    {
        return month != null && (month.equalsIgnoreCase("January")
            || month.equalsIgnoreCase("February")
            || month.equalsIgnoreCase("March")
            || month.equalsIgnoreCase("April") || month.equalsIgnoreCase("May")
            || month.equalsIgnoreCase("June") || month.equalsIgnoreCase("July")
            || month.equalsIgnoreCase("August")
            || month.equalsIgnoreCase("September")
            || month.equalsIgnoreCase("October")
            || month.equalsIgnoreCase("November")
            || month.equalsIgnoreCase("December"));
    }


    /**
     * Returns the list of user data.
     * 
     * @return LinkedList of UserData objects
     */
    public LinkedList<UserData> getUserDataList()
    {
        return userDataList;
    }
}
