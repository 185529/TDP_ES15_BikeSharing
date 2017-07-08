package it.polito.tdp.bikesharing.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.bikesharing.db.BabsDAO;

public class Model {
	
	BabsDAO babsDAO;
	List<Station> stazioni;
	
	public Model(){
		this.babsDAO = new BabsDAO();
	}
	
	public List<Station> getStazioni(){
		
		if(stazioni==null){
			stazioni = babsDAO.getAllStations();
		}
		
		return stazioni;
	}

	public List<Statistics> getStats(LocalDate date) {

		List<Statistics> stats = new ArrayList<Statistics>();
				
		for(Station stazione : getStazioni()){
			
			System.out.println("BOOO");
			
			int picks = babsDAO.getPickNumber(stazione, date);
			int drops = babsDAO.getDropNumber(stazione, date);
			
			Statistics stat = new Statistics(stazione, picks, drops);
			stats.add(stat);
			
		}
		
		return stats;
		
	}

}
