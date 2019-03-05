/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package full.enigma.machine.attempt.pkg1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author William Francois & Fernando Batista
 */
public class Enigma {
    
   private ArrayList<Character> rotorOne = new ArrayList<>(Arrays.asList('g','n','u','a','h','o','v','b','i','p','w','c','j','q','x','d','k','r','y',' ','e','l','s','z','f','m','t'));
   private ArrayList<Character> rotorTwo = new ArrayList<>(Arrays.asList('e','j',' ','o','t','y','c','h','m','r','w','a','f','k','p','u','z','d','i','n','s','x','b','g','l','q','v'));
   private ArrayList<Character> rotorThree = new ArrayList<>(Arrays.asList('b','d','f','h','j','l','n','p','r','t','v','x','z','a','c','e','g','i',' ','k','m','o','q','s','u','w','y'));
   private ArrayList<Character> rotorFour = new ArrayList<>(Arrays.asList('k','p','h','d','e','a','c',' ','v','t','w','q','m','y','n','l','x','s','u','r','z','o','j','f','b','g','i'));
   private ArrayList<Character> rotorFive = new ArrayList<>(Arrays.asList('n','d','y','g','l','q','i','c','v','e','z','r','p','t','a','o','x','w','b','m','j','s','u','h','k',' ','f'));
   private ArrayList<ArrayList<Character>> rotors = new ArrayList<>(Arrays.asList(rotorOne,rotorTwo,rotorThree,rotorFour,rotorFive));
   private String encode;
   private String input;
   private String decode;
   private int innerRotor;
   private int MiddleRotor;
   private int outerRotor;
   private int innerRotorPosition;
   private int middleRotorPosition;
   private int outerRotorPosition;
   private String plugBoard ="";
  // protected char[] plugBoardArray;
  // protected boolean fullRotation;
   private String textFromFille;
   private String firstTranspose="";
   private String lastTranspose="";
   private String finalString="";
   
    public Enigma() {
      
    }

    public void setInnerRotor(int innerRotor) {
        this.innerRotor = innerRotor;
    }

    public void setMiddleRotor(int MiddleRotor) {
        this.MiddleRotor = MiddleRotor;
    }

    public void setOuterRotor(int outerRotor) {
        this.outerRotor = outerRotor;
    }

    public void setInnerRotorPosition(int innerRotorPosition) {
        this.innerRotorPosition = innerRotorPosition;
    }

    public void setOuterRotorPosition(int outerRotorPosition) {
        this.outerRotorPosition = outerRotorPosition;
    }

    public void setMiddleRotorPosition(int middleRotorPosition) {
        this.middleRotorPosition = middleRotorPosition;
    }

    public void setPlugBoard(String plugBoard) {
        plugBoard= plugBoard.toLowerCase();
        plugBoard= plugBoard.replaceAll("\\s","");
        this.plugBoard = plugBoard;
    }

  
    
