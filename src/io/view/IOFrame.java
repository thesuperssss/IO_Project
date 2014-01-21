package io.view;

import io.controller.IOController;

import javax.swing.JFrame;
/**
 * Frame for the IO project
 * @author jwil1446
 * @version 1.1 13/12/13 Created setup method and constructor, Added a title to the window.
 */
public class IOFrame extends JFrame
{
	/**
	 *  IOPanel for the frame.
	 */
	private IOPanel basePanel;
	
	/**
	 * Constructor for the IOFrame
	 * @param baseController IOCOntroller passed in for MVC relationship.
	 */
	public IOFrame(IOController baseController)
	{
		basePanel = new IOPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("IO Project");
		this.setSize(400, 400);
		this.setVisible(true);
	}
}
