import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals(Constant.showAll)) {
            System.out.println(Constant.loadingDataMsg);
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.txtfileName)));
                String line = bufferedReader.readLine();
                String studentNames[] = line.split(Constant.coma);
                for (String studentName : studentNames) {
                    System.out.println(studentName.trim());
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].equals(Constant.random)) {
            System.out.println(Constant.loadingDataMsg);
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.txtfileName)));
                String line = bufferedReader.readLine();
                String studentNames[] = line.split(Constant.coma);
                Random random = new Random();
                int studentNumber = random.nextInt(4);
                System.out.println(studentNames[studentNumber].trim());
            } catch (Exception e) {
            }
            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.add)) {
            System.out.println(Constant.loadingDataMsg);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(Constant.txtfileName, true));
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
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.txtfileName)));
                String line = bufferedReader.readLine();
                if (line.contains(args[0].substring(1))) {
                    System.out.println(Constant.foundMsg);
                } else {
                    System.out.println(Constant.notFoundMsg);
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.count)) {
            System.out.println(Constant.loadingDataMsg);
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(Constant.txtfileName)));
                String line = bufferedReader.readLine();
                String names[] = line.split(Constant.coma);
                System.out.println(names.length / 2 + Constant.wordFound);
            } catch (Exception e) {
            }
            System.out.println(Constant.dataLoadedMsg);
        }
        else{
            System.out.println(Constant.warningMsg);
        }
    }
}