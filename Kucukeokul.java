
public class Kucukeokul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		int not1 = 50 ;
		int not2 = 48  ; 
		int ortalama = (not1+not2) /2 ; 
		if (ortalama > 50) 
			System.out.println("Dersi Ge�ti") ; 
		else if (ortalama < 50) {
			System.out.println("Dersi Ge�emedi") ; }
			else if (ortalama == 50) {
				System.out.println("S�n�rda") ;
				
			}
			
		if (ortalama >= 85) {
			System.out.println("Takdir Belgesi") ;
		}
		else if (ortalama >= 70 ) {
			System.out.println("Te�ekk�r Belgesi") ;
		}
		else if (ortalama >= 50 ) {
			System.out.println("Belge Alamad�") ;
		
		}
		else if (ortalama <= 50) {
			System.out.println("S�n�fta kald�") ;
		}
		
	}

}
