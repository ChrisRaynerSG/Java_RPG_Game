package appwindow;

import dbm.DatabaseConnection;
import dbm.DatabaseQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox){
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(InventoryPanel.inventory.getModel().getValueAt(0,0).equals("Weak healing potion") && InventoryPanel.inventory.getSelectedRow() == 0){
                    JOptionPane.showMessageDialog(AppWindow.inventoryPanel, "Healing potion drunk!");
                    DatabaseQuery databaseQuery = new DatabaseQuery(DatabaseConnection.getConnection());
                    databaseQuery.removeFromInventory(1,1);
                    int amountToChange = Integer.parseInt(InventoryPanel.inventory.getModel().getValueAt(0,1).toString())-1;
                    int totalValueToChange = Integer.valueOf(InventoryPanel.inventory.getModel().getValueAt(0,3).toString())-20;
                    InventoryPanel.inventory.getModel().setValueAt(amountToChange,0,1);
                    InventoryPanel.inventory.getModel().setValueAt(totalValueToChange,0,3);
                }
                JOptionPane.showMessageDialog(AppWindow.inventoryPanel, "Button pressed");
                fireEditingStopped();

            }
        });
    }
    @Override
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row,
                                                 int column
                                                 ){
        if(isSelected){
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        }
        else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue(){
        if(isPushed){
            //Action here
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing(){
        return super.stopCellEditing();
    }
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
}
