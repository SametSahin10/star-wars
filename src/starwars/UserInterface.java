package starwars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
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
        
        JPanel healthIndicator = new JPanel(new GridLayout(1, 2));
        healthIndicator.setBackground(new Color(150, 191, 195));
        healthPanel.add(healthIndicator, BorderLayout.EAST);
        
        JLabel healthLabel = new JLabel("Canlar: ");
        healthIndicator.add(healthLabel);
        
        JLabel healthHearts = new JLabel("Kalpler");
        healthIndicator.add(healthHearts);
        
        //-----------------------------------------------------------
        
        //Second row of GridBagLayout
                
        JPanel mapPanel = new JPanel(new BorderLayout(10, 10));
        mapPanel.setBackground(new Color(150, 191, 195));
        
        JTable mapTable = new JTable(11, 14);
        mapTable.setRowHeight(40);
        mapTable.setGridColor(Color.black);
        mapTable.setShowGrid(true);
        mapTable.setBackground(Color.yellow);
        mapPanel.add(mapTable, BorderLayout.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 6;
        gbc.fill = GridBagConstraints.BOTH;
        add(mapPanel, gbc);
        
        //-----------------------------------------------------------
        
        //Third row of GridBagLayout
        
        JPanel shortestPathPanel = new JPanel();
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
        JLabel shortestPathText = new JLabel(dummyPath);
        shortestPathPanel.add(shortestPathText);
        
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
