import java.util.*;
import java.security.SecureRandom;

public class WordSearchGen {

    private static int gridSize;
    private char[][] wSearch;
    private char[][] solution;
    private SecureRandom rand;
    private Scanner console;
    private String[] wList;

    public WordSearchGen() {
        this.console = new Scanner(System.in);
        this.rand = new SecureRandom();
    }


    public void printIntro() {
        System.out.println("Welcome to my word search generator!");
        System.out.println("This program will allow you to generate your own word search puzzle");
    }
    public char printMenu() {
        char menuEntry;
        Scanner input = new Scanner(System.in);

        System.out.println("Please select an option:");
        System.out.println("Generate a new word search (g)");
        System.out.println("Print out your word search (p)");
        System.out.println("Show the solution to your word search (s)");
        System.out.println("Quit the program (q)");
        menuEntry = input.nextLine().toLowerCase().charAt(0);

        return menuEntry;
    }

    public String[] enterWords() {
        System.out.println("How many words in total do you want your word search to contain?");
        int total = console.nextInt();

        this.wList = new String[total];

        for(int i = 0; i < total; i++) {
            System.out.println("Enter a word: ");
            String enteredWord = console.next();
            wList[i] = enteredWord.toLowerCase();
        }
        return wList;
    }

    public void generate(String[] wList) {
        int longWord = 0;
        int row;
        int column;
        int direction = rand.nextInt(4);
        boolean space;

        for(String w : wList) {
            int len = w.length();
            if(len > longWord) {
                longWord = len;
            }
        }

        gridSize = longWord + 5;
        this.wSearch = new char[gridSize][gridSize];
        this.solution = new char[gridSize][gridSize];
        fillSolution();
        copyBoard(gridSize);

        for (String s : wList) {
            space = false;

            while (!space) {
                row = rand.nextInt(gridSize);
                column = rand.nextInt(gridSize);

                space = make(s, row, column, direction);

                if (space) {
                    putWord(s, row, column, direction);
                }
            }
            fillBoard();
        }
    }

    public void fillSolution() {
        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                solution[i][j] = '*';
            }
        }
    }

    public void copyBoard(int gridSize) {
        for(int a = 0; a < gridSize; a++) {
            System.arraycopy(solution[a], 0, wSearch[a], 0, gridSize);
        }
    }

    public void fillBoard() {
        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                if(wSearch[i][j] == '*') {
                    wSearch[i][j] = (char)('a' + rand.nextInt(26));
                }
            }
        }
    }

    private boolean make(String word, int b, int c,int d) {
        boolean a1 = c >= word.length();
        boolean b1 = b >= word.length();
        boolean c1 = b >= word.length() && c >= word.length();
        switch(d) {
            case 0:
                if(a1) {
                    for (int i = 0; i < word.length(); i++) {
                        if (wSearch[b][i + c] != 0 && wSearch[b][c + i] != word.charAt(i)) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            case 1:
                if(b1) {
                    for(int i = 0; i < word.length(); i++) {
                        if(wSearch[b + i][c] != 0 && wSearch[b + i][c] != word.charAt(i)) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            case 2:
                if(c1) {
                    for(int i = 0; i < word.length(); i++) {
                        if(wSearch[b - i][c + i] != 0 && wSearch[b - i][c + i] != word.charAt(i)) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            case 3:
                if(c1) {
                    for(int i = 0; i < word.length(); i++) {
                        if(wSearch[b + i][c + i] != 0 && wSearch[b + i][c + i] != word.charAt(i)) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
        }
        return false;
    }

    public void putWord(String word, int b, int c, int d) {
        switch(d) {
            case 0:
                for(int i = 0; i < word.length(); i++) {
                    wSearch[b][c + i] = word.charAt(i);
                }
            case 1:
                for(int i = 0; i < word.length(); i++) {
                    wSearch[b + i][c] = word.charAt(i);
                }
            case 2:
                for(int i = 0; i < word.length(); i++) {
                    wSearch[b - i][c + i] = word.charAt(i);
                }
            case 3:
                for(int i = 0; i < word.length(); i++) {
                    wSearch[b + i][c + i] = word.charAt(i);
                }
        }
    }

    public void print() {
        System.out.println(Arrays.deepToString(wSearch));
    }

    public void showSolution() {
        System.out.println(Arrays.deepToString(solution));

    }
}
