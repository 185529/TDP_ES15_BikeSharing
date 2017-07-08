package it.polito.tdp.bikesharing.model;

public class Statistics implements Comparable<Statistics> {
	
	private Station station;
	private int pick;
	private int drop;
	
	/**
	 * @param station
	 * @param pick
	 * @param drop
	 */
	public Statistics(Station station, int pick, int drop) {
		super();
		this.station = station;
		this.pick = pick;
		this.drop = drop;
	}

	/**
	 * @return the station
	 */
	public Station getStation() {
		return station;
	}

	/**
	 * @param station the station to set
	 */
	public void setStation(Station station) {
		this.station = station;
	}

	/**
	 * @return the pick
	 */
	public int getPick() {
		return pick;
	}

	/**
	 * @param pick the pick to set
	 */
	public void setPick(int pick) {
		this.pick = pick;
	}

	/**
	 * @return the drop
	 */
	public int getDrop() {
		return drop;
	}

	/**
	 * @param drop the drop to set
	 */
	public void setDrop(int drop) {
		this.drop = drop;
	}

	@Override
	public int compareTo(Statistics other) {

		return Double.compare(this.station.getLat(), other.getStation().getLat());
		
	}
 
	

}
