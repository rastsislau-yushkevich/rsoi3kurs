import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Producer {
    @Resource(name="java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name="java:/jms/queue/Laba7Queue")
    private Destination destination;

    @Resource(name="java:/jms/queue/ExpiryQueue")
    private Destination dest;

    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void produceMessage() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(destination);
        TextMessage textMessage = session.createTextMessage("Hello MDB");

        messageProducer.send(textMessage);


        connection.close();
        session.close();
    }
}
