/* Emenems Calculator
 * By: Neale Oliva
 * 12-04-2022
 */
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class njcalculator{
    public static JFrame mainF;
    public static void app() throws NumberFormatException{
               mainF = new JFrame("Oliva Emenems 2.0");
               mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               mainF.getContentPane().setBackground(Color.orange);
               mainF.setResizable(false);
        JLabel title = new JLabel("The accuracy you always needed");
               title.setBounds(50, 290, 500, 30);
        JLabel label1 = new JLabel("Insert 1st Number");
               label1.setBounds(50, 100, 200, 30); 
        JTextField input1 = new JTextField();
                  input1.setBounds(50,125, 200, 20);
                  input1.setBackground( new Color(255,255,204 ));
                  input1.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent ke){
                        inputValidate(ke, input1);
                    }   
                  });
        JLabel label2 = new JLabel("Insert 2nd Number.");
               label2.setBounds(50,150, 200,30);
        JTextField input2 = new JTextField();
                  input2.setBounds(50,175, 200,20);
                  input2.setBackground( new Color(255,255,204 ));
                  input2.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent ke){
                        inputValidate(ke, input2);
                    }
                  });
        JLabel label3 = new JLabel("Choose Operation.");
               label3.setBounds(50,50, 200,28); 
        String[] operations = {"Addition","Subtraction","Multiplication","Division"};
        JComboBox<String> input3 = new JComboBox<String>(operations);
                  input3.setBounds(50, 75, 200, 20); 
        JLabel results = new JLabel("");
               results.setBounds(200,255, 100, 20);
        JButton execute = new JButton("Calculate");
                execute.setBackground( new Color(204, 255, 204) );
                execute.setBounds(50,250, 100, 30);
                execute.setBorderPainted(false);
                execute.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) throws NumberFormatException{
                        try {
                            results.setText(Float.toString(
                                calculate(Float.parseFloat(input1.getText()),
                                          Float.parseFloat(input2.getText()),
                                          (String) input3.getSelectedItem())
                            ));                              
                        } catch (Exception err) {           
                            System.out.println(err);
                            JOptionPane.showMessageDialog(mainF,"Input Error","Error",JOptionPane.ERROR_MESSAGE);
                            throw new NumberFormatException("Wrong/Empty Input");
                        }
                    }
                });

        mainF.add(title); mainF.add(label1); mainF.add(label2); mainF.add(input1); mainF.add(input2);
        mainF.add(label3); mainF.add(input3); mainF.add(execute); mainF.add(results);
        
        mainF.setSize(320,400);
        mainF.setLayout(null);  
        mainF.setVisible(true); 
        mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainF.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        mainF.setVisible(true);
    }
    public static void inputValidate(KeyEvent ke,JTextField InputComponent){
        String field = InputComponent.getText();
        if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' )
            ||(ke.getKeyChar() == '.' && field.chars().filter(ch -> ch == '.').count() <= 0)
            || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
            ){
            InputComponent.setEditable(true);
        } else{
            InputComponent.setEditable(false);
        }
    }
    public static float calculate(float num1, float num2, String operation) throws ArithmeticException {
        switch (operation) {
            case "Addition":  
                return num1 + num2;
            case "Subtraction":  
                return num1 - num2;
            case "Multiplication":  
                return num1 * num2;
            case "Division":  
                if (num2 == 0){
                    JOptionPane.showMessageDialog(mainF,"Cannot divide by Zero","Error",JOptionPane.ERROR_MESSAGE);
                    throw new ArithmeticException("Cannot divide by Zero");
                } else {
                    return num1 / num2;}
            default:
                System.out.println("Error: Incorrect operation input");
                break;
        }
        return 0;
    }
    public static void main(String[] args){
        app();
    }
}