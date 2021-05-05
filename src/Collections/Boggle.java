package Collections;
/**
 * this is based on boxing boogle game to develop Collection's understanding, this will finish the game
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Boggle {static final String[] DICE = {"AJBBOO", "AFFPSK", "ANEAGE", "APSHCO", "QNUMHI", "ZNHRLN", "TDSTYI", "TTWOOA", "TLRYET", "TUMIOC", "EDVLRY", "EDRLXI", "EEGNHW", "EIOTSS", "ERHTWV", "EENUSI"};

    static final int ROW_LENGTH = 4;

    char[] boggleCharacters;
    Set<String> dictionary;
    static List<Set<Integer>>neighbours  = new ArrayList<Set<Integer>>(DICE.length);//make nested list show the introduction about the numbers, no overlap square

    /**
     *  0  1  2  3
     *  4  5  6  7
     *  8  9 10 11
     * 12 13 14 15
     *
     * So, for example, the neighbours of 0 are 1,4,5;
     * the neighbours of 5 are 0, 1, 2, 4, 6, 8, 9, and 10;
     * This function implements how to create a small matrix( this case is that creating 3*3 matrix in 4*4 matrix)
     * A matrix algorithm
     */

    static {//above function
        for (int i=0; i<DICE.length;i++){//16 total length
            Set<Integer> neighbourOfI = new HashSet<>();
            int x = i/4; // the number of row, 0,1,2,3 are row 1, 4,5,6,7 are row 2
            int y = i%4;// top of the square, like 5 the top neighbours are 0,1,2 and the 8%4=0, 9%4=1, 10%4=2
            for (int neighbourX = x-1; neighbourX<=x+1;neighbourX++){//the size of each small square's length is 3
                if(neighbourX >=0 && neighbourX < ROW_LENGTH){//boundary
                    for (int neighbourY = y-1; neighbourY <=y+1;neighbourY++){//the size of each small square's width is 3
                        if(neighbourY >=0 && neighbourY < ROW_LENGTH){//boundary
                        int neighbourDienumber = neighbourX*4 + neighbourY;
                        if(neighbourDienumber != i){//cannot be itself
                            neighbourOfI.add(neighbourDienumber);
                        }
                        }
                    }
                }
            }
            //System.out.println("Neighbour of "+ i); //this is for checking the function
            //for(var neighbour: neighbourOfI){
                //System.out.println(neighbour);
            neighbours.add(neighbourOfI);
        }
    }


    Boggle(){
        boggleCharacters = shake();
        //constructor shake random chars
        dictionary = processDictionary("Assets/dictionary.txt");//input dictionary
    }

    /**
     * select code which would be refacotred,
     * Click right of mouse,
     * Choose refactor -> Refactor
     * @param args
     */
    public static void main(String[] args) { Boggle boggle = new Boggle();
    //generate random chars
        boggle.solve();
    }

    /**
     * 1. Start at a particular die
     * 2. for each neighbour die
     * 3. move to neighbour - check whether already visited
     */
    void solve(){
        for(int i=0; i<DICE.length;i++) {
            Set<String> results = new HashSet<>();
            int start = i; //change to method
            boolean[] alreadyVisited = new boolean[DICE.length];
            alreadyVisited[start] = true;
            String prefix = String.valueOf(boggleCharacters[start]);
            findWords(results, start, alreadyVisited, prefix);
            for(var word: results){
                System.out.println(word);
            }
        }
    }

    private void findWords(Set<String> results, int start, boolean[] alreadyVisited, String prefix) {//set is for eliminating overlap
        //for each neighbour die
        for(Integer neighbour : neighbours.get(start)){//small square in for current char, like the neighbours of 5 are 0, 1, 2, 4, 6, 8, 9, and 10
            if (!alreadyVisited[neighbour]){
                String candidate = prefix + boggleCharacters[neighbour];
                if (candidate.length() >=3&&dictionary.contains(candidate)){//longer words for candidate.length ==3
                    //this is a word
                    results.add(candidate);
                }
                //recursion
                alreadyVisited[neighbour] = true;//cannot be overlap for neighbours
                findWords(results,neighbour, alreadyVisited,candidate);//recur
                alreadyVisited[neighbour] = false;
            }
        }
    }


    Set<String> processDictionary(String filename){//method to create the dictionary to the hashset
        Set<String> words = new HashSet<>();
        try{//if there have a file in the rout
            Scanner s = new Scanner(new File(filename));//input the file of dictionary in the asset
            while(s.hasNext()){
                String word = s.next().toUpperCase();
                words.add(word);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Found "+ words.size()+" words.");//calculate how many words
        return words;

    }

    private static char[] shake() {
        char [] boggieDice = new char[16];//change from static
        StringBuilder result = new StringBuilder();
        //Random rand = new Random(0);//try a same boggle dice to debug,
        Random rand = new Random();
        boolean[] alreadySelected = new boolean[DICE.length];
        for (int i = 0; i < DICE.length; i++) {
        int die = rand.nextInt(DICE.length);
        while (alreadySelected[die]) {
            die = (die + 1) % DICE.length;
            //die = rand.nextInt(dice.length); // could be slow?
        }
        alreadySelected[die] = true;
        int face = rand.nextInt(6);
        char faceChar = DICE[die].charAt(face);
        boggieDice[i] = faceChar;
        result.append(faceChar);
        if (i % ROW_LENGTH == ROW_LENGTH - 1) result.append(System.lineSeparator());
    }
        System.out.println(result.toString());
        return boggieDice;//change not void
    }

    @Test
    public void testEnglishWords(){//test dictionary whether the dictionary is correct
        Boggle boggle = new Boggle();
        assertTrue(boggle.dictionary.contains("THIN"));
        assertFalse(boggle.dictionary.contains("ZZZZZZZZ"));
    }
}
