import java.util.ArrayList;

public class Table extends ArrayList<String[]> {

	private static final long serialVersionUID = 1L;
	private int size[];
	
	public int[] getSize() {
		return size;
	}
	
	public void setSize(int[] size) {
		this.size = size;
	}
}
