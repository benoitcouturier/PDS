import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//ATTENTION : il ne faut pas oublier le "COMMIT;" dans SQLDevelopper pour
		// laisser Java (la 2ème Session) de lire et modifier la BD lors des reqûetes.
		//Pas besoin de faire de COMMIT dans les requêtes Java, c'est fais automatiquement
		
		Scanner sc = new Scanner(System.in);
		Database db = new Database();
		
		while(true) {
			String input = sc.nextLine();
			
			try {
				print(db.request(input));
				
			}catch(SQLSyntaxErrorException e) {
				if(input.toUpperCase().indexOf("STOP") == 0) {
					System.out.println("Connexion interrompue");
					break;
				}
				System.out.println("Erreur de rédaction de la requête \n");
			}
			catch(SQLException e) {
				System.out.println("Erreur de connexion...");
				e.printStackTrace();
			}
		}
	}

	public static void print(Table table) {
		if (table == null)
			 System.out.println("\nLa commande a bien été éffectué");
		else {
			String format = "";
			String[] entete = table.get(0);
			int[] t = new int[5];
			String etoile = "*";
			String tiret = "-";
			for(int i = 0; i < entete.length-1; i++)
				format = format + " %-"+table.getSize()[i]+"s |";
			format = format + " %-"+table.getSize()[entete.length-1]+"s ";
			for(int i = 0; i < entete.length; i++)
				t[i] = i;
			for(int i = entete.length; i < t.length; i++)
				t[i] = entete.length - 1;
			for(int i = 0; i < table.getSize().length; i++) {
				etoile = etoile + "***";
				tiret = tiret + "---";
				for(int j = 0; j < table.getSize()[i]; j++) {
					etoile = etoile + "*";
					tiret = tiret + "-";
				}
			}
			System.out.println("\n" + etoile);
			System.out.format("*"+format+"*\n",entete[t[0]], entete[t[1]], entete[t[2]], entete[t[3]], entete[t[4]]);
		    System.out.println(etoile);
			for (int i = 1; i < table.size(); i ++) {
				String[] ligne = table.get(i);
				System.out.format("|"+format+"|\n",ligne[t[0]], ligne[t[1]], ligne[t[2]], ligne[t[3]], ligne[t[4]]);
				System.out.println(tiret);
			}
		}
	}
}
