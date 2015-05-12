
package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;





import dao.ClubDAO;
import dao.ProprietaireDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import utils.DahouetController;
import model.Club;
import model.Proprietaire;
import ui.UIdahouet;

public class UIsaisieProprio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSaisienomproprio;
	private JTextField txtSaisiecptepart;
	private JTextField txtSaisiecoordonnees;

	private UIdahouet UIdahouet;
	public static JComboBox<String> comboBoxClub = new JComboBox<String>();
	
	
	/**
	 * Launch the application.
	 */

//	static void main(String[] args) {
//		try {
//			UIsaisieProprio dialog = new UIsaisieProprio();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public UIsaisieProprio() {
		setTitle("Nouveau propriétataire");
		setBounds(100, 100, 450, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNomduProprietaire = new JLabel("Nom du proprietaire :");
			contentPanel.add(lblNomduProprietaire, "2, 4");
		}
		{
			txtSaisienomproprio = new JTextField();
			txtSaisienomproprio.setText("saisieNomProprio");
			contentPanel.add(txtSaisienomproprio, "6, 4, 3, 1, fill, default");
			txtSaisienomproprio.setColumns(10);
		}
		{
			JLabel lblClub = new JLabel("Club :");
			contentPanel.add(lblClub, "2, 8, right, default");
		}
		{
			
			comboBoxClub = new JComboBox<String>();
			comboBoxClub.removeAllItems();
			
			List<String> listeClub=ClubDAO.ListeClub();

			for (String club: listeClub){
				comboBoxClub.addItem(club);
			}
		
			
			contentPanel.add(comboBoxClub, "6, 8, 3, 1, fill, default");
			
		}
		{
			JLabel lblCoordonnees = new JLabel("Coordonnees :");
			contentPanel.add(lblCoordonnees, "2, 12, right, default");
		}
		{
			txtSaisiecoordonnees = new JTextField();
			txtSaisiecoordonnees.setText("saisieCoordonnees");
			contentPanel.add(txtSaisiecoordonnees, "6, 12, 3, 1, fill, default");
			txtSaisiecoordonnees.setColumns(10);
		}
		{
			JLabel lblCompteParticipant = new JLabel("Compte participant :");
			contentPanel.add(lblCompteParticipant, "2, 16, right, default");
		}
		{
			txtSaisiecptepart = new JTextField();
			txtSaisiecptepart.setText("saisieCptePart");
			contentPanel.add(txtSaisiecptepart, "6, 16, 3, 1, fill, default");
			txtSaisiecptepart.setColumns(10);
		}
			{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
			
			
			
			{
				JButton okButton = new JButton("Enregistrer");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						 try {
							enregtProprio();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					
				});
			
				okButton.setActionCommand("Enregistrer");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				
				
				
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setActionCommand("Annuler");
				buttonPane.add(cancelButton);
		
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
				 setVisible(false);
					//	 dispose();

					}
				});			
			
			
			
			}
		}
	}

	
	private void enregtProprio() throws Exception {
	
		// test si nom proprietaire saisi	
				if (txtSaisienomproprio.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Veuillez saisir un nom de proprietaire", "Erreur saisie",
							JOptionPane.WARNING_MESSAGE);
					return;
					
				}	
				
		// test si coordonnées saisies	
				if (txtSaisiecoordonnees.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Veuillez saisir les coordonnées du proprietaire", "Erreur saisie",
							JOptionPane.WARNING_MESSAGE);
					return;
					
				}				
		
		// test si compte participant saisi et valide	
				
									
				if ( (!txtSaisiecptepart.getText().equals("O"))  && (!txtSaisiecptepart.getText().equals("o")) && (!txtSaisiecptepart.getText().equals("N"))  && (!txtSaisiecptepart.getText().equals("n")))  {
					JOptionPane.showMessageDialog(this, "Veuillez saisir la participation du propriétaire (O ou N)", "Erreur saisie",
							JOptionPane.WARNING_MESSAGE);
					return;
					
				}					
		
				
		// Enregistrement du proprietaire			
				
		
				// recuperation du numero de club avec son nom
				
				
				String nomclub=comboBoxClub.getSelectedItem().toString();
				
				Club club= new Club(0, null);
				club=ClubDAO.NumeroClub(nomclub);
				
				int numclub = club.getNum_club();
				int numproprio=0;
		
				
				Proprietaire p = new Proprietaire(numproprio, numclub,txtSaisienomproprio.getText() ,txtSaisiecoordonnees.getText(),txtSaisiecptepart.getText() ) ;
				ProprietaireDAO.createProprietaire(p,numclub);
				
				
		//		UIdahouet = new UIdahouet();
	//		UIdahouet.setVisible(true);
			//	this.setVisible(false);
			//	dispose();
		//		this.dispose();
		//		new ui.UIdahouet().setVisible(true);

			return;
		
	}




	
}
