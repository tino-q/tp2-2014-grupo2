package fiuba.algo3.tp2;
import java.util.ArrayList;

public class RedElectrica {
	ArrayList <CentralElectrica> centralesElctricas=new ArrayList<CentralElectrica>();
	ArrayList <LineaDeTension> lineasDeTension=new ArrayList <LineaDeTension>();
	Mapa mapa;

	
	private boolean hayElectricidadAdyacente(LineaDeTension lineaDeTension){
		int distanciaEntreLineas;
		CentralElectrica centraltemporal;
		LineaDeTension lineatemporal;
		int consumoDeLote;		
		for(int i=0;i<lineasDeTension.size();i++){
			lineatemporal=lineasDeTension.get(i);
			distanciaEntreLineas=mapa.calcularDistanciaEntreLotes(lineaDeTension.getPosicionX(),lineaDeTension.getPosicionY() ,lineatemporal.getPosicionX() , lineatemporal.getPosicionY());
			if(distanciaEntreLineas<2){
				if(lineatemporal.getTieneElectricidad()){
					centraltemporal=lineatemporal.getCentralElectrica();
					consumoDeLote=mapa.getConsumoElecticoDeLote(lineaDeTension.getPosicionX(), lineaDeTension.getPosicionY());
					if((int)centraltemporal.getUsoActual()+(int)consumoDeLote<(int)centraltemporal.getCapacidadAbastecimiento()){
						lineaDeTension.setTieneElectricidad(centraltemporal);
						centraltemporal.agregarAConsumoDeEnergia(consumoDeLote);
						return true;
					
					}
				}
			}
		}
		return false;
	}
	
	public  void actualizarRed(){
		
		reiniciarMapaElectrico();
		actualizarTodo();
		actualizarElectricidadEnLotes();
	}
	
	private void reiniciarMapaElectrico() {
		this.actualizarCentrales();
		this.actualizarLineasDeTension();
		
		CentralElectrica centralTem;
		LineaDeTension lineaTem;
		for(int i=0;i<mapa.obtenerTamanioLado();i++){//pone todos los lotes sin electricidad
			for(int j=0;j<mapa.obtenerTamanioLado();j++){
				mapa.setElectricidadLote(i, j, false);
			}
		}
		for(int i=0;i<centralesElctricas.size();i++){//reinicie el uso de electricidad en las centrales
			centralTem=centralesElctricas.get(i);
			centralTem.setUsoActualACero();

		}
		for(int i=0;i<lineasDeTension.size();i++){//pone todas las lineas de tension sin electricidad
			lineaTem=lineasDeTension.get(i);
			lineaTem.setNoTieneElectricidad();
		}

		
	}

	private void actualizarLineasDeTension() {
		LineaDeTension lineaTem;
		for(int i=0;i<lineasDeTension.size();i++){
			lineaTem=lineasDeTension.get(i);
			if(lineaTem.obtenerVida()<=0){
				lineasDeTension.remove(lineaTem);
			}
		}
		
	}

	private void actualizarTodo(){
		
		LineaDeTension lineatemporal;
		for(int i=0;i<lineasDeTension.size();i++){
			lineatemporal=lineasDeTension.get(i);
			if(lineatemporal.tieneElectricidad==false){
				if(hayElectricidadAdyacente(lineatemporal)){
					this.actualizarTodo();
				}
				if(existeCentralCercana(lineatemporal)){
					this.actualizarTodo();	
				}
			}
		}	
	}
	
	private void actualizarElectricidadEnLotes() {
		int distanciaACentral;
		int consumoDeLote;
		LineaDeTension lineatemporal;
		CentralElectrica centraltemporal;
		for(int i=0; i< centralesElctricas.size();i++){
			centraltemporal=centralesElctricas.get(i);
			for(int x=0; x<mapa.tamanioLadoMapa; x++){
				for(int y=0; y<mapa.tamanioLadoMapa; y++){
					distanciaACentral=mapa.calcularDistanciaEntreLotes(x,y ,centraltemporal.getPosicionX() , centraltemporal.getPosicionY());
					if(distanciaACentral<centraltemporal.getRadioDeAlcance()){
						consumoDeLote=mapa.getConsumoElecticoDeLote(x,y);
						if((int)centraltemporal.getUsoActual()+(int)consumoDeLote<(int)centraltemporal.getCapacidadAbastecimiento()){
							mapa.setElectricidadLote(x, y,true);
							mapa.setCentralQueAlimentaLote(x,y,centraltemporal);
							centraltemporal.agregarAConsumoDeEnergia(consumoDeLote);
						}
					}
				}
		
			}
		}
		
		for(int i=0;i<lineasDeTension.size();i++){
			lineatemporal=lineasDeTension.get(i);
			mapa.setElectricidadLote(lineatemporal.getPosicionX(), lineatemporal.getPosicionY(),lineatemporal.getTieneElectricidad());
		}
	}

	private boolean existeCentralCercana(LineaDeTension nuevaLineaDeTension){
		CentralElectrica centraltemporal;
		int consumoDeLote;
		int distanciaACentral;
		for(int i=0; i< centralesElctricas.size();i++){
			centraltemporal=centralesElctricas.get(i);
			distanciaACentral=mapa.calcularDistanciaEntreLotes(nuevaLineaDeTension.getPosicionX(),nuevaLineaDeTension.getPosicionY() ,centraltemporal.getPosicionX() , centraltemporal.getPosicionY());
			if(distanciaACentral<centraltemporal.getRadioDeAlcance()){
				consumoDeLote=mapa.getConsumoElecticoDeLote(nuevaLineaDeTension.getPosicionX(), nuevaLineaDeTension.getPosicionY());
				if((int)centraltemporal.getUsoActual()+(int)consumoDeLote<(int)centraltemporal.getCapacidadAbastecimiento()){
					nuevaLineaDeTension.setTieneElectricidad(centraltemporal);
					centraltemporal.agregarAConsumoDeEnergia(consumoDeLote);
					return true;
				}
			}
		}
		return false;
	}
	
	private void actualizarCentrales() {
		CentralElectrica centraltem;
		for(int i=0;i<centralesElctricas.size();i++){
			centraltem=centralesElctricas.get(i);
			if(centraltem.obtenerVida()<=0){
				centralesElctricas.remove(centraltem);
			}
		}
		
	}

	public void agregarCentralElectrica(CentralElectrica nuevaCentral){
		centralesElctricas.add(nuevaCentral);
		this.actualizarRed();
	
	}
	
	public void agregarLineaDeTension(LineaDeTension nuevaLineaDeTension){
		lineasDeTension.add(nuevaLineaDeTension);
		this.actualizarRed();
	}
	

	public void agregarMapa(Mapa nuevoMapa) {
		mapa=nuevoMapa;
		
	}

	
}
