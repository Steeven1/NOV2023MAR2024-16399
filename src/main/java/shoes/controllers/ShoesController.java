/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes.controllers;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author SteevenE
 */
public class ShoesController {
    
    public void list(JTable tbShoes){
      DefaultTableModel modelTable = new DefaultTableModel();  
      modelTable.addColumn("Id");
      modelTable.addColumn("Modelo");
      modelTable.addColumn("Marca");
      modelTable.addColumn("Tamaño");
      
      tbShoes.setModel(modelTable);
      shoes.model.ShoesModel objModel = new shoes.model.ShoesModel();
      List<shoes.entities.Shoes> listOfShoes =  objModel.list();
      
      Object[] data = new Object[4];
      
      for (shoes.entities.Shoes s: listOfShoes){
          data[0] = s.getId();
          data[1] = s.getModel();
          data[2] = s.getBrand();
          data[3] = s.getSize();
          
          modelTable.addRow(data);
      }
      
      tbShoes.setModel(modelTable);
    }
    
    public void insertShoes(
    JTextField textModel, JTextField textBrand, JTextField textSize 
    ){
        try{
        shoes.model.ShoesModel shoesModel = new shoes.model.ShoesModel();
        shoes.entities.Shoes shoes = new shoes.entities.Shoes();
        shoes.setId(null);
        shoes.setModel(textModel.getText());
        shoes.setBrand(textBrand.getText());
        shoes.setSize(textSize.getText());
        
        shoesModel.create(shoes);
        
        JOptionPane.showMessageDialog(null, "Se insertó correctamente el par de zapatos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: no se pudo insertar");
        }
    }
    
    public void selectOnePairOfShoes(JTable tbShoes, 
            JTextField textId,
            JTextField textModel, 
            JTextField textBrand,
            JTextField textSize
            ){
        try{
            int row = tbShoes.getSelectedRow();
            if(row>= 0){
                textId.setText(tbShoes.getValueAt(row, 0).toString());
                textModel.setText(tbShoes.getValueAt(row, 1).toString());
                textBrand.setText(tbShoes.getValueAt(row, 2).toString());
                textSize.setText(tbShoes.getValueAt(row, 3).toString());
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: no se pudo seleccionar");
        }
    }
    
    public void modShoes(
    JTextField textId,       
    JTextField textModel, 
    JTextField textBrand, 
    JTextField textSize 
    ){
        try{
        shoes.model.ShoesModel shoesModel = new shoes.model.ShoesModel();
        shoes.entities.Shoes shoes = new shoes.entities.Shoes();
        shoes.setId(Long.valueOf(textId.getText()));
        shoes.setModel(textModel.getText());
        shoes.setBrand(textBrand.getText());
        shoes.setSize(textSize.getText());
        
        shoesModel.mod(shoes);
        
        JOptionPane.showMessageDialog(null, "Se modificó correctamente el par de zapatos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: no se pudo modificar");
        }
    }
    
    public void deleteShoes(
    JTextField textId
    ){
        try{
        shoes.model.ShoesModel shoesModel = new shoes.model.ShoesModel();
        shoes.entities.Shoes shoes = new shoes.entities.Shoes();
        shoes.setId(Long.valueOf(textId.getText()));
       
        
        shoesModel.delete(shoes);
        
        JOptionPane.showMessageDialog(null, "Se eliminó correctamente el par de zapatos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: no se pudo eliminar");
        }
    }
    
    public void resetText(
     JTextField textId,
            JTextField textModel, 
            JTextField textBrand,
            JTextField textSize
    ){
        textId.setText("");
        textModel.setText("");
        textBrand.setText("");
        textSize.setText("");
        
    }
}
