package Gui;

import Logic.AyarlarEkraniActions;
import Logic.JTextFieldLimit;
import Logic.KeyTyped;
import java.awt.*;
import javax.swing.*;

public class AyarlarEkrani {

    JFrame ayarlarEkraniFrame = null;
    JPanel ayarlarEkraniPanel = null;
    JLabel geriLabel = null;
    JLabel adSoyadLabel = null;
    JLabel musteriNoLabel = null;
    JTextField musteriNoText = null;
    JLabel telNoLabel = null;
    JTextField telNoText = null;
    JLabel telNoDegistirIcon = null;
    JLabel sifreLabel = null;
    JTextField sifreText = null;
    JLabel sifreDegistirIcon = null;
    AyarlarEkraniActions action = new AyarlarEkraniActions(this);

    public AyarlarEkrani() {
        getAyarlarEkraniPanel().setBackground(new Color(204, 255, 204));
        getAyarlarEkraniPanel().add(getGeriLabel());
        getAyarlarEkraniPanel().add(getAdSoyadLabel());
        getAyarlarEkraniPanel().add(getMusteriNoLabel());
        getAyarlarEkraniPanel().add(getMusteriNoText());
        getAyarlarEkraniPanel().add(getTelNoLabel());
        getAyarlarEkraniPanel().add(getTelNoText());
        getAyarlarEkraniPanel().add(getTelNoDegistirIcon());
        getAyarlarEkraniPanel().add(getSifreLabel());
        getAyarlarEkraniPanel().add(getSifreText());
        getAyarlarEkraniPanel().add(getSifreDegistirIcon());
        getAyarlarEkraniFrame().setVisible(true);
    }

    public JFrame getAyarlarEkraniFrame() {
        if (ayarlarEkraniFrame == null) {
            ayarlarEkraniFrame = new JFrame("Ayarlar");
            ayarlarEkraniFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            ayarlarEkraniFrame.setResizable(false);
            ayarlarEkraniFrame.setLocation(700, 350);
            ayarlarEkraniFrame.setSize(460, 310);
            ayarlarEkraniFrame.setContentPane(getAyarlarEkraniPanel());
        }
        return ayarlarEkraniFrame;
    }

    public JPanel getAyarlarEkraniPanel() {
        if (ayarlarEkraniPanel == null) {
            ayarlarEkraniPanel = new JPanel();
            ayarlarEkraniPanel.setFocusable(true);
            ayarlarEkraniPanel.setLayout(null);
        }
        return ayarlarEkraniPanel;
    }

    public JLabel getGeriLabel() {
        if (geriLabel == null) {
            geriLabel = new JLabel();
            geriLabel.setBounds(10, 10, 30, 28);
            geriLabel.setIcon(new ImageIcon(getClass().getResource("/Gui/Image/geriIcon.png")));
            geriLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            geriLabel.addMouseListener(action);
        }
        return geriLabel;
    }

    public JLabel getAdSoyadLabel() {
        if (adSoyadLabel == null) {
            adSoyadLabel = new JLabel();
            adSoyadLabel.setText("Sayın [Müşteri Adı Soyadı]");
            adSoyadLabel.setFont(getFont(1, 19)); // style:bold , size:19
            adSoyadLabel.setForeground(Color.red);
            adSoyadLabel.setBounds(20, 40, 350, 30);
        }
        return adSoyadLabel;
    }

    public JLabel getMusteriNoLabel() {
        if (musteriNoLabel == null) {
            musteriNoLabel = new JLabel();
            musteriNoLabel.setText("Müşteri Numaranız : ");
            musteriNoLabel.setFont(getFont(1, 16)); // style:bold , size:19
            musteriNoLabel.setForeground(Color.black);
            musteriNoLabel.setBounds(20, 90, 160, 30);
        }
        return musteriNoLabel;
    }

    public JTextField getMusteriNoText() {
        if (musteriNoText == null) {
            musteriNoText = new JTextField();
            musteriNoText.setFont(getFont(0, 11));
            musteriNoText.setBounds(200, 90, 170, 30);
            musteriNoText.setEditable(false);
        }
        return musteriNoText;
    }

    public JLabel getTelNoLabel() {
        if (telNoLabel == null) {
            telNoLabel = new JLabel();
            telNoLabel.setText("Telefon Numaranız : ");
            telNoLabel.setFont(getFont(1, 16)); // style:bold , size:19
            telNoLabel.setForeground(Color.black);
            telNoLabel.setBounds(20, 140, 160, 30);
        }
        return telNoLabel;
    }

    public JTextField getTelNoText() {
        if (telNoText == null) {
            telNoText = new JTextField();
            telNoText.setFont(getFont(0, 11));
            telNoText.setBounds(200, 140, 170, 30);
            telNoText.setEditable(false);
            KeyTyped.sadeceSayiAl(getAyarlarEkraniFrame(), getTelNoText());
            telNoText.setDocument(new JTextFieldLimit(11));
        }
        return telNoText;
    }

    public JLabel getTelNoDegistirIcon() {
        if (telNoDegistirIcon == null) {
            telNoDegistirIcon = new JLabel();
            telNoDegistirIcon.setBounds(380, 140, 30, 30);
            telNoDegistirIcon.setIcon(new ImageIcon(getClass().getResource("/Gui/Image/degistirIcon.png")));
            telNoDegistirIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            telNoDegistirIcon.addMouseListener(action);
        }
        return telNoDegistirIcon;
    }

    public JLabel getSifreLabel() {
        if (sifreLabel == null) {
            sifreLabel = new JLabel();
            sifreLabel.setText("Şifreniz                       :");
            sifreLabel.setFont(getFont(1, 16)); // style:bold , size:19
            sifreLabel.setForeground(Color.black);
            sifreLabel.setBounds(20, 190, 160, 30);
        }
        return sifreLabel;
    }

    public JTextField getSifreText() {
        if (sifreText == null) {
            sifreText = new JTextField();
            sifreText.setFont(getFont(0, 11));
            sifreText.setBounds(200, 190, 170, 30);
            sifreText.setEditable(false);
        }
        return sifreText;
    }

    public JLabel getSifreDegistirIcon() {
        if (sifreDegistirIcon == null) {
            sifreDegistirIcon = new JLabel();
            sifreDegistirIcon.setBounds(380, 190, 30, 30);
            sifreDegistirIcon.setIcon(new ImageIcon(getClass().getResource("/Gui/Image/degistirIcon.png")));
            sifreDegistirIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            sifreDegistirIcon.addMouseListener(action);
        }
        return sifreDegistirIcon;
    }

    public Font getFont(int style, int size) {
        return new Font("Segoe UI", style, size);
    }
}