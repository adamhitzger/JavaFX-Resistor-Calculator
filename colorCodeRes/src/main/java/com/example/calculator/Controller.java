package com.example.calculator;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    DecimalFormat df = new DecimalFormat("##.##");
    //listy pro comboboxy
    ObservableList<String> fisrtThreeBandColors = FXCollections
            .observableArrayList("Black (0)", "Brown (1)", "Red (2)", "Orange (3)", "Yellow (4)", "Green (5)", "Blue (6)",
                    "Violet (7)", "Grey (8)", "White (9)");

    ObservableList<String> multiplierBandList = FXCollections
            .observableArrayList("Black (1Ω)", "Brown (10Ω)", "Red (100Ω)", "Orange (1kΩ)", "Yellow (10kΩ)", "Green (100kΩ)", "Blue (1MΩ)",
                    "Violet (10MΩ)", "Grey (100MΩ)", "White (1GΩ)", "Gold (0.1Ω)", "Silver (0.01Ω)");

    ObservableList<String> toleranceBandList = FXCollections
            .observableArrayList("Brown (±1%)", "Red (±2%)", "Green (±0.5%)", "Blue (±0.25%)",
                    "Violet (±0.1%)", "Grey (±0.05%)", "Gold (±5%)", "Silver (±10%)");

    ObservableList<String> ppmBandList = FXCollections
            .observableArrayList("Brown (100 ppm)", "Red (50 ppm)", "Orange (15 ppm)", "Yellow (25 ppm)", "Blue (10 ppm)", "Violet (5 ppm)");

    ObservableList<String> listJednotek = FXCollections.observableArrayList("Ω", "kΩ", "MΩ", "GΩ");

    //texty, tlačítka, obrázky
    @FXML
    private Text result;

    @FXML
    private Button calculateButton;

    @FXML
    private ImageView resPic;

    @FXML
    private ImageView closePic;


    //labely
    @FXML
    private Label heading;


    //Comboboxy
    @FXML
    private ComboBox<String> firstBandBox;

    @FXML
    private ComboBox<String> secondBandBox;

    @FXML
    private ComboBox<String> thirdBandBox;

    @FXML
    private ComboBox<String> multiplierBox;

    @FXML
    private ComboBox<String> toleranceBox;

    @FXML
    private ComboBox<String> ppmBox;

    @FXML
    private ComboBox<String> jednotky;

    //přepínače pruhů
    @FXML
    private ToggleGroup resistorBands;

    @FXML
    private RadioButton radioBand_4;

    @FXML
    private RadioButton radioBand_5;

    @FXML
    private RadioButton radioBand_6;

    //rectangly
    @FXML
    private Rectangle firstBand;

    @FXML
    private Rectangle secondBand;

    @FXML
    private Rectangle thirdBand;

    @FXML
    private Rectangle toleranceBand;

    @FXML
    private Rectangle multiplierBand;

    @FXML
    private Rectangle ppmBand;

    public Controller() {

    }

    public void getBands(ActionEvent event){
        if(radioBand_4.isSelected()){
            thirdBandBox.setDisable(true);
            thirdBand.setVisible(false);
            ppmBox.setDisable(true);
            ppmBand.setVisible(false);
        }else if(radioBand_5.isSelected()){
            thirdBandBox.setDisable(false);
            thirdBand.setVisible(true);
            ppmBox.setDisable(true);
            ppmBand.setVisible(false);
        }else if(radioBand_6.isSelected()){
            thirdBandBox.setDisable(false);
            thirdBand.setVisible(true);
            ppmBox.setDisable(false);
            ppmBand.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstBandBox.setItems(fisrtThreeBandColors);
        secondBandBox.setItems(fisrtThreeBandColors);
        thirdBandBox.setItems(fisrtThreeBandColors);
        multiplierBox.setItems(multiplierBandList);
        toleranceBox.setItems(toleranceBandList);
        ppmBox.setItems(ppmBandList);
        jednotky.setItems(listJednotek);
        jednotky.setValue("Ω");
        thirdBandBox.setValue("3. band");
        ppmBox.setValue("PPM");
    }

    public void calculate(ActionEvent actionEvent) {
        String one = "", two = "", three = "",multi="", tolerance = "", ppm = "";
        String vysledek = "";
        System.out.println("Calculating");
        String firstBandBoxValue = firstBandBox.getValue();
        switch (firstBandBoxValue) {
            case "Black (0)":
                one = "0";
                firstBand.setFill(Color.BLACK);
                break;
            case "Brown (1)":
                one = "1";
                firstBand.setFill(Color.color(0.538, 0.411, 0.1));
                break;
            case "Red (2)":
                one = "2";
                firstBand.setFill(Color.RED);
                break;
            case "Orange (3)":
                one = "3";
                firstBand.setFill(Color.ORANGE);
                break;
            case "Yellow (4)":
                one = "4";
                firstBand.setFill(Color.YELLOW);
                break;
            case "Green (5)":
                one = "5";
                firstBand.setFill(Color.GREEN);
                break;
            case "Blue (6)":
                one = "6";
                firstBand.setFill(Color.BLUE);
                break;
            case "Violet (7)":
                one = "7";
                firstBand.setFill(Color.color(0.5, 0.2, 0.5));
                break;
            case "Grey (8)":
                one = "8";
                firstBand.setFill(Color.GRAY);
                break;
            case "White (9)":
                one = "9";
                firstBand.setFill(Color.WHITE);
                break;
        }
        String secondBandBoxValue = secondBandBox.getValue();
        switch (secondBandBoxValue) {
            case "Black(0)":
                two += "0";
                secondBand.setFill(Color.BLACK);
                break;
            case "Brown (1)":
                two += "1";
                secondBand.setFill(Color.color(0.538, 0.411, 0.1));
                break;
            case "Red (2)":
                two += "2";
                secondBand.setFill(Color.RED);
                break;
            case "Orange (3)":
                two += "3";
                secondBand.setFill(Color.ORANGE);
                break;
            case "Yellow (4)":
                two += "4";
                secondBand.setFill(Color.YELLOW);
                break;
            case "Green (5)":
                two += "5";
                secondBand.setFill(Color.GREEN);
                break;
            case "Blue (6)":
                two += "6";
                secondBand.setFill(Color.BLUE);
                break;
            case "Violet (7)":
                two += "7";
                secondBand.setFill(Color.color(0.5, 0.2, 0.5));
                break;
            case "Grey (8)":
                two += "8";
                secondBand.setFill(Color.GRAY);
                break;
            case "White (9)":
                two += "9";
                secondBand.setFill(Color.WHITE);
                break;
        }
        String thirdBandBoxValue = thirdBandBox.getValue();
        switch (thirdBandBoxValue) {
            case "Black (0)":
                three += "0";
                thirdBand.setFill(Color.BLACK);
                break;
            case "Brown (1)":
                three += "1";
                thirdBand.setFill(Color.color(0.538, 0.411, 0.1));
                break;
            case "Red(2)":
                three += "2";
                thirdBand.setFill(Color.RED);
                break;
            case "Orange (3)":
                three += "3";
                thirdBand.setFill(Color.ORANGE);
                break;
            case "Yellow (4)":
                three += "4";
                thirdBand.setFill(Color.YELLOW);
                break;
            case "Green (5)":
                three += "5";
                thirdBand.setFill(Color.GREEN);
                break;
            case "Blue (6)":
                three += "6";
                thirdBand.setFill(Color.BLUE);
                break;
            case "Violet (7)":
                three += "7";
                thirdBand.setFill(Color.color(0.5, 0.2, 0.5));
                break;
            case "Grey (8)":
                three += "8";
                thirdBand.setFill(Color.GRAY);
                break;
            case "White (9)":
                three += "9";
                thirdBand.setFill(Color.WHITE);
                break;
        }
        if (radioBand_4.isSelected()) {
            vysledek = one + two;
        } else {
            vysledek = one + two + three;
        }
        double nasobek = Double.parseDouble(vysledek);
        String multipierBandBoxValue = multiplierBox.getValue();
        switch (multipierBandBoxValue) {
            case "Black(1Ω)":
                nasobek *= 1.0;
                multiplierBand.setFill(Color.BLACK);
                break;
            case "Brown (10Ω)":
                nasobek *= 10.0;
                multiplierBand.setFill(Color.color(0.538, 0.411, 0.1));
                break;
            case "Red (100Ω)":
                nasobek *= 100.0;
                multiplierBand.setFill(Color.RED);
                break;
            case "Orange (1kΩ)":
                nasobek *= 1000.0;
                multiplierBand.setFill(Color.ORANGE);
                break;
            case "Yellow (10kΩ)":
                nasobek *= 10000.0;
                multiplierBand.setFill(Color.YELLOW);
                break;
            case "Green (100kΩ)":
                nasobek *= 100000.0;
                multiplierBand.setFill((Color.GREEN));
                break;
            case "Blue (1MΩ)":
                nasobek *= 1000000.0;
                multiplierBand.setFill(Color.BLUE);
                break;
            case "Violet (10MΩ)":
                nasobek *= 10000000.0;
                multiplierBand.setFill(Color.color(0.5, 0.2, 0.5));
                break;
            case "Grey (100MΩ)":
                nasobek *= 100000000.0;
                multiplierBand.setFill(Color.GREY);
                break;
            case "White (1GΩ)":
                nasobek *= 100000000.0;
                multiplierBand.setFill(Color.WHITE);
                break;
            case "Gold (0.1Ω)":
                nasobek *= 0.1;
                multiplierBand.setFill(Color.GOLD);
                break;
            case "Silver (0.01Ω)":
                nasobek *= 0.01;
                multiplierBand.setFill(Color.SILVER);
                break;
        }
        String hodnotaJednotek = jednotky.getValue();
        switch (hodnotaJednotek) {
            case "Ω":
                df.format(nasobek);
                multi = Double.toString(nasobek) + " Ω ";
                break;
            case "kΩ":
                nasobek /= 1000.0;
                df.format(nasobek);
                multi = Double.toString(nasobek) + " kΩ ";
                break;
            case "MΩ":
                nasobek /= 1000000.0;
                df.format(nasobek);
                multi = Double.toString(nasobek) + " MΩ ";
                break;
            case "GΩ":
                nasobek /= 1000000000.0;
                df.format(nasobek);
                multi = Double.toString(nasobek) + " GΩ ";
                break;
        }
        String toleranceBandBoxValue = toleranceBox.getValue();
        switch (toleranceBandBoxValue) {
            case "Brown (±1%)":
                tolerance += " ±1%";
                toleranceBand.setFill(Color.color(0.538, 0.411, 0.1));
                break;
            case "Red (±2%)":
                tolerance += " ±2%";
                toleranceBand.setFill(Color.RED);
                break;
            case "Green (±0.5%)":
                tolerance += " ±0.5%";
                toleranceBand.setFill(Color.GREEN);
                break;
            case "Blue (±0.25%)":
                tolerance += " ±0.25%";
                toleranceBand.setFill(Color.BLUE);
                break;
            case "Violet (±0.1%)":
                tolerance += " ±0.1%";
                toleranceBand.setFill(Color.color(0.5, 0.2, 0.5));
                break;
            case "Grey (±0.05%)":
                tolerance += " ±0.05%";
                toleranceBand.setFill(Color.GRAY);
                break;
            case "Gold (±5%)":
                tolerance += " ±5%";
                toleranceBand.setFill(Color.GOLD);
                break;
            case "Silver (±10%)":
                tolerance += " ±10%";
                toleranceBand.setFill(Color.SILVER);
                break;
        }
        String ppmBandBoxValue = ppmBox.getValue();
        switch (ppmBandBoxValue) {
            case "Brown (100 ppm)":
                ppm += " 100 ppm";
                ppmBand.setFill(Color.color(0.538, 0.411, 0.1));
                break;
            case "Red(50 ppm)":
                ppm += " 50 ppm";
                ppmBand.setFill(Color.RED);
                break;
            case "Orange (15 ppm)":
                ppm += " 15 ppm";
                ppmBand.setFill(Color.ORANGE);
                break;
            case "Yellow (25 ppm)":
                ppm += " 25 ppm";
                ppmBand.setFill(Color.YELLOW);
                break;
            case "Blue (10 ppm)":
                ppm += " 10 ppm";
                ppmBand.setFill(Color.BLUE);
                break;
            case "Violet (5 ppm)":
                ppm += " 5 ppm";
                ppmBand.setFill(Color.color(0.5, 0.2, 0.5));
                break;
        }
        if (radioBand_4.isSelected()) {

            vysledek = multi + tolerance;
        } else if (radioBand_5.isSelected()) {

            vysledek = multi + tolerance;
        } else if (radioBand_6.isSelected()) {
            vysledek = multi + tolerance + ppm;
        }
        result.setVisible(true);
        result.setText(vysledek);
    }

    public void closeApp(MouseEvent mouseEvent) {
        Platform.exit();
    }
}