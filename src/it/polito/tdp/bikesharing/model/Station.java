package it.polito.tdp.bikesharing.model;

import java.time.LocalDate;

public class Station {
	
	private int id;
	private String name;
	private double lat;
	private double lon;
	private int dockCount;
	private String landMark;
	private LocalDate installation;
	
	/**
	 * @param id
	 * @param name
	 * @param lat
	 * @param lon
	 * @param dockCount
	 * @param landMark
	 * @param installation
	 */
	public Station(int id, String name, double lat, double lon, int dockCount, String landMark,
			LocalDate installation) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.dockCount = dockCount;
		this.landMark = landMark;
		this.installation = installation;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return the dockCount
	 */
	public int getDockCount() {
		return dockCount;
	}

	/**
	 * @param dockCount the dockCount to set
	 */
	public void setDockCount(int dockCount) {
		this.dockCount = dockCount;
	}

	/**
	 * @return the landMark
	 */
	public String getLandMark() {
		return landMark;
	}

	/**
	 * @param landMark the landMark to set
	 */
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	/**
	 * @return the installation
	 */
	public LocalDate getInstallation() {
		return installation;
	}

	/**
	 * @param installation the installation to set
	 */
	public void setInstallation(LocalDate installation) {
		this.installation = installation;
	}

}
