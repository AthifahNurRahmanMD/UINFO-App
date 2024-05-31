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

public class PTN_NONBH {
    private Stage stage;
    private Kampus kampus;

    public PTN_NONBH(Stage stage, Kampus kampus) {
        this.stage = stage;
        this.kampus = kampus;
    }

    public void show(){
        Label ptnNonBH = new Label ("PTN-NONBH");
        ptnNonBH.getStyleClass().add("label-ptnbhstatushl");
        Text text2 =  new Text("Perguruan Tinggi Tidak Berbadan Hukum");
        text2.getStyleClass().add("text-aboutptnbh2");
        Text text3 = new Text("PTN Non-BH berada di bawah kendali pemerintah dalam berbagai aspek operasional.\nIni berarti keputusan-keputusan strategis dan pengelolaan institusi lebih banyak diatur\noleh kebijakan dan regulasi pemerintah.");
        text3.getStyleClass().add("text-aboutptnbh3");
        Text kelebihanPTNBH = new Text ("KELEBIHAN");
        kelebihanPTNBH.getStyleClass().add("text-aboutptnbh1");
        Text listkelebihan =  new Text("1. Biaya Kuliah Lebih Rendah:\n     Lebih terjangkau karena didukung\n     penuh oleh pemerintah.\n2. Akses Lebih Terbuka:\n     Mudah diakses oleh mahasiswa dari\n     berbagai latar belakang ekonomi.\n3. Pendanaan Stabil:\n    Pendanaan dari pemerintah lebih stabil dan\n    dapat diandalkan.\n4. Fokus pada Pendidikan:\n     Lebih fokus pada tujuan pendidikan\n     dan penelitian murnidaripada komersialisasi.\n5. Pengawasan Ketat:\n    Pengawasan dan regulasi dari pemerintah\n    memastikan standar kualitas tertentu.");
        listkelebihan.getStyleClass().add("text-ptnbh4");
        Text kekuranganPTNBH = new Text ("KEKURANGAN");
        kekuranganPTNBH.getStyleClass().add("text-aboutptnbh1");
        Text listkekurangan = new Text ("1. Otonomi Terbatas:\n    Keterbatasan dalam pengambilan\n    keputusan cepat dan inovatif.\n2. Birokrasi Tinggi:\n    Proses birokrasi yang lebih panjang\n    dan kompleks.\n3. Kurang Fleksibel:\n    Kesulitan dalam menyesuaikan kurikulum\n    dengan cepat sesuai kebutuhan pasar.\n4. Pendanaan Terbatas:\n    Terbatas pada dana yang diberikan\n    pemerintah,kurang fleksibel dalam\n    pengelolaan keuangan.\n5. Pengembangan Terbatas:\n   Terbatasnya peluang untuk mengembangkan\n   usaha dan sumber pendapatan alternatif.");
        listkekurangan.getStyleClass().add("text-ptnbh4");
        
        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("button-backbutton");
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> {
                PTNSDetail ptnScene = new PTNSDetail(stage, kampus);
                ptnScene.show();
            });
        
        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/newptnStatusbg.png"));

        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(ptnNonBH, new Insets(20,595,480,28));
        StackPane.setMargin(text2, new Insets(58,350,435,350));
        StackPane.setMargin(text3, new Insets(63,350,363,350));
        StackPane.setMargin(kelebihanPTNBH, new Insets(104,453,300,146));
        StackPane.setMargin(listkelebihan, new Insets(255,400,170,101));
        StackPane.setMargin(kekuranganPTNBH, new Insets(104,140,300,460));
        StackPane.setMargin(listkekurangan, new Insets(288,105,200,423));
        StackPane.setMargin(backButton, new Insets(430, 350, 15, 350));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll(ptnNonBH,text2,text3,kelebihanPTNBH,listkelebihan,kekuranganPTNBH,listkekurangan,backButton);
        Scene scene = new Scene(stackPane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}

