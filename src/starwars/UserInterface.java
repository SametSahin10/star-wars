package starwars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sametsahin
 */
public class UserInterface extends JFrame {
        
    public UserInterface(String title) {
        super(title);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setupUI();
            }
        });
    }
    
    private void setupUI() {
        GridBagLayout gblForFrame = new GridBagLayout();
        
        setLayout(gblForFrame);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        //First row of GridBagLayout
        
        JPanel healthPanel = new JPanel(new BorderLayout());
        healthPanel.setBackground(new Color(150, 191, 195));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(healthPanel, gbc);
        
        JPanel healthIndicator = new JPanel(new GridLayout(1, 4));
        healthIndicator.setBackground(new Color(150, 191, 195));
        healthPanel.add(healthIndicator, BorderLayout.EAST);
        
        JLabel healthLabel = new JLabel("Canlar: ");
        healthLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        healthIndicator.add(healthLabel);
        
        JLabel healthHeart = new JLabel(new ImageIcon("resources/heart.png"));
        healthIndicator.add(healthHeart);
        
        JLabel healthHeart1 = new JLabel(new ImageIcon("resources/heart.png"));
        healthIndicator.add(healthHeart1);
        
        JLabel healthHeart2 = new JLabel(new ImageIcon("resources/heart.png"));
        healthIndicator.add(healthHeart2);
        
        //-----------------------------------------------------------
        
        //Second row of GridBagLayout
                
        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setBackground(new Color(150, 191, 195));
        
        JPanel westArrowPanel = new JPanel(new GridLayout(11, 0));
        westArrowPanel.setBackground(Color.BLUE);
        westArrowPanel.setSize(50, 300);
        
        for (int i = 0; i < 11; i++) {
            switch (i) {
                case 4:
                    JLabel westArrowLabel = 
                    new JLabel(new ImageIcon("resources/rightArrow.png"));
                    westArrowPanel.add(westArrowLabel);
                    break;
                default:
                    westArrowPanel.add(new JLabel());
            }
        }
        
        JPanel eastArrowPanel = new JPanel(new GridLayout(11, 0));
        eastArrowPanel.setBackground(Color.GREEN);
        
        for (int i = 0; i < 11; i++) {
            switch (i) {
                case 4:
                    JLabel eastArrowLabel = 
                    new JLabel(new ImageIcon("resources/leftArrow.png"));
                    eastArrowPanel.add(eastArrowLabel);
                    break;
                case 9:
                    JLabel eastCupLabel = 
                    new JLabel(new ImageIcon("resources/cup.png"));
                    eastArrowPanel.add(eastCupLabel);
                    break;
                default:
                    eastArrowPanel.add(new JLabel());
            }
        }
        
        JPanel northArrowPanel = new JPanel(new GridLayout(1, 16));
        northArrowPanel.setBackground(Color.CYAN);
        
        for (int i = 0; i < 16; i++) {
            switch (i) {
                case 5:
                    JLabel northArrowLabel = 
                    new JLabel(new ImageIcon("resources/downArrow.png"));
                    northArrowLabel.setHorizontalAlignment(JLabel.CENTER);
                    northArrowPanel.add(northArrowLabel);
                    break;
                case 13:
                    JLabel northArrowLabel1 = 
                    new JLabel(new ImageIcon("resources/downArrow.png"));
                    northArrowLabel1.setHorizontalAlignment(JLabel.CENTER);
                    northArrowPanel.add(northArrowLabel1);
                    break;
                default:
                    northArrowPanel.add(new JLabel());
            }
        }
        
        JPanel southArrowPanel = new JPanel(new GridLayout(1, 14));
        southArrowPanel.setBackground(Color.MAGENTA);
        
        for (int i = 0; i < 14; i++) {
            switch (i) {
                case 4:
                    JLabel southArrowLabel = 
                    new JLabel(new ImageIcon("resources/upArrow.png"));
                    southArrowPanel.add(southArrowLabel);
                    break;
                default:
                    southArrowPanel.add(new JLabel());
            }
        }
        
        mapPanel.add(westArrowPanel, BorderLayout.WEST);
        mapPanel.add(eastArrowPanel, BorderLayout.EAST);
        mapPanel.add(northArrowPanel, BorderLayout.NORTH);
        mapPanel.add(southArrowPanel, BorderLayout.SOUTH);
        
        JPanel playGroundPanel = new JPanel(new GridLayout(11, 14));
        
        JLabel cellsAsJLabels[][] = new JLabel[11][14];
        
        FileOperations fileOperations = new FileOperations();
        
        try {
            String[][] mazeData = fileOperations.readDataFromText();
            
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 14; j++) {
                    cellsAsJLabels[i][j] = new JLabel(mazeData[i][j]);
                    cellsAsJLabels[i][j].setHorizontalAlignment(SwingConstants.RIGHT);
                    cellsAsJLabels[i][j].setVerticalAlignment(SwingConstants.BOTTOM);
                    cellsAsJLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    playGroundPanel.add(cellsAsJLabels[i][j]);
                }
            }
            
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        
        DarthVader darthVader = new DarthVader(5, 12);
        cellsAsJLabels[5][6].setHorizontalAlignment(SwingConstants.CENTER);
        cellsAsJLabels[5][6].setVerticalAlignment(SwingConstants.CENTER);
        cellsAsJLabels[5][6].setText("");
        cellsAsJLabels[5][6].setIcon(darthVader.getKarakterSimgesi());
        
        playGroundPanel.setBackground(Color.PINK);
        mapPanel.add(playGroundPanel, BorderLayout.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 8;
        gbc.fill = GridBagConstraints.BOTH;
        add(mapPanel, gbc);
        
        //-----------------------------------------------------------
        
        //Third row of GridBagLayout
        
        JPanel shortestPathPanel = new JPanel(new BorderLayout());
        shortestPathPanel.setBackground(new Color(150, 191, 195));
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(shortestPathPanel, gbc);
        
        //-----------------------------------------------------------
        
        String dummyPath;
        dummyPath = "Stormtrooper (0,12)'den (5, 6)'ya 11 adimda ulasir.";
        JLabel shortestPathLabel = new JLabel(dummyPath);
        shortestPathLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        shortestPathLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shortestPathLabel.setVerticalAlignment(SwingConstants.CENTER);
        shortestPathPanel.add(shortestPathLabel, BorderLayout.CENTER);
        
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class FileOperations {
        private String[][] readDataFromText() throws IOException {
            String[] lines = new String[13];
            Scanner in = null;
        
            try {
                in = new Scanner(new FileReader("resources/Harita.txt"));
                in.useDelimiter("\n");
                int i = 0;
                while (in.hasNext()) {
                lines[i] = in.next();
                i++;
                }
            } finally {
                if (in != null) {
                in.close();
                }
            }
            
            String[][] mazeData = new String[11][14];
        
            for (int i = 2; i < lines.length; i++) {
                try {
                    in = new Scanner(lines[i]);
                    in.useDelimiter("\t");
                    int j = 0;
                    while (in.hasNext()) {                    
                    mazeData[i - 2][j] = in.next();
                    j++;
                    }
                } finally {
                    if (in != null) {
                    in.close();
                    }
                }
            }
            
            return mazeData;
        }
    }
}
