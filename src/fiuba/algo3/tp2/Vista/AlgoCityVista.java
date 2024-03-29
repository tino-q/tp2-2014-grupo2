package fiuba.algo3.tp2.Vista;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import fiuba.algo3.tp2.Controlador.AlgoCityControlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class AlgoCityVista extends JFrame {
		
        miJbutton[][] grid; 
        JLabel[] gridLabel;
        AlgoCityControlador controlador;
        int tamanioLadoMapa;
        
        public AlgoCityVista(int TamanioLadoMapa){ 
        		tamanioLadoMapa = TamanioLadoMapa;
        		Font unfont;
        		setTitle("AlgoCity");
        		setResizable(false);
        		float flot;
        		Dimension dimen = new Dimension(80,50);
        		int tamanioGrilla = tamanioLadoMapa + 2;
                setLayout(new GridLayout(tamanioGrilla,tamanioGrilla));
                grid=new miJbutton[tamanioGrilla][tamanioGrilla]; 
                gridLabel = new JLabel[tamanioGrilla];
                for(int y=0; y<(tamanioGrilla); y++){
                        for(int x=0; x<(tamanioGrilla); x++){                          
                        		grid[x][y]=new miJbutton("nodeberiaestaresto"); 
                        		grid[x][y].setCoordenadas(x, y);
                        		grid[x][y].setPreferredSize(dimen);
                        		unfont = grid[x][y].getFont();
                        		flot = unfont.getSize2D();
                        		flot = (float) (flot/1.1);
                        		unfont = unfont.deriveFont(flot);
                        		grid[x][y].setFont(unfont);
                        		if (x==1 && (y>=0) && (y<tamanioGrilla)){
                        			gridLabel[y] = new JLabel ("");
                        			this.add(gridLabel[y]);
                        			} else {
                        				this.add(grid[x][y]);
                        			}
                        }
                }
                
                
                
                setBotonesMenu(tamanioGrilla);
                setBotonesLote(tamanioLadoMapa);
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pack(); 
        }
        
        
        private void setBotonesMenu(int tamanioGrilla){
        	JButton botonTemporal;
            for(int y=0; y<tamanioGrilla; y++){
                for(int x=0; x<tamanioGrilla; x++){
                   	if ((x==0)||(x==1)) {
                		botonTemporal = grid[x][y];
                		botonTemporal.setVisible(false);
                	}
                	
                	if ((y==tamanioGrilla-1)||(y==tamanioGrilla-2)) {
                		botonTemporal = grid[x][y];
                		botonTemporal.setVisible(false);
                	}
                	
                	if ((x==0)&&(y<=13)) {
                		botonTemporal = grid[x][y];
                		botonTemporal.setVisible(true);
                	}
                }
            }
        	
        	 JLabel label;
             JButton boton = grid[0][0];
             boton.setText("<html>Proximo<br/>turno</html>");
             Font elfont = boton.getFont();
             float tama = elfont.getSize2D();
             tama = (float) (tama*1.2);
             elfont = elfont.deriveFont(tama);
             boton.setFont(elfont);
             ActionListener action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.proximoTurno();
					}
				};
				boton.addActionListener(action);
             
             
             
             boton = grid[0][1];
             boton.setText("<html>CASA</html>");
             boton.setFont(elfont);
             label = gridLabel[1];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCasa();
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][2];
             boton.setText("<html>COMER.</html>");
             boton.setFont(elfont);
             label = gridLabel[2];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirComercio();
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][3];
             boton.setText("<html>INDUS.</html>");
             boton.setFont(elfont);
             label = gridLabel[3];
             label.setText("$10");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirIndustria();;
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][4];
             boton.setText("<html>BOMB.</html>");
             boton.setFont(elfont);
             label = gridLabel[4];
             label.setText("$1500");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirBomberos();
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][5];
             boton.setText("<html>Cent.<br/>Eolica</html>");
             boton.setFont(elfont);
             label = gridLabel[5];
             label.setText("$1000");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCentralEolica();;
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][6];
             boton.setText("<html>Cent.<br/>Mineral</html>");
             boton.setFont(elfont);
             label = gridLabel[6];
             label.setText("$3000");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCentralMineral();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][7];
             boton.setText("<html>Cent.<br/>Nuclear</html>");
             boton.setFont(elfont);
             label = gridLabel[7];
             label.setText("$10000");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirCentralNuclear();
					}
				};
				boton.addActionListener(action);

             boton = grid[0][8];
             boton.setText("<html>Ruta</html>");
             boton.setFont(elfont);
             label = gridLabel[8];
             label.setText("$10");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirRuta();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][9];
             boton.setText("<html>Linea<br/>Tension</html>");
             boton.setFont(elfont);
             label = gridLabel[9];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirLineaDeTension();
					}
				};
				boton.addActionListener(action);
             
             boton = grid[0][10];
             boton.setText("<html>Tuberia</html>");
             boton.setFont(elfont);
             label = gridLabel[10];
             label.setText("$5");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirTuberia();
					}
				};
				boton.addActionListener(action);
             

             boton = grid[0][11];
             boton.setText("<html>Pozo<br/>Agua</html>");
             boton.setFont(elfont);
             label = gridLabel[11];
             label.setText("$250");
             action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.SetProximoAConstruirPozoDeAgua();
					}
				};
				boton.addActionListener(action);
        

	         boton = grid[0][12];
	         boton.setText("<html>Sacar Xs</html>");
	         boton.setFont(elfont);
	         action = new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						controlador.actualizarVista();
					}
				};
				boton.addActionListener(action);   


		         boton = grid[0][13];
		         boton.setText("<html>Salir</html>");
		         boton.setFont(elfont);
		         action = new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							System.exit(0);;
						}
					};
					boton.addActionListener(action);   
				
        }
  
        
        private void setBotonesLote(int tamanioLadoMapa){
        	JButton boton;
        	ActionListener escuchador;
        	escuchador = new ActionListener(){
        		@Override
        		public void actionPerformed(ActionEvent e){
        			miJbutton botoncito =(miJbutton) e.getSource();
        			int x = botoncito.getcoordX();
        			int y = botoncito.getcoordY();
        			controlador.construirEnCoordenadas(x-2, y);
        			controlador.actualizarVista();
        		}
        	};
     
        	for (int i=0; i<tamanioLadoMapa; i++){
        		for (int j=0; j<tamanioLadoMapa; j++){
        			boton = grid[i+2][j];
        			boton.addActionListener(escuchador);
        		}
        	}
        	
        }
        
        public void setBotonTexto(String string, int x, int y){
        	JButton temp = grid[x][y];
        	temp.setText(string);
        }
        
        public void setNumeroTurnos(int x){
        	JLabel label = gridLabel[13];
        	label.setText("Turno: "+Integer.toString(x));
        }
        
        public void setCantidadPoblacion(int x){
        	JLabel label = gridLabel[14];
        	label.setText("<html>Poblacion:<br/>" +Integer.toString(x)+"</html>");
        }
        
        public void msgbox(String s){
        	   JOptionPane.showMessageDialog(null, s);
        	}
        
        public void setSaldo(int x){
        	JLabel label = gridLabel[15];
        	String string = Integer.toString(x);
            label.setText("<html>Saldo:<br/>$" + string + "</html>" );
        }
        
        public void setControlador(AlgoCityControlador unControlador){
        	controlador = unControlador;
        }
        
        public String getBotonTexto(int x, int y){
        	JButton temp = grid[x][y];
        	return temp.getText();
        }
        
        public void setBotonColorBackground(Color color, int x, int y){
        	JButton temp = grid[x][y];
        	temp.setBackground(color);
        }
        
        public void setBotonColorTexto(Color color, int x, int y){
        	JButton temp = grid[x][y];
        	temp.setForeground(color);
        }


		public void mostrarDaniosDeUltimaCatastrofe(double[][] daniosALotes) {
			

			double DanioDeUltimaCat = 0;


				for (int i=0; i<tamanioLadoMapa; i++){
					for (int j=0; j<tamanioLadoMapa; j++){
						DanioDeUltimaCat = daniosALotes[i][j];
						if (DanioDeUltimaCat>0){
							JButton boton = grid[i+2][j];
					        boton.setText("<html>XXXXX<br/>-" + String.valueOf((int)DanioDeUltimaCat) + "</html>");
						}
					}
				
			
	        }
	     }
        
}
