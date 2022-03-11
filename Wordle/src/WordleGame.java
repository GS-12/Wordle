import java.util.Scanner;

public class WordleGame{

    public static void main(String[] args){
        // Write debugAnswer to get word.
        String[]words = {"hello","other","about","which","their","faith","lunch","maybe","earth","elite","sharp","sword"};
        String word = words[(int)(Math.random() * words.length)];
        Scanner scnr = new Scanner(System.in);
        //System.out.println(word);
        System.out.println("Guess the 5-letter word.");
        System.out.println("You have 6 tries.");
        System.out.println("Y - correct, C - correct but in the wrong place, X - wrong");
        int g = 6;
        String guess = "";
        String guessInput = "";
        String newGuess = "";
        String newWord = "";
        while(!guess.equals(word)){
            if(g > 0){
                guessInput = scnr.next();
                guess = guessInput.toLowerCase();
            }
            if(guessInput.equals("debugAnswer")){
                System.out.println(word);

            }
            if(g == 0){
                break;
            }
            newGuess = guess;
            newWord = word;
            if(guess.length() != 5){
                System.out.println("Enter a 5-letter word");
                continue;
            }
            for(int i = 0; i < word.length(); i++){
                boolean correct = false;
                newGuess = guess;
                //System.out.println(newWord + " " + newGuess);


                if(guess.charAt(i) == word.charAt(i)){
                    System.out.print("Y ");
                    correct = true;
                }
                else {
                    newGuess = guess;
                    if(i == 0){
                        for (int j = 0; j < newWord.length(); ++j){
                            if(guess.charAt(j) == word.charAt(j)){
                                newWord = newWord.replaceFirst(newWord.substring(j,j+1),"");
                                newGuess = newGuess.replaceFirst(newGuess.substring(j,j+1),"");
                                //System.out.println(newWord + " " + newGuess);
                            }
                        }
                    }

                    for(int j = 0; j < newWord.length(); ++j){
                        if(i <= newWord.length()){
                            if(newGuess.charAt(i) == newWord.charAt(j)){
                                System.out.print("C ");
                                newWord = newWord.replaceFirst(newWord.substring(j,j+1),"");
                                newGuess = newGuess.replaceFirst(newGuess.substring(i,i+1),"");
                                //System.out.println(newWord + " " + newGuess);
                                correct = true;
                            }
                        }

                    }
                }
                if(!correct){
                    System.out.print("X ");
                }
            }
            if(!guess.equals(word)){
                System.out.println("");
                g -= 1;
                System.out.println("You have " + g + " guesses remaining");
            }

        }
        if(guess.equals(word)){
            System.out.println("\nCorrect!");
        }
        else {
            System.out.println("The word was " + word);
        }

    }
}
