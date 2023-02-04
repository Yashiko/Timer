package apps;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class StartWatch implements ActionListener {

	JFrame f;
	JLabel displayLabel, nameLabel;
	JButton b1, b2, b3;
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	
	String seconds_string = String.format("%02d", seconds); // to show two numbers in display
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		  
		  public void actionPerformed(ActionEvent e) {
		   
		   elapsedTime = elapsedTime+1000;
		   hours = (elapsedTime/3600000);
		   minutes = (elapsedTime/60000) % 60;
		   seconds = (elapsedTime/1000) % 60;	//modules don't count 60 or more
		   seconds_string = String.format("%02d", seconds);
		   minutes_string = String.format("%02d", minutes);
		   hours_string = String.format("%02d", hours);
		  displayLabel.setText(hours_string + " : " + minutes_string + " : " + seconds_string);
		   
		  }  
		 });

	StartWatch(){
		f = new JFrame();
		displayLabel = new JLabel();
		displayLabel.setBounds(68, 20, 350,50);
		displayLabel.setText(hours_string + " : "+ minutes_string + " : " + seconds_string);
		displayLabel.setBackground(Color.blue);
		displayLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		displayLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
		displayLabel.setHorizontalAlignment(JLabel.CENTER);
		displayLabel.setOpaque(true);	
		nameLabel = new JLabel("Timer");
		nameLabel.setBounds(200, 180, 350,50);
		nameLabel.setFont(new Font("Century", Font.BOLD, 30));
		b1 = new JButton("Start");
		b1.setBounds(90, 100, 100, 50);
		b1.setFont(new Font("Monospaced", Font.BOLD, 22));
		b2 = new JButton("Stop");
		b2.setBounds(190, 100, 100, 50);
		b2.setFont(new Font("Monospaced", Font.BOLD, 22));
		b3 = new JButton("Reset");
		b3.setBounds(290, 100, 100, 50);
		b3.setFont(new Font("Monospaced", Font.BOLD, 22));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		ImageIcon image = new ImageIcon("D:\\clock.png");
		f.setIconImage(image.getImage());
		f.setTitle("Timer");
		f.setBounds(500,350,500,300);
		f.setLayout(null);
		f.setVisible(true);
		f.add(displayLabel);
		f.add(nameLabel);
		f.add(b1);
		f.add(b2);
		f.add(b3);

	}


	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==b1) {
			timer.start();	
		}else if (event.getSource() == b2){
			timer.stop();
		}else if (event.getSource()== b3) {
			timer.stop();
			elapsedTime = 0;
			seconds = 0;
			minutes = 0;
			hours = 0;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			displayLabel.setText(hours_string+" : "+minutes_string+" : "+seconds_string);

		}
	}
	

	
	public static void main(String[] args) {
		  new StartWatch();
		
		
	}

}
