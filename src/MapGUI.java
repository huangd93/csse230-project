import javax.swing.JFrame;


public class MapGUI {
	private JFrame mainframe;
	public MapGUI(){
		this.mainframe = new JFrame("Your Adventure");
        this.mainframe.setSize(1366, 768);
        this.mainframe.setVisible(true);
        this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainframe.setResizable(false);
        
        
	}
}
