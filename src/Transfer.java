
public class Transfer {

	private Racun sourceAcc;
	private Racun targetAcc;
	private double iznosTransfera;
	
	Transfer(){
		
	}
	
	Transfer(Racun sourceAcc, Racun targetAcc,double iznosTransfera){
		this.sourceAcc = sourceAcc;
		this.targetAcc = targetAcc;
		this.iznosTransfera = iznosTransfera;
	}
	
	

	public Racun getSourceAcc() {
		return sourceAcc;
	}

	public void setSourceAcc(Racun sourceAcc) {
		this.sourceAcc = sourceAcc;
	}

	public Racun getTargetAcc() {
		return targetAcc;
	}

	public void setTargetAcc(Racun targetAcc) {
		this.targetAcc = targetAcc;
	}

	public double getIznosTransfera() {
		return iznosTransfera;
	}

	public void setIznosTransfera(double iznosTransfera) {
		this.iznosTransfera = iznosTransfera;
	}
	
	
}
