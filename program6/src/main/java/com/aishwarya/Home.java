package com.aishwarya;

import javafx.application.Application;
//import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home extends Application{

    private final ObservableList<InventoryItem> item=FXCollections.observableArrayList();
    private TableView<InventoryItem> tableView = new TableView<InventoryItem>();


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("INVENTORY MANAGMENT SYSTEM");

        tableView =new TableView<>();
        tableView.setItems(item);
        tableView.setPrefHeight(200);

        TableColumn <InventoryItem ,String>nameColumn=new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn <InventoryItem ,String>idcol=new TableColumn<>("ID");
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn <InventoryItem,String>quantityColumn=new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

          nameColumn.setText("Name");
          idcol.setText("ID");
          quantityColumn.setText("Quantity");
 
   
           tableView.getColumns().addAll(nameColumn, idcol, quantityColumn);


        TextField iField=new TextField();
        iField.setPromptText("Item Name");
        iField.setMaxWidth(200);

        TextField aField=new TextField();
        aField.setPromptText("Item Id");
        aField.setMaxWidth(200);

        TextField docField=new TextField();
        docField.setPromptText("Quantity");
        docField.setMaxWidth(200);


         
        Label resultlabel=new Label();

        Button add=new Button("ADD");
        add.setMaxWidth(150);
        add.setStyle("-fx-button-type:RAISED");
        add.setOnAction(e ->{
            String name=iField.getText();
            String id=aField.getText();
            String quantityText=docField.getText().trim();

            if (quantityText == null || quantityText.trim().isEmpty()) {
        resultlabel.setText("Quantity field is empty.");
        return;
            }
            try{
                int quantity=Integer.parseInt(quantityText);
                item.add(new InventoryItem(name, id, quantity));
                iField.clear();
                aField.clear();
                docField.clear();
                resultlabel.setText("");
            }catch(Exception ex){
                resultlabel.setText("Number format Exception" );
                
            }
                 });
        Button update =new Button("UPDATE");
        update.setMaxWidth(150);
        update.setStyle("-fx-button-type:RAISED");
        update.setOnAction(e ->{
            InventoryItem selected=tableView.getSelectionModel().getSelectedItem();
            if(selected != null){
                selected.setName(iField.getText());
                selected.setId(aField.getText());
                try{
                    selected.setQuantity(Integer.parseInt(docField.getText()));
                    tableView.refresh();
                    resultlabel.setText("");

                }catch(Exception ex){
                    resultlabel.setText("Quantity must be number");
                }
            }
            else{
                System.out.println(" Select an Item ");
            }
            });

        Button delete=new Button("DELETE");
        add.setStyle("-fx-button-type:RAISED");
        delete.setMaxWidth(150);
        delete.setOnAction( e ->{
            InventoryItem selected=tableView.getSelectionModel().getSelectedItem();
            if(selected !=null){
                item.remove(selected);
                resultlabel.setText("");
            }else{
                resultlabel.setText("Select an Item to Delete");
            }
});
  tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                iField.setText(newSelection.getName());
                aField.setText(newSelection.getId());
                docField.setText(String.valueOf(newSelection.getQuantity()));
            }
        });
  HBox hb=new HBox(10,add,update,delete);
  hb.setAlignment(Pos.CENTER);
  
  

       VBox vb =new VBox( tableView,iField,aField,docField,hb,resultlabel);
       vb.setStyle("-fx-background-color:rgba(11, 174, 87, 0.92)");
       Scene sc=new Scene(vb,900,700);
       primaryStage.setScene(sc);
       primaryStage.show();
        }
    
}
