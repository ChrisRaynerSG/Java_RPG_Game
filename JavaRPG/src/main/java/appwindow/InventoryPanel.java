package appwindow;

import dbm.DatabaseResults;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventoryPanel extends JPanel implements ActionListener {

    public static String[] columnNames = {"Item", "Amount", "Value", "Total Value","Action"};
    public static ArrayList<String[]> playerInventory;
    public static JButton returnToGame = new JButton("Back");
    public static JTable inventory;
    public static int playerId;

    InventoryPanel(int playerId){
        InventoryPanel.playerId = playerId;
        add(returnToGame, BorderLayout.NORTH);
        add(updateTable(), BorderLayout.CENTER);
        returnToGame.addActionListener(this);
    }

    public static JScrollPane updateTable(){
        DefaultTableModel inventoryModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return column == 4;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex){
                return columnIndex == 4 ? JButton.class : String.class;
            }
        };

        inventoryModel.addColumn("Item");
        inventoryModel.addColumn("Amount");
        inventoryModel.addColumn("Value");
        inventoryModel.addColumn("Total Value");
        inventoryModel.addColumn("Action");

        playerInventory = DatabaseResults.getPlayerInventory(playerId);

        for(int i = 0; i<playerInventory.size(); i++){
            inventoryModel.addRow(playerInventory.get(i));
        }
        inventory = new JTable(inventoryModel);
        JScrollPane inventoryContainer = new JScrollPane(inventory);
        inventory.getColumn("Action").setCellRenderer(new ButtonRenderer());
        inventory.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
        return inventoryContainer;

    }

    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        if(source == returnToGame){
            AppWindow.layout.show(AppWindow.mainPanel, AppWindow.MAIN_MENU_STRING);
        }
    }
}
