//@author Maximiliano De Santiago Galan

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


import static java.nio.file.StandardOpenOption.CREATE;


public class PersonReader
{
    ArrayList<Person> people = new ArrayList<Person>();
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File desiredFile;
        String rec = "";
        ArrayList<String[]> storedData = new ArrayList<String[]>();
        ArrayList<Person> generatedPeople = new ArrayList<Person>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                desiredFile = chooser.getSelectedFile();
                Path file = desiredFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;

                    String[] temp = rec.split(","); //create temporary array storing divided data
                    String YOBString = temp[4];
                    YOBString = YOBString.replaceAll(" ",""); //remove spaces from String to allow conversion to Int
                    Person Temp = new Person(temp[0], temp[1], temp[2], temp[3], Integer.valueOf(YOBString)); //fill a Person object with the read data
                    generatedPeople.add(Temp); //add generated Person to an arrayList
                }
                reader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(("File not found"));
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        int lineCount = 1;


        for(Person People : generatedPeople)
        {
            System.out.println("Line " + lineCount + " " + People.toCSVDataRecord()); //print out people in CSV form
            lineCount ++;
        }
        System.out.println("\n\nData file read!");
    }


}
