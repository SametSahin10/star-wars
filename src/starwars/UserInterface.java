package starwars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

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
//        GridLayout gridLayoutForFrame = new GridLayout(3, 1);
        GridLayout gridLayoutForMap = new GridLayout(3, 3);
        GridBagLayout gblForFrame = new GridBagLayout();
        
        setLayout(gblForFrame);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel healthPanel = new JPanel(new BorderLayout());
        healthPanel.setBackground(new Color(150, 191, 195));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        add(healthPanel, gbc);
        
        JPanel healthIndicator = new JPanel(new GridLayout(1, 2));
        healthIndicator.setBackground(new Color(150, 191, 195));
        healthPanel.add(healthIndicator, BorderLayout.EAST);
        
        JLabel healthLabel = new JLabel("Canlar: ");
        healthIndicator.add(healthLabel);
        
        JLabel healthHearts = new JLabel("Kalpler");
        healthIndicator.add(healthHearts);
                
        JPanel mapPanel = new JPanel();
        mapPanel.setLayout(gridLayoutForMap);
        mapPanel.setBackground(Color.PINK);
        
        for (int i = 0; i < 11 * 14; i++) {
            JLabel label = new JLabel("ex");
            mapPanel.add(label);
        }
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 9;
        gbc.fill = GridBagConstraints.BOTH;
        add(mapPanel, gbc);
        
        JPanel shortestPathPanel = new JPanel();
        shortestPathPanel.setBackground(new Color(150, 191, 195));
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.BOTH;
        add(shortestPathPanel, gbc);
        
        String dummyPath;
        dummyPath = "Stormtrooper (0,12)'den (5, 6)'ya 11 adimda ulasir.";
        JLabel shortestPathText = new JLabel(dummyPath);
        shortestPathPanel.add(shortestPathText);
        
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
