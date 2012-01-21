package cynosure.conundrum.polyhedra;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Polyhedra extends JFrame {

	/**
	 *    class Polyhedra
	 */

	private static final long serialVersionUID = 1L;

	JPanel m_panel;
	JButton m_buttonTetrahedron;
	JButton m_buttonCube;
	JButton m_buttonOctahedron;
	JButton m_buttonDodecahedron;
	JButton m_buttonIcosahedron;

	Toolkit toolkit;

	String sPolyhedron;
	int xPos, yPos;

	// constructor
	public Polyhedra()
	{
		// window size width by height
		setSize(500, 250);
		// window title
		setTitle("Polyhedra");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		toolkit = getToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		// center window on screen
		setLocation(screenSize.width / 2 - getWidth() / 2,
				screenSize.height / 2 - getHeight() / 2);

		// construct panel
		m_panel = new JPanel();
		getContentPane().add(m_panel);
		m_panel.setLayout(null);

		// position buttons
		m_buttonTetrahedron = new JButton("Tetrahedron");
		m_buttonCube = new JButton("Cube");
		m_buttonOctahedron = new JButton("Octahedron");
		m_buttonDodecahedron = new JButton("Dodecahedron");
		m_buttonIcosahedron = new JButton("Icosahedron");
		m_buttonTetrahedron.setBounds(20, 20, 120, 30);
		m_buttonCube.setBounds(20, 60, 120, 30);
		m_buttonOctahedron.setBounds(20, 100, 120, 30);
		m_buttonDodecahedron.setBounds(20, 140, 120, 30);
		m_buttonIcosahedron.setBounds(20, 180, 120, 30);

		// bind action listeners to buttons
		m_buttonTetrahedron.addActionListener(
				new ButtonTetrahedronListener());
		m_buttonCube.addActionListener(
				new ButtonCubeListener());
		m_buttonOctahedron.addActionListener(
				new ButtonOctahedronListener());
		m_buttonDodecahedron.addActionListener(
				new ButtonDodecahedronListener());
		m_buttonIcosahedron.addActionListener(
				new ButtonIcosahedronListener());

		// add buttons
		m_panel.add(m_buttonTetrahedron);
		m_panel.add(m_buttonCube);
		m_panel.add(m_buttonOctahedron);
		m_panel.add(m_buttonDodecahedron);
		m_panel.add(m_buttonIcosahedron);

		// initialize polyhedron string
		sPolyhedron = "Polyhedron";
		xPos = 160;
		yPos = 60;
	}

	public void paint(Graphics graphics)
	{
		super.paint(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.drawString(sPolyhedron, xPos, yPos);
	}

	// Tetrahedron action listener
	class ButtonTetrahedronListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			sPolyhedron = "Tetrahedron";
			xPos = 160;
			yPos = 60;
			repaint();
		}
	}

	// Cube action listener
	class ButtonCubeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			sPolyhedron = "Cube";
			xPos = 160;
			yPos = 100;
			repaint();
		}
	}

	// Octahedron action listener
	class ButtonOctahedronListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			sPolyhedron = "Octahedron";
			xPos = 160;
			yPos = 140;
			repaint();
		}
	}

	// Dodecahedron action listener
	class ButtonDodecahedronListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			sPolyhedron = "Dodecahedron";
			xPos = 160;
			yPos = 180;
			repaint();
		}
	}

	// Icosahedron action listener
	class ButtonIcosahedronListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			sPolyhedron = "Icosahedron";
			xPos = 160;
			yPos = 220;
			repaint();
		}
	}

	// entrance
	public static void main(String[] args)
	{
		Polyhedra m_polyhedra = new Polyhedra();
		m_polyhedra.setVisible(true);
	}
}


