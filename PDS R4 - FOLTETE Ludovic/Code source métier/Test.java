package allocate;

public class Test {

	public static void main(String[] args) {
		Database db = new Database();
		ControlerAllocation ca = new ControlerAllocation(db);
		ca.autoAllocate();
	}

}
