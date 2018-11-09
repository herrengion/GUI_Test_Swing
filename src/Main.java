import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main{

    public static void main(String[] a){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ButtonDemo());
        f.setSize(1000,300);
        f.setVisible(true);
    }
}

class ButtonDemo extends JPanel implements ActionListener {
    JTextField jtf;

    public ButtonDemo() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    makeGUI();
                }
            });
        } catch (Exception exc) {
            System.out.println("Can't create because of " + exc);
        }
    }

    private void makeGUI() {
        setLayout(new FlowLayout());

        ImageIcon france = new ImageIcon(this.getClass().getResource("images/france.gif"));
        JButton jb = new JButton(france);
        jb.setActionCommand("France");
        jb.addActionListener(this);
        jb.setMargin(null);
        add(jb);


        ImageIcon germany = new ImageIcon(this.getClass().getResource("images/germany.gif"));
        jb = new JButton(germany);
        jb.setActionCommand("Germany");
        jb.addActionListener(this);
        jb.setMargin(null);
        add(jb);

        ImageIcon italy = new ImageIcon(this.getClass().getResource("images/italy.gif"));
        jb = new JButton(italy);
        jb.setActionCommand("Italy");
        jb.addActionListener(this);
        jb.setMargin(null);
        add(jb);

        /*ImageIcon japan = new ImageIcon(this.getClass().getResource("images/japan.gif"));
        jb = new JButton(japan);
        jb.setActionCommand("Japan");
        jb.addActionListener(this);
        jb.setMargin(null);
        add(jb);*/

        jtf = new JTextField(15);
        jtf.setMargin(null);
        add(jtf);
    }

    public void actionPerformed(ActionEvent ae) {
        jtf.setText(ae.getActionCommand());
    }
}