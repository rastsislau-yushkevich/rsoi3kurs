import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.*;

@MessageDriven(name = "Consumer",
        activationConfig = {@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Laba7Queue")})
public class Consumer {

    ObjectOutputStream oos = null;

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(textMessage.getText());
            oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/messages.txt"));
            oos.writeObject(textMessage.toString());
            oos.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
