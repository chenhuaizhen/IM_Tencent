package Common;



public class Message implements java.io.Serializable{

	private String message;
	private String sender;
	private String getter;
	private String contain;
	private String sendTime;
	private String photo_adr;
	private Items item;
	private byte[] buf = new byte[4096];
	
	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public String getPhoto_adr() {
		return photo_adr;
	}

	public void setPhoto_adr(String photo_adr) {
		this.photo_adr = photo_adr;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public byte[] getBuf(){
		return buf;
	}
	
	public void setBuf(byte[] buf){
		this.buf = buf;
	}
}
