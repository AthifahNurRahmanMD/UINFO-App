package UINFO.Pages;

import UINFO.Models.Kampus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakultasJurusan {

    private Stage stage;
    private Kampus kampus;
    ObservableList<Kampus> dataKampus;
    ArrayList<Fakultas> listFakultas;

    public FakultasJurusan(Stage stage, Kampus kampus, ObservableList<Kampus> dataKampus) {
        this.stage = stage;
        this.kampus = kampus;
        this.dataKampus = dataKampus;
        this.listFakultas = new ArrayList<>();
        initializeFakultasList();
    }

    private void initializeFakultasList() {
        Map<String, Fakultas> fakultasMap = new HashMap<>();

        for (Kampus k : dataKampus) {
            String fakultasName = k.getFakultas();
            if (!fakultasMap.containsKey(fakultasName)) {
                Fakultas fakultas = new Fakultas(fakultasName);
                fakultasMap.put(fakultasName, fakultas);
                listFakultas.add(fakultas);
            }
            fakultasMap.get(fakultasName).addJurusan(k.getJurusan());
        }
    }

    public void show() {
        TableView<Fakultas> tableView = new TableView<>();

        TableColumn<Fakultas, String> colFakultas = new TableColumn<>("Fakultas");
        colFakultas.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<Fakultas, String> colJurusan = new TableColumn<>("Jurusan");
        colJurusan.setCellValueFactory(new PropertyValueFactory<>("jurusanListString"));

        tableView.getColumns().addAll(colFakultas, colJurusan);
        tableView.setItems(FXCollections.observableArrayList(listFakultas));

        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            if (kampus.getStatus().equals("")) {
                PTNSDetail ptsScene = new PTNSDetail(stage, kampus);
                ptsScene.show();
            } else {
                PTNSDetail ptnScene = new PTNSDetail(stage, kampus);
                ptnScene.show();
            }
        });

        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/detailcampusbg.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(backButton, new Insets(400, 550, 15, 0));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll(backButton, tableView);

        Scene scene = new Scene(stackPane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/CssStyle/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static class Fakultas {
        private String nama;
        private List<String> jurusanList;

        public Fakultas(String nama) {
            this.nama = nama;
            this.jurusanList = new ArrayList<>();
        }

        public String getNama() {
            return nama;
        }

        public void addJurusan(String jurusan) {
            this.jurusanList.add(jurusan);
        }

        public String getJurusanListString() {
            return String.join("\n", jurusanList);
        }
    }
}
