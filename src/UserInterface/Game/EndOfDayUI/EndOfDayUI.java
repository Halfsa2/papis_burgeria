package UserInterface.Game.EndOfDayUI;

import UserInterface.Game.ContinueBtn;
import UserInterface.Window.Window;

import javax.swing.*;
import java.awt.*;

public class EndOfDayUI extends JPanel {
    Window window;
    JLabel titleLabel;
    JLabel dailyProfitLabel;
    JLabel totalMoneyLabel;
    public EndOfDayUI(Window window) {
        this.window = window;
        this.setLayout(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titleLabel = new JLabel();
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD,60));

        JPanel profitPanel = new JPanel();
        profitPanel.setOpaque(false);
        profitPanel.setLayout(new BoxLayout(profitPanel, BoxLayout.Y_AXIS));
        dailyProfitLabel = new JLabel();
        dailyProfitLabel.setFont(dailyProfitLabel.getFont().deriveFont(Font.BOLD,30));
        dailyProfitLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dailyProfitLabel.setForeground(Color.green);
        totalMoneyLabel = new JLabel();
        totalMoneyLabel.setOpaque(false);
        totalMoneyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalMoneyLabel.setFont(totalMoneyLabel.getFont().deriveFont(Font.BOLD,30));
        totalMoneyLabel.setForeground(Color.DARK_GRAY);

        JPanel continueBtnPanel = new JPanel();
        continueBtnPanel.setOpaque(false);
        continueBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        ContinueBtn continueBtn = new ContinueBtn(window);
        continueBtnPanel.add(continueBtn);

        profitPanel.add(dailyProfitLabel);
        profitPanel.add(totalMoneyLabel);
        titlePanel.add(titleLabel);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(profitPanel, BorderLayout.CENTER);
        this.add(continueBtnPanel, BorderLayout.SOUTH);

    }
    public void update() {
        titleLabel.setText("Day " + window.getGame().getToday().getCount());
        dailyProfitLabel.setText("Daily profit: "+window.getGame().getToday().getProfit());
        totalMoneyLabel.setText("Total money: "+ window.getGame().getMoney());
        this.revalidate();
        this.repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon bg = new ImageIcon(getClass().getResource("/images/dailySummary_background.png"));
        Image img = bg.getImage();
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
