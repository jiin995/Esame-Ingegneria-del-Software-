package corebusiness.articoli;

import java.util.ArrayList;
import java.util.Date;
import dao.DAO_Articolo;
import java.sql.SQLException;

import corebusiness.oggettiCelesti.*;
import corebusiness.Astronomi.Astronomo;
import corebusiness.Exception.ArticoloNotFound;

public class GestoreArticoli implements IGestoreArticoli {
	
	private static GestoreArticoli istance;
	
	protected GestoreArticoli(){};

	public void inserisciArticolo(int id,String titolo,String corpo,Date data,Astronomo A){}
	
	public void eliminaArticolo(Articolo A){}
	
	public void modificaArticolo(Articolo A){}
	
	public void gestisciLikeDislike(Articolo A){}

	public ArrayList<Articolo> ricercaArticoli(String titoloRic,String tipoOggRic){
		
		ArrayList<Articolo> listaArticoliRic = new ArrayList<Articolo>();
		boolean aggiunto=false;
		int i=0;
		Articolo a=null;
		if((!titoloRic.isEmpty())||(!tipoOggRic.isEmpty())){
			try{
				ArrayList<Articolo> listaArticoli = DAO_Articolo.readAll();
				while(i<listaArticoli.size())
					{
						a=listaArticoli.get(i);
						if(!titoloRic.isEmpty())
							{
								if(a.getTitolo().equals(titoloRic))
									{
										listaArticoliRic.add(a);
										aggiunto=true;
									}	
							}
						if((!aggiunto)&&(!tipoOggRic.isEmpty()))
							{
								OggettoCeleste o = listaArticoli.get(i).getOggetto();
									if(o.ottieniTipo().equals(tipoOggRic))
										{
											listaArticoliRic.add(a);
										}
								
							}
						i++;
						aggiunto=false;
					}
			}
			catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			catch (ArticoloNotFound e){
				e.printErrorMessage();
			}
		}
		return listaArticoliRic;		
	}
	
	
	public ArrayList<Articolo> listaArticoli(){
		
		ArrayList<Articolo> listaArticoli=null;
		
		try{
			listaArticoli=DAO_Articolo.readAll();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			
		}
		
		catch(ArticoloNotFound e){
			e.printErrorMessage();
		}
		
		return listaArticoli;
	}
	
	public ArrayList<String> listaTitoli(){
		
		int i=0;
		ArrayList<String> listaTitoli=new ArrayList<String>();
		ArrayList<Articolo> listaArticoli=this.listaArticoli();
		while(i<listaArticoli.size()){
			listaTitoli.add(listaArticoli.get(i).getTitolo());
			i++;
		}
		
		return listaTitoli;
	}
	
	public static GestoreArticoli getistance(){
		if (istance == null) {
			GestoreArticoli.istance = new GestoreArticoli();
		}
		return istance;
	}

}
