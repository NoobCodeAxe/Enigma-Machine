/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package full.enigma.machine.attempt.pkg1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author William Francois & Fernando Batista
 */
public  class EnigmaGUI extends JFrame implements ActionListener {
    
      public EnigmaGUI() {
        super(" Enigma Machine! ");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
      
       public void run(){
       Enigma magic = new Enigma();
       setLayout(new GridLayout(4,1));
       
        JPanel option = new JPanel(new GridLayout(1,2));
                 JPanel OptionSubRows = new JPanel(new GridLayout(3, 1));
                 JPanel OptionSubStart = new JPanel(new GridLayout(3, 1));
                 JPanel OptionSubPlugBoard = new JPanel(new GridLayout(3, 1));
                        JPanel plug = new JPanel (new GridLayout(1,1));
                    option.add(OptionSubRows);
                    option.add(OptionSubPlugBoard);
                        OptionSubPlugBoard.add(plug);
                    option.add(OptionSubStart);
        JPanel inputText = new JPanel(new GridLayout(1, 1));
                 JPanel inText = new JPanel(new GridLayout(1,1));
                    inputText.add(inText);
        JPanel buttons = new JPanel(new GridLayout(1, 2));
                JPanel fromFile = new JPanel(new GridLayout(2,1));
                JPanel fromTextField = new JPanel(new GridLayout(2,1));
                    buttons.add(fromFile);
                    buttons.add(fromTextField);
        JPanel outputText = new JPanel(new GridLayout(1, 1));
                JPanel ouText = new JPanel(new GridLayout(1,1));
                    outputText.add(ouText);
        
        
        DefaultComboBoxModel innerRow = new DefaultComboBoxModel();
            for (int i=1;i<6;i++){
                innerRow.addElement(i);
            }
            JComboBox jInnerRow = new JComboBox(innerRow);
        DefaultComboBoxModel middleRow = new DefaultComboBoxModel();
             for (int i=1;i<6;i++){
                middleRow.addElement(i);
            }
            JComboBox jMiddleRow = new JComboBox(middleRow);
        DefaultComboBoxModel outerRow = new DefaultComboBoxModel();
             for (int i=1;i<6;i++){
                outerRow.addElement(i);
            }
            JComboBox jOuterRow = new JComboBox(outerRow);
        DefaultComboBoxModel innerRowStart = new DefaultComboBoxModel();
            for (int i=1;i<28;i++){
                innerRowStart.addElement(i);
            }
            JComboBox jInnerRowStart = new JComboBox(innerRowStart);
        DefaultComboBoxModel middleRowStart = new DefaultComboBoxModel();
            for (int i=1;i<28;i++){
                middleRowStart.addElement(i);
            }
            JComboBox jMiddleRowStart = new JComboBox(middleRowStart);
        DefaultComboBoxModel outerRowStart = new DefaultComboBoxModel();
                for (int i=1;i<28;i++){
                outerRowStart.addElement(i);
            }
            JComboBox jOuterRowStart = new JComboBox(outerRowStart);
        
        JTextArea plugBoard = new JTextArea(10, 10);
            JScrollPane plugScroll = new JScrollPane(plugBoard);
                plugScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                plugScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                   plug.add(plugScroll);
        JTextArea iText = new JTextArea(10, 50);
            JScrollPane inputTextScroll = new JScrollPane(iText);
                inputTextScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                inputTextScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    inText.add(inputTextScroll);
        JTextArea oText = new JTextArea(10, 50);   
            JScrollPane outputTextScroll = new JScrollPane(oText);
                outputTextScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                outputTextScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    ouText.add(outputTextScroll);
                    oText.setLineWrap(true);
                    oText.setWrapStyleWord(true);
        
        JButton encode = new JButton("Encode");      
        JButton decode = new JButton("Decode");
        JButton encodeFromFile = new JButton("Encode From File");
        JButton decodeFromFile = new JButton("Decode From File");
        
      
        
        
        OptionSubRows.add(jInnerRow);
        OptionSubRows.add(jMiddleRow);
        OptionSubRows.add(jOuterRow);
        OptionSubStart.add(jInnerRowStart);
        OptionSubStart.add(jMiddleRowStart);
        OptionSubStart.add(jOuterRowStart);
       // OptionSubPlugBoard.add(plugBoard);
       // inText.add(iText);
        fromFile.add(decodeFromFile);
        fromFile.add(encodeFromFile);
        fromTextField.add(decode);
        fromTextField.add(encode);
        //ouText.add(oText);
   
        //option.setBorder(BorderFactory.createLineBorder(Color.black));
        OptionSubRows.setBorder(BorderFactory.createTitledBorder(" Rotor "));
            jInnerRow.setBorder(BorderFactory.createTitledBorder(" Inner "));
            jMiddleRow.setBorder(BorderFactory.createTitledBorder(" Middle "));
            jOuterRow.setBorder(BorderFactory.createTitledBorder(" Outer "));
        OptionSubStart.setBorder(BorderFactory.createTitledBorder(" Start Position "));
            jInnerRowStart.setBorder(BorderFactory.createTitledBorder(" Inner "));
            jMiddleRowStart.setBorder(BorderFactory.createTitledBorder(" Middle "));
            jOuterRowStart.setBorder(BorderFactory.createTitledBorder(" Outer "));
        OptionSubPlugBoard.setBorder(BorderFactory.createTitledBorder(" Plugboard ")); 
            plug.setBorder(BorderFactory.createTitledBorder(" 20 Characters "));
       // inputText.setBorder(BorderFactory.createLineBorder(Color.black));
        inputText.setBorder(BorderFactory.createTitledBorder(" Input "));
            inText.setBorder(BorderFactory.createTitledBorder(" Enter text "));
        buttons.setBorder(BorderFactory.createTitledBorder("Process"));
            fromTextField.setBorder(BorderFactory.createTitledBorder(" From Field "));
            fromFile.setBorder(BorderFactory.createTitledBorder(" From File "));
        outputText.setBorder(BorderFactory.createTitledBorder(" Output "));
            ouText.setBorder(BorderFactory.createTitledBorder(" Result "));
        
            
        encodeFromFile.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              File inputFile;
              JFileChooser userTextFile = new JFileChooser();
              FileNameExtensionFilter textFileOnly = new FileNameExtensionFilter("TEXT Files", "txt");    
              userTextFile.setFileFilter(textFileOnly);
              inputFile=userTextFile.getSelectedFile();
              int returnVal = userTextFile.showOpenDialog(fromFile);
               if (returnVal == JFileChooser.APPROVE_OPTION) {
                   inputFile=userTextFile.getSelectedFile();
                   BufferedReader input = null;
                  try {
                      input = new BufferedReader(new FileReader(inputFile));
                  } catch (FileNotFoundException ex) {
                      Logger.getLogger(EnigmaMachine.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  try {
                      iText.read(input,inputFile);
                  } catch (IOException ex) {
                      Logger.getLogger(EnigmaMachine.class.getName()).log(Level.SEVERE, null, ex);
                  }
               }
                magic.setPlugBoard(plugBoard.getText());
                magic.setInnerRotor((int) innerRow.getSelectedItem());
                magic.setOuterRotor((int) outerRow.getSelectedItem());
                magic.setMiddleRotor((int) middleRow.getSelectedItem()); 
                magic.setInnerRotorPosition((int) innerRowStart.getSelectedItem());
                magic.setMiddleRotorPosition((int) middleRowStart.getSelectedItem());
                magic.setOuterRotorPosition((int) outerRowStart.getSelectedItem());
                magic.transposeString(iText.getText());
                magic.setEncodeFromFile();
                magic.lastTranspose();
                oText.append(magic.getFinalString());
           }
        });
        
        decode.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                magic.setInnerRotor((int) innerRow.getSelectedItem());
                  magic.setOuterRotor((int) outerRow.getSelectedItem());
                  magic.setMiddleRotor((int) middleRow.getSelectedItem());
                  magic.setInnerRotorPosition((int) innerRowStart.getSelectedItem());
                  magic.setMiddleRotorPosition((int) middleRowStart.getSelectedItem());
                  magic.setOuterRotorPosition((int) outerRowStart.getSelectedItem());
                  magic.setPlugBoard(plugBoard.getText());
                  magic.transposeString(iText.getText());
                  magic.setDecodeFromFile();
                  magic.lastTranspose();
                  oText.append(magic.getFinalString());
           }
       });
        
        encode.addActionListener(new ActionListener () {
           @Override
           public void actionPerformed(ActionEvent e) {
                magic.setPlugBoard(plugBoard.getText());
                magic.setInnerRotor((int) innerRow.getSelectedItem());
                magic.setOuterRotor((int) outerRow.getSelectedItem());
                magic.setMiddleRotor((int) middleRow.getSelectedItem()); 
                magic.setInnerRotorPosition((int) innerRowStart.getSelectedItem());
                magic.setMiddleRotorPosition((int) middleRowStart.getSelectedItem());
                magic.setOuterRotorPosition((int) outerRowStart.getSelectedItem());
                magic.transposeString(iText.getText());
                magic.setEncodeFromFile();
                magic.lastTranspose();
                oText.append(magic.getFinalString());
           }
       });
        
        decodeFromFile.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e) {
              File inputFile;
              JFileChooser userTextFile = new JFileChooser();
              FileNameExtensionFilter textFileOnly = new FileNameExtensionFilter("TEXT Files", "txt");    
              userTextFile.setFileFilter(textFileOnly);
              int returnVal = userTextFile.showOpenDialog(fromFile);
               if (returnVal == JFileChooser.APPROVE_OPTION) {
                   inputFile=userTextFile.getSelectedFile();
                   BufferedReader input = null;
                  try {
                      input = new BufferedReader(new FileReader(inputFile));
                  } catch (FileNotFoundException ex) {
                      Logger.getLogger(EnigmaMachine.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  try {
                      iText.read(input,inputFile);
                  } catch (IOException ex) {
                      Logger.getLogger(EnigmaMachine.class.getName()).log(Level.SEVERE, null, ex);
                  }
               }
                  magic.setInnerRotor((int) innerRow.getSelectedItem());
                  magic.setOuterRotor((int) outerRow.getSelectedItem());
                  magic.setMiddleRotor((int) middleRow.getSelectedItem());
                  magic.setInnerRotorPosition((int) innerRowStart.getSelectedItem());
                  magic.setMiddleRotorPosition((int) middleRowStart.getSelectedItem());
                  magic.setOuterRotorPosition((int) outerRowStart.getSelectedItem());
                  magic.setPlugBoard(plugBoard.getText());
                  magic.transposeString(iText.getText());
                  magic.setDecodeFromFile();
                  magic.lastTranspose();
                  oText.append(magic.getFinalString());
           }   
        });
 

        
        add(option);
        add(inputText);
        add(buttons);
        add(outputText);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
