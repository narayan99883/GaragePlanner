import java.util.Scanner;
import java.lang.Object;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.*;

//class for dealing with the garage as a whole, incorporates other garage classes
public class Garage {

	// to store all the garageobjects
	public ArrayList<GarageObject> objects;

	// to store the 5 garagesections
	public GarageSection[] sections;
	// SECTION CODES:
	// 0 = main
	// 1 = hangers
	// 2 = racks
	// 3 = doorside
	// 4 = shelves

	// constructor
	public Garage() {
		// adding in each of the 5 sections
		// 480 feet^3 in total
		sections = new GarageSection[5];
		sections[0] = new GarageSection("main", 240);
		sections[1] = new GarageSection("hangers", 80);
		sections[2] = new GarageSection("racks", 60);
		sections[3] = new GarageSection("doorside", 40);
		sections[4] = new GarageSection("shelves", 60);

		objects = new ArrayList<GarageObject>();
	}

	// determines array position based on location name
	public int whichSection(String location) {
		if (location.equals("main")) {
			return 0;
		} else if (location.equals("hangers")) {
			return 1;
		} else if (location.equals("racks")) {
			return 2;
		} else if (location.equals("doorside")) {
			return 3;
		} else if (location.equals("shelves")) {
			return 4;
		} else {
			System.out.println("Invalid, program terminated");
			return -1;
		}
	}

	// adding an object
	// error is skipping line (for input to read)
	public boolean insert() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the object?");
		String name = input.nextLine();
		System.out.println("Where are you putting the object?");
		String loca = input.nextLine();
		System.out.println("What is the size of the object?");
		double size = Double.parseDouble(input.nextLine());

		GarageObject newObject = new GarageObject(name, size, sections[whichSection(loca)]);

		// if object is too big
		if (sections[whichSection(loca)].sizeLeft - size < 0) {
			System.out.println("Object too big - can't add to location");

			return false;
		}

