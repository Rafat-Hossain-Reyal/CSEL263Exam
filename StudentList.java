import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals(Constant.showAll)) {
            System.out.println(Constant.loadingDataMsg);

                String studentNames[] = readFile(Constant.txtfileName).split(Constant.coma);
                for (String studentName : studentNames) {
                    System.out.println(studentName.trim());
                }

            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].equals(Constant.random)) {
            System.out.println(Constant.loadingDataMsg);

                String studentNames[] = readFile(Constant.txtfileName).split(Constant.coma);
                Random random = new Random();
                int studentNumber = random.nextInt(4);
                System.out.println(studentNames[studentNumber].trim());

            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.add)) {
            System.out.println(Constant.loadingDataMsg);
            try {
                BufferedWriter bufferedWriter = writeFile(Constant.txtfileName);
                String newStudentName = args[0].substring(1);
                DateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);
                bufferedWriter.write(Constant.coma + newStudentName + Constant.updateList + new SimpleDateFormat(Constant.dateFormat));
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.search)) {
            System.out.println(Constant.loadingDataMsg);
            String [] names=readFile(Constant.txtfileName).split(Constant.coma);
            int count1=0;
            for(int i=0;i<names.length;i++)
            {
                if(names[i].trim().equals(args[0].substring(1)))
                {
                    count1++;
                }

            }
            if(count1==0)
            {
                System.out.println(args[0].substring(1)+" "+ Constant.notFoundMsg);
            }
            else
            {
                System.out.println(args[0].substring(1)+" "+Constant.foundMsg+" "+count1+"times");
            }
            System.out.println(Constant.dataLoadedMsg);
        } else if (args[0].contains(Constant.count)) {
            System.out.println(Constant.loadingDataMsg);

                String names[] = readFile(Constant.txtfileName).split(Constant.coma);
                System.out.println(names.length + Constant.wordFound);

            System.out.println(Constant.dataLoadedMsg);
        }
        else{
            System.out.println(Constant.warningMsg);
        }
    }
    static String readFile(String fileName)
    {
        try
        {
            BufferedReader bufferedReader= new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName)));
        String names=bufferedReader.readLine();
        return  names;

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