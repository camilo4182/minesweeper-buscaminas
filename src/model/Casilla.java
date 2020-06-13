/**
 *Clase Casilla
 *@author Johan Camilo Cortes Ocampo
 *@version 1.0 - 21/04/2018
*/

package model;

public class Casilla{
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
//ATRIBUTOS
//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	private int cantidadMinasAlrededor;
	private boolean mina;
	private boolean cubierta;
	private boolean marca;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
//MÉTODOS
//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 *Metodo constructor que crea un objeto de tipo Casilla.<br>
	 *
	 *<b>Post:</b> Se ha creado un objeto de tipo Casilla.<br>
	*/
	public Casilla(){
		cantidadMinasAlrededor = 0;
		mina = false;
		cubierta = true;
		marca = false;
	}
	
	/**
	 *Asigna a la casilla la cantidad de minas que hay a su alrededor.<br>
	 *
	 *<b>Pre:</b> Se verifico que esta casilla no posee una mina.<br>
	 *
	 *<b>Post:</b> Se asigno la cantidad de minas alrededor.<br>
	 *
	 *@param minas - Cantidad de casillas con minas que hay alrededor. Es un numero entero positivo.
	*/
	public void establecerCantidadMinas(int minas){
		cantidadMinasAlrededor = minas;
	}
	 
	/**
	 *Establece que la casilla posee una mina.<br>
	 *
	 *<b>Pre:</b> La casilla fue seleccionada aleatoriamente para tener una mina.<br>
	 *
	 *<b>Post:</b> Se establecio que la casilla tiene una mina.<br>
	 *
	 *@param mina - Valor booleano para comunicar que esta casilla posee una mina.
	*/
	public void establecerHayMina(boolean mina){
		this.mina = mina;
	}
	
	/**
	 *Cambia el valor booleano del estado de la casilla.<br>
	 *
	 *<b>Pre:</b> La variable esta declarada.<br>
	 *
	 *@param estado - Estado actual de la casilla (cubierta o descubierta).
	*/
	public void cubrir(boolean cubierta){
		this.cubierta = cubierta;
	}
	
	/**
	 *Cambia el valor booleano de la variable marca.<br>
	 *
	 *<b>Pre:</b> La variable esta declarada.<br>
	 *
	 *@param marca - Indica si la casilla tiene marca o no.
	 */
	public void establecerMarca(boolean marca) {
		this.marca = marca;
	}
	
	/**
	 *Devuelve la cantidad de casillas con mina que hay alrededor.<br>
	 *
	 *<b>Pre:</b> Esta casilla no tiene mina.<br>
	 *<b>Pre:</b> La cantidad de minas alrededor es un entero positivo.<br>
	 *
	 *@return cantidadMinasAlrededor - Numero de casillas con mina que hay alrededor.
	 */
	public int darCantidadMinasAlrededor(){
		return cantidadMinasAlrededor;
	}
	
	/**
	 *Devuelve el valor booleano que dice si la casilla posee una mina o no.<br>
	 *
	 *<b>Pre:</b> El valor de la variable mina esta asignado o es el valor predeterminado.<br>
	 *
	 *@return mina - Indica si en la casilla hay o no una mina.
	 */
	public boolean hayMina(){
		return mina;
	}
	
	/**
	 *Devuelve un valor booleano que indica si la casilla esta cubierta (true) o ya se ha descubierto (false).<br>
	 *
	 *@return estado - Indica si la casilla esta cubierta o ya se descubrio.
	 */
	public boolean estaCubierta(){
		return cubierta;
	}
	
	/**
	 *Devuelve un valor booleano que indica si la casilla esta marcada o no.<br>
	 *
	 *@return marca -  Indica si la casilla tiene una marca o no.
	 */
	public boolean estaMarcada() {
		return marca;
	}
}