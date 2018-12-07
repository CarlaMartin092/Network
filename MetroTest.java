/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File ;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import network.Metro ;
import java.util.ArrayList ;

/**
 *
 * @author carlamartin
 */
public class MetroTest {
    
    @Test
    public void TestMetroConstructor() {
        
        //Écriture du fichier test
        File file = new File("readerTest.txt");
        FileWriter fw;
        
        try{
            //Création de l'objet
            fw = new FileWriter(file);
            String str = "%\n";
            str += "% Ligne 1\n";
            str +="%\n";
            str +="Chatelet\n" ;
            str +="Gare de Lyon\n";
            str +="Bercy\n";
            //On écrit la chaîne
            fw.write(str);
            //On ferme le flux
            fw.close();
        }catch(IOException e1){
            System.out.println("File not created");
        }
        
        //Tableau de référence
        ArrayList <String> arr = new ArrayList() ;
        arr.add("Chatelet");
        arr.add("Gare de Lyon");
        arr.add("Bercy");
        String str1 , str2 ;
        
        
        //Comparaison du tableau de référence avec arrayNode de l'objet Metro créé
        try{
            Metro m = new Metro(file);
            for(int i = 0 ; i<m.arrayNode.size() ; i++){
                str1 = m.arrayNode.get(i) ;
                str2 = arr.get(i) ;
                if(str1.compareTo(str2)!=0){
                    fail("Reading the station :" + str1 + "instead of " + "str2");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
