package com.urong.test;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMain {

	public static void main(String[] arg) {
		MyFrame f = new MyFrame("2차원 좌표 점 찍기");
	}
}

class MyFrame extends JFrame {
	MyFrame(String title) {
		super(title);
		setSize(620, 620);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		makeUI();

		setVisible(true);
	}

	private void makeUI() {
		MyPanel p = new MyPanel();
		add(p, BorderLayout.CENTER);
	}
}

class MyPanel extends JPanel {
	protected void paintComponent(Graphics g) {
		int x = 1;
		double[] y = 
			{1, 1.2, 1.6, 2.6, 3.9, 5.2, 6.0, 3.2, 5.2, 3.1, 4.3, 3.3, 2.3, 2.5, 3.21, 3.2, 2.4, 2.1, 3, 3.2}; 
		
		Graphics2D g2 = (Graphics2D) g;
		for (double d : y) {
			g2.fillOval(x+=1 * 20, (int) Math.round(d) * 20, 7, 7);
		}

		float dash3[] = { 3, 3f };
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash3, 0));
		g2.translate(300, 300);

		for (int i = -300; i <= 300; i = i + 20) {
			g2.draw(new Line2D.Float(-300, i, 300, i));
		}
		for (int j = -300; j <= 300; j = j + 20) {
			g2.draw(new Line2D.Float(j, -300, j, 300));
		}
	}

}
