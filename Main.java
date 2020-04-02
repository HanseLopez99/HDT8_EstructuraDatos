
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {

	private JFrame frame;
	private PrioritySystem prioritySystem;
	private JRadioButton vectorHeapRadioButton, priorityJCFRadioButton;
	private JPanel menuPanel, choicePanel, innerPanel;
	private JButton btnNewButton_1;
	private JScrollPane scrollPatient,scrollCurrentPatient;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		Initialize();
	}
	
	/**
	 * method to fill the DefaultTableModel with patients
	 */
	private void setTable() {
		PriorityQueue<Patient> data = prioritySystem.getPatients();
		model = new DefaultTableModel();
		model.setColumnCount(3);
		model.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Sintoma"});
		model.setRowCount(prioritySystem.size());
		int c = prioritySystem.size();
		
		for (int i = 0; i < c;i++) {
			Patient pa = data.remove();
			model.setValueAt(pa.getPriority(), i, 0);
			model.setValueAt(pa.getName(), i, 1);
			model.setValueAt(pa.getSymptom(), i, 2);
		}
		scrollPatient.setViewportView(new JTable(model));
	}
	
	/**
	 * method to fill the table with the current patient
	 */
	private void setCurrentTable() {
		Patient p = prioritySystem.getPatient();
		model = new DefaultTableModel();
		model.setColumnCount(3);
		model.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Sintoma"});
		model.setRowCount(0);
		if (prioritySystem.getPatient() != null) {
			model.setRowCount(1);
			model.setValueAt(p.getPriority(), 0, 0);
			model.setValueAt(p.getName(), 0, 1);
			model.setValueAt(p.getSymptom(), 0, 2);
		}
		scrollCurrentPatient.setViewportView(new JTable(model));
	}

	/**
	 * Initialize the content
	 */
	private void Initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1250, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.orange);
		
		choicePanel = new JPanel();
		choicePanel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(choicePanel, "name_1");
		choicePanel.setLayout(null);
		
		innerPanel = new JPanel();
		innerPanel.setBackground(SystemColor.BLUE);
		innerPanel.setBounds(240, 90, 800, 600);
		choicePanel.add(innerPanel);
		innerPanel.setLayout(null);

		JLabel label = new JLabel("ATENCION DE EMERGENCIAS");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		label.setBounds(103, 13, 700, 85);
		innerPanel.add(label);
		
		vectorHeapRadioButton = new JRadioButton("VectorHeap");
		vectorHeapRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (vectorHeapRadioButton.isSelected()) {
					priorityJCFRadioButton.setSelected(false);
				}
			}
		});
		vectorHeapRadioButton.setBackground(SystemColor.controlHighlight);
		vectorHeapRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		vectorHeapRadioButton.setBounds(193, 120, 400, 100);
		innerPanel.add(vectorHeapRadioButton);
		
		priorityJCFRadioButton = new JRadioButton("PriorityQueueJCF");
		priorityJCFRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (priorityJCFRadioButton.isSelected()) {
					vectorHeapRadioButton.setSelected(false);
				}
			}
		});
		priorityJCFRadioButton.setBackground(SystemColor.controlHighlight);
		priorityJCFRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		priorityJCFRadioButton.setBounds(193, 250, 400, 100);
		innerPanel.add(priorityJCFRadioButton);
		
		JButton btnNewButton = new JButton("Elegir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (vectorHeapRadioButton.isSelected() || priorityJCFRadioButton.isSelected()) {
					if (vectorHeapRadioButton.isSelected()) {
						prioritySystem = new PrioritySystem("VectorHeap");
					}else if (priorityJCFRadioButton.isSelected()) {
						prioritySystem = new PrioritySystem("PriorityQueueJCF");
					}
					menuPanel.setVisible(true);
					choicePanel.setVisible(false);
					setTable();
					setCurrentTable();
				}else {
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguno");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setBounds(350, 420, 127, 41);
		innerPanel.add(btnNewButton);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.GREEN);
		frame.getContentPane().add(menuPanel, "name_2");
		menuPanel.setLayout(null);
		
		btnNewButton_1 = new JButton("Agregar Pacientes desde Explorador de Archivos");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prioritySystem.addPatient();
				setTable();
			}
		});
		btnNewButton_1.setBounds(420, 40, 400, 42);
		menuPanel.add(btnNewButton_1);
		
		scrollPatient = new JScrollPane();
		scrollPatient.setBounds(200, 202, 348, 465);
		scrollPatient.setBackground(Color.WHITE);
		menuPanel.add(scrollPatient);
		
		scrollCurrentPatient = new JScrollPane();
		scrollCurrentPatient.setBounds(700, 202, 348, 465);
		scrollCurrentPatient.setBackground(Color.WHITE);
		menuPanel.add(scrollCurrentPatient);
		
		JLabel lblNewLabel_1 = new JLabel("Pacientes");//
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(205, 160, 157, 30);
		menuPanel.add(lblNewLabel_1);
		
		JButton btnTransferir = new JButton("Pasar a clinica");//
		btnTransferir.setBackground(Color.LIGHT_GRAY);
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prioritySystem.getPatient() == null) {
					try {
                        prioritySystem.transferPatient();
						setCurrentTable();
						setTable();
					}catch(Exception ex) {}
				}else {
					JOptionPane.showMessageDialog(null, "No puedes transferir otro paciente hasta atender el existente");
				}
			}
		});
		btnTransferir.setBounds(390, 130, 150, 62);
		menuPanel.add(btnTransferir);
		
		JLabel lblPacienteAAtender = new JLabel("Paciente a atender");
		lblPacienteAAtender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPacienteAAtender.setBounds(710, 159, 199, 30);
		menuPanel.add(lblPacienteAAtender);
		
		JButton btnNewButton_2 = new JButton("Atender");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(prioritySystem.getPatient() != null) {
					prioritySystem.checkPatient();
					setCurrentTable();
					setTable();
					JOptionPane.showMessageDialog(null, "Se acaba de atender a un paciente!");
				}else {
					JOptionPane.showMessageDialog(null, "No hay ningun paciente por ahora...");
				}
			}
		});
		btnNewButton_2.setBounds(930, 140, 97, 49);
		menuPanel.add(btnNewButton_2);
		
	}
	
}
