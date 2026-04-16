package level1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MainGame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextArea sceneDescription;
	private static JLabel lblImage;
	private static JButton btnChoice1;
	private static JButton btnChoice2;
	private static Scene currentScence;
	private static AdventureGame game;




	/**
	 * Launch the application.
	 */
		public static void main(String[] args) {
        //game.play();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGame1 frame = new MainGame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGame1() {
		
		game = new AdventureGame();
		currentScence = game.getCurrentScene();
		//updateSceneDisplay();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chose your own adventure game");
		lblNewLabel.setFont(new Font("Felix Titling", Font.PLAIN, 11));
		lblNewLabel.setBounds(79, 11, 311, 51);
		contentPane.add(lblNewLabel);
		
		lblImage = new JLabel("");
		//lblImage.setIcon(new ImageIcon(MainGame1.class.getResource("/images2/lobby.png")));
		
		ImageIcon icon = new ImageIcon(MainGame1.class.getResource("/images2/lobby.png"));
		Image img = icon.getImage();
		
		Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon (scaledImg);
		
		lblImage.setIcon(scaledIcon);
		lblImage.setBounds(79, 54, 300, 294);
		contentPane.add(lblImage);
		
		sceneDescription = new JTextArea();
		sceneDescription.setBounds(79, 359, 284, 44);
		contentPane.add(sceneDescription);
		
		btnChoice1 = new JButton("New button");
		btnChoice1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					int nextId = currentScence.getChoices().get(0).getNextSceneId();
					currentScence = game.getScences().findSceneById(nextId);
					
					updateSceneDisplay();
			}
		});
		btnChoice1.setBounds(22, 165, 89, 69);
		contentPane.add(btnChoice1);
		
		btnChoice2 = new JButton("New button");
		btnChoice2.setBounds(359, 165, 89, 69);
		contentPane.add(btnChoice2);
		
		updateSceneDisplay();
	}
	
	public void updateSceneDisplay() {
		//Scene scene = game.getCurrentScene();
		
		//lblTitle.setText(scene.getTitle());
		sceneDescription.setText(currentScence.getDescription());
		System.out.println(currentScence.getDescription());
		//txtInventory.setText(game.getPlayer().getInventoryText());
		
		ImageIcon icon = new ImageIcon(currentScence.getImagePath());
		Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		lblImage.setIcon(new ImageIcon(img));
		
		btnChoice1.setText("<html>" + currentScence.getChoices().get(0).getText() + "<html>");
		btnChoice2.setText("<html>" + currentScence.getChoices().get(1).getText() + "<html>");
		
		//btnPickup.setVisible(scene.getItem() != null);
	}
}
