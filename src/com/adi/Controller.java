package com.adi;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private Boolean c_to_f=true;
    @FXML
    public Label welcomelabel ;
    @FXML
    public Button convertbutton ;
    @FXML
    public ChoiceBox<String> userchoice ;
    @FXML
    public TextField usertext ;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        userchoice.getItems().add("Fahrenheit to celsius");
        userchoice.getItems().add("celsius to Fahrenheit");
        userchoice.setValue("celsius to Fahrenheit");
        userchoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("celsius to Fahrenheit"))
                c_to_f = true;
            else
                c_to_f = false;
        });
        convertbutton.setOnAction(event ->
                convert());


    }

    private void convert()
    {
        String text=usertext.getText();
        float enteredtemp=0.0f;
        try {
             enteredtemp = Float.parseFloat(text);
        }
        catch (Exception e)
        {
            warnuser();
            return;
        }
        float newtemp=0.0f;
        if(c_to_f)
            newtemp=(enteredtemp*9/5)+32;
        else
            newtemp=(enteredtemp-32)*5/9;
        display(newtemp);
    }

    private void warnuser() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Temperature");
        alert.setContentText("Re-enter the temperature");
        alert.show();
    }

    private void display(float newtemp) {
        String unit=c_to_f?"F":"C";

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("the new temperature is "+newtemp+unit);
        alert.show();
    }
}
