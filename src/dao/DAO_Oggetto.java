package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import corebusiness.Exception.*;
import corebusiness.oggettiCelesti.*;

public class DAO_Oggetto {
	
	public static OggettoCeleste create(int id,String nome,String tipo) throws BadType,SQLException
		{
			OggettoCeleste ogg=null;
			
			try{
				 	ogg = new OggettoCeleste(id,nome,tipo);
				 	Connection c = DBManager.getConnection();
				 		PreparedStatement stat = c.prepareStatement("INSERT INTO OGGETTICELESTI (ID_OGGETTO,NOME,TIPO) VALUES(?,?,?)");
				 			stat.setInt(1, id);
				 			stat.setString(2, nome);
				 			stat.setString(3, tipo);
				 			stat.executeUpdate();
				 		stat.close();
			}
			
			catch(BadType b)
				{
					b.printErrorMessage();
				}
			
			catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			return ogg;
		}
	
	
	public static OggettoCeleste read(Integer id) throws OggettoCelesteNotFound
		{
			OggettoCeleste ogg=null;

			if(id==null)
				throw new OggettoCelesteNotFound();
			else
				{
					try
						{
							Connection c = DBManager.getConnection();
							PreparedStatement stat = c.prepareStatement("SELECT * FROM OGGETTICELESTI WHERE ID_OGGETTO=?");
								stat.setInt(1,id);
							ResultSet res = stat.executeQuery();
							if(res.first()){
								if(!res.wasNull())
									ogg= new OggettoCeleste(res.getInt("ID_OGGETTO"),res.getString("NOME"),res.getString("TIPO"));
							}
							else
								throw new OggettoCelesteNotFound();
							res.close();
							stat.close();
						}
					
					catch(BadType b)
						{
							b.printErrorMessage();
						}
					
					catch (SQLException e)
						{
							System.out.println(e.getMessage());
						}
				}
			return ogg;
		}

	
	public static void update (OggettoCeleste Ogg) throws SQLException,OggettoCelesteNotFound
		{
			Integer id=Ogg.getIdOggetto();
			boolean rowaffected=false ;
			
			if(id != null)
				{
					Connection c = DBManager.getConnection();
					PreparedStatement stat = c.prepareStatement("UPDATE OGGETTICELESTI SET NOME=?,TIPO=?");
						stat.setString(1,Ogg.getName());
						stat.setString(2, Ogg.ottieniTipo());
						rowaffected=stat.execute();
						stat.close();
					c.close();
				}
			if(!rowaffected)
			{
					throw new OggettoCelesteNotFound();
			}
		
		}
	
	public static void delete (OggettoCeleste Ogg) throws SQLException
		{
			Connection c = DBManager.getConnection();
			PreparedStatement stat = c.prepareStatement("DELETE FROM OGGETTICELESTI WHERE ID_OGGETTO=?");
					stat.setInt(1, Ogg.getIdOggetto());
			stat.executeUpdate();
			stat.close();
			c.close();
			
		}
	
	public static ArrayList<OggettoCeleste> readAll () throws SQLException
		{
			ArrayList<OggettoCeleste> listaOggetti= new ArrayList<OggettoCeleste>();

			Connection c = DBManager.getConnection();
			PreparedStatement stat = c.prepareStatement("SELECT * FROM OGGETTICELESTI ");
			
			ResultSet res=stat.executeQuery();
			
			while(res.next()){
					try{
						listaOggetti.add(new OggettoCeleste(res.getInt("ID_OGGETTO"),res.getString("NOME"),res.getString("TIPO")));
					}
			
					catch(BadType b){
						b.getMessage();
					}
			}
			
			stat.close();
			res.close();
			return listaOggetti;
		}

}//END CLASS DAO_OGGETTO
