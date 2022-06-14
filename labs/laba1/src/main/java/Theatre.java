import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


public class Theatre {
    public String date_performance(String date) throws IOException {

        String performance = new String();
        String line;

        FileReader fr = new FileReader("/Users/ryu/Desktop/lab1txts/dates.rtf");
        BufferedReader in = new BufferedReader(fr);

        while ((line=in.readLine())!=null) {
            String[] str = line.split(" ");
            if (str[0].equals(date)) {
                performance = str[1];
                break;
            } else  {
                performance = "There is no such performance";
            }
        }
        return performance;
    }

    public String performance_date(String performance) throws IOException {
        String date = new String();
        String line;

        FileReader fr = new FileReader("/Users/ryu/Desktop/lab1txts/performances.rtf");
        BufferedReader in = new BufferedReader(fr);

        while ((line=in.readLine())!=null) {
            String[] str = line.split(" ");
            if (str[0].equals(date)) {
                performance = str[1];
                break;
            } else  {
                performance = "There is no such date";
            }
        }
        return performance;
    }

}
