package corebusiness.Exception;

public class BadType extends Exception  {
	
	private static final long serialVersionUID = 2366899017590604235L;
	
	public void printErrorMessage(){
		System.out.println("Tipo Oggetto Celeste Errato");
	}
}
