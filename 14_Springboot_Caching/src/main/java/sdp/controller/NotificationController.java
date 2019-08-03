package sdp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sdp.bean.Notification;

@RestController
public class NotificationController {

	private List<Notification> notifications;

	@Autowired
	private CacheManager cacheManager;

	@RequestMapping("/notifications")
	@Cacheable("notifications")
	public List<Notification> getNotifications() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		return notifications;
	}

	@RequestMapping("/notification/{id}")
	@Cacheable("notification")
	public Notification getNotifications(@PathVariable String id) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		for (Notification notification : notifications) {
			if (id.equals(notification.getId())) {
				return notification;
			}
		}
		return null;
	}

	
	//@Scheduled(initialDelayString = "3600000", fixedRateString = "3600000")	// clear in every 1 hr
	@Scheduled(initialDelay = 20000, fixedRate = 20000)	// clear in every 20 seconds
	public void clearCache() {
		System.out.println("Clearing cache...");
		cacheManager.getCacheNames().forEach(cacheName -> {
			cacheManager.getCache(cacheName).clear();
		});
	}

	@PostConstruct
	public void init() {
		System.out.println("Initializing notification list...");
		notifications = new ArrayList<>();
		notifications.add(new Notification("1001", "text", false, "This is a text message."));
		notifications.add(new Notification("1002", "email", false, "This is an email notification."));
		notifications.add(new Notification("1003", "text", true, "This is a text message."));
		notifications.add(new Notification("1004", "email", true, "This is an email notification."));
	}

}
