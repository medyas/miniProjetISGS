package miniProjet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Deal {
	
	private String categorie;
	private String description;
	private float prix_ini;
	private float prix_deal;
	private String date_debut;
	private String date_fin;
	private Fournisseur localisation;
	private String ref;
	
	
	public Deal() {
		this.categorie = "";
		this.description = "";
		this.prix_deal = 0;
		this.prix_ini = 0;
		this.date_debut = "";
		this.date_fin = "";
		this.localisation = new Fournisseur();
		this.ref = "";
	}
	
	public Deal(String categorie, String description, float prix_ini, float prix_deal, String date_d, String date_f, Fournisseur loc, String ref) {
		this.categorie = categorie;
		this.description = description;
		this.prix_deal = prix_deal;
		this.prix_ini = prix_ini;
		this.date_debut = date_d;
		this.date_fin = date_f;
		this.localisation = loc;
		this.ref = ref;
	}
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix_ini() {
		return prix_ini;
	}
	public void setPrix_ini(float prix_ini) {
		this.prix_ini = prix_ini;
	}
	public float getPrix_deal() {
		return prix_deal;
	}
	public void setPrix_deal(float prix_deal) {
		this.prix_deal = prix_deal;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public Fournisseur getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Fournisseur localisation) {
		this.localisation = localisation;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	private boolean compareCategorie( String categorie) {
			return this.categorie.equals(categorie);
	}
	
	private String date() {
	    Date date = (Date) Calendar.getInstance().getTime();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    return sdf.format(date);
	}
	
	public boolean compareDate() {
		String currentDate[] = date().split("/");
		String endDate[] =this.date_fin.split("/");
		String beginDate[] = this.date_debut.split("/");
		boolean begin = false, end = false;
		
		if(toInt(currentDate[2]) > toInt(beginDate[2]))
			begin = true;
		else if(toInt(currentDate[2]) == toInt(beginDate[2]) && toInt(currentDate[1]) > toInt(beginDate[1]))
			begin = true;
		else if(toInt(currentDate[2]) == toInt(beginDate[2]) && toInt(currentDate[1]) == toInt(beginDate[1]) && toInt(currentDate[0]) >= toInt(beginDate[0]))
			begin = true;
		else
			begin = false;
		
		if(toInt(currentDate[2]) < toInt(endDate[2]) )
			end = true;
		else if(toInt(currentDate[2]) == toInt(endDate[2]) && toInt(currentDate[1]) < toInt(endDate[1]))
			end = true;
		else if(toInt(currentDate[2]) == toInt(endDate[2]) && toInt(currentDate[1]) == toInt(endDate[1]) && toInt(currentDate[0]) <= toInt(endDate[0]))
			end = true;
		else
			end = false;
		
		return (begin && end);
			
	}
	
	private int toInt(String temp) {
		return Integer.parseInt(temp);
	}
	
	public boolean compareDeal(String categorie) {
		return (compareCategorie(categorie) && compareDate());
	}

}
