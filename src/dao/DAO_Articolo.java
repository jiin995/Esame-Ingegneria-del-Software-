package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import corebusiness.articoli.*;
import corebusiness.oggettiCelesti.*;
import corebusiness.Exception.ArticoloNotFound;
import corebusiness.Exception.OggettoCelesteNotFound;

public class DAO_Articolo {
	
	public static Articolo create(int id,String titolo,String corpo,OggettoCeleste ogg) throws SQLException{
		
		Connection c = DBManager.getConnection();
			PreparedStatement stat=c.prepareStatement("INSERT INTO ARTICOLI (ID_ARTICOLO,TITOLO,CORPO,OGGETTOCELESTE) VALUES (?,?,?,?)");
				stat.setInt(1,id);
				stat.setString(2, titolo);
				stat.setString(3,corpo);
				stat.setInt(3, ogg.getIdOggetto());			
			Articolo newArticolo=new Articolo(id,titolo,corpo,ogg);
	    return newArticolo;
	}
	
	public static void update(Articolo Art) throws SQLException,ArticoloNotFound {
	
		Integer id=Art.getIdArticolo();
		boolean rowaffected=false;
		
		if(id != null){
			Connection c = DBManager.getConnection();
			PreparedStatement stat = c.prepareStatement("UPDATE ARTICOLI SET TITOLO=?, OGGETTO=?, CORPO=?");
				stat.setString(1,Art.getTitolo());
				stat.setInt(2,(Art.getOggetto()).getIdOggetto());
				stat.setString(3, Art.getCorpo());
			rowaffected=stat.execute();
			stat.close();
			c.close();
		}
		if(!rowaffected)
			throw new ArticoloNotFound();
	}
	
	
	public static void delete (Articolo Art) throws SQLException
		{
			Connection c = DBManager.getConnection();
			PreparedStatement stat = c.prepareStatement("DELETE FROM ARTICOLI WHERE ID_ARTICOLO=?");
				stat.setInt(1, Art.getIdArticolo());
			stat.executeUpdate();
			stat.close();
			c.close();
		}
	
	
	@SuppressWarnings("unused")
	public static Articolo read(int id) throws ArticoloNotFound
		{
		
			Integer Id= id;
			Articolo Art=null;
			OggettoCeleste ogg=null;
		
			if(Id != null)
				{
					try{
							Connection c = DBManager.getConnection();
							PreparedStatement stat = c.prepareStatement("SELECT * FROM ARTICOLI WHERE ID_ARTICOLO=?");
								stat.setInt(1,id);
							ResultSet res=stat.executeQuery();
							if(res.first()){
								if(!res.wasNull()){
									try{
										ogg = DAO_Oggetto.read(res.getInt("OGGETTO"));
									}
									catch(OggettoCelesteNotFound o){
										o.getMessage();
									}							
									Art = new Articolo(res.getInt("ID_ARTICOLO"),res.getString("TITOLO"),res.getString("CORPO"),ogg,res.getInt("NLIKE"),res.getInt("NDISLIKE"),res.getDate("DATA"));
								}
							}
							else
								throw new ArticoloNotFound();
							res.close();
							c.close();
					}
				
					catch(SQLException e){
						System.out.println(e.getMessage());
					}
				}
			else
				throw new ArticoloNotFound();
		
		return Art;
	}
	
	
	public static ArrayList<Articolo> readAll () throws SQLException,ArticoloNotFound
	{
		ArrayList<Articolo> listaArticoli= new ArrayList<Articolo>();
		OggettoCeleste ogg=null;

		Connection c = DBManager.getConnection();
		Statement stat = c.createStatement();
		
		ResultSet res=stat.executeQuery("SELECT * FROM ARTICOLI");;
		
		if(res.first())
			do{
					try{
						ogg = DAO_Oggetto.read(res.getInt("OGGETTO"));
					}
					catch(OggettoCelesteNotFound o){
						o.getMessage();
					}	
					listaArticoli.add(new Articolo(res.getInt("ID_ARTICOLO"),res.getString("TITOLO"),res.getString("CORPO"),ogg,res.getInt("NLIKE"),res.getInt("NDISLIKE"),res.getDate("DATA")));
			}while(res.next());
		else
			throw new ArticoloNotFound();
		
		stat.close();
		res.close();
		return listaArticoli;
	}
	
}// END CLASS DOA_ARTICOLO
