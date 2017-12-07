package miniProjet;

public class Fournisseur {

	private String nom;
	private String address;
	private String tel;
	private String email;
	private String hor_travail;
	private String ref;
	
	
	public Fournisseur() {
		this.nom = "";
		this.address = "";
		this.tel = "";
		this.email = "";
		this.hor_travail = "";
		this.ref = "";
	}
	
	public Fournisseur(String nom, String address, String tel, String email, String hor_t, String ref) {
		this.nom = nom;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.hor_travail = hor_t;
		this.ref = ref;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHor_travail() {
		return hor_travail;
	}
	public void setHor_travail(String hor_travail) {
		this.hor_travail = hor_travail;
	}
	
	public boolean lookupFour(String nom) {
		
		return (this.ref.equals(nom) || this.nom.equals(nom));
	}
}
