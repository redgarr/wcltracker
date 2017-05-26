package com.brynhagen.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.joda.time.DateTime;

/**
 * Created by jonathan on 26/05/17.
 */
public class GraphPanel
	extends JPanel
{

	private class DataPoint
	{

		private DateTime date;
		private int value;

		public DataPoint(DateTime date, int value)
		{
			this.date = date;
			this.value = value;
		}

		public DateTime getDate()
		{
			return date;
		}

		public int getValue()
		{
			return value;
		}
	}

	DataPoint p1 = new DataPoint(new DateTime(1495187092000l), 500);
	DataPoint p2 = new DataPoint(new DateTime(1495273492000l), 600);
	DataPoint p3 = new DataPoint(new DateTime(1495359892000l), 800);
	private List<DataPoint> dataPoints;
	private final int GRAPH_PADDING = 40;

	public GraphPanel()
	{
		setBackground(ClientConstants.paneContentBackgroundColor);
		dataPoints = new ArrayList();
		dataPoints.add(p1);
		dataPoints.add(p2);
		dataPoints.add(p3);

	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D)g;
		graphics2D.setRenderingHint(
			RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);


		int height = getHeight() - 30;
		int maxScore = dataPoints.stream().mapToInt(DataPoint::getValue).max().orElse(0);
		g.setColor(ClientConstants.contentBackgroundColor);
		g.fillRect(0,0,getWidth(), height);


		//Draw %ile lines
		//TODO: find top dpser, use that as base for color lines
		g.setColor(ClientConstants.greenRankingColor);
		g.drawLine(0, (int)(height*0.75), getWidth(), (int)(height*0.75));

		g.setColor(ClientConstants.blueRankingColor);
		g.drawLine(0, (int)(height*0.50), getWidth(), (int)(height*0.50));

		g.setColor(ClientConstants.purpleRankingColor);
		g.drawLine(0, (int)(height*0.25), getWidth(), (int)(height*0.25));

		g.setColor(ClientConstants.orangeRankingColor);
		g.drawLine(0, (int)(height*0.05), getWidth(), (int)(height*0.05));


		double xScale = ((double) getWidth() - 2 * GRAPH_PADDING) / (dataPoints.size() - 1);
		double yScale = ((double) height - 2 * GRAPH_PADDING) / (maxScore - 1);

		for(int i=0; i<dataPoints.size(); i++)
		{
			int x = (int)(i*xScale + GRAPH_PADDING);
			int y = (int)((maxScore - dataPoints.get(i).getValue())*yScale + GRAPH_PADDING);

			g.setColor(Color.GREEN);
			g.fillOval(x, y, 10, 10);
			g.setColor(Color.WHITE);
			g.drawString(dataPoints.get(i).getDate().getDayOfMonth() + "/" + dataPoints.get(i).getDate().getMonthOfYear(), x, getHeight()-15);
		}
	}
}
