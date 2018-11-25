package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;

import console_backend.*;

public class WindowOrganisator {
	JFrame window = new JFrame("Hacker Game");
	JTextArea textout = new JTextArea();
	JTextField textin = new JTextField(30);
	
	Board board;
	InputManager manager;
	
	List<KeyListener> gameKeyListeners = new ArrayList<KeyListener>();
	
	public WindowOrganisator() {
		JPanel console = new JPanel();
		console.setLayout(new BorderLayout());
		
		JScrollPane scroller = new JScrollPane();
		scroller.setViewportView(textout);
		
		console.add(scroller, BorderLayout.CENTER);
		console.add(textin, BorderLayout.SOUTH);
		
		window.getContentPane().add(console, BorderLayout.EAST);
		
		LocalConsole lc = new LocalConsole(textout);
		textin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				manager.manage(textin.getText());
				textin.setText("");
			}
		});
		
		board = new Board();
		window.getContentPane().add(board.getPanel(), BorderLayout.CENTER);
		
		ConsoleLog consoleLog = new ConsoleLog(new LocalGameProxy(board), lc);
		
		manager = new InputManager(consoleLog);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 700);
		window.setVisible(true);
	}	
	
	public static void main(String[] args) {
		new WindowOrganisator();
	}
}
