package Calculadora;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField campoTexto;
	private String operador;
	private long numerosUno;
	private long numerosDos;
	
	// VENTANA
	public Gui() {
		setTitle("Calculadora "); //NOMBRE A LA VENTANA
		setSize(465,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //PARA QUE EL USUARIO PUEDA CERRAR LA VENTANA
		setLocationRelativeTo(null);  // PARA QUE LA VENTANA ME SALGA EN EL MEDIO NO EN CUALQUIER LUGAR
		setResizable(false); // BLOQUEA LA PANTALLA PARA QUE NO LO PUEDA HACER GRANDE
		componentes(); //AGREGAMOS CADA UNOS DE LOS COMPONENTES
	}
	
	//FACILITA EL LLEVAR A TODOS LOS COMPONENTES A LA VENTANA
	private void componentes() {
		crearPanel();
		crearBotonesNum();
		crearPantalla();
	}
	
	private void crearPanel() {
		panel=new JPanel(); //HACEMOS UN NUEVO PANEL
		panel.setLayout(null); // PARA PODER CAMBIARLE LOS ESTILOS AL PANEL
		panel.setBackground(Color.blue); //FONDO DEL PANEL
		this.getContentPane().add(panel);
	}
	
	private void crearBotonesNum() {
		JButton n1=new JButton("1");
		JButton n2=new JButton("2");
		JButton n3=new JButton("3");
		JButton n4=new JButton("4");
		JButton n5=new JButton("5");
		JButton n6=new JButton("6");
		JButton n7=new JButton("7");
		JButton n8=new JButton("8");
		JButton n9=new JButton("9");   // CREAMOS CADA UNO DE LOS BOTONES NECESARIOS
		JButton n0=new JButton("0");
		JButton igual=new JButton("=");
		JButton mas=new JButton("+");
		JButton menos=new JButton("-");
		JButton por=new JButton("*");
		JButton divicion=new JButton("/");
		JButton limpiar=new JButton("C");
		JButton factorial=new JButton("!");
		JButton dobleCero=new JButton("00");
		JButton cuadrado=new JButton("x^2");
		JButton eliminarUno=new JButton("<-");
		
		int ancho=100; //ANCHO DEL BOTON
		int alto=50;   // LARGO DEL BOTON
		n1.setBounds(20,400,ancho,alto);
		n2.setBounds(125,400,ancho,alto); //DEFINIMOS EL TAMAÑO DEL BOTON Y EN QUE CORDENADA ESTARA
		n3.setBounds(230,400,ancho,alto);
		igual.setBounds(335, 400,ancho,alto);
		igual.setFont(new Font("Arial",Font.BOLD,25));  //ESTILO DE ESTE BOTON
		igual.setBackground(Color.GREEN);   // EL COLOR
		
		n4.setBounds(20,340, ancho, alto);
		n5.setBounds(125,340, ancho, alto);
		n6.setBounds(230,340, ancho, alto);
		mas.setBounds(335,340, ancho, alto);
		
		n7.setBounds(20,280, ancho, alto);
		n8.setBounds(125,280, ancho, alto);
		n9.setBounds(230,280, ancho, alto);
		menos.setBounds(335,280, ancho, alto);
		
		n0.setBounds(20,220, ancho, alto);
		por.setBounds(125,220, ancho, alto);
		divicion.setBounds(230, 220, ancho, alto);
		limpiar.setBounds(335,220, ancho, alto);
		limpiar.setBackground(Color.RED);
		limpiar.setFont(new Font("Arial",Font.BOLD,25));
		
		factorial.setBounds(20,160, ancho, alto);
		dobleCero.setBounds(125,160, ancho, alto);
		cuadrado.setBounds(230,160, ancho, alto);
		eliminarUno.setBounds(335,160, ancho, alto);
		
		// TODOS LOS BOTONES EN UN ARRAY
		JButton [] arrayButton= {n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,
				dobleCero,igual,mas,menos,por,divicion,factorial,cuadrado,limpiar,eliminarUno};
		for(JButton boton:arrayButton) {
			agregarBotones(boton); // AGREGAMOS AL PANEL CADA UNO DE LOS BOTONES CON ESTA FUNCION
		}
		
		for(JButton boton:arrayButton) {
			if(boton!=limpiar && boton!=igual) {  //AGREGAMOS ESTILO A TODOS LOS BOTONES MENOS A LOS QUE SON DIFERENTE
				estiloBotones(boton);             // YA QUE ESOS TIENEN ESTILOS DIFERENTES
			}
		}
		
		// HACE QUE EN LA PANTALLA SE VEA LOS NUMEROS ESTO SE LE LLAMA FUNCIONES lambda
		n1.addActionListener(e -> campoTexto.setText(campoTexto.getText()+n1.getText()));
		n2.addActionListener(e->campoTexto.setText(campoTexto.getText()+n2.getText()));
		n3.addActionListener(e->campoTexto.setText(campoTexto.getText()+n3.getText()));
		n4.addActionListener(e->campoTexto.setText(campoTexto.getText()+n4.getText()));
		n5.addActionListener(e->campoTexto.setText(campoTexto.getText()+n5.getText()));
		n6.addActionListener(e->campoTexto.setText(campoTexto.getText()+n6.getText()));
		n7.addActionListener(e->campoTexto.setText(campoTexto.getText()+n7.getText()));
		n8.addActionListener(e->campoTexto.setText(campoTexto.getText()+n8.getText()));
		n9.addActionListener(e->campoTexto.setText(campoTexto.getText()+n9.getText()));
		n0.addActionListener(e->campoTexto.setText(campoTexto.getText()+n0.getText()));
		dobleCero.addActionListener(e->campoTexto.setText(campoTexto.getText()+dobleCero.getText()));
		
		// EVENTOS DE LOS BOTONES DE OPERADORES
		mas.addActionListener(evento -> {
			try {
				this.numerosUno = Long.parseLong(campoTexto.getText());
				campoTexto.setText("");
				this.operador = mas.getText();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		
		menos.addActionListener(evento -> {
			try {
				this.numerosUno = Long.parseLong(campoTexto.getText());
				campoTexto.setText("");
				this.operador = menos.getText();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		
		divicion.addActionListener(evento ->{
			try {
				this.numerosUno=Long.parseLong(campoTexto.getText());
				campoTexto.setText("");
				this.operador=divicion.getText();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		});
		
		por.addActionListener(evento ->{
			try {
				this.numerosUno=Long.parseLong(campoTexto.getText());
				campoTexto.setText("");
				this.operador=por.getText();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		});
		
		factorial.addActionListener(evento->{
			try {
				Calculadora calculo = new Calculadora(Long.parseLong(campoTexto.getText()));
				campoTexto.setText(String.valueOf(calculo.nFactorial()));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		});
		
		cuadrado.addActionListener(evento->{
			try {
				Calculadora calculo = new Calculadora(Long.parseLong(campoTexto.getText()));
				campoTexto.setText(String.valueOf(calculo.cuadrado()));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		});

		limpiar.addActionListener(evento -> {
			campoTexto.setText("");
			this.numerosUno=0;
			this.numerosDos=0;
			});
		
		eliminarUno.addActionListener(evento->{
			//SI EL CAMPO NO ESTA VACIO
			if(!campoTexto.getText().isEmpty()) {
				//CONTAMOS LA LONGITUD DEL CAMPO
				int longitud=campoTexto.getText().length();
				campoTexto.setText(campoTexto.getText().substring(0,longitud-1)); // AGREGAMOS(OBTENER LOS NUMEROS-USAMOS UNA FUNCION DONDE EXTRAEMOS TODO EL TEXTO MENOS EL ULTIMO)	 
			}
		});

		igual.addActionListener(evento -> {

			try {
				this.numerosDos = Long.parseLong(campoTexto.getText());
				Calculadora calculo = new Calculadora(this.numerosUno, this.numerosDos);

				switch (operador) {
				case "+":
					campoTexto.setText(String.valueOf(calculo.suma()));
					break;
				case "-":
					campoTexto.setText(String.valueOf(calculo.resta()));
					break;
				case "*":
					campoTexto.setText(String.valueOf(calculo.multiplicacion()));
					break;
				case "/":
					campoTexto.setText(String.valueOf(calculo.divicion()));
					break;
				}
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
		});
	}
	
	private void crearPantalla() {
		campoTexto=new JTextField();
		campoTexto.setBounds(20,50,415,100);
		campoTexto.setEnabled(false);// PARA QUE EL USUARIO NO INGRESE TEXTO EN ESE LUGAR
		campoTexto.setDisabledTextColor(Color.BLACK);
		campoTexto.setFont(new Font("Arial", Font.BOLD, 40));
		campoTexto.setHorizontalAlignment(JTextField.RIGHT); // COMIENZAN LAS LETRAS POR LA DERECHA
		panel.add(campoTexto);
	}
	
	private void agregarBotones(JButton boton) {
		panel.add(boton); //AGREGAMOS AL PANEL CADA UNO DE LOS BOTONES
	}
	
	private void estiloBotones(JButton boton) {
		boton.setBackground(Color.orange); //COLOR DEL BOTON
		boton.setFont(new Font("Arial",Font.BOLD,25)); // ESTILO LETRA Y TAMAÑO
	}
}
