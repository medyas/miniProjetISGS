package miniProjet;

public class Client {

	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private int cin;
	
	public Client() {
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.tel = "";
		this.cin = 0;
	}
	
	public Client(String nom, String prenom, String email, String tel, int cin) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.cin = cin;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean search(int cin) {
		return this.cin == cin ;
	}
	
	public boolean search(String tel) {
		return this.tel.equals(tel) ;
	}
	
}
