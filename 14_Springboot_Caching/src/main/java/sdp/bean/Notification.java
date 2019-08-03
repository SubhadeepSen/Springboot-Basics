package sdp.bean;

public class Notification {

	private String id;
	private String type;
	private boolean isSent;
	private String message;

	public Notification(String id, String type, boolean isSent, String message) {
		super();
		this.id = id;
		this.type = type;
		this.isSent = isSent;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSent() {
		return isSent;
	}

	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
