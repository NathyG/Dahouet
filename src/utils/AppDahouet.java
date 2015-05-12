package utils;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;

import ui.UIdahouet;
import ui.UIsaisieProprio;
import dao.Connect;


public class AppDahouet {
	private DahouetController mainControler;
	private UIdahouet mainUI;
	private UIsaisieProprio proprioUI;
	

	
	
	Connection c = Connect.cConnect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AppDahouet window = new AppDahouet();
					window.mainUI.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppDahouet() {
		initialize();
	}

	
	private void initialize() {
		
		/**
		 * init views
		 */
		//main window	
		
		
		mainUI = new UIdahouet();
		mainUI.setVisible(false);
		
		// saisie new proprio 
		proprioUI = new UIsaisieProprio();
		proprioUI.setVisible(false);
				
		
		//create the main controller and bind uis to controller
		DahouetController mainControler = new DahouetController(mainUI,proprioUI);
		
		/**
		 * subscribe controller to ui events
		 */
	//	UIdahouet.addListener(mainControler);
	//	proprioUI.addListener(mainControler);
	
		// Center frames
		centerFrame(mainUI);
//		centerFrame(proprioUI);
	
		//initialize data
		mainControler.init();
		
					
	//	mainUI.setBounds(100, 100, 450, 300);
	//	mainUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}

	private void centerFrame(UIdahouet ui) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = ui.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		ui.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
	}

	
	
	
	
	
	
	
}




