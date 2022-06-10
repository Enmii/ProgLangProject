/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexicalAnalyzer;

/**
 *
 * @author User
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LexicalAnalyzer {

    /**
     * @param args the command line arguments
     */
    String keywords[] = {"meal", "serve", "order", "chef", "in", "quantity"};
    String numbers [] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String signs[] = {"=", "+", "-", "*", "/", "(", ")" , "<" , ">" , "==" ,
        ">=", "<=", "[", "]", "!=", "{" , "}"};
    Scanner scan = new Scanner(System.in);
    String filename;
    
    public boolean isKeyword(String lex){
        boolean found = Arrays.stream(keywords).anyMatch(t -> t.equals(lex));
        return found;
    }
    
    public boolean isNumber(String lex){
        boolean found = Arrays.stream(numbers).anyMatch(t -> t.equals(lex));
        return found;
    }
    public boolean isSign(String lex){
            boolean found = Arrays.stream(signs).anyMatch(t -> t.equals(lex));
            return found;
    }
    public boolean isConditional(String lex){
        return lex.contains("if") || lex.contains("else") || lex.contains("maybe");
    }
    public boolean isString(String lex){
        return lex.contains("\"");
    }
    public boolean isLoop(String lex){
        return lex.contains("for") || lex.contains("do") || lex.contains("while");
    }
    public void viewLexemes(String name){
        char key;
        String codefile = "C:\\Users\\User\\Documents\\NetBeansProjects\\LexicalAnalyzer\\src\\LexicalAnalyzer\\"+name;
        try{
            File file = new File(codefile);
            Scanner myReader = new Scanner(file);
            int line = 1;
            int count = 0;
            do{
                String code = myReader.nextLine();
                String arr[] = code.split(" ");
                System.out.println("Line :" + line);
                System.out.println("__________________________________");
                for(int i = 0; i <= arr.length-1; i++){
                    if(isKeyword(arr[i])){
                        System.out.println("Lexeme: " + (i+1) + " '" + arr[i] + "' Token: Keyword");
                    }
                    else if(isLoop(arr[i])){
                        System.out.println("Lexeme: " + (i+1) + " '" + arr[i] + "' Token: Looping Statement");                        
                    }
                    else if(isConditional(arr[i])){
                        System.out.println("Lexeme: " + (i+1) + " '" + arr[i] + "' Token: Conditional Statement");                        
                    }
                    else if(isSign(arr[i])){
                        System.out.println("Lexeme: " + (i+1) + " '" + arr[i] + "' Token: Sign");                        
                    }
                    else if(isNumber(arr[i])){
                        System.out.println("Lexeme: " + (i+1) + " '" + arr[i] + "' Token: Number");                        
                    }
                    else if(isString(arr[i])){
                        System.out.println("Lexeme: " + (i+1) + " '" + arr[i] + "' Token: String Segment");                        
                    }
                    else
                        System.out.println("Lexeme: " + (i+1) + " '" + arr[i] + "' Token: Variable");  
                    count++;
                    }
                System.out.println("__________________________________");
                line++;
               
            }
            while (myReader.hasNextLine());
            System.out.println("Total lexemes:" + count);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        System.out.println("Enter any key to continue!");
        key = scan.next().charAt(0);   
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LexicalAnalyzer obj = new LexicalAnalyzer();
        int choice;
        
        do{
            System.out.println("MAIN MENU");
            System.out.println("_____________________");
            System.out.println("[1] Upload Text File");
            System.out.println("[2] View Lexemes/Tokens");
            System.out.println("[3] View Lexical Errors");
            System.out.println("[4] View Syntax Errors");
            System.out.println("[5] View Semantic Errors");
            System.out.println("[6] End Program");
            System.out.println("_____________________");
            
            choice = obj.scan.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Please enter filename to upload");
                    obj.filename = obj.scan.next();
                    break;
                case 2:
                    obj.viewLexemes(obj.filename);
                    break;
                case 3:
                    System.out.println("INSERT LEXICAL ERRORS HERE");
                    break;
                case 4:
                    System.out.println("INSERT SYNTAX ERRORS HERE");
                    break;
                case 5:
                    System.out.println("INSERT SEMANTIC ERRORS HERE");
                    break;
                case 6:
                    System.out.println("Program Exit!");
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
                }
        }while(choice !=6);
        
        
        
    }
    
}
