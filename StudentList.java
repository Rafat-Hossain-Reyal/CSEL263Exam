import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals(Constant.showAll)) {
            System.out.println(Constant.loadingDataMsg);

                BufferedReader bufferedReader =readFile(Constant.txtfileName);
                String line = readOneFile(bufferedReader);
                String studentNames[] = line.split(Constant.coma);
                for (String studentName : studentNames) {
                    System.out.println(studentName.trim());
                }

            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].equals(Constant.random)) {
            System.out.println(Constant.loadingDataMsg);

                BufferedReader bufferedReader =readFile(Constant.txtfileName);
                String line = readOneFile(bufferedReader);
                String studentNames[] = line.split(Constant.coma);
                Random random = new Random();
                int studentNumber = random.nextInt(4);
                System.out.println(studentNames[studentNumber].trim());

            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.add)) {
            System.out.println(Constant.loadingDataMsg);
            try {
                BufferedWriter bufferedWriter = writeFile(Constant.txtfileName);
                String newStudentName = args[0].substring(1);
                Date date = new Date();
                String dateFormate = Constant.dateFormat;
                DateFormat dateFormat = new SimpleDateFormat(dateFormate);
                String formatedDate = dateFormat.format(date);
                bufferedWriter.write(Constant.coma + newStudentName + Constant.updateList + formatedDate);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.search)) {
            System.out.println(Constant.loadingDataMsg);
                BufferedReader bufferedReader = readFile(Constant.txtfileName);
                String line = readOneFile(bufferedReader);
                if (line.contains(args[0].substring(1))) {
                    System.out.println(Constant.foundMsg);
                } else {
                    System.out.println(Constant.notFoundMsg);
                }

            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.count)) {
            System.out.println(Constant.loadingDataMsg);

                BufferedReader bufferedReader = readFile(Constant.txtfileName);
                String line = readOneFile(bufferedReader);
                String names[] = line.split(Constant.coma);
                System.out.println(names.length / 2 + Constant.wordFound);

            System.out.println(Constant.dataLoadedMsg);
        }
        else{
            System.out.println(Constant.warningMsg);
        }
    }
    static BufferedReader readFile(String fileName)
    {
        try
        {
            return new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)));
        }
        catch (Exception e)
        {
            return null;
        }
    }
    static String readOneFile(BufferedReader bufferedReader)
    {
        try
        {
            return bufferedReader.readLine();
        }catch (Exception e)
        {
            return null;
        }
    }
    static BufferedWriter writeFile(String fileName)
    {
        try
        {
            return new BufferedWriter(
                    new FileWriter(fileName, true));
        }
        catch (Exception e)
        {
            return null;
        }
    }
}