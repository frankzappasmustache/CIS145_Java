import java.util.*;

public class WordSearchGenTest {

    public static void main(String[] args) {
        WordSearchGen wGen = new WordSearchGen();
        char resp;

        resp = wGen.printMenu();
        wGen.printIntro();

        while(resp != 'q') {
            String[] wList = new String[0];
            switch(resp) {
                case 'g':
                    wList = wGen.enterWords();
                    wGen.generate(wList);
                    break;
                case 'p':
                    if(wList.length == 0) {
                        System.out.println("Please enter \\'g\\' to enter the words for your word search");
                    } else if(wList.length <= 1) {
                        System.out.println("Please enter \\'g\\' to enter more words. You must have more than 1");
                    } else {
                        wGen.print();
                    }
                    break;
                case 's':
                    wGen.showSolution();
                    break;
                case 'q':
                    resp = 'q';
                    break;
            }
        }

    }
}
