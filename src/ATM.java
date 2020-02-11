import java.util.ArrayList;


public class ATM {

	 ArrayList<Racun> racuni = new ArrayList<>();
	
	ATM(){
		
	}
	
	public int provjeraBrojaRacuna(int brojRacuna) {
		for (Racun e : racuni) {
			if (e.getBrojRacuna() == brojRacuna) {
				return 1;
			}
		}
		return 0;
	}

	public void prebaciNovac(int izvorni, int ciljani, double iznos) {
		for (Racun e : racuni) {
			if (e.getBrojRacuna() == izvorni) {
				e.setIznos(e.getIznos() - iznos);
			}
		}
		for (Racun f : racuni) {
			if (f.getBrojRacuna() == ciljani) {
				f.setIznos(f.getIznos() + iznos);
			}
		}
	}
}
