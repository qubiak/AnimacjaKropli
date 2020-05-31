package animacjakropli;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

public class animacjaKropli extends JFrame {

    public animacjaKropli() {
        this.setTitle("Animacja kropelki");
        this.setBounds(250, 300, 600, 250);
        Image iconImage = Toolkit.getDefaultToolkit().getImage("kropelka.gif");
        this.setIconImage(iconImage);
        panelAnimacji.setBackground(Color.GRAY);
        this.setJMenuBar(Menu);

        JMenu menuFile = Menu.add(new JMenu("Plik"));
        JMenu menuEdit = Menu.add(new JMenu("Edycja"));
        JMenu menuExit = Menu.add(new JMenu("Wyjście"));

        JMenuItem StartMenuItem = new JMenuItem("Start");
        JMenuItem StopMenuItem = new JMenuItem("Stop");
        JMenuItem DodajMenuItem = new JMenuItem("Dodaj");
        JMenuItem WyczyscMenuItem = new JMenuItem("Wyczyść");
        JMenuItem PrzyspieszMenuItem = new JMenuItem("Przyśpiesz");
        JMenuItem ZwolnijMenuItm = new JMenuItem("Zwolnij");
        JMenuItem ZamknijMenuItem = new JMenuItem("Zamknij");

        StartMenuItem.setToolTipText(bStartTip);
        StopMenuItem.setToolTipText(bStopTip);
        DodajMenuItem.setToolTipText(bDodajTip);
        WyczyscMenuItem.setToolTipText(bWyczyscTip);
        PrzyspieszMenuItem.setToolTipText(bPrzyspieszTip);
        ZwolnijMenuItm.setToolTipText(bZwolnijTip);
        ZamknijMenuItem.setToolTipText(bZamknijTip);

        StartMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
        StopMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_DOWN_MASK));
        DodajMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_DOWN_MASK));
        WyczyscMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.ALT_DOWN_MASK));
        PrzyspieszMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        ZwolnijMenuItm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_DOWN_MASK));
        ZamknijMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.ALT_DOWN_MASK));

        ActionListener ActionStart = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startAnimation();
            }
        };
        ActionListener ActionStop = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stopAnimation();
            }
        };
        ActionListener ActionDodaj = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dodajAnimation();
            }
        };
        ActionListener ActionWyczysc = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clearAnimation();
            }
        };
        ActionListener ActionPrzyspiesz = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                przyspieszAnimation();
            }
        };
        ActionListener ActionZwolnij = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zwolnijAnimation();
            }
        };
        ActionListener ActionZamknij = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        };

        menuFile.add(StartMenuItem).addActionListener(ActionStart);
        menuFile.add(StopMenuItem).addActionListener(ActionStop);
        menuEdit.add(DodajMenuItem).addActionListener(ActionDodaj);
        menuEdit.add(WyczyscMenuItem).addActionListener(ActionWyczysc);
        menuEdit.add(PrzyspieszMenuItem).addActionListener(ActionPrzyspiesz);
        menuEdit.add(ZwolnijMenuItm).addActionListener(ActionZwolnij);
        menuExit.add(ZamknijMenuItem).addActionListener(ActionZamknij);

        JButton bStart = (JButton) panelButtonow.add(new JButton("Start"));
        bStart.setToolTipText(bStartTip);
        bStart.addActionListener(ActionStart);

        JButton bStop = (JButton) panelButtonow.add(new JButton("Stop"));
        bStop.setToolTipText(bStopTip);
        bStop.addActionListener(ActionStop);

        JButton bDodaj = (JButton) panelButtonow.add(new JButton("Dodaj"));
        bDodaj.setToolTipText(bDodajTip);
        bDodaj.addActionListener(ActionDodaj);

        JButton bWyczysc = (JButton) panelButtonow.add(new JButton("Wyczyść"));
        bWyczysc.setToolTipText(bWyczyscTip);
        bWyczysc.addActionListener(ActionWyczysc);

        JButton bPrzyspiesz = (JButton) panelButtonow.add(new JButton("Przyspiesz"));
        bPrzyspiesz.setToolTipText(bPrzyspieszTip);
        bPrzyspiesz.addActionListener(ActionPrzyspiesz);

        JButton bZwolnij = (JButton) panelButtonow.add(new JButton("Zwolnij"));
        bZwolnij.setToolTipText(bZwolnijTip);
        bZwolnij.addActionListener(ActionZwolnij);

        this.getContentPane().add(panelAnimacji);
        this.getContentPane().add(panelButtonow, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void startAnimation() {
        panelAnimacji.startAnimation();
    }

    public void stopAnimation() {
        panelAnimacji.stop();
    }

    public void dodajAnimation() {
        panelAnimacji.startAnimation();
        panelAnimacji.addKropelka();
    }

    public void clearAnimation() {
        panelAnimacji.clearAnimation();
        panelAnimacji.repaint();
    }

    public void przyspieszAnimation() {
        panelAnimacji.speedPlus();
    }

    public void zwolnijAnimation() {
        panelAnimacji.speedMinus();
    }

    public void exit() {
        System.exit(3);
    }

    String bStartTip = "wpraw w ruch kropelki";
    String bStopTip = "zatrzymaj kropelki";
    String bDodajTip = "dodaj nową kropelkę";
    String bWyczyscTip = "wyczyść pole z kropelek";
    String bPrzyspieszTip = "przyśpiesz ruch kropelek";
    String bZwolnijTip = "zwolnij ruch kropelek";
    String bZamknijTip = "zamknij program";

    private JPanel panelButtonow = new JPanel();
    private PanelAnimacji panelAnimacji = new PanelAnimacji();
    private JMenuBar Menu = new JMenuBar();

    public static void main(String[] args) {
        new animacjaKropli().setVisible(true);
    }

    class PanelAnimacji extends JPanel {

        private int ThreadSpeed = 10;
        private volatile boolean zatrzymany = false;//volatile delikatna zmienna przez wątki. zwolni program ale zabzpieczy nas przed błędami
        private Object lock = new Object();

        public void addKropelka() {
            listaKropelek.add(new Kropelka());
            watek = new Thread(grupaWatkow, new KropelkaRunnable((Kropelka) listaKropelek.get(listaKropelek.size() - 1)));
            watek.start();

            grupaWatkow.list();

        }

        public void startAnimation() {
            if (zatrzymany) {
                zatrzymany = false;
                synchronized (lock) {
                    lock.notifyAll();
                }

            }
        }

        public void stop() {
            zatrzymany = true;
        }

        public void clearAnimation() {
            listaKropelek.clear();
        }

        public void speedPlus() {
            if (ThreadSpeed == 1) {
                JOptionPane.showMessageDialog(null, "Bardziej już nie przyśpieszysz");
            } else {
                ThreadSpeed--;
            }
        }

        public void speedMinus() {
            if (ThreadSpeed == 20) {
                JOptionPane.showMessageDialog(null, "Bardziej już nie zwolnisz");
            } else {
                ThreadSpeed++;
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < listaKropelek.size(); i++) {
                g.drawImage(Kropelka.getImg(), ((Kropelka) listaKropelek.get(i)).x, ((Kropelka) listaKropelek.get(i)).y, null);
            }
        }

        ArrayList listaKropelek = new ArrayList();
        JPanel ten = this;
        Thread watek;
        ThreadGroup grupaWatkow = new ThreadGroup("Grupa Kropelek");

        public class KropelkaRunnable implements Runnable {

            public KropelkaRunnable(Kropelka kropelka) {
                this.kropelka = kropelka;
            }

            public void run() {

                while (true) {
                    synchronized (lock) {
                        while (zatrzymany) {
                            try {
                                lock.wait();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    this.kropelka.ruszKropelka(ten);
                    repaint();

                    try {
                        Thread.sleep(ThreadSpeed);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            }

            Kropelka kropelka;
        }
    }
}

class Kropelka {

    public static Image getImg() {
        return Kropelka.kropelka;
    }

    public void ruszKropelka(JPanel pojemnik) {
        Rectangle granicePanelu = pojemnik.getBounds();
        x += dx;
        y += dy;

        if (y + yKropelki >= granicePanelu.getMaxY()) {
            y = (int) (granicePanelu.getMaxY() - yKropelki);
            dy = -dy;
        }
        if (x + xKropelki >= granicePanelu.getMaxX()) {
            x = (int) (granicePanelu.getMaxX() - xKropelki);
            dx = -dx;
        }
        if (y < granicePanelu.getMinY()) {
            y = (int) granicePanelu.getMinY();
            dy = -dy;
        }

        if (x < granicePanelu.getMinX()) {
            x = (int) granicePanelu.getMinX();
            dx = -dx;
        }

    }

    public static Image kropelka = new ImageIcon("kropelka.gif").getImage();

    int x = 0;
    int y = 0;
    int dx = 1;
    int dy = 1;
    int xKropelki = kropelka.getWidth(null);
    int yKropelki = kropelka.getHeight(null);
}