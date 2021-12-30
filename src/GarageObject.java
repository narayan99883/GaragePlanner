import java.util.Scanner;

//class for objects getting added into the garage
public class GarageObject {
	
	//information about each GarageObject
	public String name;
	public double size;
	public GarageSection location;
	
	//constructor
	public GarageObject (String name, double size, GarageSection location) {
		this.name = name;
		this.size = size;
		this.location = location;
	}
	
}

//class for different sections of garage
class GarageSection {
	
	//information about each GarageSection
	public String name;
	public double totalSize;
	public double sizeLeft;
	
	//constructor
	public GarageSection(String name, double totalSize) {
		this.name = name;
		this.totalSize = totalSize;
		sizeLeft = totalSize;
	}
}
