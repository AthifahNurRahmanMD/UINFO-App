// package UINFO.Pages;

// import UINFO.Models.Kampus;
// import UINFO.db.DbController;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.image.Image;
// import javafx.scene.layout.Background;
// import javafx.scene.layout.BackgroundImage;
// import javafx.scene.layout.BackgroundRepeat;
// import javafx.scene.layout.BackgroundSize;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class FakultasJurusanClass {

//     private Stage stage;
//     private Kampus kampus;
//     private ObservableList<Kampus> datajurusan_fakultas_kampus; 
//     ArrayList<Fakultas_Jurusan> listFakultas;

//     public FakultasJurusanClass(Stage stage, Kampus kampus, ObservableList<Kampus> datajurusan_fakultas_kampus) {
//         this.stage = stage;
//         this.kampus = kampus;
//         this.datajurusan_fakultas_kampus = datajurusan_fakultas_kampus; //ini bagian untuk inisialisasi observableList
//         this.listFakultas = new ArrayList<>();
//         fetchDataFromDatabase(); // ini bagian memanggil metode untuk mengambil data dari db
//         initializeFakultasList();
//     }

//     private void fetchDataFromDatabase() {
//         // ambil data dari db using DbController
//         DbController dbController = new DbController();
//         datajurusan_fakultas_kampus = dbController.getdetailuniv(kampus.getKampus());
//         for (Kampus kampus : datajurusan_fakultas_kampus) {
//             System.out.println(kampus);
//         }
//     }

//     private void initializeFakultasList() {
//         Map<String, Map<String, Fakultas_Jurusan>> universitasMap =  new HashMap<>();

//         for (Kampus kampus : datajurusan_fakultas_kampus){
//             String universitas =  kampus.getKampus();
//             String fakultas = kampus.getFakultas();
//             String jurusan = kampus.getJurusan();
            
//             universitasMap.putIfAbsent(universitas, new HashMap<>());
//             Map<String, Fakultas_Jurusan> fakultasMap =  universitasMap.get(universitas);
            
//             if (!fakultasMap.containsKey(fakultas)){
//                 Fakultas_Jurusan fakultasjurusan =  new Fakultas_Jurusan(fakultas);
//                 fakultasMap.put(fakultas, fakultasjurusan);
//                 listFakultas.add(fakultasjurusan);
//             }
//             fakultasMap.get(fakultas).addJurusan(jurusan);
//         }


//         // Map<String, Fakultas_Jurusan> fakultasMap = new HashMap<>();

//         // for (Kampus kampus : datajurusan_fakultas_kampus) {
//         //     String fakultasdanjurusan_kampus = kampus.getFakultas();
//         //     if (!fakultasMap.containsKey(fakultasdanjurusan_kampus)) {
//         //         Fakultas_Jurusan fakultasjurusan = new Fakultas_Jurusan(fakultasdanjurusan_kampus);
//         //         fakultasMap.put(fakultasdanjurusan_kampus, fakultasjurusan);
//         //         listFakultas.add(fakultasjurusan);
//         //     }
//         //     fakultasMap.get(fakultasdanjurusan_kampus).addJurusan(kampus.getJurusan());
//         // }
//     }

//     public void show() {
//         TableView<Fakultas_Jurusan> tableView = new TableView<>();

//         TableColumn<Fakultas_Jurusan, String> colFakultas = new TableColumn<>("Fakultas");
//         colFakultas.setCellValueFactory(new PropertyValueFactory<>("nama"));

//         TableColumn<Fakultas_Jurusan, String> colJurusan = new TableColumn<>("Jurusan");
//         colJurusan.setCellValueFactory(new PropertyValueFactory<>("jurusanListString"));

//         tableView.getColumns().addAll(colFakultas, colJurusan);
//         tableView.setItems(FXCollections.observableArrayList(listFakultas));

//         Button backButton = new Button("Back");
//         backButton.setPrefWidth(100);
//         backButton.setOnAction(e -> {
//             if (kampus.getStatus().equals("")) {
//                 PTNSDetail ptsScene = new PTNSDetail(stage, kampus);
//                 ptsScene.show();
//             } else {
//                 PTNSDetail ptnScene = new PTNSDetail(stage, kampus);
//                 ptnScene.show();
//             }
//         });

//         Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/detailcampusbg.png"));

//         BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
//             BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
//             new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

//         StackPane stackPane = new StackPane();
//         StackPane.setMargin(backButton, new Insets(400, 550, 15, 0));
//         stackPane.setBackground(new Background(backgroundImg));
//         stackPane.getChildren().addAll(backButton, tableView);


//         Scene scene = new Scene(stackPane, 800, 500);
//         scene.getStylesheets().add(getClass().getResource("/CssStyle/styles.css").toExternalForm());
//         stage.setScene(scene);
//         stage.show();
//     }

//     public static class Fakultas_Jurusan {
//         private String nama;
//         private List<String> jurusanList;

//         public Fakultas_Jurusan(String nama) {
//             this.nama = nama;
//             this.jurusanList = new ArrayList<>();
//         }

//         public String getNama() {
//             return nama;
//         }

//         public void addJurusan(String jurusan) {
//             this.jurusanList.add(jurusan);
//         }

//         public String getJurusanListString() {
//             return String.join("\n", jurusanList);
//         }
//     }
// }

package UINFO.Pages;

import UINFO.Models.Kampus;
import UINFO.db.DbController;
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

public class FakultasJurusanClass {

    private Stage stage;
    private ObservableList<Kampus> dataKampus; // Data kampus yang diperoleh dari database

    public FakultasJurusanClass(Stage stage, Kampus kampus, ObservableList<Kampus> dataKampus) {
        this.stage = stage;
        this.dataKampus = dataKampus;
    }

    public void show() {
        TableView<Fakultas_Jurusan> tableView = new TableView<>();

        TableColumn<Fakultas_Jurusan, String> colFakultas = new TableColumn<>("Fakultas");
        colFakultas.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<Fakultas_Jurusan, String> colJurusan = new TableColumn<>("Jurusan");
        colJurusan.setCellValueFactory(new PropertyValueFactory<>("jurusanListString"));

        tableView.getColumns().addAll(colFakultas, colJurusan);
        tableView.setItems(FXCollections.observableArrayList(initializeFakultasList()));

        Button backButton = new Button("Back");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
            PTNSDetail ptsScene = new PTNSDetail(stage, dataKampus.get(0)); // Misalnya mengambil data dari kampus pertama untuk tujuan navigasi kembali
            ptsScene.show();
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

    private List<Fakultas_Jurusan> initializeFakultasList() {
        Map<String, Fakultas_Jurusan> fakultasMap = new HashMap<>();

        for (Kampus kampus : dataKampus){
            String fakultas = kampus.getFakultas();
            String jurusan = kampus.getJurusan();
            
            if (!fakultasMap.containsKey(fakultas)){
                Fakultas_Jurusan fakultasjurusan =  new Fakultas_Jurusan(fakultas);
                fakultasMap.put(fakultas, fakultasjurusan);
            }
            fakultasMap.get(fakultas).addJurusan(jurusan);
        }

        return new ArrayList<>(fakultasMap.values());
    }

    public static class Fakultas_Jurusan {
        private String nama;
        private List<String> jurusanList;

        public Fakultas_Jurusan(String nama) {
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
