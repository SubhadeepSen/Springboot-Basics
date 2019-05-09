package activemq.mq.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publish")
public class Publisher {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;

	@RequestMapping(value = "/{message}", method = RequestMethod.POST)
	public String publish(@PathVariable("message") String message) {
		jmsTemplate.convertAndSend(queue, message);
		return "Published message...";
	}
}
