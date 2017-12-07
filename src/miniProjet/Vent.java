package miniProjet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Vent {

	private String date_achat;
	private Deal deal;
	private Client client;
	private int quantite;
	private float total;
	
	public Vent() {
		this.date_achat = "";
		this.deal = new Deal();
		this.client = new Client();
		this.quantite = 0;
		this.total = 0;
	}
	
	public Vent(Client c, Deal d, int q) {
		this.date_achat = date();
		this.deal = d;
		this.client = c;
		this.quantite = q;
		this.total = q*d.getPrix_deal();
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getDate_achat() {
		return date_achat;
	}
	public void setDate_achat(String date_achat) {
		this.date_achat = date_achat;
	}
	public Deal getDeal() {
		return deal;
	}
	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	private String date() {
	    Date date = (Date) Calendar.getInstance().getTime();
	    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	    return sdf.format(date);
	}
	
}
