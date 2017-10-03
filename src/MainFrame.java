import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton jbtn1 = new JButton("Exemple");
    private JButton jbtn2 = new JButton("Decrypte");
    private JButton jbtn3 = new JButton("Clear");
    private JButton jbtn4 = new JButton("Exit");
    private JLabel jlb = new JLabel("key");
    private JPanel jpn = new JPanel(new GridLayout(6,1,3,3));
    private JTextArea jtaL = new JTextArea();
    private JTextArea jtaR = new JTextArea();
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JTextField jtf = new JTextField("3");
    private int count = 0 ;

    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(100,100,500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
//        cp.setLayout(new GridLayout(5,1,3,3));
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpn , BorderLayout.CENTER);
        cp.add(jspL , BorderLayout.WEST);
        cp.add(jspR , BorderLayout.EAST);
        jtaL.setPreferredSize(new Dimension(200,400));
        jtaR.setPreferredSize(new Dimension(200,400));
        jtaL.setLineWrap(true);
        jtaR.setLineWrap(true);

        jpn.add(jbtn1);
        jpn.add(jbtn2);
//        jlb.setHorizontalAlignment(JLabel.CENTER);
        jpn.add(jlb);
        jpn.add(jtf);
        jpn.add(jbtn3);
        jpn.add(jbtn4);



        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("Two of AU students’ works entitled" +
                        "“Neiwan Love Story” and“Taiwan Old-street " +
                        "Chinese Characters” win the “Best of the Best” " +
                        "RedDot Medals.");
            }
        });

        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = jtaL.getText().toCharArray();
                int len = data.length;//,key = Integer.parseInt(jtf.getText());
                for(int i =0;i<len;i++){
                    data[i] +=Integer.parseInt(jtf.getText());//key
                }
                jtaR.setText(new String(data));
            }
        });
        jbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
                jtaR.setText("");
            }
        });
        jbtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
