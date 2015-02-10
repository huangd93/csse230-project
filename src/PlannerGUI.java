import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlannerGUI {
	/**
     * Mainframe.
     */
     JFrame mainframe;
     
     /**
     * Constructs the Map GUI.
     */
     public PlannerGUI() {
           this.mainframe = new JFrame("Yggdrasil (The World Tree): Plan Adventure");
           this.mainframe.setSize(1366, 768);
           this.mainframe.setVisible(true);
           this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.mainframe.setResizable(false);
           
           JPanel mainPanel = new JPanel();
           
           JLabel distanceChoice = new JLabel("How far would you like to travel?");
           JComboBox<JLabel> distanceList = new JComboBox<JLabel>();
           distanceList.addItem(new JLabel("Less than 100 miles"));
           distanceList.addItem(new JLabel("Between 100 and 200 miles"));
           distanceList.addItem(new JLabel("Between 200 and 300 miles"));
           distanceList.addItem(new JLabel("Between 300 and 400 miles"));
           distanceList.addItem(new JLabel("Greater than 400 miles"));
           JLabel timeChoice = new JLabel("How long would you like your adventure to be?");
           JComboBox<JLabel> timeList = new JComboBox<JLabel>();
           timeList.addItem(new JLabel("Less than 1 hour"));
           timeList.addItem(new JLabel("Between 1 and 2 hours"));
           timeList.addItem(new JLabel("Between 2 and 3 hours"));
           timeList.addItem(new JLabel("Between 3 and 4 hours"));
           timeList.addItem(new JLabel("Greater than 4 hours"));
           JButton planButton = new JButton("Create Adventure");
           planButton.addActionListener(new ButtonHandler());
           
           mainPanel.setBounds(433, 15, 500, 550);
           
           mainPanel.add(distanceChoice);
           mainPanel.add(distanceList);
           mainPanel.add(timeChoice);
           mainPanel.add(timeList);
           mainPanel.add(planButton);
           
           this.mainframe.setLayout(null);
           this.mainframe.add(mainPanel);
     }
}