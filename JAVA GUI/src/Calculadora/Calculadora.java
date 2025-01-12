package Calculadora;

import javax.swing.JOptionPane;

public class Calculadora {
	
	private long numeroUno;
	private long numeroDos;
	private long numeroSuelto;
	
	public Calculadora(long numeroUno, long numeroDos) {
		this.numeroUno=numeroUno;
		this.numeroDos=numeroDos;
	}
	
	
	public Calculadora(long numeroSuelto) {
		this.numeroSuelto = numeroSuelto;
	}

	public long suma() {
		return this.numeroUno+this.numeroDos;
	}
	
	public long resta() {
		return this.numeroUno-this.numeroDos;
	}
	
	public long multiplicacion() {
		return this.numeroUno*this.numeroDos;
	}
	
	public double divicion() {
		
		try {
			double divicion=this.numeroUno/this.numeroDos;
			return divicion;
		}catch(ArithmeticException e) {
			JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
		}
		return Double.NaN;
	}
	
	public long cuadrado() {
		return this.numeroSuelto*this.numeroSuelto;
	}
	
	public int nFactorial() {
		int resultado = 1;
		try {
			for (int i = 1; i <= this.numeroSuelto; i++) {
				resultado *= i;
			}
			return resultado;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:"+e.getMessage());
		}
		return -1;
	}
	
}

