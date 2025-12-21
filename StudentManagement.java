

		import javax.swing.*;
		import javax.swing.table.DefaultTableModel;
		import java.awt.*;
		import java.awt.event.*;
		import java.util.ArrayList;

		public class StudentManagement extends JFrame implements ActionListener {

		    JLabel lblId, lblName, lblMarks;
		    JTextField txtId, txtName, txtMarks;
		    JButton btnAdd, btnClear;
		    JTable table;
		    DefaultTableModel model;

		    ArrayList<String[]> studentList = new ArrayList<>();

		    StudentManagement() {
		        // Frame settings
		        setTitle("Student Management System");
		        setSize(600, 400);
		        setLayout(new BorderLayout());
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        // Panel for inputs
		        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

		        lblId = new JLabel("Student ID:");
		        lblName = new JLabel("Student Name:");
		        lblMarks = new JLabel("Marks:");

		        txtId = new JTextField();
		        txtName = new JTextField();
		        txtMarks = new JTextField();

		        btnAdd = new JButton("Add");
		        btnClear = new JButton("Clear");

		        panel.add(lblId);
		        panel.add(txtId);
		        panel.add(lblName);
		        panel.add(txtName);
		        panel.add(lblMarks);
		        panel.add(txtMarks);
		        panel.add(btnAdd);
		        panel.add(btnClear);

		        add(panel, BorderLayout.NORTH);

		        // Table
		        model = new DefaultTableModel();
		        model.addColumn("ID");
		        model.addColumn("Name");
		        model.addColumn("Marks");

		        table = new JTable(model);
		        add(new JScrollPane(table), BorderLayout.CENTER);

		        // Button actions
		        btnAdd.addActionListener(this);
		        btnClear.addActionListener(this);

		        setVisible(true);
		    }

		    public void actionPerformed(ActionEvent e) {

		        if (e.getSource() == btnAdd) {
		            String id = txtId.getText();
		            String name = txtName.getText();
		            String marks = txtMarks.getText();

		            if (id.isEmpty() || name.isEmpty() || marks.isEmpty()) {
		                JOptionPane.showMessageDialog(this, "Please fill all fields");
		            } else {
		                model.addRow(new String[]{id, name, marks});
		                JOptionPane.showMessageDialog(this, "Student Added Successfully");
		            }
		        }

		        if (e.getSource() == btnClear) {
		            txtId.setText("");
		            txtName.setText("");
		            txtMarks.setText("");
		        }
		    }

		    public static void main(String[] args) {
		        new StudentManagement();
		    }
		


	}


