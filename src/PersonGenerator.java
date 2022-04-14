//@author Maximiliano De Santiago Galan

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;


public class PersonGenerator
{
    public static void main(String[] args) {
        String IDNum;
        String firstName;
        String lastName;
        String title;
        int YOB;

        String fileName;
        Scanner fileNameInput = new Scanner(System.in);
        fileName = SafeInput.getNonZeroLenString(fileNameInput, "Input Desired File Name (Don't include .txt)");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");

        boolean adding;

        ArrayList<Person> people = new ArrayList<Person>();
        adding = true;

        //Get input from user
        while(adding)
        {
            //get Safeinput from user for each field in Person
            Scanner IDNumInput = new Scanner(System.in);
            IDNum = SafeInput.getNonZeroLenString(IDNumInput, "IDNum");
            Scanner firstNameInput = new Scanner(System.in);
            firstName = SafeInput.getNonZeroLenString(firstNameInput, "First Name");
            Scanner lastNameInput = new Scanner(System.in);
            lastName = SafeInput.getNonZeroLenString(lastNameInput, "Last Name");
            Scanner titleInput = new Scanner(System.in);
            title = SafeInput.getNonZeroLenString(titleInput, "Title");
            Scanner YOBInput = new Scanner(System.in);
            YOB = SafeInput.getRangedInt(YOBInput, "Year of Birth", 1940, 2000);
            //creates a temporary Person with input data
            Person holder = new Person(IDNum, firstName, lastName, title, YOB);
            //add temp person to arraylist
            people.add(holder);
            //Ask user if they wish to enter another person
            Scanner continueInput = new Scanner(System.in);
            adding = SafeInput.getYNConfirm(continueInput, "Add Another Person? (Y or N)");
        }
        int counter = 0;
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Person person : people)
            {
                writer.write(person.toCSVDataRecord(), 0, person.toCSVDataRecord().length());
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
