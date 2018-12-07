/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;
import java.io.File;
import java.io.BufferedReader ;
import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author carlamartin
 */
public class Metro extends Network {
    
    public ArrayList <String> arrayNode ; //ensemble des sommets du graphe 
    
    public Metro (File f) throws FileNotFoundException{
        
        BufferedReader buf = null ;
        //FileReader fr ;
        String line ;//ligne du fichier
        this.arrayNode = new ArrayList ();
        try{
            
            //int numberOfLine = 0; 
            buf = new BufferedReader(new FileReader(f));
            while((line = buf.readLine()) != null ){
                System.out.println("Current line : "+line);
                switch(lineAnalysis(line)){
                    case 0 :
                        if(line.contains("Ligne")){
                            //Traitement du cas : c'est une nouvelle ligne de métro
                            //numberOfLine ++ ;
                        }
                        continue;
                    case 1 :
                        this.arrayNode.add(line);
                
                }
            }
            System.out.println(this.arrayNode);
            buf.close() ;
        }catch(FileNotFoundException e1){
            System.out.println("Problème à l'ouverture");
        }
        catch(IOException e){
            System.out.println("Problème de lecture");
        }
        
    }
    
    public void setArrayNode(File f){
        
        //FileReader fr ;
        String line ;//ligne du fichier
        this.arrayNode = new ArrayList ();
        try{
            //int numberOfLine = 0; 
            BufferedReader buf = new BufferedReader(new FileReader(f));
            while((line = buf.readLine()) != null ){
                System.out.println("Current line : "+line);
                switch(lineAnalysis(line)){
                    case 0 :
                        if(line.contains("Ligne")){
                            //Traitement du cas : c'est une nouvelle ligne de métro
                        }
                        continue;
                    case 1 :
                        this.arrayNode.add(line);
                
                }
            }
            System.out.println(this.arrayNode);
            buf.close() ;
        }catch(FileNotFoundException e1){
            System.out.println("Problème à l'ouverture");
        }
        catch(IOException e){
            System.out.println("Problème de lecture");
        }
    }
    
    public static int lineAnalysis (String line){
        //renvoie 0 si la ligne est un commentaire
        //1 si c'est une déclaration de station
        //2 si c'est une déclaration d'arête dans les deux sens ;
        // 3 si c'est une déclaration d'arête dans un seul sens ;
        CharSequence comment = "%", edge1 = "-", edge2 = ">" ; 
        if(line.contains(comment)){
            System.out.println("Cas : commentaire ");
            return 0 ;
        }
        else if (line.contains(edge1)){
            return 2 ;
        }
        else if (line.contains(edge2)){
            return 3 ;
        }
        System.out.println("Cas : nouvelle station ");
        return 1 ;
    }
    
    public static void main(String [] args) {
    }
}
