package corebusiness.Exception;

public class ArticoloNotFound extends Exception{

		
		private static final long serialVersionUID = 232683017590604235L;
		
		public void printErrorMessage(){
			System.out.println(" Articolo non trovato");
		}
		
}

