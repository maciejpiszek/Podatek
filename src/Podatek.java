import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Podatek extends JFrame implements ActionListener {

	private JLabel lDochod;
	private JLabel lWaluta1;
	private JLabel lPodatek;
	private JLabel lWaluta2;
	private JTextField tDochod;
	private JTextField tPodatek;
	private JButton bOblicz;
	private JButton bWyjdz;
	private double tmpDochod;
	private double tmpPodatek;


	public Podatek() {
			
	
	setSize(500,220);
	setTitle("Oblicz podatek");
	setLayout(null);
	
	lDochod = new JLabel("Podaj swój dochód: ");
	lDochod.setBounds(40, 40, 200, 20);
	lDochod.setForeground(Color.BLUE);
	lDochod.setFont(new Font("Arial", Font.BOLD, 15));
	add(lDochod);
	
	tDochod = new JTextField("");
	tDochod.setBounds(230, 40, 150, 20);
	tDochod.setToolTipText("Twój roczny dochód");
	add(tDochod);
	
	lWaluta1 = new JLabel("pln");
	lWaluta1.setBounds(390, 40, 150, 20);
	lWaluta1.setForeground(Color.BLUE);
	lWaluta1.setFont(new Font("Arial", Font.BOLD, 15));
	add(lWaluta1);
	
	lPodatek = new JLabel("Twój podatek wynosi: ");
	lPodatek.setBounds(40, 90, 200, 20);
	lPodatek.setForeground(Color.RED);
	lPodatek.setFont(new Font("Arial", Font.BOLD, 15));
	add(lPodatek);
	
	tPodatek = new JTextField("");
	tPodatek.setBounds(230, 90, 150, 20);
	tPodatek.setToolTipText("Kwota nale¿nego podatku");
	add(tPodatek);
	
	lWaluta2 = new JLabel("pln");
	lWaluta2.setBounds(390, 90, 150, 20);
	lWaluta2.setForeground(Color.RED);
	lWaluta2.setFont(new Font("Arial", Font.BOLD, 15));
	add(lWaluta2);
	
	bOblicz = new JButton("Przelicz");
	bOblicz.setBounds(40, 135, 150, 20);
	add(bOblicz);
	bOblicz.addActionListener(this);
	
	bWyjdz = new JButton("Wyjœcie");
	bWyjdz.setBounds(230, 135, 150, 20);
	add(bWyjdz);
	bWyjdz.addActionListener(this);
	
	}
	
	public static void main (String [] args) {
		
		Podatek podatek = new Podatek();
		podatek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		podatek.setVisible(true);
	}


	public void actionPerformed (ActionEvent e) {
		
		Object zrodlo = e.getSource();
		
		if (zrodlo==bOblicz) {
		tmpDochod = Double.parseDouble(tDochod.getText());
		if (tmpDochod <= 6600.0) {
			tmpPodatek = 0;
			} else if (tmpDochod > 6600.0 && tmpDochod <= 11000.0) {
				tmpPodatek = tmpDochod * 0.18 - (1188 - (631.98 * (tmpDochod - 6600.0) / 4400.0));
			} else if (tmpDochod > 11000.0 && tmpDochod <= 85528.0) {
				tmpPodatek = tmpDochod * 0.18 - 556.02;
			} else if (tmpDochod > 85528.0 && tmpDochod <= 127000.0) {
				tmpPodatek = (tmpDochod - 85528.0) * 0.32 + 15394.04 - (556.02 - (556.02 * (tmpDochod - 85528.0) / 41472.0));
			} else tmpPodatek = (tmpDochod - 85528.0) * 0.32 + 15394.04;
		
		tPodatek.setText(String.valueOf(Math.round(tmpPodatek)));
		} else if (zrodlo==bWyjdz) dispose();
		
		
	}
	
	
}
