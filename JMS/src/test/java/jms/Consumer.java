package jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

    public static void main(String[] args) {

        try {
   //etablissement d'une connexion au broker ActiveMQ
            // Créer un objet ConnectionFactory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            // Créer une connexion
            Connection connection = connectionFactory.createConnection();
            //  Démarrer la connexion
            connection.start();


   // Créer une session
            Session session = connection.createSession(true , Session.AUTO_ACKNOWLEDGE);


    //   Créer un objet Topic pour définir la destination du message
            Destination destination = session.createTopic("myTopic.topic");

    //  Créer un MessageConsumer
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener(){
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            System.out.println("Message reçu: " + textMessage.getText());
                             } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });












            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }