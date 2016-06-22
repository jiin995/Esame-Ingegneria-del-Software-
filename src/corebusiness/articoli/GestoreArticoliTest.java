package corebusiness.articoli;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;

public class GestoreArticoliTest {
	
	 static GestoreArticoli gestore;
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			gestore=new GestoreArticoli();
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			gestore=null;
		}

		@Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}

		//TC=1
		@Test
		public final void ricercaArtNotPresente() {
			assertTrue(gestore.ricercaArticoli("LUNA", "").size()==0);
		}
		
		//TC=2
		@Test
		public final void ricercaTipoOggInvalid() {
			assertTrue(gestore.ricercaArticoli("","stellina").size()==0);
		}
		
		//TC=3
		@Test
		public final void ricercaArtNull()  {
			assertTrue(gestore.ricercaArticoli("", "").size()==0);
		}
		
		//TC=4
		@Test
		public final void ricercaArtPresent() {
			ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
			listaArticoli=gestore.ricercaArticoli("LUNA E SOLE", "");
			assertTrue((listaArticoli.size()==1)&&(listaArticoli.get(0).getTitolo().equals("LUNA E SOLE")));
		}
		
		//TC=5
		@Test
		public final void ricercaTipoOggValido() {
			ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
			listaArticoli=gestore.ricercaArticoli("","STELLA");
			boolean good=false;
			for (int i=0;i<listaArticoli.size();i++)
				{
					if(listaArticoli.get(i).getOggetto().ottieniTipo().equals("STELLA"))
						good=true;
					else
						good=false;
				}
			assertTrue((listaArticoli.size()>0)&&(good));
		}
		
		//TC=5
		@Test
		public final void ricercaArticoloPresTipoOggValido() {
			ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
			listaArticoli=gestore.ricercaArticoli("M32","PIANETA");
			boolean good=false;
			for (int i=0;i<listaArticoli.size();i++)
				{
					if(listaArticoli.get(i).getOggetto().ottieniTipo().equals("PIANETA"))
						good=true;
					else
						if(!listaArticoli.get(i).getTitolo().equals("M32"))
							good=false;
				}
					assertTrue((listaArticoli.size()>0)&&(good));
		}
		
		
}
