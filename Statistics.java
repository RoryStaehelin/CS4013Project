import java.time.LocalDate;

public class Statistics {
    private String statistic;
    Statistics()
    {
        //Loads data from statistics.csv for all dates and saves them in a nice formatted way in statistic
    }
    Statistics(LocalDate startDate, LocalDate endDate)
    {
        //Loads data from statistics.csv between specified dates and saves them in a nice formatted way in statistic
    }

    public String getStatistic()
    {
        return statistic;
    }
}
