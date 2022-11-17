import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
	public String name, serial;
	int value;

	Inventory (String name, String serial, int value) {
		this.name = name;
		this.serial = serial;
		this.value = value;
	}

	@Override
	public String toString() {
		return name + "," + serial + "," + value;
	}
}

class Main {
	public static void main(String[] args) {
		ArrayList<Inventory> inventory = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
		String name, serial;
		int value;

		do {
			System.out.println("Press 1 to add an item.");
			System.out.println("Press 2 to delete an item.");
			System.out.println("Press 3 to update an item.");
			System.out.println("Press 4 to show all items.");
			System.out.println("Press 5 to quit the program.");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch(choice) {
				case 1:
				System.out.println("Enter the name:");
				name = scanner.nextLine();
				System.out.println("Enter the serial number:");
				serial = scanner.nextLine();
				System.out.println("Enter the value in dollars (whole number):");
				value = scanner.nextInt();
				scanner.nextLine();
				inventory.add(new Inventory(name, serial, value));
				break;

				case 2:
				System.out.println("Enter the serial number of the item to delete:");
				serial = scanner.nextLine();
				for (int i = 0; i < inventory.size(); i++) {
					if (inventory.get(i).serial.equals(serial)) {
						inventory.remove(i);
					}
				}
				break;

				case 3:
				System.out.println("Enter the serial number of the item to change:");
				serial = scanner.nextLine();
				for (int i = 0; i < inventory.size(); i++) {
					if (inventory.get(i).serial.equals(serial)) {
						System.out.println("Enter the new name:");
						name = scanner.nextLine();
						inventory.get(i).name = name;
						System.out.println("Enter the new value in dollars (whole number):");
						value = scanner.nextInt();
						inventory.get(i).value = value;
					}
				}
				break;

				case 4:
				for(Inventory i : inventory) {
					System.out.println(i);
				}
				break;

				case 5:
				break;

				default:
				break;
			}

		} while (choice != 5);
	}
}
