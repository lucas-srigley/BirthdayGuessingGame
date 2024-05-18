/**
 * Name: Lucas Srigley
 * Student Number: 20289448
 */
package Date;

public class Singer extends Person {
	// create instance variables
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
	// create copy constructors
	public Singer(String name, Date born, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
		super(name, born, gender, difficulty);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
	}
	public Singer(Singer otherSinger) {
		super(otherSinger);
		this.debutAlbum = otherSinger.debutAlbum;
		this.debutAlbumReleaseDate = new Date(otherSinger.debutAlbumReleaseDate);
	}
	public Entity clone() {
		return new Singer(this);
	}
	public String toString() {
		return super.toString() + "\nDebut Album: " + debutAlbum + "\nRelease Date: " + debutAlbumReleaseDate;
	}
	public String entityType() {
		return "singer!";
	}
	
	// create accessors
	public String getDebutAlbum() {
		return debutAlbum;
	}
	
	public Date getDebutAlbumReleaseDate() {
		return debutAlbumReleaseDate;
	}
	
	// create mutators
	public void setDebutAlbum(String debutAlbum) {
		this.debutAlbum = debutAlbum;
	}
	
	public void setDebutAlbumReleaseDate(Date debutAlbumReleaseDate) {
		this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
	}
}
