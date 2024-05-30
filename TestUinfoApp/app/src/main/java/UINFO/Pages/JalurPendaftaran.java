package UINFO.Pages;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import UINFO.Models.Kampus;
import UINFO.Pages.FakultasJurusanClass.Fakultas_Jurusan;
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

public class JalurPendaftaran {

    private Stage stage;
    private Kampus kampus;
    private ObservableList<Kampus> dataJalurPendaftaran;
    private ObservableList<Jalur_Pendaftaran_Kampus> listJalurPendaftaran;

    public JalurPendaftaran(Stage stage, Kampus kampus, ObservableList<Kampus> dataJalurPendaftaran) {
        this.stage = stage;
        this.kampus = kampus;
        this.dataJalurPendaftaran = dataJalurPendaftaran;
        this.listJalurPendaftaran = FXCollections.observableArrayList();
        initializeJalurPendaftaran();
    }

    private void initializeJalurPendaftaran() {
        // Map<String, Map<String, Jalur_Pendaftaran_Kampus>> jalurPendaftaranMap = new HashMap<>();

        // for (Kampus kampus : dataJalurPendaftaran) {
        //     String universitas = kampus.getKampus();
        //     String jalurPendaftaran = kampus.getJalurPendaftaran();
        //     String biayaPendaftaran = kampus.getBiayaPendaftaran();

        //     jalurPendaftaranMap.putIfAbsent(universitas, new HashMap<>());
        //     Map<String, Jalur_Pendaftaran_Kampus> JapenKampusMap = jalurPendaftaranMap.get(universitas);

        //     if (!JapenKampusMap.containsKey(jalurPendaftaran)) {
        //         Jalur_Pendaftaran_Kampus jalur_PendaftarandanBiaya = new Jalur_Pendaftaran_Kampus(jalurPendaftaran);
        //         JapenKampusMap.put(jalurPendaftaran, jalur_PendaftarandanBiaya);
        //         listJalurPendaftaran.add(jalur_PendaftarandanBiaya);
        //     }
        //     // JapenKampusMap.get(jalurPendaftaran).addBiayaPendaftaran(biayaPendaftaran);
        // }
        Map<String, Jalur_Pendaftaran_Kampus> jalurPendaftaranMap = new HashMap<>();

        for (Kampus kampus : dataJalurPendaftaran) {
            String jalurdanbiayaPendaftaran = kampus.getJalurPendaftaran();
            if (!jalurPendaftaranMap.containsKey(jalurdanbiayaPendaftaran)) {
                Jalur_Pendaftaran_Kampus biayaPendaftaran = new Jalur_Pendaftaran_Kampus(jalurdanbiayaPendaftaran);
                jalurPendaftaranMap.put(jalurdanbiayaPendaftaran, biayaPendaftaran);
                listJalurPendaftaran.add(biayaPendaftaran);
            }
            jalurPendaftaranMap.get(jalurdanbiayaPendaftaran).addBiaya(kampus.getBiayaPendaftaran());
        }
    }

    public void show() {
        TableView<Jalur_Pendaftaran_Kampus> tableView = new TableView<>();
        
        // Create a single column for TableView
        TableColumn<Jalur_Pendaftaran_Kampus, String> colJalurPendaftaran = new TableColumn<>("Jalur Pendaftaran");
        colJalurPendaftaran.setCellValueFactory(new PropertyValueFactory<>("jalurseleksi"));
        colJalurPendaftaran.setPrefWidth(270);

        TableColumn<Jalur_Pendaftaran_Kampus, String> colBiayaPendaftaran = new TableColumn<>("Biaya Pendaftaran");
        colBiayaPendaftaran.setCellValueFactory(new PropertyValueFactory<>("biayaPendaftaran"));
        colBiayaPendaftaran.setPrefWidth(230);

        tableView.setMaxWidth(500);
        tableView.setMaxHeight(300);
        tableView.getColumns().addAll(colJalurPendaftaran, colBiayaPendaftaran);
        tableView.setItems(FXCollections.observableArrayList(listJalurPendaftaran));

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
        scene.getStylesheets().add(getClass().getResource("/CssStyle/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public static class Jalur_Pendaftaran_Kampus {
        private String jalurseleksi;
        private List<String> biaya;

        public Jalur_Pendaftaran_Kampus(String jalurseleksi) {
            this.jalurseleksi = jalurseleksi;
            this.biaya = new ArrayList<>();
        }

        public String getJalurseleksi() {
            return jalurseleksi;
        }

        public void addBiaya(String biayaPendaftaran) {
            this.biaya.add(biayaPendaftaran);
        }

        public String getBiayaPendaftaran() {
            return String.join("\n", biaya);
        }

        


        // public String getBiayaPendaftaran() {
        //     return biayaPendaftaran;
        // }
        // public void setBiayaPendaftaran(String biayaPendaftaran) {
        //     this.biayaPendaftaran = biayaPendaftaran;
        // }
    }

    // public static class Jalur_Pendaftaran_Kampus {
    //     private String nama;
    //     private List<String> jalurlist;

    //     public Jalur_Pendaftaran_Kampus(String nama) {
    //         this.nama = nama;
    //         this.jalurlist = new ArrayList<>();
    //     }


    //     public void addBiaya(String biayaPendaftaran) {
    //         this.addBiaya(biayaPendaftaran);
    //     }

    //     public String getNama() {
    //         return nama;
    //     }

    //     public void addJalur(String jalurpendaftaran) {
    //         this.jalurlist.add(jalurpendaftaran);
    //     }

    //     public String getJalurString() {
    //         return String.join("\n", jalurlist);
    //     }
    // }
}
