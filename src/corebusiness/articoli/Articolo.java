package corebusiness.articoli;


import java.util.Date;

import corebusiness.oggettiCelesti.OggettoCeleste;

public class Articolo {
	
	private int idArticolo;
	private String titolo;
	private String corpo;
	private Date dataInserimento;
	private OggettoCeleste Oggetto;
	private int numeroLike=0;
	private int numeroDislike=0;
	
	public Articolo(int id,String titolo,String corpo,OggettoCeleste Ogg){
		
		this.corpo=corpo;
		this.idArticolo=id;
		this.titolo=titolo;
		this.Oggetto=Ogg;
		
	}
	
	public Articolo (int id,String titolo,String corpo,OggettoCeleste Ogg,int nlike,int ndislike,Date dat){
		
		this.corpo=corpo;
		this.idArticolo=id;
		this.titolo=titolo;
		this.Oggetto=Ogg;
		this.dataInserimento=dat;
		this.numeroLike=nlike;
		this.numeroDislike=ndislike;
		
	}
					
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public OggettoCeleste getOggetto() {
		return Oggetto;
	}
	public void setOggetto(OggettoCeleste oggetto) {
		Oggetto = oggetto;
	}
	public int getNumeroLike() {
		return numeroLike;
	}
	public void setNumeroLike(int numeroLike) {
		this.numeroLike = numeroLike;
	}
	public int getNumeroDislike() {
		return numeroDislike;
	}
	public void setNumeroDislike(int numeroDislike) {
		this.numeroDislike = numeroDislike;
	}
	public int getIdArticolo() {
		return idArticolo;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}


}
