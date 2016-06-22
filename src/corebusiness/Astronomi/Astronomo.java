package corebusiness.Astronomi;

import java.util.Date;

public class Astronomo {
	
	@SuppressWarnings("unused")
	private int idAstronomo;
	
	@SuppressWarnings("unused")
	private String nome;
	
	@SuppressWarnings("unused")
	private String cognome;
	
	@SuppressWarnings("unused")
	private Date dataNascita;
	
	@SuppressWarnings("unused")
	private String titolo;
	
	@SuppressWarnings("unused")
	private String professione;	
	
	@SuppressWarnings("unused")
	private String email;
	
	@SuppressWarnings("unused")
	private String descizionePersonale;

	@SuppressWarnings("unused")
	private String password;

	@SuppressWarnings("unused")
	private Date DataRegistrazione;
	
	public  Astronomo (int id,String nome,String cognome){
		this.idAstronomo=id;
		this.nome=nome;
		this.cognome=cognome;
		
	}

}
