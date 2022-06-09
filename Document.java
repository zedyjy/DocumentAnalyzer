package CS102_reUP.HangmanGame.Lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Document {

    public Term [] terms;
    public String fileName;
    public int count;
    public int totalWordCount = 0;
    String[]termsInTxt;
    public Document() {

    }

    public Document(String fileName) {
        terms = new Term[10000];
        setFileName(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = "C:\\Users\\zeyne\\Dropbox\\My PC (LAPTOP-UIF680BP)\\Desktop\\"+fileName+".txt";
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileContent() throws FileNotFoundException {
        String content;
        File file = new File(getFileName());
        Scanner sc = new Scanner(file);

        sc.useDelimiter("\\Z");
        content =sc.next().toLowerCase(Locale.ROOT).replaceAll("[,.:\"]","");
        content=content.replace("\n"," ");
        content= content.replace("-"," ");
        return content;
    }

    public void processDocument() throws FileNotFoundException {
        int temp = 0;
        int term = 0;

        termsInTxt = getFileContent().split("\\s");
        for (int i = 0; i <getFileContent().length(); i++) {
            if (getFileContent().charAt(i) == ' ') {
                Term t = new Term(getFileContent().substring(temp+1, i));
                for(int j=0;j<term;j++) {
                    if (t.getWord().equals(terms[j].getWord())&&terms[i]!=null) {
                        i++;
                        terms[j].incrementCount();
                    }
                }
                terms[term]=t;
                term++;
                temp = i;
            }
        }
        totalWordCount=termsInTxt.length-2;
        System.out.println(totalWordCount);
    }


    public int getCount(String word) {
        count=0;
        for(int i =0; i < terms.length;i++) {
            if (terms[i] != null && terms[i].getWord().equals(word)) {
                count++;
            }
        }
        return count;
    }

    public double getFrequency(String word){
        return (double)getCount(word)/(totalWordCount);
    }

    public String mostFrequent(){
        double max = 0;
        String mostFrequentWord="";
        double frequencyCount;
        for(int i = 1; i < totalWordCount;i++) {
                frequencyCount = getFrequency(termsInTxt[i]);
                if (frequencyCount > max ) {
                    max = frequencyCount;
                    mostFrequentWord = termsInTxt[i];
                    i++;
                }
        }
        return mostFrequentWord;
    }
}


