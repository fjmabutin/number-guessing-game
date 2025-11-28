import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class numgame extends JFrame {

    private JTextField guessField;
    private JLabel resultLabel;
    private int randomNumber;

    public numgame() {
        setTitle("Number Guessing Game");
        setSize(350, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        randomNumber = (int) (Math.random() * 20) + 1;

        JLabel label = new JLabel ("Guess a number from 1 to 20");
        setSize(400,150);
        add (label);

        JTextField guessField = new JTextField(5);
        setSize(600, 200);
        add(guessField);

        JButton guessButton = new JButton("Guess");
        setSize (400, 300);
        add(guessButton);

        JLabel resultLabel = new JLabel("Enter a number and press Guess.");
        setSize(500, 400);
        add(resultLabel);

        guessButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    
                    if (guess == randomNumber) {
                        resultLabel.setText("Correct! Number is: " + randomNumber);
                    } else if (guess < randomNumber) {
                        resultLabel.setText("Too low! Number was: " + randomNumber);
                    } else {
                        resultLabel.setText("Too high! Number was: " + randomNumber);
                    }

                    // Generate a new number for next round
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
