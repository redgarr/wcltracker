package com.brynhagen.gui.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;

import com.brynhagen.gui.ClientConstants;

/**
 * Created by Jonathan on 2017-06-02.
 */
public class GraphToolbarComboBoxUI
	extends BasicComboBoxUI
{

	@Override
	protected JButton createArrowButton()
	{
		JButton button = new JButton()
		{

			@Override
			public int getWidth()
			{
				return 0;
			}
		};

		return button;
	}

	@Override
	protected ComboPopup createPopup()
	{
		BasicComboPopup popup = new BasicComboPopup(comboBox)
		{

			@Override
			protected JScrollPane createScroller()
			{
				JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scroller.getVerticalScrollBar().setUnitIncrement(5);
				scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI()
				{
					@Override
					protected JButton createDecreaseButton(int orientation) {
						return createZeroButton();
					}

					@Override
					protected JButton createIncreaseButton(int orientation) {
						return createZeroButton();
					}

					@Override
					public Dimension getPreferredSize(JComponent c) {
						return new Dimension(5, super.getPreferredSize(c).height);
					}

					@Override
					protected void paintThumb(Graphics g, JComponent c,
						Rectangle thumbBounds)
					{
						if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
							return;
						}
						g.setColor(ClientConstants.paneContentBackgroundColor);
						g.fillRect(0, 0, getWidth(), getHeight());

						g.setColor(ClientConstants.contentBackgroundColor);
						g.translate(thumbBounds.x, thumbBounds.y);
						g.fillRect(0, 0, thumbBounds.width, thumbBounds.height);

					}

					private JButton createZeroButton() {
						return new JButton() {
							@Override
							public Dimension getMinimumSize() {
								return new Dimension(new Dimension(0, 0));
							}

							@Override
							public Dimension getPreferredSize() {
								return new Dimension(new Dimension(0, 0));
							}

							@Override
							public Dimension getMaximumSize() {
								return new Dimension(new Dimension(0, 0));
							}
						};
				}});

				return scroller;
			}
		};
		return popup;
	}
}
