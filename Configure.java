import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
import javafx.stage.*;

/**
 * Configure
 */
public class Configure extends Application {

    Stage window;
    TableView<Sensor> report;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        
        window = primaryStage;

        Label l_UID, l_LOCATION, l_CO2MIN, l_CO2MAX, l_SETCO2, l_SETTEMP, l_TEMPMIN, l_TEMPMAX, l_SEARCHSENSOR;
        l_UID = new Label("UID");
        l_LOCATION = new Label("LOCATION");
        l_CO2MIN = new Label("SET CO2% MIN");
        l_CO2MAX = new Label("SET CO2% MAX");
        l_TEMPMIN = new Label("SET TEMP MIN");
        l_TEMPMAX = new Label("SET TEMP MAX");
        l_SETCO2 = new Label("SET CO2%");
        l_SETTEMP = new Label("SET TEMP");
	    l_SEARCHSENSOR = new Label("UID: ");

        TextField t_UID, t_LOCATION, t_CO2MIN, t_CO2MAX, t_SETCO2, t_SETTEMP, t_TEMPMIN, t_TEMPMAX, t_SEARCHSENSOR;
        t_UID = new TextField("");
        t_LOCATION = new TextField("");
        t_CO2MIN = new TextField("");
        t_CO2MAX = new TextField("");
        t_TEMPMIN = new TextField("");
        t_TEMPMAX = new TextField("");
        t_SETCO2 = new TextField("");
        t_SETTEMP = new TextField("");
	    t_SEARCHSENSOR = new TextField("");

        Button b_MODIFYSENSOR, b_ADDSENSOR;
        Button b_SEARCHSENSOR = new Button("Search Sensor");
        b_MODIFYSENSOR = new Button("Modify Sensor");

        Slider s_CO2MIN, s_CO2MAX, s_TEMPMIN, s_TEMPMAX, s_SETCO2, s_SETTEMP;

        s_SETCO2 = new Slider();
        s_SETTEMP = new Slider();

        GridPane layout = new GridPane();
        layout.setVgap(20);
        layout.setHgap(20);

        layout.addRow(0, l_UID, t_UID, 
                    new Separator(Orientation.VERTICAL),
         l_CO2MIN, t_CO2MIN, 
                    new Separator(Orientation.VERTICAL),
         l_TEMPMIN, t_TEMPMIN, 
                    new Separator(Orientation.VERTICAL)
        );


        layout.addRow(1, l_LOCATION, t_LOCATION,
                        new Separator(Orientation.VERTICAL),
                        l_CO2MAX, t_CO2MAX,
                        new Separator(Orientation.VERTICAL),
                        l_TEMPMAX, t_TEMPMAX,
                        new Separator(Orientation.VERTICAL)
        );
                        
        layout.addRow(2, l_SEARCHSENSOR,
			t_SEARCHSENSOR,
			new Separator(Orientation.VERTICAL),
			b_SEARCHSENSOR,
            new Separator(Orientation.VERTICAL)
        );

        layout.addRow(3, new Separator(Orientation.VERTICAL),
                        s_SETCO2, 
                        new Separator(Orientation.VERTICAL),
                        new Separator(Orientation.VERTICAL),
                        s_SETTEMP
        );

        layout.addRow(4, l_SETCO2, t_SETCO2,
                        new Separator(Orientation.VERTICAL),
                        l_SETTEMP, t_SETTEMP,
                        b_MODIFYSENSOR
        );

        // TableColumn<Sensor, String> tc_uid, tc_loc, tc_setCO2min;
        TableColumn<Sensor, String> tc_uid;
        TableColumn<Sensor, String> tc_loc;
        TableColumn<Sensor, Double> tc_setCO2min;

        tc_uid = getStrColumn("UID", "UID");
        tc_loc = getStrColumn("LOCATION", "Location");
        tc_setCO2min = getDblColumn("SET CO2(%) MIN", "setCO2_min");

        report = new TableView<>();
        report.setItems(getSensor());
        report.getColumns().add(tc_uid);
        report.getColumns().add(tc_loc); //, tc_loc, tc_setCO2min);
        report.getColumns().add(tc_setCO2min);


        layout.setAlignment(Pos.CENTER);
        TabPane tp = new TabPane();
        Tab configure = new Tab("Configure", layout);
        Tab reportView  = new Tab("Report View", report);
        tp.getTabs().add(reportView);
        tp.getTabs().add(configure);
        Scene scene = new Scene( tp);
        window.setScene(scene);
        window.setTitle("Window1r");
        window.setMaximized(true);
        window.show();
    }

    static TableColumn<Sensor, String> getStrColumn(String caption, String id) {
        TableColumn<Sensor, String> col = new TableColumn<>(caption);
        col.setMinWidth(100);
        col.setCellValueFactory(new PropertyValueFactory<>(id));
        return col;
    }


    static TableColumn<Sensor, Double> getDblColumn(String caption, String id) {
        TableColumn<Sensor, Double> col = new TableColumn<>(caption);
        col.setMinWidth(100);
        col.setCellValueFactory(new PropertyValueFactory<>(id));
        return col;
    }

    static ObservableList<Sensor> getSensor() {
        ObservableList<Sensor> sensors = FXCollections.observableArrayList();
        sensors.add(new Sensor("100000", "LOC1"));
        sensors.add(new Sensor("100001", "LOC2"));
        sensors.add(new Sensor("100002", "LOC3"));
        sensors.add(new Sensor("100003", "LOC4"));
        return sensors;

    }

}

/*


        HBox hb_UID = new HBox(10);
        HBox hb_LOCATION = new HBox(10);

        hb_UID.getChildren().addAll(l_UID, t_UID);
        hb_LOCATION.getChildren().addAll(l_LOCATION, t_LOCATION);


        VBox vb = new VBox(15);
        vb.getChildren().addAll(hb_UID, hb_LOCATION);

*/
