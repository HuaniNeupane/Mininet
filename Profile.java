import java.util.*;

public class Profile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, People> ppl = new HashMap<>();

		ppl.put("Alice", new Adult("Alice", 27, "works in KFC"));
		ppl.put("Bob", new Adult("Bob", 28, "CEO"));
		ppl.put("Fiona", new Teen("Fiona", 12, "student"));
		ppl.put("Gigi", new Teen("Gigi", 10, "student"));
		ppl.put("Ivan", new Infant("Ivan", 2));

		addPerson(ppl);
		displayNameList(ppl);

	}

	public static void addPerson(Map<String, People> _people) {

		String choice;
		Scanner sc3 = new Scanner(System.in);
		do {
			System.out.println("++++++ADDING  NEW  HUMAN++++++\n");

			// Creating new Scanner
			Scanner sc = new Scanner(System.in);

			// Asking for name input (needs
			System.out.print("Enter name: ");
			String _name = sc.nextLine();

			// Asking for age input
			System.out.print("Enter age(1-100): ");
			int _age = sc.nextInt();

			if (_age < 3) {
				_people.put(_name, new Infant(_name, _age));
				System.out.println("ADDED: 1 baby");
			} else {
				Scanner sc2 = new Scanner(System.in);
				System.out.print("Add status: ");
				String _status = sc2.nextLine();

				if (_age > 16) {
					_people.put(_name, new Adult(_name, _age, _status));
					System.out.println("ADDED: 1 Adult");
				} else {
					_people.put(_name, new Teen(_name, _age, _status));
					System.out.println("ADDED: 1 Teenager");
				}
			}
		// Ask user if they want to add another person 
			System.out.println("Would you like to add another? (Y/N): ");
			choice = sc3.nextLine();
		} while (choice == "Y");
	}

	public static void displayNameList(Map<String, People> p) {

		// get set of the entries
		Set set = p.entrySet();

		// get an iterator
		Iterator i = set.iterator();

		// display the list
		System.out.println("=====LIST NAMES====");
		while (i.hasNext()) {
			Map.Entry list = (Map.Entry) i.next();
			System.out.println(list.getKey());
		}
	}
}
