import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {


    private JButton button;
    JFrame frame = new JFrame();
    JTextArea textArea = new JTextArea("Исходный документ",60,80);
    JTextArea textArea2= new JTextArea("Результат",60,80);
    ReadJson readJson = new ReadJson();
    public Window() {
        this.textArea = textArea;
        this.textArea2 = textArea2;
        frame.setSize(100,100);
        frame.setExtendedState(MAXIMIZED_BOTH);

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JButton button = new JButton("Определить");
        frame.add(textArea,BorderLayout.NORTH);
        frame.add(textArea2,BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txt = getTextArea();
              String result =  readJson.ReadingJson(txt);
              setTextArea2(result);
            }
        } ;
        button.addActionListener(actionListener);
        frame.setVisible(true);
    }

    public String getTextArea() {
        return textArea.getText();
    }

    public void setTextArea2(String list) {
        textArea2.setText(list);
    }
}
