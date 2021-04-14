package life;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameOfLife extends JFrame{


    JLabel GenerationLabel;
    JLabel AliveLabel;
    Grid grid;
    int size;
    int[][] universe;
    Boolean pause = true;
    int currentGeneration = 0;
    JButton resetButton;
    JToggleButton playToggleButton;


    public GameOfLife() {

        super("Game of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        playToggleButton = new JToggleButton();
        playToggleButton.setName("PlayToggleButton");
        playToggleButton.setText("Pause/Play");
        add(playToggleButton);

        resetButton = new JButton();
        resetButton.setName("ResetButton");
        resetButton.setText("Reset");
        add(resetButton);




        GenerationLabel = new JLabel();
        GenerationLabel.setName("GenerationLabel");
        GenerationLabel.setText("Generation #" + getCurrentGeneration());



        AliveLabel = new JLabel("Alive: 0");
        AliveLabel.setName("AliveLabel");



        add(AliveLabel);
        add(GenerationLabel);
        setVisible(true);
        grid = new Grid();
        add(grid);

        playToggleButton.addActionListener(arg0 -> {

            pause = !playToggleButton.isSelected();
        });

        resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                         }
        });

    }
/*
    public void paint(Graphics g) {
        super.paint(g);

    for (int i = 0; i < (size * size) * 2; i += 20) {
        for(int j = 0; j < (size * size) * 2; j += 20){

            if(universe[i/2 / size][j/2 / size] == 1){
                g.fillRect(100 + j, 85 + i , 20, 20);
            } else {
                g.drawRect(100 + j, 85 + i , 20, 20);
            }

        }

      }
    }
*/    public int getCurrentGeneration() {
        return currentGeneration;
    }

    public void nextGeneration() {
        this.currentGeneration++;
    }


}
