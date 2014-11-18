package fiuba.algo3.tp2.Controlador;
import java.awt.Color;
import java.awt.Font;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.Vista.AlgoCityVista;

public class AlgoCityControlador {
	
	public Juego juego;
	public AlgoCityVista vista;
	
	public AlgoCityControlador(AlgoCityVista LaVista, Juego ElJuego){
		juego = ElJuego;
		vista = LaVista;
	}
	
	boolean ConstruyeCasa = false;
	boolean ConstruyeComercio = false;
	boolean ConstruyeIndustria = false;
	boolean ConstruyeCentralNuclear = false;
	boolean ConstruyeCentralEolica = false;
	boolean ConstruyeCentralMineral = false;
	boolean ConstruyePozoDeAgua = false;
	boolean ConstruyeTuberia = false;
	boolean ConstruyeLineaDeTension = false;
	boolean ConstruyeBomberos = false;
	boolean ConstruyeRuta = false;
	
	
	
	public void actualizarSuperficie(){
		Lote loteTemp;
		String stringTemp;
		Color colorMarron = new Color(130,50,0);
		Color colorAzul = new Color(0,153,255);
		Color colorBlanco = new Color(255,255,255);
		Color colorGris = new Color(100,100,100);
		
		for (int i = 0; i<juego.elMapa.obtenerTamanioLado(); i++){
			for (int j = 0; j<juego.elMapa.obtenerTamanioLado(); j++){
				loteTemp = juego.elMapa.obtenerLote(i, j);
				if (loteTemp.esLoteDeAgua()) {
					vista.setBotonColorBackground(colorAzul, i+2, j);
				} else if (loteTemp.esLoteDeTierra()){
					vista.setBotonColorBackground(colorMarron, i+2, j);
				};
				
				if (loteTemp.esLoteDeRuta()){
					vista.setBotonColorBackground(colorGris, i+2, j);
				}
				stringTemp = loteTemp.obtenerIdentificadorLote();
				vista.setBotonTexto(stringTemp, i+2, j);
				vista.setBotonColorTexto(colorBlanco, i+2, j);
			}
		}
	}
	
	
	
	
	
	
	
	public void setTodosFalso(){
		ConstruyeCasa = false;
		ConstruyeComercio = false;
		ConstruyeIndustria = false;
		ConstruyeCentralNuclear = false;
		ConstruyeCentralEolica = false;
		ConstruyeCentralMineral = false;
		ConstruyePozoDeAgua = false;
		ConstruyeTuberia = false;
		ConstruyeLineaDeTension = false;
		ConstruyeBomberos = false;
		ConstruyeRuta = false;
	}
	
	public void SetProximoAConstruirCasa(){
		ConstruyeCasa = true;
	}
	
	public void SetProximoAConstruirComercio(){
		ConstruyeComercio = true;
	}
	
	public void SetProximoAConstruirIndustria(){
		ConstruyeIndustria = true;
	}
	
	public void SetProximoAConstruirCentralNuclear(){
		ConstruyeCentralNuclear = true;
	}
	
	public void SetProximoAConstruirCentralEolica(){
		ConstruyeCentralEolica = true;
	}
	
	public void SetProximoAConstruirCentralMineral(){
		ConstruyeCentralMineral = true;
	}
	
	public void SetProximoAConstruirTuberia(){
		ConstruyeTuberia = true;
	}
	
	public void SetProximoAConstruirLineaDeTension(){
		ConstruyeLineaDeTension = true;
	}
	
	public void SetProximoAConstruirPozoDeAgua(){
		ConstruyePozoDeAgua = true;
	}
	
	public void SetProximoAConstruirBomberos(){
		ConstruyeBomberos = true;
	}
	
	public void SetProximoAConstruirRuta(){
		ConstruyeRuta = true;
	}
	
	public void construirEnCoordenadas(int x, int y){
		if (ConstruyeRuta) {
			juego.ComprarUnaRutaEnCoord(x, y);
		}
		if (ConstruyeRuta) {
			juego.ComprarUnaRutaEnCoord(x, y);
		}
	}
}
