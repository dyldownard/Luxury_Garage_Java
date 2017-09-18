package basePackage;

public class FloorsArray {

	private Floor[] aR;
	
	public FloorsArray(int amount, int spaces) {
		aR = new Floor[amount];
		for (int i = 0; i < amount; i++) {
			aR[i] = new Floor(spaces, this);
		}
	}
	
	public Floor[] getFloorsArray() {
		return aR;
	}
	
	public Car search(String arg) {
		return new Car();
	}
	
	@Override
	public String toString() {
		return "FloorsArray has " + aR.length + " floors.";
	}
	
	public void printFloors() {
		for (int i = 0; i < aR.length; i++) {
			System.out.println("	Floor " + (i + 1) + "" +aR[i]);
		}		
	}
}
