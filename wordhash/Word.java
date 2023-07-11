/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordhash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Word {
    private String keyWord;
    private ArrayList<Occurrence> occurrences = new ArrayList<>();

    public Word(String keyWord, String fileName) {
        this.keyWord = keyWord;
        this.insertOccurrence(fileName);
    }

    
    public void insertOccurrence(String fileName){

        for (Occurrence occurrence : this.getOccurrences()) {
            if(occurrence.getFileName().equals(fileName)){
                occurrence.Add();
                return;
            }
        }
        Occurrence occurrence = new Occurrence(fileName);
        this.occurrences.add(occurrence); 
    }
    
    public void sortByFiles(){
        Collections.sort(occurrences, new Comparator<Occurrence>() {
            @Override
            public int compare(Occurrence o1, Occurrence o2) {
                return Integer.compare(o2.getQuantityOfOccurrences(), o1.getQuantityOfOccurrences());
            }
        });
    }
    
    
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public ArrayList<Occurrence> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(ArrayList<Occurrence> occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public String toString() {
        return "Word{" + "keyWord=" + keyWord + ", occurrences=" + occurrences + '}';
    }
    
    
}
