package starwars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import jdk.swing.interop.SwingInterOpUtils;

/**
 *
 * @author sametsahin
 */
public class UserInterface extends JFrame {
    private JLabel cellsAsJLabels[][];
        
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
        
        cellsAsJLabels = new JLabel[11][14];
        
        FileOperations fileOperations = new FileOperations();
        
        try {
            String[][] mazeData = fileOperations.readMazeDataFromText();
            
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 14; j++) {
                    cellsAsJLabels[i][j] = new JLabel(mazeData[i][j]);
                    cellsAsJLabels[i][j].setHorizontalAlignment(SwingConstants.RIGHT);
                    cellsAsJLabels[i][j].setVerticalAlignment(SwingConstants.BOTTOM);
                    cellsAsJLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    playGroundPanel.add(cellsAsJLabels[i][j]);
                }
            }
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //Add character here.
        CharacterOperations co = new CharacterOperations();
        co.addGoodCharacter("Luke Skywalker", 5, 6);

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

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("Hello from UP Key Pressed");
                    co.moveCharacter("UP");

                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("Hello from DOWN Key Pressed");
                    co.moveCharacter("DOWN");
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("Hello from LEFT Key Pressed");
                    co.moveCharacter("LEFT");
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("Hello from RIGHT Key Pressed");
                    co.moveCharacter("RIGHT");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class FileOperations {
        Scanner in = null;
        
        private String[] readLinesFromText() throws IOException {
            String[] lines = new String[13];
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
            return lines;
        }
        
        private String[][] readMazeDataFromText() throws IOException {
            String[] lines = readLinesFromText();
            
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
        
        private HashMap readBadCharDataFromText() throws IOException {
            String[] lines = readLinesFromText();
            
            HashMap<String, String> charAndDoor = new HashMap<>();
            
            String[][] characterInfos = new String[2][2];
            int i = 0;
        
            try {
                for (int j = 0; j < characterInfos.length; j++) {
                    in = new Scanner(lines[i]);
                    in.useDelimiter(",");
                    while (in.hasNext()) {
                        for (int k = 0; k < characterInfos[j].length; k++) {
                            characterInfos[j][k] = in.next();
                        }
                        i++;
                    }   
                }
                } finally {
                    if (in != null) {
                    in.close();
                    }
                }
            
            for (int j = 0, m = 0; j < characterInfos.length; j++) {
                charAndDoor.put(characterInfos[j][m], characterInfos[j][m + 1]);
            }
            
            return charAndDoor;
        }
    }
    
    private class CharacterOperations {
        private ArrayList<Karakter> goodCharacters = new ArrayList<>();
        private ArrayList<Karakter> badCharacters = new ArrayList<>();
//        private LukeSkywalker lukeSkywalker;
//        private MasterYoda masterYoda;
//        private DarthVader darthVader;
//        private KyloRen kyloRen;
//        private Stormtrooper stormtrooper;

//        private void addBadCharacter(String charName, int x, int y) {
//            int locX;
//            int locY;
//
//            switch (charName) {
//                case "Darth Vader":
//                    darthVader = new DarthVader(x, y);
//                    locX = darthVader.getLokasyon().getX();
//                    locY = darthVader.getLokasyon().getY();
//                    cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
//                    cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
//                    cellsAsJLabels[locX][locY].setText("");
//                    cellsAsJLabels[locX][locY].setIcon(darthVader.getKarakterSimgesi());
//                    break;
//                case "Kylo Ren":
//                    kyloRen = new KyloRen(x, y);
//                    locX = kyloRen.getLokasyon().getX();
//                    locY = kyloRen.getLokasyon().getY();
//                    cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
//                    cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
//                    cellsAsJLabels[locX][locY].setText("");
//                    cellsAsJLabels[locX][locY].setIcon(kyloRen.getKarakterSimgesi());
//                    break;
//                case "Stormtrooper":
//                    stormtrooper = new Stormtrooper(x, y);
//                    locX = stormtrooper.getLokasyon().getX();
//                    locY = stormtrooper.getLokasyon().getY();
//                    cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
//                    cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
//                    cellsAsJLabels[locX][locY].setText("");
//                    cellsAsJLabels[locX][locY].setIcon(stormtrooper.getKarakterSimgesi());
//                    break;
//                default:
//                    System.err.println("Character cannot be added");
//            }
//        }
        
        private void addGoodCharacter(String charName, int x, int y) {
            int locX;
            int locY;

            switch (charName) {
                case "Luke Skywalker":
                    System.out.println("Hello from addGoodCharacter");
                    goodCharacters.add(new LukeSkywalker(x, y, true));
                    //Get back here
                    if (goodCharacters.get(0).isActive()) {
                        System.out.println("isActive is true");
                    }
                    locX = goodCharacters.get(0).getLokasyon().getX();
                    System.out.println("LocationX is: " + locX);
                    locY = goodCharacters.get(0).getLokasyon().getY();
                    System.out.println("LocationY is: " + locY);
                    cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                    cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                    cellsAsJLabels[locX][locY].setText("");
                    cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(0).getKarakterSimgesi());
                    break;
                case "Master Yoda":
                    goodCharacters.add(new MasterYoda(x, y, true));
                    locX = goodCharacters.get(1).getLokasyon().getX();
                    locY = goodCharacters.get(1).getLokasyon().getY();
                    cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                    cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                    cellsAsJLabels[locX][locY].setText("");
                    cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(1).getKarakterSimgesi());
//                    cellsAsJLabels[locX][locY].addKeyListener(new ControlKeyListener());
                    break;
                default:
                    System.err.println("Character cannot be added");
            }
        }

        private void clearOldCell(int x, int y) {
            System.out.println("clearOldCell()");
            cellsAsJLabels[x][y].setHorizontalAlignment(SwingConstants.RIGHT);
            cellsAsJLabels[x][y].setVerticalAlignment(SwingConstants.BOTTOM);
            cellsAsJLabels[x][y].setText("1");
            cellsAsJLabels[x][y].setIcon(null);
        }

        private void moveCharacter(String whereTo) {
            System.out.println("moveCharacter()");
            if (goodCharacters.get(0) == null) {
                System.out.println("Luke Skywalker is null");
            }
            switch (whereTo) {
                case "UP":
                    if (goodCharacters.get(0).isActive()) {
                        System.out.println("Hello from UP");
                        if (goodCharacters.get(0) == null) {
                            System.out.println("Luke Skywalker is null");
                        }
                        int locX = goodCharacters.get(0).getLokasyon().getX();
                        int locY = goodCharacters.get(0).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(0).getLokasyon().getX(), goodCharacters.get(0).getLokasyon().getY());
                        locX -= 1;
                        goodCharacters.get(0).getLokasyon().setX(locX);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(0).getKarakterSimgesi());
                    } else if (goodCharacters.get(1).isActive()) {
                        int locX = goodCharacters.get(1).getLokasyon().getX();
                        int locY = goodCharacters.get(1).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(1).getLokasyon().getX(), goodCharacters.get(1).getLokasyon().getY());
                        locX -= 1;
                        goodCharacters.get(1).getLokasyon().setX(locX);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(1).getKarakterSimgesi());
                    } else {
                        System.err.println("No active character found");
                    }
                    break;
                case "DOWN":
                    if (goodCharacters.get(0).isActive()) {
                        int locX = goodCharacters.get(0).getLokasyon().getX();
                        int locY = goodCharacters.get(0).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(0).getLokasyon().getX(), goodCharacters.get(0).getLokasyon().getY());
                        locX += 1;
                        goodCharacters.get(0).getLokasyon().setX(locX);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(0).getKarakterSimgesi());
                    } else if (goodCharacters.get(1).isActive()) {
                        int locX = goodCharacters.get(1).getLokasyon().getX();
                        int locY = goodCharacters.get(1).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(1).getLokasyon().getX(), goodCharacters.get(1).getLokasyon().getY());
                        locX += 1;
                        goodCharacters.get(1).getLokasyon().setX(locX);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(1).getKarakterSimgesi());
                    } else {
                        System.err.println("No active character found");
                    }
                    break;
                case "LEFT":
                    if (goodCharacters.get(0).isActive()) {
                        int locX = goodCharacters.get(0).getLokasyon().getX();
                        int locY = goodCharacters.get(0).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(0).getLokasyon().getX(), goodCharacters.get(0).getLokasyon().getY());
                        locY -= 1;
                        goodCharacters.get(0).getLokasyon().setY(locY);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(0).getKarakterSimgesi());
                    } else if (goodCharacters.get(1).isActive()) {
                        int locX = goodCharacters.get(1).getLokasyon().getX();
                        int locY = goodCharacters.get(1).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(1).getLokasyon().getX(), goodCharacters.get(1).getLokasyon().getY());
                        locX -= 1;
                        goodCharacters.get(1).getLokasyon().setY(locY);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(0).getKarakterSimgesi());
                    } else {
                        System.err.println("No active character found");
                    }
                    break;
                case "RIGHT":
                    if (goodCharacters.get(0).isActive()) {
                        int locX = goodCharacters.get(0).getLokasyon().getX();
                        int locY = goodCharacters.get(0).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(0).getLokasyon().getX(), goodCharacters.get(0).getLokasyon().getY());
                        locY += 1;
                        goodCharacters.get(0).getLokasyon().setY(locY);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(0).getKarakterSimgesi());
                    } else if (goodCharacters.get(1).isActive()) {
                        int locX = goodCharacters.get(1).getLokasyon().getX();
                        int locY = goodCharacters.get(1).getLokasyon().getY();
                        clearOldCell(goodCharacters.get(1).getLokasyon().getX(), goodCharacters.get(1).getLokasyon().getY());
                        locX += 1;
                        goodCharacters.get(1).getLokasyon().setY(locY);
                        cellsAsJLabels[locX][locY].setHorizontalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setVerticalAlignment(SwingConstants.CENTER);
                        cellsAsJLabels[locX][locY].setText("");
                        cellsAsJLabels[locX][locY].setIcon(goodCharacters.get(0).getKarakterSimgesi());
                    } else {
                        System.err.println("No active character found");
                    }
                    break;
                default:
                    System.err.println("Unknown direction");
            }
        }
    }
}
