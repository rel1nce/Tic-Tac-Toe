import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TicTacToe implements ActionListener{

    Font textFont = new Font("Sans Serif", Font.PLAIN, 50);
    Random rand = new Random();
    JFrame frame = new JFrame("Tic Tac Toe UI");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(60, 60, 60));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(600, 500));
        frame.setMaximumSize(new Dimension(1000, 1000));
        //frame.setResizable(false);

        textField.setBackground(new Color(50, 50, 50));
        textField.setForeground(new Color(150, 150, 150));
        textField.setFont(textFont);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe with Players!");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(100, 100, 100));

        for(int ind = 0; ind < 9; ++ind) {
            buttons[ind] = new JButton();
            button_panel.add(buttons[ind]);
            buttons[ind].setFont(new Font("MV Boli", Font.BOLD, 100));
            buttons[ind].setFocusable(false);
            buttons[ind].addActionListener(this);
            buttons[ind].setBackground(new Color(80, 80, 80));
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int ind = 0; ind < 9; ++ind) {
            if(e.getSource() == buttons[ind]) {
                if(player1_turn) {
                    if(buttons[ind].getText() == "") {
                        buttons[ind].setForeground(new Color(50, 50, 50));
                        buttons[ind].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();

                    }
                } else {
                    if(buttons[ind].getText() == "") {
                        buttons[ind].setForeground(new Color(50, 50, 50));
                        buttons[ind].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }

                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(1500);
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }

        if(rand.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
        } else {
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    public void check() {
        //check X win combinations
        if(
                (buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")
                ) {
                xWins(0, 1, 2);
        }
        if(
                (buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        if(
                (buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        if(
                (buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        //check O wins combinations
        if(
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        if(
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        if(
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        if(
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        if(
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        if(
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        if(
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        if(
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(0, 255, 0));
        buttons[b].setBackground(new Color(0, 255, 0));
        buttons[c].setBackground(new Color(0, 255, 0));

        for(int ind = 0; ind < 9; ++ind) {
            buttons[ind].setEnabled(false);
        }
        textField.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(0, 255, 0));
        buttons[b].setBackground(new Color(0, 255, 0));
        buttons[c].setBackground(new Color(0, 255, 0));

        for(int ind = 0; ind < 9; ++ind) {
            buttons[ind].setEnabled(false);
        }
        textField.setText("O wins");
    }
}
