package Server;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame {
    
    
    private static JFrame frame;
    private static JTextField textPort;
    private static JTextField textSquare;
    private static JTextField textCircle;
    private static JTextField textRectangle;

    public static JButton buttonSunucuBaslat;
    public static int portNumber;
    public static int squareNumber;
    public static int circleNumber;
    public static int rectangleNumber;
    private ServerThread serverThread;

    public void runFrame() {
        
        //Create Frame
        frame = new JFrame();
        frame.setTitle("Server Data Login");
        frame.setBounds(100, 100, 500, 400);
        frame.setLocation(100, 200);
    
        //First Panel
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(null);
    
        //#region Label Alanları
        JLabel labelPort = new JLabel("Port :");
        labelPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelPort.setBounds(35, 43, 67, 23);
        firstPanel.add(labelPort);
    
        JLabel labelsquareNumber = new JLabel("Number of Frames :");
        labelsquareNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelsquareNumber.setBounds(35, 112, 200, 23);
        firstPanel.add(labelsquareNumber);
    
        JLabel labelcircleNumber_1 = new JLabel("Number of Circles :");
        labelcircleNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelcircleNumber_1.setBounds(35, 170, 200, 23);
        firstPanel.add(labelcircleNumber_1);
    
        JLabel labelrectangleNumber_1_1 = new JLabel("Number of Rectangle:");
        labelrectangleNumber_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelrectangleNumber_1_1.setBounds(35, 232, 200, 23);
        firstPanel.add(labelrectangleNumber_1_1);
        //#endregion
    
        // #region TextBox Fields
        textPort = new JTextField();
        textPort.setBounds(250, 43, 116, 23);
        firstPanel.add(textPort);
        textPort.setColumns(10);
    
        textSquare = new JTextField();
        textSquare.setColumns(10);
        textSquare.setBounds(250, 112, 116, 23);
        firstPanel.add(textSquare);
    
        textCircle = new JTextField();
        textCircle.setColumns(10);
        textCircle.setBounds(250, 170, 116, 23);
        firstPanel.add(textCircle);
    
        textRectangle = new JTextField();
        textRectangle.setColumns(10);
        textRectangle.setBounds(250, 232, 116, 23);
        firstPanel.add(textRectangle);
        //#endregion
    
        // #region Button Fields
        buttonSunucuBaslat = new JButton("Start");
        buttonSunucuBaslat.setBackground(new Color(0, 128, 192));
        buttonSunucuBaslat.setForeground(new Color(0, 0, 0));
        buttonSunucuBaslat.setBounds(181, 301, 116, 33);
        firstPanel.add(buttonSunucuBaslat);
    
        buttonSunucuBaslat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
    
                    portNumber = Integer.parseInt(textPort.getText());
                    squareNumber = Integer.parseInt(textSquare.getText());
                    circleNumber = Integer.parseInt(textCircle.getText());
                    rectangleNumber = Integer.parseInt(textRectangle.getText());
    
                    frame.setBounds(100, 100, 500, 500);
    
                    if (e.getSource() == buttonSunucuBaslat) {
                        int port = portNumber;
                        serverThread = new ServerThread(port,squareNumber,circleNumber,rectangleNumber);
                        serverThread.start();
                    }
    
                    MovingShapesControl movingShapes = new MovingShapesControl(portNumber, squareNumber, circleNumber,
                            rectangleNumber);

                    frame.add(movingShapes);
                    frame.setTitle("Server");
                    frame.pack();
                    frame.remove(firstPanel);
                    frame.revalidate();
                    movingShapes.startAnimation();
    
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "You entered wrong information or left blank");
                }
            }
    
        });
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(firstPanel);
        frame.setVisible(true);
        frame.setResizable(true);
        //#endregion

    }
    
   

}



