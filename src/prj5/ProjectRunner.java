// Virginia Tech Honor Code Pledge:
// Project 5 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Baz Atiyeh (90632952)

package prj5;

import java.io.IOException;
import java.util.List;

/**
 * The ProjectRunner class contains the main method to run the social media
 * analytics dashboard.
 * 
 * @author Baz Atiyeh
 * @version Nov 19, 2024
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Main method that runs the analytics dashboard
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException
    {
        InputFileReader filer;
        boolean showConsole = true;
        boolean showGUI = true;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        if (showConsole)
        {
            List<UserData> userDataList = filer.getUserDataList();

            // Sort by channel name and display traditional engagement rates
            userDataList.sort(new NameComparator());
            for (UserData user : userDataList)
            {
                double engagementRate = user.getTraditionalEngagementRate();
                System.out.printf(
                    "%s\ntraditional: %.1f\n==========\n",
                    user.getChannelName(),
                    engagementRate);
            }

            // Separator
            System.out.println("**********");
            System.out.println("**********");

            // Sort by reach engagement rate
            userDataList.sort(new ReachEngagementRateComparator());
            for (UserData user : userDataList)
            {
                double engagementRate = user.getReachEngagementRate();
                if (engagementRate == 0.0)
                {
                    System.out.printf(
                        "%s\nreach: N/A\n==========\n",
                        user.getChannelName());
                }
                else
                {
                    System.out.printf(
                        "%s\nreach: %.1f\n==========\n",
                        user.getChannelName(),
                        engagementRate);
                }
            }
        }

        if (showGUI)
        {
            GUI window = new GUI(filer.getUserDataList());
        }
    }
}
