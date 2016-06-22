package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

import corebusiness.articoli.*; 

public class UIVisitatore {
	
	private static String tipiOg[]={"STELLA","PIANETA","SISTEMA PLANETARIO","SISTEMA STELLARE","GALASSIA"};
	private static final int nTipi=5;
	
	private static UIVisitatore istance;
	
	protected UIVisitatore(){}
	
	public static UIVisitatore getIstance(){
		if(istance==null)
			istance= new UIVisitatore();
		return istance;
	}
	
	public void RicercaArticolo()
		{
        		
		 	String titoloRic=selezionaTitolo();
		 	String tipoOggRic=selezionaTipoOggetto();
		 	ArrayList<Articolo> listaArticoli=new ArrayList<Articolo>();
		 	
		 	if((!titoloRic.isEmpty())||(!tipoOggRic.isEmpty()))
		 		{
		 			GestoreArticoli gest = GestoreArticoli.getistance();
		 			listaArticoli=gest.ricercaArticoli(titoloRic, tipoOggRic);
				 	mostraListaArticoli(listaArticoli);
		 		}
		 	else{
		 		System.out.println("Impossibile eseguire la funzione parametri non validi");
		 	}
		}
	
	public String selezionaTitolo()
		{
			GestoreArticoli gest = GestoreArticoli.getistance();
			ArrayList<String> listaTitoli = gest.listaTitoli();
			System.out.println("0) Lascia il campo vuoto");
			mostraTitoli(listaTitoli);
			
			Integer sc=0;
			
			try{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				String input = bufferedReader.readLine();
				sc=Integer.parseInt(input);
			}
			
			catch(IOException d){
				System.out.println(d.getMessage());
			}
			if(sc==0){
				System.out.println("Hai scelto di lasciare il campo vuoto");
				return "";
			}
				else 
					if((sc<= (listaTitoli.size())))
						return listaTitoli.get(sc-1);			
					else{
						System.out.println("Scelta errata il campo titolo sarà lasciato vuoto");
						return "";
					}
		}
	
	public String selezionaTipoOggetto()
		{
			Integer sc=0;
		    
			System.out.println("0)Lascia il campo vuoto");
			mostraTipiOggetti();
			
			try{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				String input = bufferedReader.readLine();
				sc=Integer.parseInt(input);
				}
		
			catch(IOException d){
				System.out.println(d.getMessage());
			}
			if(sc==0){
				System.out.println("Hai scelto di lasciare il campo vuoto");
				return "";
			}
			else 
				if((sc<= nTipi))
					return tipiOg[sc-1];			
				else{
					System.out.println("Scelta errata il campo tipo Oggetto sarà lasciato vuoto");
					return "";
				}
		}
	
	private void  mostraTipiOggetti(){
		for(int i=0;i<nTipi;i++)
			{
				System.out.print(i+1);
				System.out.print(")  ");
				System.out.println(tipiOg[i]);
			}
	}
	
	private void mostraTitoli(ArrayList<String> listaTitolo)
		{
			for(int i=0;i<listaTitolo.size();i++)
				{
					System.out.print(i+1);
					System.out.print(")  ");
					System.out.println(listaTitolo.get(i));
				}
		}
	

	private void mostraListaArticoli(ArrayList<Articolo>listaArticoli){
		
		for(int i=0;i<listaArticoli.size();i++)
			{
				System.out.print("ID Articolo : ");
					System.out.println(listaArticoli.get(i).getIdArticolo());
					System.out.println();;
					
				System.out.print("Titolo Articolo : ");
					System.out.println(listaArticoli.get(i).getTitolo());
					System.out.println();

				System.out.print("Oggetto Celeste : ");
					System.out.println(listaArticoli.get(i).getOggetto().getName());
					System.out.println();

				System.out.print("Tipo Oggetto Celeste : ");
					System.out.println(listaArticoli.get(i).getOggetto().ottieniTipo());
					System.out.println();

				System.out.print("Corpo Articolo : ");
					System.out.println(listaArticoli.get(i).getCorpo());
					System.out.println();
							
			}
	}

}