		// adding to arraylist and adjusting sizeLeft in location
		objects.add(newObject);
		sections[whichSection(loca)].sizeLeft -= size;
		System.out.println("Object added to garage.");
		// input.close();
		return true;
	}

	// deleting an object
	public boolean delete() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the object?");
		String objectName = input.nextLine();

		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).name.equals(objectName)) {
				objects.get(i).location.sizeLeft += objects.get(i).size;
				objects.remove(i);
				System.out.println("Object removed from garage");
				return true;
			}
		}

		// if name is not found in arraylist
		System.out.println("Object not found");
		return false;
	}

	// writes to the txt file in textfiles/textdoc.txt
	public void createFilee() {
		
		System.out.println("Size is: " + objects.size());
		System.out.println(sections[0].name);

		Path p = Paths.get("txtfiles/textdoc.txt");
		PrintWriter pr;
		try {
			pr = new PrintWriter(Files.newBufferedWriter(p));
			System.out.println("Making file...");
		} catch (IOException io) {
			System.out.println("error occured with printing");
			throw new RuntimeException("newBufferedWriter threw IO Exception");
		}
		pr.println("This is a list of all the stuff in your garage");
		pr.println("You have " + objects.size() + " objects in your garage\n");

		for (int i = 0; i < objects.size(); i++) {
			pr.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
					+ objects.get(i).location.name + " location");
		}

		System.out.println("The file path is: " + new File("txtfiles/textdoc.txt").getAbsoluteFile());
		pr.close();

	}

	// method to call all other sorts
	public void sort() {
		Scanner input = new Scanner(System.in);
		System.out.println("By smallest, largest, recent, old, or alphabetical?");
		String how = input.nextLine();

		if (how.equals("smallest")) {
			sortSmallest();
		} else if (how.equals("largest")) {
			sortLargest();
		} else if (how.equals("recent")) {
			sortRecent();
		} else if (how.equals("old")) {
			sortOld();
		} else if (how.equals("alphabetical")) {
			sortAlphabetical();
		} else if (how.equals("location")) {
			sortLocation();
		} else {
			System.out.println("Incorrect input - please input either size, recent, old, or alphabetical");
		}

	}

	// sort from largest to smallest
	public void sortSmallest() {
		ArrayList<GarageObject> copy = objects;

		int n = copy.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (copy.get(j).size > copy.get(j + 1).size) {
					// swap
					Collections.swap(copy, j, j + 1);
				}
			}
		}

		for (int i = 0; i < copy.size(); i++) {
			System.out.println(copy.get(i).name + " is " + copy.get(i).size + " feet cubed and is in the "
					+ copy.get(i).location.name + " location");
		}
	}

	// sort from largest to smallest
	public void sortLargest() {
		ArrayList<GarageObject> copy = objects;

		int n = copy.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (copy.get(j).size < copy.get(j + 1).size) {
					// swap
					Collections.swap(copy, j, j + 1);
				}
			}
		}

		for (int i = 0; i < copy.size(); i++) {
			System.out.println(copy.get(i).name + " is " + copy.get(i).size + " feet cubed and is in the "
					+ copy.get(i).location.name + " location");
		}
	}

	public void sortLocation() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).location.name.equals("main")) {
				System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
						+ objects.get(i).location.name + " location");
			}
		}
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).location.name.equals("hangers")) {
				System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
						+ objects.get(i).location.name + " location");
			}
		}
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).location.name.equals("racks")) {
				System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
						+ objects.get(i).location.name + " location");
			}
		}
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).location.name.equals("doorside")) {
				System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
						+ objects.get(i).location.name + " location");
			}
		}
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).location.name.equals("shelves")) {
				System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
						+ objects.get(i).location.name + " location");
			}
		}
	}

	// sort by the oldest objects being shown first
	public void sortOld() {
		for (int i = 0; i < objects.size(); i++) {
			System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
					+ objects.get(i).location.name + " location");
		}
	}

	// sort by newest objects being shown first
	public void sortRecent() {
		for (int i = objects.size() - 1; i >= 0; i--) {
			System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
					+ objects.get(i).location.name + " location");
		}
	}

	// sort by alphabetical order
	public void sortAlphabetical() {
		ArrayList<GarageObject> copy = objects;

		int n = copy.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (copy.get(j).name.compareTo(copy.get(j + 1).name) > 0) {
					// swap
					Collections.swap(copy, j, j + 1);
				}
			}
		}

		for (int i = 0; i < copy.size(); i++) {
			System.out.println(copy.get(i).name + " is " + copy.get(i).size + " feet cubed and is in the "
					+ copy.get(i).location.name + " location");
		}
	}

	// seeing how much size is available in each section
	public void howMuchSpace() {
		for (int i = 0; i < 5; i++) {
			System.out
					.println("The " + sections[i].name + " section has " + sections[i].sizeLeft + " feet cubed left.");
		}
	}

	// get info on an object with a certain name.
	public void getInfo() {
		System.out.println("What is the name of the object?");
		Scanner input = new Scanner(System.in);
		String nameObj = input.nextLine();

		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).name.equals(nameObj)) {
				System.out.println(objects.get(i).name + " is " + objects.get(i).size + " feet cubed and is in the "
						+ objects.get(i).location.name + " location");
			}
		}

	}

	public void clearSection() {
		System.out.println("What section do you want to clear?");
		Scanner input = new Scanner(System.in);
		String sec = input.nextLine();

		int x = whichSection(sec);

		for (int i = objects.size() - 1; i >= 0; i--) {
			if (objects.get(i).location.name.equals(sec)) {
				objects.get(i).location.sizeLeft += objects.get(i).size;
				objects.remove(i);
			}
		}
		System.out.println("Section cleared.");
	}

	// FOR TESTING PURPOSES
	public void testWrite() {
		
		System.out.println("Size is: " + objects.size());
		
		Path p = Paths.get("txtfiles/textdoc.txt");
		PrintWriter pr;
		try {
			pr = new PrintWriter(Files.newBufferedWriter(p));
			System.out.println("no error, file should write (?)");
		} catch (IOException io) {
			System.out.println("error occured with printing");
			throw new RuntimeException("newBufferedWriter threw IO Exception");
		}
		System.out.println("File should write (?)");
		for (int k = 0; k < 10; k = k + 1) {
			pr.println(k);
		}
		System.out.println(new File("textdoc.txt").getAbsoluteFile());
		pr.close();
	}

}
