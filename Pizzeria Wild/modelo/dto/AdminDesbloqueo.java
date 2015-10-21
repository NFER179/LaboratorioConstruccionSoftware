package dto;

public class AdminDesbloqueo {
	
	private String pass;
	
	public AdminDesbloqueo(String pass) {
		this.pass = pass;
	}

	public String GetPass() {
		return this.pass;
	}
}