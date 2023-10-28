import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExpenseTracker extends JFrame {
    private ArrayList<String> expenses = new ArrayList<>();

    public ExpenseTracker() {
        setTitle("Expense Tracker");

        JLabel expenseLabel = new JLabel("Expense:");
        JTextField expenseEntry = new JTextField();
        JButton addButton = new JButton("Add Expense");
        JList<String> expenseList = new JList<>();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expense = expenseEntry.getText();
                if (!expense.isEmpty()) {
                    expenses.add(expense);
                    updateExpenseList(expenseList);
                    expenseEntry.setText("");
                }
            }
        });

        setLayout(new FlowLayout());
        add(expenseLabel);
        add(expenseEntry);
        add(addButton);
        add(expenseList);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void updateExpenseList(JList<String> expenseList) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String item : expenses) {
            model.addElement(item);
        }
        expenseList.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExpenseTracker();
            }
        });
    }
}