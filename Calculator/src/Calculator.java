import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A simple calculator application implemented using Java Swing.
 * It supports basic arithmetic operations such as addition, subtraction,
 * multiplication, and division.
 */
public class Calculator implements  ActionListener{
    JFrame frame;
    JTextField textField;
    JButton [] numButtons = new JButton[10];
    JButton [] functionButtons = new JButton[9];
    JButton addButton , subButton , mulButton , divButton ;
    JButton decButton , equalButton , delButton , clrButton , negButton;
    JPanel panel;
    GridLayout grid;
    Font myFont = new Font("SANS_SERIF", Font.BOLD,30);
    double num1=0, num2=0, result=0;
    char operator;

    /**
     *Constructs a new Calculator instance and initializes the GUI components.
     */
    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460, 550);
        frame.setLayout(null);

        // Create and set properties for the text field
        textField = new JTextField();
        textField.setBounds(50,25, 320, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);

        //Initialize function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        //Set background colours for buttons
        setButtonColours();

        // Add function buttons to the array
        addFunctionButtons();

        // Initialize and configure number buttons
        configureNumberButtons();

        // Set bounds for negative button ,delete button ,clear button
        negButton.setBounds(50,430,80,50);
        delButton.setBounds(140,430,100,50);
        clrButton.setBounds(250,430,120,50);

        // Create panel with grid layout for number and operator buttons
        panel = new JPanel();
        panel.setBounds(50,100,320,300);
        grid = new GridLayout(4,4,10,10);
        panel.setLayout(grid);

        // Add buttons to panel
        addButtonsToPanel();

        // Add components to frame
        frame.add(textField);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }

    /**
     * Sets background colors for the function buttons.
     */
    private void setButtonColours(){
        addButton.setBackground(Color.pink);
        subButton.setBackground(Color.pink);
        mulButton.setBackground(Color.pink);
        divButton.setBackground(Color.pink);
        decButton.setBackground(Color.pink);
        equalButton.setBackground(Color.pink);
        delButton.setBackground(Color.orange);
        clrButton.setBackground(Color.pink);
        negButton.setBackground(Color.pink);
    }

    /**
     * Adds function buttons to the array and sets their properties.
     */
    private void addFunctionButtons(){
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i=0; i<9 ; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
    }


    /**
     * Configures the number buttons by initializing them and setting their properties.
     */
    private void configureNumberButtons(){
        for(int i=0; i<10 ; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }
    }

    /**
     * Adds the number and operator buttons to the panel in a grid layout.
     */
    private void addButtonsToPanel(){
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    /**
     * Handles button click events and performs the corresponding actions.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0; i<10; i++){
            if(e.getSource() == numButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
           num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
           num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
           num1 =Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }
        if(e.getSource() == equalButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result =num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 =result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String targetNum =  textField.getText();
            textField.setText("");
            for(int i=0; i<targetNum.length()-1; i++){
                textField.setText(textField.getText()+targetNum.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}