package it.polito.tdp.imdb.model;

public class Arco {
	
	Director a1;
	Director a2;
	int peso;
	public Arco(Director a1, Director a2, int peso) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.peso = peso;
	}
	public Director getA1() {
		return a1;
	}
	public void setA1(Director a1) {
		this.a1 = a1;
	}
	public Director getA2() {
		return a2;
	}
	public void setA2(Director a2) {
		this.a2 = a2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	

}
