public class LetterInventory {
    String data;

    public LetterInventory(String data) {
        this(data);
    }

    public int get(char letter) throws IllegalArgumentException {
        return letter;
    }

    public void set(char letter, int value) throws IllegalArgumentException {
        this.value = value;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if(empty) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {

    }

    public LetterInventory add(LetterInventory other) {
        LetterInventory inventory1 = new LetterInventory("Isaac Newton");

        LetterInventory inventory2 = new LetterInventory("Michael Faraday");

        LetterInventory sum = inventory1.add(inventory2);
        return sum;
    }

    public LetterInventory subtract(LetterInventory other) {
        LetterInventory b = new LetterInventory;
        return b;
    }
}
