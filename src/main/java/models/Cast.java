package models;

public class Cast {
	private boolean adult;
    private int gender;
    private int id;
    private String known_for_department;
    private String name;
    private String originalName;
    private double popularity;
    private String profile_path;
    private int castId;
    private String character;
    private String creditId;
    private int order;

    // Constructor
    public Cast(boolean adult, int gender, int id, String known_for_department, String name,
                 String originalName, double popularity, String profile_path, int castId,
                 String character, String creditId, int order) {
        this.adult = adult;
        this.gender = gender;
        this.id = id;
        this.known_for_department = known_for_department;
        this.name = name;
        this.originalName = originalName;
        this.popularity = popularity;
        this.profile_path = profile_path;
        this.castId = castId;
        this.character = character;
        this.creditId = creditId;
        this.order = order;
    }

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKnownForDepartment() {
		return known_for_department;
	}

	public void setKnownForDepartment(String knownForDepartment) {
		this.known_for_department = knownForDepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public String getProfilePath() {
		return profile_path;
	}

	public void setProfilePath(String profilePath) {
		this.profile_path = profilePath;
	}

	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}


}
