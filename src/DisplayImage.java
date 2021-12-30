import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class DisplayImage {

	
	//old main for testing purposes
	/*
    public static void main(String avg[]) throws IOException
    {
    	//call the display method (constructor)
        //DisplayImage abc=new DisplayImage();
        
        //email
        //JavaMailUtil.sendGuideMail("pandeyavi1@gmail.com");
         
        //Garage
    	
        Garage garage = new Garage();
        
        garage.insert();
        garage.insert();
        
        garage.createFile();
    }
    */

    //displaying the layout image
    public DisplayImage() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("images/garageLayout.jpg"));
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200,300);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}