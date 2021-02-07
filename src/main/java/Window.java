import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {


    private JButton button;
    JFrame frame = new JFrame("Определитель имен.Json");
    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea("Исходный документ",60,80);
    JTextArea textArea2= new JTextArea("Результат",60,80);
    ReadJson readJson = new ReadJson();

    public Window() {
        this.textArea = textArea;
        this.textArea2 = textArea2;
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        frame.setSize(100,100);
        frame.setExtendedState(MAXIMIZED_BOTH);

        JButton button = new JButton("Определить");
        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scrollPane2 = new JScrollPane(textArea2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
       // panel.add(textArea,BorderLayout.WEST);
        panel.add(scrollPane,BorderLayout.WEST);
        panel.add(button, BorderLayout.CENTER);
        panel.add(scrollPane2,BorderLayout.EAST);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txt = getTextArea();
              String result =  readJson.ReadingJson(txt);
              setTextArea2(result);
            }
        } ;
        button.addActionListener(actionListener);

        frame.add(panel,BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public String getTextArea() {
        return textArea.getText();
    }

    public void setTextArea2(String list) {
        textArea2.setText(list);
    }
}
