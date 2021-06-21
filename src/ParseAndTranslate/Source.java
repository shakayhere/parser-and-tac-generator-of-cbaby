package ParseAndTranslate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Source {
    static int relativeAddressNumber = 0;                   // Relative Address number for translator symboltable
    static int t = 1;                                       // Number for temp variable generation
    static List <Integer> tokensInLine = new ArrayList();   // To check how many tokens are there in 1 line
    static String fileName;                                 // file/path name entered by user // file/path name entered by user
    
    //////////////////////////
    //     Main Function    //
    //////////////////////////
    
    public static void main(String[] args) throws IOException {
        
        // Getting file Name/Path from user
        
        Scanner getFileInput = new Scanner(System.in);
        System.out.print("Enter path/filename: ");
        fileName = getFileInput.nextLine();
        
        if(fileName.endsWith(".cbaby"))
        {}
        else
        {
            System.out.println("Incorrect file selected. File not found or does not end with (.cbaby) file extention!");
            return;
        }

        // Lexical Analysis
        ImplementLex lexAnalyze = new ImplementLex();
        lexAnalyze.setFileName(fileName);
        lexAnalyze.startLex();
        tokensInLine = lexAnalyze.getTokensInLine();
        
        // Parser and Three Address Code Generator
        ParseAndTranslate parser = new ParseAndTranslate();
        parser.setFileName(fileName);
        parser.setTokensInLine(tokensInLine);
        parser.startParseAndTranslate();
        
    }
}


    //////////////////////////
    //  ------------------  //
    //////////////////////////
