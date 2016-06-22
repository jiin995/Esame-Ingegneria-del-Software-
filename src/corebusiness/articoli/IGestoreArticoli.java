package corebusiness.articoli;


import corebusiness.Astronomi.*;
import java.util.Date;
import java.util.ArrayList;

public interface IGestoreArticoli {
	
	public void inserisciArticolo(int id,String titolo,String corpo,Date data,Astronomo A);
	
	public void eliminaArticolo(Articolo A);
	
	public void modificaArticolo(Articolo A);
	
	public ArrayList<Articolo> ricercaArticoli(String titoloRic,String tipoOggRic);
	
	public void gestisciLikeDislike(Articolo A);
	
	public ArrayList<Articolo> listaArticoli();
	
	public ArrayList<String> listaTitoli();
			
}
