package CS102_reUP.HangmanGame.Lab02;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocumentAnalyzer {
    public static void main (String [] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        char choice;
        String fileName;
        /*Document [] documents = new Document[1];
        documents[0] = new Document("text1");
        documents[0].processDocument();
        System.out.println(documents[0].getCount("the"));
        System.out.println((documents[0].getFrequency("simon")));
        System.out.println(documents[0].mostFrequent());
        System.out.println(documents[0].getFileContent());
        //System.out.println(documents[0].getCount(documents[0].mostFrequent()));*/

        System.out.println("Please enter the number of documents: ");
        int numberOfDocuments = input.nextInt();

        Document [] documents = new Document[numberOfDocuments];


        for(int i =0;i < numberOfDocuments;i++) {
            System.out.println("Enter the name of the document:");
            fileName = input.next();
            System.out.println(numberOfDocuments);
            documents[i] = new Document(fileName);
            documents[i].processDocument();
        }

        do{
            System.out.println("Enter 1 if you want to find the frequency of a word\n" +
                    "Enter 2 if you want to find the most frequent terms in each document\n" +
                    "Enter 3 to calculate tf-idf of user entered word for each document.\n" +
                    "Enter x to exit.");
            choice = input.next().charAt(0);
            String word;

            if(choice=='1'){
                System.out.println("Enter the word which you want to find the frequency:");
                word = input.next();
                for(int k = 0; k<numberOfDocuments;k++){
                    System.out.println("Document " + (k+1) + "\n" +
                            "Word: "+ word+"\n" +
                            "Term Frequency:" + documents[k].getFrequency(word));
                }
            }

            else if(choice=='2'){
                for(int a = 0; a<numberOfDocuments;a++){
                    System.out.println("Document: " + (a+1) + "\n" +
                            "Word: "+ documents[a].mostFrequent()+"\n" +
                            "Number of Appearance: " + (int)documents[a].getCount(documents[a].mostFrequent()));
                }
            }

            else if(choice=='3'){
                System.out.println("Enter the word which you want to calculate tf-idf:");
                String word1;
                word1 = input.next();
                int size=0;
                double [] freq = new double [numberOfDocuments];
                for(int j = 0;j<numberOfDocuments; j++) {
                    freq[j] = documents[j].getFrequency(word1);
                    if ( freq[j]!= 0) {
                        size++;
                    }
                }
                for(int a = 0; a<numberOfDocuments;a++){
                    System.out.println("Document: " + (a+1) + "\n" +
                            "Word: "+ word1+"\n" +
                            "tf-idf: " + freq[a]*(((Math.log(numberOfDocuments))/size)));
                }
            }
        }while(choice!='x');
    }
}
