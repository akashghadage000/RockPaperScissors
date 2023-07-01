import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissors extends JFrame {
    JButton rock, paper, scissors;
    JLabel L1;

    public RockPaperScissors() {
        setTitle("Rock Paper Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        rock = new JButton("Rock");
        rock.addActionListener(new ButtonClickListener());

        paper = new JButton("Paper");
        paper.addActionListener(new ButtonClickListener());

        scissors = new JButton("Scissors");
        scissors.addActionListener(new ButtonClickListener());

        L1 = new JLabel("Make your move!");

        add(rock);
        add(paper);
        add(scissors);
        add(L1);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton clickedButton = (JButton) event.getSource();
            String userChoice = clickedButton.getText();
            String computerChoice = generateComputerChoice();

            String result = determineWinner(userChoice, computerChoice);
            L1.setText(result);
        }
    }

    private String generateComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        int randomIndex = (int) (Math.random() * choices.length);
        return choices[randomIndex];
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win! " + userChoice + " beats " + computerChoice;
        } else {
            return "Computer wins! " + computerChoice + " beats " + userChoice;
        }
    }

    public static void main(String[] args) {
        RockPaperScissors ob=new RockPaperScissors();
    }
}

