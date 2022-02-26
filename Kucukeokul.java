
public class Kucukeokul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		int not1 = 50 ;
		int not2 = 48  ; 
		int ortalama = (not1+not2) /2 ; 
		if (ortalama > 50) 
			System.out.println("Dersi Geçti") ; 
		else if (ortalama < 50) {
			System.out.println("Dersi Geçemedi") ; }
			else if (ortalama == 50) {
				System.out.println("Sýnýrda") ;
				
			}
			
		if (ortalama >= 85) {
			System.out.println("Takdir Belgesi") ;
		}
		else if (ortalama >= 70 ) {
			System.out.println("Teþekkür Belgesi") ;
		}
		else if (ortalama >= 50 ) {
			System.out.println("Belge Alamadý") ;
		
		}
		else if (ortalama <= 50) {
			System.out.println("Sýnýfta kaldý") ;
		}
		
	}

}
