package utils;


import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.ClasseDAO;
import dao.ProprietaireDAO;
import dao.SerieDAO;
import ui.UIdahouet;
import ui.UIsaisieProprio;

public class DahouetController {

	
	public static UIdahouet uiDahouet;
	
	public UIsaisieProprio frmProprio = null;

	public static   JComboBox<String> comboBoxProprio = new JComboBox<String>();
	public static JComboBox<String> comboBoxSerie = new JComboBox<String>();
	public static JComboBox<String> comboBoxClasse = new JComboBox<String>();

	
	public DahouetController( UIdahouet uiDahouet, UIsaisieProprio frmProprio) {
	
		
		this.uiDahouet = uiDahouet;
		this.frmProprio = frmProprio;
	}

	public void init() {
		
	}

	
	// cbbox proprietaire
		public static  void cbProprio() {
	
			List<String> listeProprio = ProprietaireDAO.ListeProprio();

			for (String proprio : listeProprio) {
				UIdahouet.comboBoxProprio.addItem(proprio);
			}
		}
		
		
	// cbbox serie
		public static void cbSerie() {
			
			List<String> listeSerie = SerieDAO.ListeSerie();

			for (String serie : listeSerie) {
				UIdahouet.comboBoxSerie.addItem(serie);
			}
		}
		
		
	// cbbox classe
		public static void cbClasse(String nomSerie) {
			
			List<String> listeClasse = ClasseDAO.ListeClasse(nomSerie);

			for (String classe : listeClasse) {
				UIdahouet.comboBoxClasse.addItem(classe);
			}

		}

		
	// tests fenetre voilier
		public static void tests() {	
			
	
		if (UIdahouet.txtSaisienomvoilier.getText().equals("")) {
			JOptionPane.showMessageDialog(
					uiDahouet, "Veuillez saisir un nom de voilier", "Erreur saisie",
					JOptionPane.WARNING_MESSAGE);
			return;

		}
		}

	
	
	}

	
	

