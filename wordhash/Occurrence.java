package wordhash;


public class Occurrence {
    private String fileName;
    private int quantityOfOccurrences=1;

    public Occurrence(String fileName) {
        this.fileName = fileName;
    }
    
    
    public void Add(){
        this.quantityOfOccurrences++;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getQuantityOfOccurrences() {
        return quantityOfOccurrences;
    }

    public void setQuantityOfOccurrences(int quantityOfOccurences) {
        this.quantityOfOccurrences = quantityOfOccurences;
    }

    @Override
    public String toString() {
        return "Occurrence{" + "fileName=" + fileName + ", quantityOfOccurences=" + quantityOfOccurrences + '}';
    }

}
