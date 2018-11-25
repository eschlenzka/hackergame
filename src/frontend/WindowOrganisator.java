package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;

import console_backend.ConsoleLog;
import console_backend.GameProxy;
import console_backend.InputManager;
import console_backend.LocalGameProxy;
import game_backend.GameLogic;

public class WindowOrganisator {
	JFrame window = new JFrame("Hacker Game");
	JPanel game = new JPanel();
	JTextArea textout = new JTextArea();
	JTextField textin = new JTextField();
	
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
		
		window.getContentPane().add(game, BorderLayout.WEST);
		window.getContentPane().add(console, BorderLayout.EAST);
		
		LocalConsole lc = new LocalConsole(textout);
		textin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				manager.manage(textin.getText());
				textin.setText("");
			}
		});
		
		board = new Board(game);
		manager = new InputManager(new ConsoleLog(new LocalGameProxy(new GameLogic(board)), new LocalConsole(textout)));
	}	
	
	public static void main(String[] args) {
		new WindowOrganisator();
	}
}
