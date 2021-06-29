package it.polito.tdp.imdb.model;

public class DirettoreConPeso implements Comparable<DirettoreConPeso>{
	Director d;
	Integer peso;
	public DirettoreConPeso(Director d, Integer peso) {
		super();
		this.d = d;
		this.peso = peso;
	}
	public Director getD() {
		return d;
	}
	public void setD(Director d) {
		this.d = d;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	@Override
	public int compareTo(DirettoreConPeso o) {
		// TODO Auto-generated method stub
		return o.peso-this.peso;
	}
	@Override
	public String toString() {
		return "DirettoreConPeso [d=" + d + ", peso=" + peso + "]";
	}
	

}
