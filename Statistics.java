import java.time.LocalDate;

public class Statistics {
    private String statistic;
    Statistics()
    {
        String fileName = "Resturant.csv";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                System.out.println("ReservationId : " + values[0] + ", "
                                 + "numPeople: " + values[1] + ", "
                                 + "date: " + values[2] + ", "
                                 + "time : " + values[3] + ", "
                                 + "tableNo: " + values[4] + ", "
                                 + "customerId: " + values[5]);              
            }
            
        } catch(FileNotFoundException e){
            e.printStackTrace();            
        } catch(IOException e){
            e.printStackTrace();
        }
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
