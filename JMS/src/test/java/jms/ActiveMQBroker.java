package jms;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerService;

public class ActiveMQBroker {
    public static void main(String[] args){
        try {
        BrokerService brokerService = new BrokerService();

        brokerService.setPersistent(false);

        brokerService.addConnector("tcp://0.0.0.0:6161616");
        
        brokerService.start();






        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
