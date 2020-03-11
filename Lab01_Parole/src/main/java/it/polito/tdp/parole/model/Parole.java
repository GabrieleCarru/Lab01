package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Parole implements Comparator<String> {
	
		// Struttura dati utilizzata
		private List<String> elenco = new ArrayList<String>();
//		private List<String> elencoOrdinato = new ArrayList<String>();
		
	public Parole() {
		//TODO
		
	}
	
	public void addParola(String p) {
		elenco.add(p);
	}
	
	public List<String> getElenco() {
		
//		elencoOrdinato = Collections.sort(elenco);
//		elencoOrdinato=elenco.stream().sorted().collect(Collectors.toList());
//		List<String> elencoOrdinato = elenco.stream()
//										.sorted()
//										.collect(Collectors.toList());
		List<String> eO = elenco.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
										
		return eO;
	}
	
	public void reset() {
		elenco.clear();
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
