import java.io.; import java.text.; import java.util.*;

public class StudentList { public static void main(String[] args) {

// Check arguments if (args[0].equals("a")) { System.out.println("Loading data ...");

	// String studentNames1 = readFile("students.txt");
	//String line = studentNames1(bufferedReader);
	String studentNames[] = readFile("students.txt").split(",");
	for (String studentName : studentNames) {
		System.out.println(studentName.trim());
	}

	System.out.println("Data Loaded.");
} else if (args[0].equals("r")) {
	System.out.println("Loading data ...");
	String studentNames1 = readFile("students.txt");
	// String line = readOneFile(bufferedReader);
	String studentNames[] = studentNames1.split(",");
	Random random = new Random();
	int studentNumber = random.nextInt(4);
	System.out.println(studentNames[studentNumber].trim());

	System.out.println("Data Loaded.");
} else if (args[0].contains("+")) {
	System.out.println("Loading data ...");
	try {
		BufferedWriter bufferedWriter = writeFile("students.txt");
		String newStudentName = args[0].substring(1);
		Date date = new Date();
		String datedfomrmatrr = "dd/mm/yyyy-hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(datedfomrmatrr);
		String formatedDate = dateFormat.format(date);
		bufferedWriter.write(", " + newStudentName + "\nList last updated on " + formatedDate);
		bufferedWriter.close();
	} catch (Exception e) {
	}

	System.out.println("Data Loaded.");
} else if (args[0].contains("?")) {
	System.out.println("Loading data ...");

	String studentNames1 = readFile("students.txt");
	// String line = readOneFile(bufferedReader);
	if (studentNames1.contains(args[0].substring(1))) {
		System.out.println("we found it");
	} else {
		System.out.println("we don't found it");
	}

	System.out.println("Data Loaded.");
}
    else if(args[0].contains("c"))
	{
		System.out.println("Loading data ...");

		String studentNames1= readFile("students.txt");
		// String line = readOneFile(bufferedReader);
		String names[]=studentNames1.split(",");
		System.out.println(names.length/2+"words found");

		System.out.println("Data Loaded.");
	}

}

	static String readFile(String fileName) {
		try {
			BufferedReader bufferedReader= new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));



			String studentNames1= bufferedReader.readLine();
			return studentNames1;
		} catch (Exception e) {
			return null;
		}
	}

	static BufferedWriter writeFile(String fileName) {
		try {
			return new BufferedWriter(
					new FileWriter("students.txt", true));
		} catch (Exception e) {
			return null;
		}

	}
}
