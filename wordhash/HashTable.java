
package wordhash;

/**
 *
 * @author joao_
 */

import java.util.LinkedList;
public class HashTable {

    static int HASHMOD=101,BASE =128;
    private LinkedList<Word>[] hashTable = new LinkedList[HASHMOD];
    

    
    public void insert(String stringKey, String fileName){
      int hashValue = stringIntoInt(stringKey);
      hashValue = hashFunction(hashValue);
     
      if(hashTable[hashValue] == null){
        hashTable[hashValue] = new LinkedList<Word>();
        }
      
    for (Word word : hashTable[hashValue]) {
        String currentKey = word.getKeyWord();
        if (currentKey.equals(stringKey)) {
            word.insertOccurrence(fileName);
            return;
        }
    }
      
      
      Word word = new Word(stringKey, fileName);
      hashTable[hashValue].add(word);
            
        }
        


    public void search(String stringKey){
      
      int hashValue = stringIntoInt(stringKey);
      hashValue = hashFunction(hashValue);
      if(hashTable[hashValue] == null){
        System.out.println("o elemento não se encontra");
        return;
      }
      
      for(Word element : hashTable[hashValue]){
          if(stringKey.equals(element.getKeyWord())){
            element.sortByFiles();
            System.out.println(element.toString());
            return;
          }
      }

    }
    
     
    public int hashFunction(int id){
        return id % HASHMOD;
    }
    
    public int stringIntoInt(String word){
        int k = 0;
        for (int i = 0; i < word.length(); i++) {
            k = (k * BASE + word.charAt(i));
        }
        return Math.abs(k);
    }
    
    
    
}    


