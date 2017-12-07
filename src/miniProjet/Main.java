package miniProjet;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client client[] = new Client[100];
		Deal deals[] = new Deal[100];
		Fournisseur fournisseur[] = new Fournisseur[100];
		Vent vent[] = new Vent[100];
		
		int clientCount = 0, dealsCount = 0, fourCount = 0, ventCount = 0;
		
		int choice = 0;
		
		print("\tInstitut Supérieur de gestion de Sousse (ISGS)");
		print("\t    Mini Projet POO Annee 2017-2018\n\t\t  Gestion des Deals\n");
		
		do {

			print("1-Cree un Client.\n2-Cree un Deal.\n3-Cree un Fournisseur.\n4-Faire un Vent.\n5-Liste des Clients par Deal.\n6-Liste des Deals d’un Client.\n7-Rechercher un Client.\n8-Rechercher les deals.\n9-Quit.");
			do {
				System.out.print(">>>");
				try {
					choice = Integer.parseInt(s.nextLine());
				}
				catch (NumberFormatException e) {
					print("Invalid input, Only number are allowed.");
				}
				if(choice >9 || choice <= 0)
					print("Invalid input!");
			}while(choice > 9 || choice <= 0);
			
			if(choice == 9)
				print("Thank you.");
			else {				
				switch(choice) {
					case 1:
						client[clientCount] = createClient();
						if(client[clientCount] != null) {
							clientCount++;
							print("Client was successfully created :)");
						}
						else 
							print("Something happened, Couldn't create Client");
						
						print("\n");
						break;
						
					case 2:
							Deal d = new Deal();
							d = createDeal(fourCount, fournisseur);
							deals[dealsCount] = d;
							if(deals[dealsCount] != null) {
								dealsCount++;
								print("Deal was successfully created :)");
							}
							else 
								print("Something happened, Couldn't create Deal");
							
							print("\n");
							break;
							
					case 3:
						fournisseur[fourCount] = createFour();
						if(fournisseur[fourCount] != null) {
							fourCount++;
							print("Fournisseur was successfully created :)");
						}
						else 
							print("Something happened, Couldn't create Deal");
						
						print("\n");
						break;
						
					case 4:
						if(dealsCount == 0 || clientCount ==0) {
							print("Clients and Deals are required to create a sell.");
						}
						else {
							vent[ventCount] = createVent(client, deals, clientCount, dealsCount);
							if(vent[ventCount] != null) {
								ventCount++;
								print("Vent was successfully :)");
								print("Total to be paid: "+vent[ventCount-1].getTotal()+"dt");
							}
							else 
								print("Something happened, Couldn't create Vent.");
						}
						
						print("\n");
						break;
						
					case 5:
						listClients(deals, vent, dealsCount, ventCount);
						
						print("\n");
						break;
						
					case 6:
						listDeals(client, vent, clientCount, ventCount);
						
						print("\n");
						break;
						
					case 7:
						searchClient(clientCount, client);
						break;
						
					case 8:
						print("Deal Search");
						System.out.print("Enter deal categorie: ");
						String categorie = s.nextLine();
						
						print("Valid Deals in: "+categorie);
						for(int i=0; i<dealsCount; i++) {
							if(deals[i].compareDeal(categorie)) {
								printDeal(deals[i]);
							}
						}
						print("\n");
						break;
				}
			}

		}
		while(choice != 9);
		
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	static void print(String s) {
		System.out.println(s);
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	static boolean checkEmail(String email) {
		String regex =
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		
		return pattern.matcher(email).matches();
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	static boolean checkTel(String tel) {
		return tel.matches("[0-9]{2}-[0-9]{3}-[0-9]{3}");
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	static void printClient(Client client) {
		print("Client Found:");
		print("Name: "+client.getNom()+" "+client.getPrenom());
		print("Email: "+client.getEmail());
		print("Phone-Number: "+client.getTel());
		print("Cin Number: "+client.getCin());
		print("\n");
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	static void printDeal(Deal deal) {
		print("Description: "+deal.getDescription());
		print("Price: "+deal.getPrix_deal());
		print("End Date: "+deal.getDate_fin());
		print("Fournisseur: "+deal.getLocalisation().getNom());
		print("\n");
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	public static boolean checkCategorie(String categorie) {
		
		if(categorie.compareToIgnoreCase("spa") == 0)
			return true;
		else if(categorie.compareToIgnoreCase("restauration") == 0)
			return true;
		else if(categorie.compareToIgnoreCase("hotel") == 0)
			return true;
		else 
			return false;
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	public static boolean checkDate(String date) {
		if(date.matches("[0-3][1-9]/[0-1][1-9]/20[0-9][0-9]"))
			return true;
		else 
			return false;
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	public static boolean checkDates(String date_d, String date_f) {
		String d[] = date_d.split("/"), f[] = date_f.split("/");
		
		if(toInt(f[2]) > toInt(d[2]))
			return true;
		else if(toInt(f[2]) == toInt(d[2]) && toInt(f[1]) > toInt(d[1]))
			return true;
		else if(toInt(f[2]) == toInt(d[2]) && toInt(f[1]) == toInt(d[1]) && toInt(f[0]) >= toInt(d[0]))
			return true;
		else
			return false;
	}
	
	static int toInt(String temp) {
		return Integer.parseInt(temp);
	}
	/* ------------------------------------------------------------------------------------------------ */
	
	
	public static Client createClient() {
		String nom, prenom, email, tel;
		int cin=0;
		
		print("Creating a Client:");
		System.out.print("enter your name: ");
		nom = s.nextLine();
		
		System.out.print("enter your prenom: ");
		prenom = s.nextLine();
		
		System.out.print("enter your email: ");
		do {
			email = s.nextLine();
		}while(!checkEmail(email));
		
		System.out.print("enter your phone number(Exemple:22-222-222) : ");
		do {
			tel = s.nextLine();
		}
		while(!checkTel(tel));
		
		System.out.print("enter your cin number: ");
		int l=0;
		do {
			String temp = s.nextLine();
			l = temp.length();
			if(l!=8)
				print("Invalid Cin Number!");
			else
				cin = Integer.parseInt(temp);
		}while(l!=8);
		
		Client c = new Client(nom, prenom, email, tel, cin);
		
		return c;
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	public static Deal createDeal(int fourCount, Fournisseur fournisseur[]) {
		String nom, categorie, description, date_d, date_f, code;
		float prix_i, prix_d;
		
		if(fourCount == 0) {
			print("You need to create a Fournisseur before creating a Deal.");
			return null;
		}
		else {
			print("Creating a Deal:");
			System.out.print("enter your Categorie(Spa, Restauration, Hotel): ");
			do {
				categorie = s.nextLine();
				if(!checkCategorie(categorie))
					print("Invalid Categorie!");
			}
			while(!checkCategorie(categorie));
			
			
			System.out.print("enter your Description: ");
			description = s.nextLine();
			
			System.out.print("enter your prix initial: ");
			prix_i = Float.parseFloat(s.nextLine());
			
			System.out.print("enter your prix de deal: ");
			prix_d = Float.parseFloat(s.nextLine());
			
			System.out.print("enter your date de debut: ");
			do {
				date_d = s.nextLine();
				if(!checkDate(date_d))
					print("Invalid date!");
			}
			while(!checkDate(date_d));
			
			System.out.print("enter your date de fin: ");
			do {
				date_f = s.nextLine();
				if(!(checkDate(date_f) && checkDates(date_d, date_f)))
					print("Invalid date!");
			}
			while(!(checkDate(date_f) && checkDates(date_d, date_f)));
			
			System.out.print("enter your nom de Fournisseur or Ref: ");
			int l = -1;
			do {
				nom = s.nextLine();
				for(int i=0; i<fourCount; i++) {
					if(fournisseur[i].lookupFour(nom)) {
						l = i;
						break;
					}
						
				}
			}
			while(l==-1);
			
			System.out.print("enter your Deal reference: ");
			code = s.nextLine();
			
			Deal deal = new Deal(categorie, description, prix_i, prix_d, date_d, date_f, fournisseur[l], code);
			
			return deal;

		}
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	static Fournisseur createFour() {
		String nom, address, tel, email, hor_t, ref;
		
		print("Creating a Fournisseur:");
		System.out.print("enter your name: ");
		nom = s.nextLine();
		
		System.out.print("enter your address: ");
		address = s.nextLine();
		
		System.out.print("enter your phone number(Exemple:22-222-222) : ");
		do {
			tel = s.nextLine();
		}
		while(!checkTel(tel));
		
		System.out.print("enter your email: ");
		do {
			email = s.nextLine();
		}while(!checkEmail(email));
		
		System.out.print("enter the horaires de travail: ");
		hor_t = s.nextLine();
		
		System.out.print("enter the ref: ");
		ref = s.nextLine();
		
		Fournisseur f = new Fournisseur(nom,  address, tel, email, hor_t, ref);
		return f;
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	
	public static void searchClient(int clientCount, Client client[]) {
		print("recherche de Client:\n1-To enter Client cin.\n2-To enter Client phone number.");
		int c=0;
		do {
			c = Integer.parseInt(s.nextLine());
			if(c!=1 && c!=2)
				print("Invalid Cin Number!");
				
		}while(c!=1 && c!=2);
		
		switch(c) {
			case 1:
				System.out.print("Enter cin number: ");
				int cin = Integer.parseInt(s.nextLine());
				int found = -1;
				for(int i=0; i<clientCount; i++) {
					if(client[i].search(cin))
						found = i;
				}
				
				if(found != -1) {
					printClient(client[found]);
				}
				else
					print("Didn't find any Client with this cin: "+cin);
				print("\n");
				
				break;
			case 2:
				System.out.print("Enter Phone number: ");
				String tel;
				do {
					tel = s.nextLine();
				}
				while(!checkTel(tel));
				
				found = -1;
				for(int i=0; i<clientCount; i++) {
					if(client[i].search(tel))
						found = i;
				}
				
				if(found != -1) {
					printClient(client[found]);
				}
				else
					print("Didn't find any Client with this Phone Number: "+tel);
				print("\n");
				
				break;
		}
	}
	
	/* ------------------------------------------------------------------------------------------------ */
	
	static Vent createVent(Client client[], Deal deals[], int clientCount, int dealsCount) {
		String dref;
		int check = -1, cin=0, q = 0;
		Client c = new Client();
		Deal d = new Deal();
		Vent v = new Vent();
		
		print("faire une vente");
		
		System.out.print("Enter Deal Ref: ");
		do {
			dref = s.nextLine();
			for(int i=0; i<dealsCount; i++) {
				if(deals[i].getRef().equals(dref)) {
					check = i;
					break;
				}
			}
			if(check == -1)
				print("Deal not found!");
			else {
				if(!deals[check].compareDate()){
					print("Deal already passed.");
					check = -1;
				}	
			}
		}while(check==-1);
		d = deals[check];
		
		
		check = -1;
		System.out.print("Enter Client cin: ");
		do {
			cin = Integer.parseInt(s.nextLine());
			for(int i=0; i<clientCount; i++) {
				if(client[i].search(cin)) {
					check = i;
					break;
				}
			}
			if(check == -1)
				print("Client not found!");
		}while(check==-1);
		c = client[check];
		
		System.out.print("Enter the quantity: ");
		do {
			q = Integer.parseInt(s.nextLine());
		}while(q <= 0);
		
		v = new Vent(c, d, q);
		return v;
	}
	

	/* ------------------------------------------------------------------------------------------------ */
	
	static void listDeals(Client client[], Vent vent[], int clientCount, int ventCount) {
		int cin;
		Client c = new Client();
		
		print("Listing Deals of Client.");
		
		int check = -1;
		System.out.print("Enter Client cin: ");
		do {
			cin = Integer.parseInt(s.nextLine());
			for(int i=0; i<clientCount; i++) {
				if(client[i].search(cin)) {
					check = i;
					break;
				}
			}
			if(check == -1)
				print("Client not found!");
		}while(check==-1);
		c = client[check];
		
		print("Clinet "+c.getNom()+" Deals:");
		for(int i=0; i<ventCount; i++) {
			if(vent[i].getClient().equals(c))
				printDeal(vent[i].getDeal());
		}
	}

	
	/* ------------------------------------------------------------------------------------------------ */
	
	static void listClients(Deal deals[], Vent vent[], int dealsCount, int ventCount) {
		String ref;
		int check = -1;
		Deal d = new Deal();
		
		print("Listing Clients from Deals.");
		
		System.out.print("Enter Deal Ref: ");
		do {
			ref = s.nextLine();
			for(int i=0; i<dealsCount; i++) {
				if(deals[i].getRef().compareToIgnoreCase(ref) == 0) {
					check = i;
					break;
				}
			}
			if(check == -1)
				print("Deal not found!");
		}while(check == -1);
		d = deals[check];
		
		print("Deal Ref"+d.getRef()+" Clients:");
		for(int i=0; i<ventCount; i++) {
			if(vent[i].getDeal().equals(d))
				printClient(vent[i].getClient());
		}
	}

	
	/* ------------------------------------------------------------------------------------------------ */
	
	
}
