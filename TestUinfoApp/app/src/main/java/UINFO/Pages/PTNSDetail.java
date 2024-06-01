package UINFO.Pages;

import UINFO.Forum.Forum;
import UINFO.Models.Kampus;
import UINFO.db.DbController;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;

public class PTNSDetail {
    DbController dbController;

    private Stage stage; 
    private Kampus kampus;

    public PTNSDetail(Stage stage, Kampus kampus){
        this.stage = stage;
        this.kampus = kampus;
    }

    public void show() {
        Label ptnLabel = new Label(kampus.getKampus());
        ptnLabel.getStyleClass().add("label-tritwounivhl");

        Label ptnLok =  new Label(kampus.getAlamat());
        ptnLok.getStyleClass().add("label-lokasiuniv");

        // Label ptnStatus =  new Label(kampus.getStatus());
        // ptnStatus.getStyleClass().add("label-lokasiuniv");
        Button ptnStatus =  new Button(kampus.getStatus());
        ptnStatus.getStyleClass().add("button-statusptn");
        ptnStatus.setOnAction(e ->{
            if (kampus.getStatus().equals("PTN-BH")) {
                PTN_BH aboutPtn_BH = new PTN_BH(stage, kampus);
                aboutPtn_BH.show();
            } else if (kampus.getStatus().equals("PTN-NONBH")){
                PTN_NONBH aboutPtn_NONBH = new PTN_NONBH(stage, kampus);
                aboutPtn_NONBH.show();
            } 
        });

        dbController =  new DbController();
        ObservableList<Kampus> dataKampus = dbController.getdetailuniv(kampus.getKampus());


        Button btnjalur = new Button("Jalur Pendaftaran");
        btnjalur.setPrefWidth(200);
        btnjalur.setOnAction(e ->{
            JalurPendaftaran japen = new JalurPendaftaran(stage, kampus, dataKampus);
            japen.show();
        });

        Button btnfklts = new Button("Jurusan/Fakultas");
        btnfklts.setPrefWidth(200);
        btnfklts.setOnAction(e ->{
            FakultasJurusanClass fadanju = new FakultasJurusanClass(stage, kampus, dataKampus);
            fadanju.show();
        });

        Button btnBkt;
        if (kampus.getStatus().equalsIgnoreCase("Swasta")) {
            btnBkt = new Button("Biaya Pangkal");
            btnBkt.getStyleClass().add("button-fitur" + kampus.getKampus().toLowerCase().replace(" ", ""));
        } else {
            btnBkt = new Button("BKT");
            btnBkt.getStyleClass().add("button-fitur" + kampus.getKampus().toLowerCase().replace(" ", ""));
        }
        btnBkt.setPrefWidth(200);
        btnBkt.setOnAction(e -> {
            boolean isPrivate = kampus.getStatus().equalsIgnoreCase("Swasta");
            Bkt bkt = new Bkt(stage, kampus, dataKampus, isPrivate);
            bkt.show();
        });

        Button btnForum = new Button("Forum");
        btnForum.setPrefWidth(200);
        btnForum.setOnAction(e->{
            Forum forum = new Forum(stage, kampus);
            forum.showForum();
        });

        if (kampus.getKampus().equals("Universitas Hasanuddin")){
            btnjalur.getStyleClass().add("button-fiturUh");
            btnfklts.getStyleClass().add("button-fiturUh");
            btnBkt.getStyleClass().add("button-fiturUh");
            btnForum.getStyleClass().add("button-fiturUh");
        }else if(
            kampus.getKampus().equals("Universitas Negeri Makassar")){
            btnjalur.getStyleClass().add("button-fiturunm");
            btnfklts.getStyleClass().add("button-fiturunm");
            btnBkt.getStyleClass().add("button-fiturunm");
            btnForum.getStyleClass().add("button-fiturunm");
        }else if(
            kampus.getKampus().equals("Universitas Gadjah Mada")){
            btnjalur.getStyleClass().add("button-fiturugm");
            btnfklts.getStyleClass().add("button-fiturugm");
            btnBkt.getStyleClass().add("button-fiturugm");
            btnForum.getStyleClass().add("button-fiturugm");
        }else if(
            kampus.getKampus().equals("Universitas Muslim Indonesia")){
            btnjalur.getStyleClass().add("button-fiturumi");
            btnfklts.getStyleClass().add("button-fiturumi");
            btnBkt.getStyleClass().add("button-fiturumi");
            btnForum.getStyleClass().add("button-fiturumi");
        }else if(
            kampus.getKampus().equals("Universitas Bosowa ")){
            btnjalur.getStyleClass().add("button-fiturunibos");
            btnfklts.getStyleClass().add("button-fiturunibos");
            btnBkt.getStyleClass().add("button-fiturunibos");
            btnForum.getStyleClass().add("button-fiturunibos");
        }

        Button backButton = new Button("Kembali");
        backButton.setPrefWidth(100);
        backButton.getStyleClass().add("button-backbutton");
        backButton.setOnAction(e -> {
            if (kampus.getStatus().equals("Swasta")){
                PtsButton ptsScene =  new PtsButton(stage);
                ptsScene.show();
            } else{
                PtnButton ptnScene =  new PtnButton(stage);
                ptnScene.show();
            }
        });


        Image backgroundImage = new Image(getClass().getResourceAsStream("/Images/newdetailbg.png"));

        // Membuat objek BackgroundImage untuk latar belakang
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        StackPane stackPane = new StackPane();
        StackPane.setMargin(ptnLabel, new Insets(0, 380, 460, 20));
        StackPane.setMargin(ptnLok,  new Insets(10, 10, 458, 480));
        StackPane.setMargin(ptnStatus,  new Insets(0, 600, 420, 50));
        StackPane.setMargin(btnjalur, new Insets(50, 200, 100, 200));
        StackPane.setMargin(btnfklts, new Insets(50, 200, 0, 200));
        StackPane.setMargin(btnBkt, new Insets(50, 200, -100, 200));
        StackPane.setMargin(btnForum, new Insets(50,200,-200,200));        StackPane.setMargin(backButton, new Insets(400, 550, 15, 0));
        stackPane.setBackground(new Background(backgroundImg));
        stackPane.getChildren().addAll( ptnLabel,ptnLok, ptnStatus, btnjalur, btnfklts, btnBkt, backButton, btnForum);

        Scene scene = new Scene( stackPane, 800, 500);      
        scene.getStylesheets().add(getClass().getResource("/Style/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}