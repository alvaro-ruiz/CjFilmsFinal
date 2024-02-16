package models;

import java.util.List;

public class Credits {
    
	private int id;
	private Cast[] cast;
	private Crew[] crew;
	
	public Credits(int id, Cast[] cast, Crew[] crew) {
		super();
		this.id = id;
		this.cast = cast;
		this.crew = crew;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cast[] getActors() {
		return cast;
	}

	public void setCast(Cast[] actors) {
		this.cast = cast;
	}

	public Crew[] getCrew() {
		return crew;
	}

	public void setCrew(Crew[] crew) {
		this.crew = crew;
	}

	public Cast[] getCast() {
		return cast;
	}
    
}
