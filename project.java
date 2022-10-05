import java.util.*;
import java.security.*;
import java.io.*;


public class project
{
    public static void main (String[] args) throws Exception
    {      
             System.out.println((checkMatchCount()));
  
    }
    public static int checkMatchCount(){
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();

        try {
            InputStream inputStream = new FileInputStream("/Users/bsav/Library/CloudStorage/OneDrive-MaynoothUniversity/Java/SHA256_Project/nameFile.txt");
            InputStream inputStream1 = new FileInputStream("/Users/bsav/Library/CloudStorage/OneDrive-MaynoothUniversity/Java/SHA256_Project/countriesFile.txt");
            // Creating a Scanner object
            Scanner sc = new Scanner(inputStream);
            Scanner sc1 = new Scanner(inputStream1);
            // StringBuffer to store the contents
           
            // Appending each line to the buffer
            while (sc.hasNext()) {
                sb.append(" " + sc.nextLine());
            }

            while (sc1.hasNext()) {
                sb1.append(" " + sc1.nextLine());
            }

            

        } catch (Exception e) {
            e.printStackTrace();
        }
        ////Converts the Words in the string buffer to a string array using split function
        String []a= sb.toString().split(" ");
        String []b= sb1.toString().split(" ");


        // Instantiate two strings to store the randomly generated sentences
        String firstSentence= a[random()]+" is in "+ b[random()] +".";
        String secondSentence= a[random()]+" is in "+ b[random()] +".";

        ///Prints out the sentences
        System.out.println(firstSentence+" \n"+secondSentence);


        ///Stores the sha256 values in the strings
        String firstHash=sha256(firstSentence);
        String secondHash= sha256(secondSentence);

        System.out.println(firstHash+" \n"+secondHash);

        ///Converts to char arrays and get a count of matching characters 
        char []hash1=firstHash.toCharArray();
        char []hash2=secondHash.toCharArray();

        int count=0;
        for(int i=0;i<hash1.length;i++){
           if(hash1[i]==hash2[i]){
               count++;
           }

        }

        //returns the count
        return count;
        }

     public static int random()
        {
            Random random = new Random();
            int value = random.nextInt(190 + 1) + 1;
            return value;
        }

    
    public static String sha256(String input)
    {
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);
            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<data.length;i++){
                sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
            }
            return sb.toString();
        }catch(Exception e){
            return(e.toString());
        }
    }

    public static int check(String input, String input2)
    {
        int count = 0;
        for(int i=0; i < input.length(); i++)
        {
            if(input.charAt(i) == input2.charAt(i))
            {
                count++;
            }
        }
        return count;
    }
}
