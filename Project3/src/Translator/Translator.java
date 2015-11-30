package Translator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Translator extends JFrame {
	private static final long serialVersionUID = 1L;
	
	static HashMap<String, String> map = new HashMap<String, String>();
	static File file = new File();
	static Translate translate = new Translate();
	
	public static void main(String[] args) {

		override();
		
		JFrame frame = new JFrame("Главное окно");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 240);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JTextArea text1 = new JTextArea(10, 20);
		JScrollPane scroll1 = new JScrollPane(text1);
		text1.setWrapStyleWord(true);
		text1.setLineWrap(true);
		JTextArea text2 = new JTextArea(10, 20);
		JScrollPane scroll2 = new JScrollPane(text2);
		text2.setWrapStyleWord(true);
		text2.setLineWrap(true);
		
		JButton button = new JButton("Перевод");
		JButton button2 = new JButton("Очистить");
		JButton button3 = new JButton("Edit");
		
		frame.add(panel);
		panel.add(scroll1, new GridBagConstraints(0, 0, 3, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel.add(scroll2, new GridBagConstraints(3, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel.add(button, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel.add(button2, new GridBagConstraints(1, 0, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel.add(button3, new GridBagConstraints(2, 0, 1, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		
		text1.addKeyListener(new KeyListener(){
				// перевод по нажатию Enter
			@Override
			public void keyPressed(KeyEvent event) {
				 if (event.getKeyCode() == KeyEvent.VK_ENTER){
					
				 }
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				// перевод
				String strIn = text1.getText();
				String strOut;
				if(!strIn.isEmpty()){
					strOut = translate.translateAction(strIn, map);
					text2.setText(strOut);
				}
			}
		});
		
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// очистить
				text1.setText("");
				text2.setText("");
			}
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {				
				editor();
			}
		});
		
		frame.setVisible(true);
	}
	
	public static void editor(){
		JFrame frame = new JFrame("Редактор БД");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		JLabel label1 = new JLabel("Ввод (ENG)");
		JLabel label2 = new JLabel("Вывод (РУС)");
		JTextField tf1 = new JTextField(10);
		JTextField tf2 = new JTextField(10);
		JButton button1 = new JButton("Добавить");
		JButton delet = new JButton("Удалить");
		JTextField tf3 = new JTextField(10);
		JTextArea text1 = new JTextArea(10, 20);
		text1.setEditable(false);
		text1.setWrapStyleWord(true);
		text1.setLineWrap(true);
		JScrollPane scroll1 = new JScrollPane(text1);
		
		String s = showList();
		text1.setText(s);
		
		frame.add(panel1);
		panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel1.add(label2, new GridBagConstraints(1, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel1.add(tf1, new GridBagConstraints(0, 1, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel1.add(tf2, new GridBagConstraints(1, 1, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel1.add(button1, new GridBagConstraints(0, 2, 2, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel1.add(scroll1, new GridBagConstraints(0, 3, 2, 1, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel1.add(tf3, new GridBagConstraints(0, 4, 1, 1, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		panel1.add(delet, new GridBagConstraints(1, 4, 1, 1, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));
		
		
		button1.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// добавить
				if(!tf1.getText().equals("")&&!tf2.getText().equals("")){
				
				String k = tf1.getText();
				String v = tf2.getText();
				tf1.setText("");
				tf2.setText("");
				
				map.put(k, v);
				file.saveList("Dictionary", map);
				override();
				text1.setText("");
				text1.setText(showList());
				}
			}
		});
		
		delet.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String tf = tf3.getText();
				for(Map.Entry<String, String> i : map.entrySet()){
					if(i.getKey().equals(tf)){
						String k = i.getKey();
						String v = i.getValue();
						map.remove(k, v);
						file.saveList("Dictionary", map);
						override();
						text1.setText("");
						text1.setText(showList());
						tf3.setText(null);
						break;
					}
				}
			}
		});
		
		frame.setVisible(true);
		frame.pack();
	}
	public static String showList(){
		String r = "";
		for(Map.Entry<String, String> i : map.entrySet()){
			r += i.getKey() + " - " + i.getValue() + "\n";
		}
		return r;
	}
	@SuppressWarnings("unchecked")
	public static void override(){
		map = (HashMap<String, String>)file.openList("dictionary");
	}
	
	public void ifFileNotFound(){
		Dic dic = new Dic();
		map = dic.dic(map);
		file.saveList("Dictionary", map);
	}
}
