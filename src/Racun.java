
public class Racun {

	private int brojRacuna;
	private String imeKorisnika;
	private double iznos;
	
	Racun(){
		
	}
	
	Racun(int brojRacuna, String imeKorisnika, double iznos){
		this.brojRacuna = brojRacuna;
		this.imeKorisnika = imeKorisnika;
		this.iznos = iznos;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	@Override
	public String toString() {
		return "Racun [brojRacuna=" + brojRacuna + ", imeKorisnika="
				+ imeKorisnika + ", iznos=" + iznos + "]";
	}
	
	
}
