package corebusiness.Exception;

public class OggettoCelesteNotFound extends Exception {
	
	private static final long serialVersionUID=32221233L;
	
	public void printErrorMessage(){
		System.out.println("Oggetto Celeste non trovato");
	}

}
