import javax.swing.*;

public class storyGUI {
    private JTextPane TOPTEXTBOTTOMTEXTTextPane;
    private JPanel panel1;
    private JComboBox comboBox1;

    public static void main(String[] args) {
        System.out.println("Hello world");

        JFrame frame = new JFrame("storyGUI");
        frame.setContentPane(new storyGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
