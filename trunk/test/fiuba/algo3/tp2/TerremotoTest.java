package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class TerremotoTest {
	
	@Test
	public void TerremotoDeberiaDestruirPorCompletoLaConstruccionEnElEpicentro(){
		Mapa unMapa = new Mapa();
		Terremoto unTerremoto = new Terremoto();
		Construccion casa = new Casa();
		
		unMapa.insertarConstruccionEn(5, 5, casa);
		unTerremoto.iniciarTerremotoEn(5, 5, unMapa);
		
		Assert.assertEquals(0.0, unMapa.obtenerVidaDeConstruccionEnLote(5,5));

	}
	
	@Test
	public void TerremotoDeberiaDestruirParcialmenteConstruccionesVecinasPorUnFactorDeDistancia(){
		Mapa unMapa = new Mapa();
		Terremoto unTerremoto = new Terremoto();
		Construccion unaCasa = new Casa();
		Construccion ultimaCasa = new Casa();
		
		unMapa.insertarConstruccionEn(3, 5, unaCasa); //Distancia de 2 lotes entonces vida decrementa por 100-(1.5x2)=97
		unMapa.insertarConstruccionEn(4, 2, ultimaCasa); //sqrt(1+9)=3.16 entonces la vida decrementa por 100-(1.5x3)=95.5
		unTerremoto.iniciarTerremotoEn(5, 5, unMapa);
		
		Assert.assertEquals(100.0-97.0, unMapa.obtenerVidaDeConstruccionEnLote(3,5));
		Assert.assertEquals(100.0-95.5, unMapa.obtenerVidaDeConstruccionEnLote(4, 2));
	}
}
