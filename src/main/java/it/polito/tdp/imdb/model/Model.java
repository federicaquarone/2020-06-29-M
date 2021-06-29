package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {
	
	ImdbDAO dao;
	Graph<Director, DefaultWeightedEdge> grafo;
	Map<Integer, Director> idMap;
	

	public Model() {
		dao= new ImdbDAO();
		idMap= new HashMap<Integer,Director>();
	}
	
	public List<Integer> getAnni(){
		return dao.getAnni();
	}
	
	public void creaGrafo(int anno) {
		this.grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//aggiungo vertici
		Graphs.addAllVertices(grafo, dao.getVertici(anno));
		for(Director d: grafo.vertexSet())
			idMap.put(d.getId(), d);
		
		//aggiungo archi
		for(Arco a: dao.getArchi(anno, idMap)) {
			if(!grafo.containsEdge(grafo.getEdge(a.getA1(), a.getA2())) && !grafo.containsEdge(grafo.getEdge(a.getA1(), a.getA2()))) 
				Graphs.addEdge(grafo, a.getA1(), a.getA2(), a.getPeso());
		}
		
	}
	
	public int getNVertici() {
		return this.grafo.vertexSet().size();
	}
	public int getNArchi() {
		return grafo.edgeSet().size();
	}
	
	public List<Director> getDirettori(){
		List<Director> registi= new ArrayList<Director>(grafo.vertexSet());
		Collections.sort(registi);
		return  registi;
	}
	
	public List<Director> getRegistiAdiacenti(Director d){
		List<Director> vicini= Graphs.neighborListOf(grafo, d);
		Collections.sort(vicini);
		return vicini;
	
	}
	public List<DirettoreConPeso> getRegistiAdiacentiOrdinati(Director d){
		List<Director> vicini= Graphs.neighborListOf(grafo, d);
		List<DirettoreConPeso> direttoripeso= new ArrayList<DirettoreConPeso>();
		
		for(Director dd: vicini) {
			DirettoreConPeso dp= new DirettoreConPeso(dd,(int) grafo.getEdgeWeight(grafo.getEdge(d,dd)));
			direttoripeso.add(dp);
		}
		Collections.sort(direttoripeso);
		return direttoripeso;
	
	}
	
	
}
