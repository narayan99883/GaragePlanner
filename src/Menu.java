import java.util.*;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {

	// running the menu which the user uses
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Garage garage = new Garage();
		Scanner input = new Scanner(System.in);

		while (true) {

			System.out.println("Available commands: insert, delete, clear, sort, info, space, other, end");
			String choice = input.nextLine();

			if (choice.equals("insert")) {
				garage.insert();
			} else if (choice.equals("delete")) {
				garage.delete();
			} else if (choice.equals("clear")) {
				garage.clearSection();
			} else if (choice.equals("sort")) {
				garage.sort();
			} else if (choice.equals("info")) {
				garage.getInfo();
			} else if (choice.equals("space")) {
				garage.howMuchSpace();
			} else if (choice.equals("other")) {

				System.out.println("Available commands: dislpay, senduserguide, senddisplay, sendlist");
				String secchoice = input.nextLine();

				if (secchoice.equals("display")) {
					DisplayImage abc = new DisplayImage();
				} else if (secchoice.equals("senduserguide")) {
					System.out.println("To what email address?");
					String email = input.nextLine();
					JavaMailUtil.sendGuideMail(email);
				} else if (secchoice.equals("senddisplay")) {
					System.out.println("To what email address?");
					String email = input.nextLine();
					JavaMailUtil.sendDisplayMail(email);
				} else if (secchoice.equals("sendlist")) {
					System.out.println("To what email address?");
					String email = input.nextLine();
					garage.createFilee();
					JavaMailUtil.sendListMail(email);
				} else {
					System.out.println("invalid command");
				}

			} else if (choice.equals("end")) {
				System.out.println("Program ending");
				System.exit(0);
			}

			else {
				System.out.println("invalid command");
			}

			System.out.println("\n");

		}

	}

}
