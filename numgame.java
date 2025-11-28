import java.awt.event.*;
import javax.swing.*;

public class numgame extends JFrame {

    private JTextField guessField;
    private JLabel resultLabel;
    private int randomNumber;

    public numgame() {
        setTitle("Number Guessing Game");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new FlowLayout());
    
        randomNumber = (int) (Math.random() * 20) + 1;

        add(new JLabel("Guess a number from 1 to 20"));

        guessField = new JTextField(10);
        add(guessField);

        JButton guessButton = new JButton("Guess");
        add(guessButton);

        resultLabel = new JLabel("Enter a number and press Guess.");
        add(resultLabel);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    
                    if (guess == randomNumber) {
                        resultLabel.setText("Correct! The number is: " + randomNumber);
                    } else if (guess < randomNumber) {
                        resultLabel.setText("WRONG! The number was: " + randomNumber);
                    } else {
                        resultLabel.setText("WRONG! The number was: " + randomNumber);
                    }
                    randomNumber = (int) (Math.random() * 20) + 1;

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Enter a valid number.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new numgame();
    }
}
