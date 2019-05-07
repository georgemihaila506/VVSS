package note.model;

public class Corigent {
	private Elev elev;
	private int nrMaterii;
	/**
	 * @return the numeElev
	 */
	
	public Corigent(Elev numeElev, int nrMaterii) {
		this.elev = numeElev;
		this.nrMaterii = nrMaterii;
	}
	
	
	public Elev getElev() {
		return elev;
	}
	/**
	 * @param numeElev the numeElev to set
	 */
	public void setElev(Elev elev) {
		this.elev = elev;
	}
	/**
	 * @return the nrMaterii
	 */
	public int getNrMaterii() {
		return nrMaterii;
	}
	/**
	 * @param nrMaterii the nrMaterii to set
	 */
	public void setNrMaterii(int nrMaterii) {
		this.nrMaterii = nrMaterii;
	}

	public String toString() {
		return elev.toString() + " -> " + nrMaterii;
	}
}
