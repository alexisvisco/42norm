package fr.ft.aviscogl.norm;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Norm
{
    static class NormRequest
    {
        String filename;
        String content;
        String[] rules;

        public NormRequest(String filename, String content, String[] rules)
        {
            this.filename = filename;
            this.content = content;
            this.rules = rules;
        }
    }

    static class NormResponse
    {
        String filename;
        String display;
    }

    static class VersionRequest
    {
        String action;

        public VersionRequest(String action)
        {
            this.action = action;
        }
    }

    static class VersionResponse
    {
        String version;
        boolean stop;
    }

    Connection conn;
    String[] disabledRules;


    public Norm(String uri, String[] disabledRules) throws IOException, TimeoutException
    {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(uri);
        this.conn = connectionFactory.newConnection();
        this.disabledRules = disabledRules;
    }

    /*

func (norminette *Norminette) Publish(channel *amqp.Channel, queue *amqp.Queue, v interface{}) error {
	bytes, err := json.Marshal(v)
	if err != nil {
		return err
	}
	return channel.Publish("", "norminette", false, false, amqp.Publishing{
		ReplyTo: queue.Name,
		Body:    bytes,
	})
}
     */

    public void publish(Channel chan, AMQP.Queue queue, NormRequest nr) {
//        chan.basicPublish("", "norminette", false, new Bas);
    }
}
