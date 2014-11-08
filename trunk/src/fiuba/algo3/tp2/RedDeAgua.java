package fiuba.algo3.tp2;

import java.util.ArrayList;

public class RedDeAgua {
	
	ArrayList <PozoDeAgua> pozosDeAgua = new ArrayList<PozoDeAgua>();
	ArrayList <TuberiaDeAgua> tuberiasDeAgua = new ArrayList <TuberiaDeAgua>();

	private Mapa mapa;

	public void agregarPozo(PozoDeAgua pozo) {
		pozosDeAgua.add(pozo);
		this.actualizarRed();
		
	}

	public void actualizarRed() {
	
		PozoDeAgua pozoTem;
		TuberiaDeAgua tuberiaTem;
		for(int i=0; i<pozosDeAgua.size(); i++){
			pozoTem=pozosDeAgua.get(i);
			for(int j=0; j < tuberiasDeAgua.size(); j++){
				tuberiaTem=tuberiasDeAgua.get(j);
				if(pozoTem.getCoordenadaX()==tuberiaTem.getCoordenadaX()){
					if(pozoTem.getCoordenadaY()==tuberiaTem.getCoordenadaY()){
						tuberiaTem.setAgua(true);
					}
				}
			}
		this.actualizarTuberiasDeAgua();
		this.actualizarAguaEnLotes();

		}
		
	}
	
	private void actualizarAguaEnLotes() {
		TuberiaDeAgua tuberiaTem;
		for(int i=0; i<mapa.obtenerTamanioLado();i++){
			for(int j=0;j<mapa.obtenerTamanioLado();j++){
				mapa.setTieneAguaLote(i, j, false);
			}
		}
		for(int i=0;i<tuberiasDeAgua.size();i++){
			tuberiaTem=tuberiasDeAgua.get(i);
			if(tuberiaTem.tieneAgua){
				mapa.setTieneAguaLote(tuberiaTem.getCoordenadaX(), tuberiaTem.getCoordenadaY(), true);
			}
		}
		
	}

	private void actualizarTuberiasDeAgua() {
		TuberiaDeAgua tuberiaTem;
		for(int i=0; i< tuberiasDeAgua.size();i++){
			tuberiaTem=tuberiasDeAgua.get(i);
			if(tuberiaTem.tieneAgua()==false){
				if(existeTuberiaAdyacenteConAgua(tuberiaTem)){
					tuberiaTem.setAgua(true);	
					actualizarTuberiasDeAgua();
				}
			}
		}		
	}

	private boolean existeTuberiaAdyacenteConAgua(TuberiaDeAgua tuberiaTem) {
		TuberiaDeAgua tuberia;
		int distancia;
		for(int i=0; i< tuberiasDeAgua.size();i++){
			tuberia=tuberiasDeAgua.get(i);
			distancia=mapa.calcularDistanciaEntreLotes(tuberiaTem.getCoordenadaX(), tuberiaTem.getCoordenadaY(), tuberia.getCoordenadaX(),tuberia.getCoordenadaY());
			if(distancia<2){
				if(tuberia.tieneAgua){
				return true;
				}
			}
		}
		return false;
	}



	public void agregarMpa(Mapa nuevoMapa) {
		mapa = nuevoMapa;
		
	}

	public void agregarTuberia(TuberiaDeAgua tuberia) {
		tuberiasDeAgua.add(tuberia);
		this.actualizarRed();
		
	}

}
