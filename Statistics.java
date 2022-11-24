import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Statistics {
    public Statistics()
    {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("statistics.csv"));
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                System.out.println("Date : " + values[0] + ", "
                        + "Amount: " + values[1]);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public Statistics(LocalDate startDate, LocalDate endDate)
    {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("statistics.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                LocalDate sd = LocalDate.parse(values[0]);
                LocalDate ed = LocalDate.parse(values[0]);
                if(startDate.isAfter(sd) && endDate.isBefore(ed)){
                    data.add(values[0] + ", " + values[1]);
                }
                System.out.println(data);

            }
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
