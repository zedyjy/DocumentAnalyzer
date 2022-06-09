package CS102_reUP.HangmanGame.Lab02;

public class Term {
    private String word;
    private int count;

    public Term(){

    }

    public Term(String word){
        setWord(word);
        count = 0;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getWord(){
        return word;
    }

    public void incrementCount(){
        count++;
    }

    public int getTermCount(){
        return count;
    }
}
