package com.movieapp.data.entity;

import javax.persistence.*;

@Entity
public class Theatre {
	@Id
    private long theatreId;
    private String theatreName;
 	private String theatreCity;
 	
 	 public Theatre() {
 		super();
 	}
 	 public Theatre(long theatreId, String theatreName, String theatreCity) {
 		super();
 		this.theatreId = theatreId;
 		this.theatreName = theatreName;
 		this.theatreCity = theatreCity;
 	}

    public long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(long theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreCity() {
        return theatreCity;
    }

    public void setTheatreCity(String theatreCity) {
        this.theatreCity = theatreCity;
    }
}
