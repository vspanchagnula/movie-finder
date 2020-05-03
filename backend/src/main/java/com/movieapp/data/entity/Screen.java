package com.movieapp.data.entity;

import javax.persistence.*;

@Entity
public class Screen {
    @Id
    private long screenId;
    private long theatreId;
    private int seatsNum;
    
    public Screen(long screenId, long theatreId, int seatsNum) {
		super();
		this.screenId = screenId;
		this.theatreId = theatreId;
		this.seatsNum = seatsNum;
	}
    
    public Screen() {
    	super();
	}

    public long getScreenId() {
        return screenId;
    }

	public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(long theatreId) {
        this.theatreId = theatreId;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public void setSeatsNum(int seatsNum) {
        this.seatsNum = seatsNum;
    }
}
