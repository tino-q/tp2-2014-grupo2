package fiuba.algo3.tp2;

public class Poblacion {
	
	Mapa mapa;
	int poblacionTotal=0;
	
	public void agregarMapa(Mapa nuevoMapa) {
		mapa = nuevoMapa;	
	}

	public void agregarPoblacion(int valor){
		poblacionTotal = poblacionTotal + valor;
	}
	
	public int getCantidadPoblacion(){
		return poblacionTotal;
	}
	
	public void actualizar(){
		poblacionTotal = 0;
		for(int i=0; i < mapa.obtenerTamanioLado(); i++){
			for(int j=0; j < mapa.obtenerTamanioLado(); j++){
				if(mapa.getTieneCasaElLote(i,j)){
					if(mapa.getTieneAguaLote(i, j)){
						if(mapa.getTieneElecticidadLote(i, j)){
							if(this.tieneRutaAdyacente(i,j)){
								if(mapa.loteTieneComercioCercano(6, i, j)){
									if(mapa.loteTieneIndustriaCercano(14, i, j)){
										this.agregarPoblacion(100);
									}
								}
							}
						}
					}
				}
			}
		}
		
	}

	private boolean tieneRutaAdyacente(int i, int j) {
		for(int k=1; k<4;k++){
				if(mapa.getTieneRutaElLote(i-k,j)){
					return true;
				}
				if(mapa.getTieneRutaElLote(i+k,j)){
					return true;
				}
				if(mapa.getTieneRutaElLote(i,j-k)){
					return true;
				}
				if(mapa.getTieneRutaElLote(i,j+k)){
					return true;
				}
		}
		return false;
	}
	
}
