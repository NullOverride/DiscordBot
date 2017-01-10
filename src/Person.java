
public class Person implements java.io.Serializable{
	private String primaryName;
	private String discordID;
	private String discName;
	private int money;
	
	public Person() {
		this.setDiscordID("");
		this.setPrimaryName("");
		this.setDiscName("");
		this.setMoney(0);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getDiscordID() {
		return discordID;
	}

	public void setDiscordID(String discordID) {
		this.discordID = discordID;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	
	public String getDiscName() {
		return discName;
	}

	public void setDiscName(String discName) {
		this.discName = discName;
	}
}