    public void setDecode(String decode) {
        this.decode = decode;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
    public void rotate(char[] keyArray){
          char tempp = keyArray[25];

        for (int i = keyArray.length - 2; i >= 0; i--) {
            keyArray[i + 1] = keyArray[i];
        }
        keyArray[0] = tempp;
    }
    
    public void rotateLeft(char[] keyArray){
        
        char tempp = keyArray[0];

        for (int i = 0; i < keyArray.length - 1; i++) {
            keyArray[i] = keyArray[i + 1];
        }
        keyArray[25] = tempp;
        
        
    }

    public String getFinalString() {
        return finalString;
    }

    public void setFinalString(String finalString) {
        this.finalString = finalString;
    }
    
    public void setEncode(String encode) {
        this.encode = encode;
    }
    
    
    public String getDecode() {
        return decode;
    }

    public String getInput() {
        return input;
    }

    public String getEncode() {
        return encode;
    }

    public int getInnerRotor() {
        return innerRotor;
    }

    public int getMiddleRotor() {
        return MiddleRotor;
    }

    public int getOuterRotor() {
        return outerRotor;
    }

    public int getInnerRotorPosition() {
        return innerRotorPosition;
    }

    public int getMiddleRotorPosition() {
        return middleRotorPosition;
    }

    public int getOuterRotorPosition() {
        return outerRotorPosition;
    }

    public String getPlugBoard() {
        return plugBoard;
    }

   
   

    public void setFirstTranspose(String firstTranspose) {
        this.firstTranspose = firstTranspose;
    }
    
        public void transposeString(String input) {
        input= input.toLowerCase();
        String tempString = "";
        //JOptionPane.showInputDialog("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        for (int i = 0; i < input.length();i+=1){
         char temp = input.charAt(i);
         int inputPositionInPlug = plugBoard.indexOf(temp);
         int remainder = inputPositionInPlug%2;
         if(remainder == 1){
             tempString+= plugBoard.charAt(inputPositionInPlug-1);
         }else if(remainder == -1){
             tempString+= input.charAt(i);
         }else if(remainder==0){
             tempString+= plugBoard.charAt(inputPositionInPlug+1);
         } 
      //   JOptionPane.showInputDialog("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        } 
    firstTranspose = tempString;
      // JOptionPane.showInputDialog(firstTranspose);
    }
    public void writeToFile(String fileName) {
        fileName += ".txt";
        
       try {
           PrintWriter writer = new PrintWriter(fileName, "UTF-8");
           writer.println(lastTranspose);
           writer.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Enigma.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(Enigma.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    public void setDecodeFromFile(){
        int irotate = 0;
          int midRotate = 0;
          int outRotate = 0; 
          //set arrays with starting position
           ArrayList <Character> in = rotors.get(innerRotor -1);
           ArrayList <Character> inTemp = new ArrayList <>();
           int tempPlace = innerRotorPosition-1;
           char tempChari;
           for (int i = 0; i < 27;i++){
               if (tempPlace > 26){
                   tempChari = in.get(tempPlace-27); 
                   inTemp.add(tempChari);
               }else if (tempPlace <=26){
                   tempChari = in.get(tempPlace); 
                   inTemp.add(tempChari);
               }
               tempPlace++;
           }
           ArrayList <Character> midTemp = new ArrayList <>();
           ArrayList <Character> mid = rotors.get(MiddleRotor -1);
           int tempPlaceM = middleRotorPosition-1;
           char tempCharm;
           for (int i = 0; i < 27;i++){
               if (tempPlaceM > 26){
                   tempCharm = mid.get(tempPlaceM-27); 
                   midTemp.add(tempCharm);
               }else if (tempPlaceM <=26){
                   tempCharm = mid.get(tempPlaceM); 
                   midTemp.add(tempCharm);
               }
               tempPlaceM++;
           }
           ArrayList <Character> outTemp = new ArrayList <>();
           ArrayList <Character> out = rotors.get(outerRotor -1);
            int tempPlaceO = outerRotorPosition-1;
           char tempCharo;
           for (int i = 0; i < 27;i++){
               if (tempPlaceO > 26){
                   tempCharo = out.get(tempPlaceO-27); 
                   outTemp.add(tempCharo);
               }else if (tempPlaceO <=26){
                   tempCharo = out.get(tempPlaceO); 
                   outTemp.add(tempCharo);
               }
               tempPlaceO++;
           }
           
           //actual decodeing
           for (int i = 0; i < firstTranspose.length();i++){
               
           char tempChar  = firstTranspose.charAt(i);
           
           int outerRotorIndex = outTemp.indexOf(tempChar);
           if (outerRotorIndex!= -1){
           tempChar = midTemp.get(outerRotorIndex);
           int middleRotorIndex = outTemp.indexOf(tempChar);
           tempChar = inTemp.get(middleRotorIndex);
           lastTranspose += tempChar;
           // rotate
                char tempp = inTemp.get(26);
            char firstTemp;
            for (int j = inTemp.size() - 2; j >= 0; j--) {
            firstTemp = inTemp.get(j);
            inTemp.set(j+1,firstTemp);
             }
            inTemp.set(0,tempp);
           irotate++;
           
           if (irotate == 27){
            char mtempp = midTemp.get(26);
            char mTemp;
            for (int j = midTemp.size() - 2; j >= 0; j--) {
            mTemp = midTemp.get(j);
            midTemp.set(j+1,mTemp);
             }
            midTemp.set(0,mtempp);
               irotate = 0;
               midRotate+=1;
           }
           if  (midRotate == 27){
               irotate = 0;
               midRotate= 0;
            char otempp = outTemp.get(26);
            char oTemp;
            for (int j = outTemp.size() - 2; j >= 0; j--) {
            oTemp = outTemp.get(j);
            outTemp.set(j+1,oTemp);
             }
            outTemp.set(0,otempp);
               outRotate +=1; 
           }
           }else{
                lastTranspose += tempChar;
           }
           
       // super.setEncodeFromFile(encode); //To change body of generated methods, choose Tools | Templates.
    }
           writeToFile("DecodedMessageFB");
       //JOptionPane.showInputDialog(decode);
    }
 
  
       public void setEncodeFromFile() {
          int irotate = 0;
          int midRotate = 0;
          int outRotate = 0; 
        
          //set arrays with starting position
           ArrayList <Character> in = rotors.get(innerRotor -1);
           ArrayList <Character> inTemp = new ArrayList <>();
           int tempPlace = innerRotorPosition-1;
           char tempChari;
           for (int i = 0; i < 27;i++){
               if (tempPlace > 26){
                   tempChari = in.get(tempPlace-27); 
                   inTemp.add(tempChari);
               }else if (tempPlace <=26){
                   tempChari = in.get(tempPlace); 
                   inTemp.add(tempChari);
               }
               tempPlace++;
           }
           ArrayList <Character> midTemp = new ArrayList <>();
           ArrayList <Character> mid = rotors.get(MiddleRotor -1);
           int tempPlaceM = middleRotorPosition-1;
           char tempCharm;
           for (int i = 0; i < 27;i++){
               if (tempPlaceM > 26){
                   tempCharm = mid.get(tempPlaceM-27); 
                   midTemp.add(tempCharm);
               }else if (tempPlaceM <=26){
                   tempCharm = mid.get(tempPlaceM); 
                   midTemp.add(tempCharm);
               }
               tempPlaceM++;
           }
           ArrayList <Character> outTemp = new ArrayList <>();
           ArrayList <Character> out = rotors.get(outerRotor -1);
            int tempPlaceO = outerRotorPosition-1;
           char tempCharo;
           for (int i = 0; i < 27;i++){
               if (tempPlaceO > 26){
                   tempCharo = out.get(tempPlaceO-27); 
                   outTemp.add(tempCharo);
               }else if (tempPlaceO <=26){
                   tempCharo = out.get(tempPlaceO); 
                   outTemp.add(tempCharo);
               }
               tempPlaceO++;
           }
           
           //actual encodeing
           for (int i = 0; i < firstTranspose.length();i++){
           char tempChar  = firstTranspose.charAt(i);
           int innerRotorIndex = inTemp.indexOf(tempChar);
           if (innerRotorIndex!= -1){
           tempChar = outTemp.get(innerRotorIndex);
           int middleRotorIndex = midTemp.indexOf(tempChar);
           tempChar = outTemp.get(middleRotorIndex);
           lastTranspose += tempChar;
           // rotate
            char tempp = inTemp.get(26);
            char firstTemp;
            for (int j = inTemp.size() - 2; j >= 0; j--) {
            firstTemp = inTemp.get(j);
            inTemp.set(j+1,firstTemp);
             }
            inTemp.set(0,tempp);
           irotate++;
           
           if (irotate == 27){
            char mtempp = midTemp.get(26);
            char mTemp;
            for (int j = midTemp.size() - 2; j >= 0; j--) {
            mTemp = midTemp.get(j);
            midTemp.set(j+1,mTemp);
             }
            midTemp.set(0,mtempp);
               irotate = 0;
               midRotate+=1;
           }
           if  (midRotate == 27){
               irotate = 0;
               midRotate= 0;
            char otempp = outTemp.get(26);
            char oTemp;
            for (int j = outTemp.size() - 2; j >= 0; j--) {
            oTemp = outTemp.get(j);
            outTemp.set(j+1,oTemp);
             }
            outTemp.set(0,otempp);
               outRotate +=1; 
           }
           }else{
                lastTranspose += tempChar;
           }
       // super.setEncodeFromFile(encode); //To change body of generated methods, choose Tools | Templates.
    }
           
           writeToFile("EncodedMessageWF");
    
}
       
       
       public void lastTranspose(){
          //input= input.toLowerCase();
        String tempString = "";
        //JOptionPane.showInputDialog("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        for (int i = 0; i < lastTranspose.length();i+=1){
         char temp = lastTranspose.charAt(i);
         int inputPositionInPlug = plugBoard.indexOf(temp);
         int remainder = inputPositionInPlug%2;
         if(remainder == 1){
             tempString+= plugBoard.charAt(inputPositionInPlug-1);
         }else if(remainder == -1){
             tempString+= lastTranspose.charAt(i);
         }else if(remainder==0){
             tempString+= plugBoard.charAt(inputPositionInPlug+1);
         } 
      //   JOptionPane.showInputDialog("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        } 
        finalString = tempString; 
       }
}


