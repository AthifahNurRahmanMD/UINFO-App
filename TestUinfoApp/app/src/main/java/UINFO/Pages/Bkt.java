package UINFO.Pages;

import UINFO.Models.Kampus;
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
public class Bkt {

    private Stage stage;
    private Kampus kampus;
    private ObservableList<Kampus> datajurusan_fakultas_kampus;
    private boolean isPrivate;

    public Bkt(Stage stage, Kampus kampus, ObservableList<Kampus> datajurusan_fakultas_kampus, boolean isPrivate) {
        this.stage = stage;
        this.kampus = kampus;
        this.datajurusan_fakultas_kampus = datajurusan_fakultas_kampus;
        this.isPrivate = isPrivate;
    }

    @SuppressWarnings("unchecked")
    public void show() {
        TableView<Kampus> tableView = new TableView<>();

        TableColumn<Kampus, String> colFakultas = new TableColumn<>("Fakultas");
        colFakultas.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        colFakultas.setPrefWidth(150);

        TableColumn<Kampus, String> colJurusan = new TableColumn<>("Jurusan");
        colJurusan.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        colJurusan.setPrefWidth(160);

        TableColumn<Kampus, String> colBkt;
        String namaLabel;
        if (isPrivate) {
            colBkt = new TableColumn<>("Biaya Pangkal");
            colBkt.setCellValueFactory(new PropertyValueFactory<>("biayaPangkal"));
            namaLabel = "UKT";
        } else {
            colBkt = new TableColumn<>("Biaya Kuliah Tunggal");
            colBkt.setCellValueFactory(new PropertyValueFactory<>("biayaKuliahTunggal"));
            namaLabel = "Gol. UKT 1-3";
        }
        colBkt.setPrefWidth(130);

        TableColumn<Kampus, String> colGolUkt13 = new TableColumn<>(namaLabel);
        colGolUkt13.setCellValueFactory(new PropertyValueFactory<>("golUKT13"));
        colGolUkt13.setPrefWidth(140);

        TableColumn<Kampus, String> colGolUkt46 = new TableColumn<>("Gol. UKT 4-6");
        colGolUkt46.setCellValueFactory(new PropertyValueFactory<>("golUKT46"));
        colGolUkt46.setPrefWidth(200);

        TableColumn<Kampus, String> colGolUkt78 = new TableColumn<>("Gol. UKT 7-8");
        colGolUkt78.setCellValueFactory(new PropertyValueFactory<>("golUKT78"));
        colGolUkt78.setPrefWidth(200);

        tableView.setMaxWidth(1100);
        tableView.setMaxHeight(300);
        if (isPrivate){
            tableView.getColumns().addAll(colFakultas, colJurusan, colBkt, colGolUkt13);
        } else {
            tableView.getColumns().addAll(colFakultas, colJurusan, colBkt, colGolUkt13, colGolUkt46, colGolUkt78);
        }

        tableView.setItems(datajurusan_fakultas_kampus);
        Button backButton = new Button("Kembali");
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

        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/detailpage.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(backButton, new Insets(400, 550, 15, 0));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll(tableView, backButton);

        Scene scene = new Scene(stackPane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}