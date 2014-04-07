
public class House {

	private int numberOfRooms;
	private String color;
	
	public House () {
		this.numberOfRooms = 0;
		this.color = "";
	}
	
	public House (int numberOfRooms, String color)  {
		this.numberOfRooms = numberOfRooms;
		this.color = color;
	}
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	public void setNumberOfRooms(int numberOfRooms) {
		if (numberOfRooms < 0)
			this.numberOfRooms = 0;
		this.numberOfRooms = numberOfRooms;
	}
	
	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "House [numberOfRooms=" + numberOfRooms + ", color=" + color
				+ "]";
	}

	public boolean equals(House h) {
		if (h != null && this.getColor().equals(h.getColor()) &&
			(this.getNumberOfRooms() == (h.getNumberOfRooms())))
		//if (this.getColor().equals(h.getColor()) &&
			//(this.getNumberOfRooms() == (h.getNumberOfRooms())))
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj != null) && obj.getClass().equals(this.getClass())) {			
		//if (obj.getClass().equals(this.getClass()) && (obj != null)) {			
			House h = (House)obj;
			if (this.getColor().equalsIgnoreCase(h.getColor()) &&
					this.getNumberOfRooms() == h.getNumberOfRooms())
				return true;
				
			}
		return false;
	}
}
