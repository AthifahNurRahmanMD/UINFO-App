// package UINFO.Pages;

// import UINFO.Models.Kampus;
// import UINFO.db.DbController;
// import javafx.collections.ObservableList;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class Fakjur {
//     private Stage stage;
//     private Kampus kampus;
//     private ObservableList<Kampus> dataKampus;

//     public Fakjur(Stage stage, Kampus kampus, ObservableList<Kampus> dataKampus) {
//         this.stage = stage;
//         this.kampus = kampus;
//         this.dataKampus = dataKampus;
//     }

//     public void show() {
//         TableView<Kampus> tableView = new TableView<>();

//         // Membuat kolom Fakultas
//         TableColumn<Kampus, String> fakultasColumn = new TableColumn<>("Fakultas");
//         fakultasColumn.setCellValueFactory(new PropertyValueFactory<>("fakultas"));

//         // Membuat kolom Jurusan
//         TableColumn<Kampus, String> jurusanColumn = new TableColumn<>("Jurusan");
//         jurusanColumn.setCellValueFactory(new PropertyValueFactory<>("jurusan"));

//         // Menambahkan kolom ke TableView
//         tableView.getColumns().addAll(fakultasColumn, jurusanColumn);

//         // Menambahkan data ke TableView
//         tableView.setItems(dataKampus);

//         // Membuat layout
//         VBox vbox = new VBox();
//         vbox.setPadding(new Insets(10));
//         vbox.setSpacing(8);
//         vbox.getChildren().add(tableView);

//         // Membuat scene dan menampilkannya
//         Scene scene = new Scene(vbox, 600, 400);
//         stage.setScene(scene);
//         stage.show();
//     }
// }
