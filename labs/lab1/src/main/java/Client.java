import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.rpc.ServiceException;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws ServiceException, IOException {
        String endpoint = "http://localhost:8080/axis/Theatre.jws";

        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));

        System.out.println("1 - enter the phone number");
        System.out.println("2 - enter the name");
        System.out.println("3 - exit");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = in.readLine();
        while (!line.equals("3")) {
            if (line.equals("3")) break;
            if (line.equals("1")) {
                String date = in.readLine();
                Object[] param1 = new Object[]{date};
                String response = (String) call.invoke("date_performance", param1);
                System.out.println("Date =" + date + "\n" + "Performance =" + response);
            }
            if (line.equals("2")) {
                String performance = in.readLine();
                Object[] param2 = new Object[]{performance};
                String response = (String) call.invoke("performance_date", param2);
                System.out.println("Performance=" + performance + "\n" + "Date=" + response);
            }
            ;
            System.out.println("1 - enter the phone number");
            System.out.println("2 - enter the name");
            System.out.println("3 - exit");
            line = in.readLine();
        }

    }
}
