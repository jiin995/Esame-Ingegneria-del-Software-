package corebusiness.oggettiCelesti;

import corebusiness.Exception.BadType;

public class OggettoCeleste {
	
	private int idOggetto;
	private String name;
	private String tipo;
	
	public OggettoCeleste(int id,String name,String tipo) throws BadType
		{
			if(checkTipo(tipo))
				{
					this.idOggetto=id;
					this.name=name;
					this.tipo=tipo;
				}
			else
				throw new BadType();
		}
			
	
	public boolean checkTipo(String tipo) 
	{
		switch(tipo)
			{
				case "SISTEMA STELLARE" : return true;
				case "STELLA" : return true;
				case "SISTEMA PLANETARIO" : return true;
				case "PIANETA" : return true;
				case "GALASSIA" : return true;
				default : return false;
				
			}
	
	}
	
	public String ottieniTipo(){
		return tipo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdOggetto() {
		return idOggetto;
	}
	
	
}


