import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        TextField temperatureField = new TextField();
        temperatureField.setPromptText("Enter temperature");

        ComboBox<String> unitBox = new ComboBox<>();

        unitBox.getItems().addAll(
                "Celsius",
                "Fahrenheit",
                "Kelvin"
        );

        unitBox.setValue("Celsius");

        Button convertButton = new Button("Convert");

        Label resultLabel = new Label();

        Button saveButton = new Button("Save");

        Label statusLabel = new Label();

        Button loadButton = new Button("Load Records");

        Label recordsLabel = new Label();

        TemperatureConverter converter =
                new TemperatureConverter();

        convertButton.setOnAction(event -> {

            try {

                double temperature =
                        Double.parseDouble(
                                temperatureField.getText());

                String unit =
                        unitBox.getValue();

                if (unit.equals("Celsius")) {

                    double fahrenheit =
                            converter.celsiusToFahrenheit(
                                    temperature);

                    resultLabel.setText(
                            temperature +
                                    " °C = " +
                                    fahrenheit +
                                    " °F");
                }

                else if (unit.equals("Fahrenheit")) {

                    double celsius =
                            converter.fahrenheitToCelsius(
                                    temperature);

                    resultLabel.setText(
                            temperature +
                                    " °F = " +
                                    celsius +
                                    " °C");
                }

                else if (unit.equals("Kelvin")) {

                    double celsius =
                            converter.kelvinToCelsius(
                                    temperature);

                    resultLabel.setText(
                            temperature +
                                    " K = " +
                                    celsius +
                                    " °C");
                }

            } catch (Exception e) {

                resultLabel.setText(
                        "Invalid temperature");
            }
        });

        saveButton.setOnAction(event -> {

            try {

                double temperature =
                        Double.parseDouble(
                                temperatureField.getText());

                int unitId;

                switch (unitBox.getValue()) {

                    case "Celsius":
                        unitId = 1;
                        break;

                    case "Fahrenheit":
                        unitId = 2;
                        break;

                    case "Kelvin":
                        unitId = 3;
                        break;

                    default:
                        unitId = 1;
                }

                TempRecordDAO dao =
                        new TempRecordDAO();

                dao.saveRecord(
                        temperature,
                        unitId
                );

                statusLabel.setText(
                        "Saved to database!"
                );

            } catch (Exception e) {

                statusLabel.setText(
                        "Save failed!"
                );

                e.printStackTrace();
            }
        });

        loadButton.setOnAction(event -> {

            try {

                TempRecordDAO dao =
                        new TempRecordDAO();

                recordsLabel.setText(
                        dao.getAllRecords()
                );

            } catch (Exception e) {

                recordsLabel.setText(
                        "Failed to load records"
                );

                e.printStackTrace();
            }
        });

        VBox root = new VBox(10);

        root.getChildren().addAll(
                temperatureField,
                unitBox,
                convertButton,
                saveButton,
                loadButton,
                resultLabel,
                statusLabel,
                recordsLabel
        );

        Scene scene = new Scene(
                root,
                400,
                400
        );

        stage.setTitle(
                "Temperature Converter"
        );

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}