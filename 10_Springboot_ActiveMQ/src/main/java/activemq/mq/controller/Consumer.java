package activemq.mq.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consume")
public class Consumer {

	@JmsListener(destination = "queue.name")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void consume(String message) {
		System.out.println("Consumed: " + message);
	}
}
