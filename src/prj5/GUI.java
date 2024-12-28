package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import cs2.TextShape;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;

// -------------------------------------------------------------------------
/**
 * This helps create the display Window
 * 
 * @author Aditya Rasal
 * @version Nov 17, 2024 Project 3 // As a Hokie, I will conduct myself with
 *              honor and integrity at all times. // I will not lie, cheat, or
 *              steal, nor will I // accept the actions of those who do. // --
 *              Aditya R (adityar05)
 */
public class GUI
{
    private Window window;
    private List<UserData> data;
    private String currentPeriod;
    private boolean isTraditionalEngagement;
    private String currentSortMethod;
    private static final int BAR_WIDTH = 50;
    private static final int BAR_SPACING = 20;
    private static final Color[] BAR_COLORS =
        { new Color(255, 140, 0), new Color(51, 102, 255),
            new Color(0, 51, 102), new Color(34, 139, 34) };
    private static final DecimalFormat df = new DecimalFormat("#.#");

    /**
     * Creates a new GUI window
     * 
     * @param userDataList
     *            The list of user data to display
     */
    public GUI(List<UserData> userDataList)
    {
        this.data = userDataList;
        this.currentPeriod = "First Quarter (Jan-March)";
        this.isTraditionalEngagement = true;
        this.currentSortMethod = "";

        window = new Window(
            "Social Media Vis AdItyaRasal8234 Baz2024S brior0506 pmehta242024S");
        window.setSize(850, 650);

        // Create left buttons
        Button traditionalButton = new Button("Traditional Engagement Rate");
        Button reachButton = new Button("Reach Engagement Rate");
        window.addButton(traditionalButton, WindowSide.WEST);
        window.addButton(reachButton, WindowSide.WEST);

        // Create buttons
        Button sortNameButton = new Button("Sort by Channel Name");
        Button sortRateButton = new Button("Sort by Engagement Rate");
        Button quitButton = new Button("Quit");
        window.addButton(sortNameButton, WindowSide.NORTH);
        window.addButton(sortRateButton, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);

        // Create bottom buttons
        Button janButton = new Button("January");
        Button febButton = new Button("February");
        Button marButton = new Button("March");
        Button quarterButton = new Button("First Quarter (Jan-March)");
        window.addButton(janButton, WindowSide.SOUTH);
        window.addButton(febButton, WindowSide.SOUTH);
        window.addButton(marButton, WindowSide.SOUTH);
        window.addButton(quarterButton, WindowSide.SOUTH);

        sortNameButton.onClick(this, "clickedSortName");
        sortRateButton.onClick(this, "clickedSortRate");
        quitButton.onClick(this, "clickedQuit");
        traditionalButton.onClick(this, "clickedTraditional");
        reachButton.onClick(this, "clickedReach");
        janButton.onClick(this, "clickedJanuary");
        febButton.onClick(this, "clickedFebruary");
        marButton.onClick(this, "clickedMarch");
        quarterButton.onClick(this, "clickedQuarter");

    }


    /**
     * Updates the display with current data
     */
    private void updateDisplay()
    {
        window.removeAllShapes();

        // Calculate dimensions
        int leftMargin = 50;
        int bottomMargin = 100;
        int topMargin = 50;
        int baseY = window.getGraphPanelHeight() - bottomMargin;

        TextShape periodText =
            new TextShape(leftMargin + 10, topMargin, currentPeriod);
        TextShape rateText = new TextShape(
            leftMargin + 10,
            topMargin + 20,
            (isTraditionalEngagement ? "Traditional" : "Reach")
                + " Engagement Rate");
        TextShape sortText = null;
        if (!currentSortMethod.isEmpty())
        {
            sortText = new TextShape(
                leftMargin + 10,
                topMargin + 40,
                "Sorting by " + currentSortMethod);
        }

        window.addShape(periodText);
        window.addShape(rateText);
        if (sortText != null)
        {
            window.addShape(sortText);
        }

        double maxRate = 0.1;
        for (UserData user : data)
        {
            double rate = getCurrentRate(user);
            if (rate > maxRate)
            {
                maxRate = rate;
            }
        }

        double availableHeight = baseY - (topMargin + 80);
        double scaleFactor = availableHeight / maxRate;

        // Draw bars
        int startX = leftMargin + 10;
        for (int i = 0; i < data.size(); i++)
        {
            UserData user = data.get(i);
            double rate = getCurrentRate(user);

            int barHeight = Math.max((int)(rate * scaleFactor), 5);

            Shape bar = new Shape(
                startX + i * (BAR_WIDTH + BAR_SPACING),
                baseY - barHeight,
                BAR_WIDTH,
                barHeight,
                BAR_COLORS[i % BAR_COLORS.length]);

            TextShape channelName = new TextShape(
                startX + i * (BAR_WIDTH + BAR_SPACING),
                baseY + 5,
                user.getChannelName());

            String valueText = (rate == 0.0) ? "N/A" : df.format(rate);
            TextShape rateValue = new TextShape(
                startX + i * (BAR_WIDTH + BAR_SPACING),
                baseY + 25,
                valueText);

            window.addShape(bar);
            window.addShape(channelName);
            window.addShape(rateValue);
        }
    }


    /**
     * Gets the current rate based on period and engagement type
     * 
     * @param user
     *            the user to get rate for
     * @return the calculated rate
     */
    private double getCurrentRate(UserData user)
    {
        if (currentPeriod.equals("First Quarter (Jan-March)"))
        {
            return isTraditionalEngagement
                ? user.getTraditionalEngagementRate()
                : user.getReachEngagementRate();
        }
        return isTraditionalEngagement
            ? user.getMonthTraditionalEngagementRate(currentPeriod)
            : user.getMonthReachEngagementRate(currentPeriod);
    }


    /**
     * Handler for sort by channel name button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedSortName(Button button)
    {
        data.sort(new NameComparator());
        currentSortMethod = "Channel Name";
        updateDisplay();
    }


    /**
     * Handler for sort by engagement rate button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedSortRate(Button button)
    {
        if (isTraditionalEngagement)
        {
            data.sort(new TraditionalEngagementRateComparator());
        }
        else
        {
            data.sort(new ReachEngagementRateComparator());
        }
        currentSortMethod = "Engagement Rate";
        updateDisplay();
    }


    /**
     * Handler for traditional engagement rate button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedTraditional(Button button)
    {
        isTraditionalEngagement = true;
        updateDisplay();
    }


    /**
     * Handler for reach engagement rate button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedReach(Button button)
    {
        isTraditionalEngagement = false;
        updateDisplay();
    }


    /**
     * Handler for January button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedJanuary(Button button)
    {
        currentPeriod = "January";
        updateDisplay();
    }


    /**
     * Handler for February button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedFebruary(Button button)
    {
        currentPeriod = "February";
        updateDisplay();
    }


    /**
     * Handler for March button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedMarch(Button button)
    {
        currentPeriod = "March";
        updateDisplay();
    }


    /**
     * Handler for First Quarter button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedQuarter(Button button)
    {
        currentPeriod = "First Quarter (Jan-March)";
        updateDisplay();
    }


    /**
     * Handler for quit button
     * 
     * @param button
     *            the button that was clicked
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }
}
