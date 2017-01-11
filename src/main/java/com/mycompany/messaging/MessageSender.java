package com.mycompany.messaging;

import com.mycompany.model.Artikl;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jovan
 */
@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Artikl artikl) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(artikl);
                return objectMessage;
            }
        });
    }
}
