package io.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import io.controller.IOController;
import io.model.Game;

public class IOPanel extends JPanel
{
	
	private IOController baseController;
	private JButton saveButton;
	private JButton loadButton;
	private JTextField titleField;
	private JTextField rankingField;
	private JTextArea rulesArea;
	private JLabel rulesLabel;
	private JLabel rankingLabel;
	private JLabel titleLabel;
	private SpringLayout baseLayout;
	private JLabel gameCountLabel;
	/**
	 * Constructor for the IOPanel
	 * @param baseController
	 */
	public IOPanel(IOController baseController)
	{
		this.baseController = baseController;

		saveButton = new JButton("save the game stuff");
		loadButton = new JButton("load the game stuff");
		titleField = new JTextField(15);
		titleLabel = new JLabel("Game Title: ");
		rankingField = new JTextField(5);
		rankingLabel = new JLabel("Game Ranking: ");
		rulesArea = new JTextArea(5, 20);
		rulesLabel = new JLabel("gameRules: ");
		baseLayout = new SpringLayout();
		gameCountLabel = new JLabel("Current game count: ");
		
		setupPanel();
		setupLayout();
		setupListeners();

	}
	/**
	 * helper method for setting up the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(rankingField);
		this.add(rulesLabel);
		this.add(rankingLabel);
		this.add(rulesArea);
		this.add(loadButton);
		this.add(saveButton);
		this.add(titleField);
		this.add(titleLabel);
		this.add(gameCountLabel);
	}
	/**
	 * helper method to set where objects go
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, rankingLabel, 3, SpringLayout.NORTH, rankingField);
		baseLayout.putConstraint(SpringLayout.WEST, rankingLabel, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, titleField, -62, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rankingField, 6, SpringLayout.SOUTH, rulesArea);
		baseLayout.putConstraint(SpringLayout.WEST, rankingField, 0, SpringLayout.WEST, rulesArea);
		baseLayout.putConstraint(SpringLayout.NORTH, titleField, -3, SpringLayout.NORTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rulesArea, -5, SpringLayout.NORTH, rulesLabel);
		baseLayout.putConstraint(SpringLayout.EAST, rulesArea, 0, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, titleLabel, 13, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rulesLabel, 0, SpringLayout.WEST, titleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 34, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -54, SpringLayout.WEST, saveButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -28, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -24, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rulesLabel, 27, SpringLayout.SOUTH, gameCountLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, gameCountLabel, 20, SpringLayout.SOUTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, gameCountLabel, 0, SpringLayout.WEST, titleLabel);
	}
	/**
	 * helper method to set up what the buttons do
	 */
	private void setupListeners()
	{
		saveButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.makeGameFromInput(titleField.getText(), rankingField.getText(), rulesArea.getText());
				if (tempGame != null)
				{
					baseController.saveGameInformation(tempGame);
					gameCountLabel.setText("Current game count: " + baseController.getProjectGames().size());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Try again witha valid number");
				}
			}

		});

		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.readGameInformation();
				if (tempGame != null)
				{
					titleField.setText(tempGame.getGameTitle());
					rankingField.setText(Integer.toString(tempGame.getFunRanking()));
					String tempRules = "";
					for (String currentRule : tempGame.getGameRules())
					{
						tempRules += currentRule + "\n";
					}
					rulesArea.setText(tempRules);
				}
			}
		});
	}

}
