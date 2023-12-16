package jms;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.jms.ConnectionFactory;
public class Producer {

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
                Session session = connection.createSession(false , Session.AUTO_ACKNOWLEDGE);


      //   Créer un objet Topic pour définir la destination du message
                Destination destination = session.createTopic("myTopic.topic");


      //  Créer un MessageProducer
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);


       //  Créer un message
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText("Hello world !");


        //  Envoyer le message
               producer.send(textMessage);


                session.commit();


                System.out.println("Envoi du Message ...");



                session.close();



                connection.close();









            } catch (Exception e) {
                e.printStackTrace();
            }


        }

}