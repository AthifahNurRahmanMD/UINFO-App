package UINFO.Pages;

import UINFO.Models.Kampus;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PTN_BH {
    private Stage stage;
    private Kampus kampus;

    public PTN_BH(Stage stage, Kampus kampus) {
        this.stage = stage;
        this.kampus = kampus;
    }

    public void show(){
        Label ptnBh = new Label("PTN-BH");
        ptnBh.getStyleClass().add("label-ptnbhstatushl");
        // Text text = new Text("PTN-BH"); //yg ditengah
        // text.getStyleClass().add("text-aboutptnbh1"); //bold
        Text text2 =  new Text("Perguruan Tinggi Berbadan Hukum");
        text2.getStyleClass().add("text-aboutptnbh2");
        Text text3 = new Text("PTN BH adalah perguruan tinggi negeri yang didirikan oleh pemerintah dengan status\nberbadan hukum yang otonom. Yang artinya perguruan tinggi negeri tersebut\noleh pemerintah melalui Kemendikbud sudah diberi hak otonom agar lebih mandiri.");
        text3.getStyleClass().add("text-aboutptnbh3");
        Text kelebihanPTNBH = new Text ("KELEBIHAN");
        kelebihanPTNBH.getStyleClass().add("text-aboutptnbh1");
        Text listkelebihan =  new Text("1. Otonomi Akademik:\n    Dapat menyesuaikan kurikulum dengan\n    cepat sesuai kebutuhan pasar.\n2. Manajemen Keuangan Mandiri:\n    Memungkinkan pencarian sumber\n    dana alternatif seperti donasi\n    dan kerjasama industri.\n3. Peningkatan Kualitas Pendidikan:\n    Responsif terhadap kebutuhan pasar kerja\n    dan perkembangan ilmu.\n4. Pengelolaan Sumber Daya:\n    Kebebasan dalam rekrutmen dan\n    pengembangan staf.\n5. Inovasi Tinggi:\n    Cepat beradaptasi dalam penelitian dan\n    pengabdian masyarakat.");
        listkelebihan.getStyleClass().add("text-ptnbh4");
        Text kekuranganPTNBH = new Text ("KEKURANGAN");
        kekuranganPTNBH.getStyleClass().add("text-aboutptnbh1");
        Text listkekurangan = new Text ("1. Biaya Kuliah Lebih Tinggi:\n    Membebani mahasiswa dan orang tua.\n2. Akses Terbatas bagi Mahasiswa\n    Kurang Mampu:\n    Potensi menurunkan aksesibilitas.\n3. Komersialisasi Pendidikan:\n    Fokus bisa bergeser ke pendapatan\n    daripada pendidikan.\n4. Ketidakpastian Pendanaan:\n    Risiko ketergantungan pada sumber\n    pendapatan non-pemerintah.\n5. Perubahan Tidak Merata:\n    Variasi kualitas dan efisiensi antar PTN-BH.\n6. Potensi Konflik Kepentingan:\n    Konflik antara tujuan pendidikan\n    dan komersial.");
        listkekurangan.getStyleClass().add("text-ptnbh4");


        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("button-backbutton");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
                PTNSDetail ptnScene = new PTNSDetail(stage, kampus);
                ptnScene.show();
            });
        
        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/newptnstatusbg.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(ptnBh, new Insets(20,595,480,20));
        // StackPane.setMargin(text, new Insets(52,350,437,350));
        StackPane.setMargin(text2, new Insets(58,350,435,350));
        StackPane.setMargin(text3, new Insets(63,350,363,350));
        StackPane.setMargin(kelebihanPTNBH, new Insets(104,453,300,146));
        StackPane.setMargin(listkelebihan, new Insets(255,400,170,99));
        StackPane.setMargin(kekuranganPTNBH, new Insets(104,140,300,460));
        StackPane.setMargin(listkekurangan, new Insets(288,99,200,420));
        StackPane.setMargin(backButton, new Insets(430, 350, 15, 350));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll(ptnBh,text2,text3,kelebihanPTNBH,listkelebihan,kekuranganPTNBH,listkekurangan,backButton);
        Scene scene = new Scene(stackPane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
