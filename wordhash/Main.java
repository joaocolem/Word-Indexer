/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wordhash;
import javax.swing.JFileChooser;
import java.io.File;
/**
 *
 * @author joao_
 */
public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.search("casa");

        // Exibir o seletor de pasta para o usuário
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = fileChooser.getSelectedFile();
            String folderPath = selectedFolder.getAbsolutePath();
            folderPath = "C:\\Users\\0066824\\Documents\\gitProjectsVscode\\Word-Indexer\\Word-Indexer\\wordhash";
            Reader.analyzeFilesInFolder(folderPath);
        } else {
            System.out.println("Nenhuma pasta selecionada.");
            return;
        }

        hashTable.search("queijo");
        hashTable.search("casa");
  
    }
}
