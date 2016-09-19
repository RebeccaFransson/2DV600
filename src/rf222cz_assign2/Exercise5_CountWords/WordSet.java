package rf222cz_assign2.Exercise5_CountWords;

/**
 * Created by ymafr on 2016-09-16.
 */
public interface WordSet extends Iterable {
    public void add(Word word); // Add word if not already added
    public boolean contains(Word word); // Return true if word contained
    public int size(); // Return current set size
    public String toString(); // Print contained words
}
