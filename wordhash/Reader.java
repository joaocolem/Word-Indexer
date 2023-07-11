/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordhash;

/**
 *
 * @author joao_
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private static String[] stopWordsArray = {"a", "ao", "aos", "aquela", "aquelas", "aquele", "aqueles", "aquilo", "as", "até", "com", "como", "da", "das", "de", "dela", "delas", "dele", "deles", "depois", "do", "dos", "e", "ela", "elas", "ele", "eles", "em", "entre", "era", "eram", "essa", "essas", "esse", "esses", "esta", "estas", "este", "estes", "eu", "isso", "isto", "já", "lhe", "lhes", "mais", "mas", "me", "mesmo", "meu", "meus", "minha", "minhas", "muito", "na", "nas", "não", "no", "nos", "nossa", "nossas", "nosso", "nossos", "num", "numa", "nós", "o", "os", "ou", "para", "pela", "pelas", "pelo", "pelos", "por", "quando", "que", "se", "sem", "seu", "seus", "sua", "suas", "só", "também", "te", "tem", "teu", "teus", "tu", "tua", "tuas", "um", "uma", "você", "vocês"};
    private static List<String> stopWords = Arrays.asList(stopWordsArray);    
    
    private static HashTable hashTable = new HashTable();
    
    
    public static void main(String[] args) {
        String folder = "C:\\Users\\0066824\\Documents\\gitProjectsVscode\\Word-Indexer\\Word-Indexer\\wordhash";
        analyzeFilesInFolder(folder);
        hashTable.search("queijo");
        hashTable.search("casa");
    }

   public static void analyzeFilesInFolder(String folder) {
        File directory = new File(folder);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    analyzeWords(file.getAbsolutePath(), file.getName());
                } else if (file.isDirectory()) {
                    analyzeFilesInFolder(file.getAbsolutePath());
                }
            }
        }
    }

    public static void analyzeWords(String file, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!stopWords.contains(word))
                        hashTable.insert(word, fileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
}