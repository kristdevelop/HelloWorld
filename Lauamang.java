/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  com.sun.javafx.tk.FontLoader
 *  com.sun.javafx.tk.Toolkit
 *  javafx.collections.FXCollections
 *  javafx.collections.ObservableList
 *  javafx.event.ActionEvent
 *  javafx.event.Event
 *  javafx.event.EventHandler
 *  javafx.geometry.Insets
 *  javafx.geometry.Pos
 *  javafx.scene.Node
 *  javafx.scene.Parent
 *  javafx.scene.Scene
 *  javafx.scene.control.Button
 *  javafx.scene.control.ComboBox
 *  javafx.scene.control.Label
 *  javafx.scene.control.ListView
 *  javafx.scene.control.TextField
 *  javafx.scene.image.Image
 *  javafx.scene.layout.AnchorPane
 *  javafx.scene.layout.BorderPane
 *  javafx.scene.layout.FlowPane
 *  javafx.scene.layout.GridPane
 *  javafx.scene.layout.HBox
 *  javafx.scene.layout.StackPane
 *  javafx.scene.layout.VBox
 *  javafx.scene.paint.Color
 *  javafx.scene.paint.ImagePattern
 *  javafx.scene.paint.Paint
 *  javafx.scene.shape.Rectangle
 *  javafx.scene.text.Font
 *  javafx.scene.text.TextAlignment
 *  javafx.stage.Stage
 *  javafx.stage.WindowEvent
 */
import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Lauamang {
    static Stage TsirkuseMang;
    static StackPane Laud;
    BorderPane GameBoard;
    GridPane ManguRuudustik;
    Rectangle Ruut;
    static Integer ManguRuutudeArv;
    static StackPane[] ManguRuudud;
    static ArrayList<Mangija> Mangijad;
    private static Integer MangijaNumber;
    static Rectangle TaringuRuut;
    static VBox NuppudeAla;
    double ManguLauaLaius = 450.0;
    double ManguLauaKorgus = 420.0;
    static boolean mangLabi;
    private Button VeeretamisNupp;
    private Button LiikumisNupp;
    private Button JargmineMangija;
    private static Label Info;
    public static HashMap<Integer, Integer> Redelid;
    public static HashMap<Integer, Integer> Ussid;

    public Lauamang() {
        TsirkuseMang = new Stage();
        this.LooManguValjak();
        this.LooManguPais();
        this.LooVasakVali();
        this.LooManguJalus();
        this.LooManguLaud();
        new taring();
        this.KesMangivad();
    }

    private void Mangime() {
        this.VeeretamisNupp.setDisable(false);
        this.LiikumisNupp.setDisable(true);
        this.JargmineMangija.setDisable(true);
        MangijaNumber = 0;
        if (Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nupuasukoht == 0) {
            Mangijad.get(MangijaNumber).liigutaNuppAlgusesse();
        }
        Info.setText(Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nimi + " palun veereta t\u00e4ringut");
    }

    public static void mangSaiLabi() {
        Info.setText("M\u00e4ngu v\u00f5itis " + Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nimi);
        FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
        FlowPane teavitus = new FlowPane();
        teavitus.setAlignment(Pos.CENTER);
        VBox sisuKast = new VBox();
        sisuKast.setSpacing(50.0);
        Label teavituseSisu = new Label("Selle m\u00e4ngu v\u00f5itis " + Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nimi);
        teavituseSisu.setPrefHeight(30.0);
        teavituseSisu.setFont(Font.font((String)"Verdana", (double)20.0));
        Rectangle teavituseTaust = new Rectangle();
        teavituseTaust.setHeight(150.0);
        teavituseTaust.setWidth((double)(fontLoader.computeStringWidth(teavituseSisu.getText(), teavituseSisu.getFont()) + 20.0f));
        teavituseTaust.setFill((Paint)Color.WHITE);
        teavituseTaust.setStroke((Paint)Color.BLACK);
        teavituseTaust.setArcHeight(20.0);
        teavituseTaust.setArcWidth(20.0);
        HBox teavituseNupud = new HBox();
        teavituseNupud.setSpacing(20.0);
        teavituseNupud.setAlignment(Pos.CENTER);
        Button uusMang = new Button("Uus m\u00e4ng");
        uusMang.setOnAction(event -> {
            new Lauamang();
        }
        );
        Button lopetaMangimine = new Button("Sulge m\u00e4ng");
        lopetaMangimine.setOnAction(event -> {
            TsirkuseMang.close();
        }
        );
        teavituseNupud.getChildren().addAll((Object[])new Node[]{uusMang, lopetaMangimine});
        sisuKast.getChildren().addAll((Object[])new Node[]{teavituseSisu, teavituseNupud});
        AnchorPane teavituseRaamistik = new AnchorPane();
        teavituseRaamistik.getChildren().addAll((Object[])new Node[]{teavituseTaust, sisuKast});
        AnchorPane.setTopAnchor((Node)sisuKast, (Double)20.0);
        AnchorPane.setLeftAnchor((Node)sisuKast, (Double)10.0);
        teavitus.getChildren().add((Object)teavituseRaamistik);
        Laud.getChildren().add((Object)teavitus);
    }

    private void KesMangivad() {
        ObservableList mangijateList = FXCollections.observableArrayList();
        ObservableList nupuVarviList = FXCollections.observableArrayList();
        FlowPane taustaRaam = new FlowPane();
        taustaRaam.setAlignment(Pos.CENTER);
        Rectangle taust = new Rectangle(370.0, 300.0);
        taust.setArcWidth(20.0);
        taust.setArcHeight(20.0);
        taust.setFill((Paint)Color.WHITE);
        VBox mangijaSisestus = new VBox();
        mangijaSisestus.setSpacing(10.0);
        HBox MangijaInfo = new HBox();
        VBox MangijaNimeKast = new VBox();
        Label MangijaNimi = new Label("Sisesta m\u00e4ngija nimi");
        TextField mangijaNimeInput = new TextField();
        MangijaNimeKast.getChildren().addAll((Object[])new Node[]{MangijaNimi, mangijaNimeInput});
        VBox MangijaNupuVarviKast = new VBox();
        Label MangijaNupuVarv = new Label("Vali omale nupu v\u00e4rv");
        nupuVarviList.addAll(new Object[]{"Punane", "Sinine", "Kollane", "Roheline"});
        ComboBox nupuVarvid = new ComboBox(nupuVarviList);
        nupuVarvid.setEditable(false);
        nupuVarvid.setPromptText("Saada olevad v\u00e4rvid");
        MangijaNupuVarviKast.getChildren().addAll((Object[])new Node[]{MangijaNupuVarv, nupuVarvid});
        MangijaInfo.getChildren().addAll((Object[])new Node[]{MangijaNimeKast, MangijaNupuVarviKast});
        VBox mangijateNimekiri = new VBox();
        Label kesMangivad = new Label("M\u00e4ngijad:");
        ListView nimeKiri = new ListView();
        nimeKiri.setMaxHeight(taust.getHeight() / 2.0 - 20.0);
        mangijateNimekiri.getChildren().addAll((Object[])new Node[]{kesMangivad, nimeKiri});
        Button lisaMangija = new Button("Lisa m\u00e4ngija");
        Button hakkameMangima = new Button("Hakkame m\u00e4ngima");
        hakkameMangima.setOnAction(event -> {
            if (Mangijad.size() > 1) {
                Laud.getChildren().remove((Object)taustaRaam);
                this.Mangime();
            } else {
                System.out.println("Mangijaid peab olema rohkem kui 2");
            }
        }
        );
        lisaMangija.setOnAction(event -> {
            String mangijaNimi = mangijaNimeInput.getText();
            String nupuVarv = String.valueOf(nupuVarvid.getValue());
            if (mangijaNimi.length() > 0 && !nupuVarv.equals("null")) {
                System.out.println("Loome m\u00e4ngija nimega " + mangijaNimi);
                Mangijad.add(new Mangija(mangijaNimi, nupuVarv));
                mangijateList.add((Object)(mangijaNimi + " - " + nupuVarv));
                nimeKiri.setItems(mangijateList);
                nupuVarviList.remove((Object)nupuVarv);
                mangijaNimeInput.setText("");
            }
        }
        );
        AnchorPane taustaKihid = new AnchorPane();
        AnchorPane.setLeftAnchor((Node)mangijaSisestus, (Double)10.0);
        AnchorPane.setTopAnchor((Node)mangijaSisestus, (Double)10.0);
        mangijaSisestus.getChildren().addAll((Object[])new Node[]{MangijaInfo, lisaMangija, mangijateNimekiri, hakkameMangima});
        taustaKihid.getChildren().addAll((Object[])new Node[]{taust, mangijaSisestus});
        taustaRaam.getChildren().add((Object)taustaKihid);
        Laud.getChildren().addAll((Object[])new Node[]{taustaRaam});
    }

    private void LooManguPais() {
        Info = new Label("Tsirkuse M\u00e4ng");
        Info.setTextFill((Paint)Color.YELLOW);
        Info.setFont(Font.font((String)"Verdana", (double)25.0));
        Info.setTextAlignment(TextAlignment.JUSTIFY);
        Info.setMinHeight(100.0);
        Info.setPrefWidth(Double.MAX_VALUE);
        Info.setAlignment(Pos.CENTER);
        Info.setStyle("-fx-background-color: green");
        this.GameBoard.setTop((Node)Info);
    }

    private void LooManguJalus() {
        HBox nupud = new HBox();
        nupud.setPadding(new Insets(10.0));
        nupud.setSpacing(10.0);
        this.VeeretamisNupp = new Button();
        this.VeeretamisNupp.setText("Veereta T\u00e4ringut");
        this.VeeretamisNupp.setOnAction(event -> {
            Mangijad.get(MangijaNumber).veeretaTaringut();
            Info.setText(Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nimi + " saab k\u00e4ia edasi " + Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).sammudeArv + " sammu.");
            this.VeeretamisNupp.setDisable(true);
            this.LiikumisNupp.setDisable(false);
        }
        );
        this.LiikumisNupp = new Button("Liiguta Nuppu");
        this.LiikumisNupp.setOnAction(event -> {
            Mangijad.get(MangijaNumber).liigutaNuppuEdasi(Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).sammudeArv);
            if (Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).sammudeArv == 6) {
                Info.setText(Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nimi + " saab veel veeretada.");
                this.VeeretamisNupp.setDisable(false);
                this.LiikumisNupp.setDisable(true);
            } else {
                Info.setText(Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nimi + ", sinu k\u00e4igud said osta. J\u00e4rgmine m\u00e4ngija");
                this.JargmineMangija.setDisable(false);
                this.LiikumisNupp.setDisable(true);
            }
        }
        );
        this.JargmineMangija = new Button("J\u00e4rgmine m\u00e4ngija");
        this.JargmineMangija.setOnAction(event -> {
            if (MangijaNumber == Mangijad.size() - 1) {
                MangijaNumber = 0;
            } else {
                Integer n = MangijaNumber;
                Integer n2 = Lauamang.MangijaNumber = Integer.valueOf(MangijaNumber + 1);
            }
            if (Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nupuasukoht == 0) {
                Mangijad.get(MangijaNumber).liigutaNuppAlgusesse();
            }
            Info.setText(Lauamang.Mangijad.get((int)Lauamang.MangijaNumber.intValue()).nimi + ", sinu kord on veeretada t\u00e4ringut.");
            this.JargmineMangija.setDisable(true);
            this.VeeretamisNupp.setDisable(false);
        }
        );
        nupud.getChildren().addAll((Object[])new Node[]{this.VeeretamisNupp, this.LiikumisNupp, this.JargmineMangija});
        this.GameBoard.setBottom((Node)nupud);
    }

    private void LooManguValjak() {
        Laud = new StackPane();
        Laud.setStyle("-fx-background-color: brown;");
        this.GameBoard = new BorderPane();
        this.GameBoard.setMinSize(650.0, 600.0);
        Laud.getChildren().add((Object)this.GameBoard);
        Scene scene = new Scene((Parent)Laud);
        TsirkuseMang.setTitle("Tsirkus");
        TsirkuseMang.setScene(scene);
        TsirkuseMang.show();
        TsirkuseMang.setOnCloseRequest(event -> {
            System.exit(0);
        }
        );
    }

    private void LooVasakVali() {
        VBox VasakVali = new VBox();
        VasakVali.setSpacing(10.0);
        VasakVali.setPadding(new Insets(10.0));
        VasakVali.setMaxWidth(100.0);
        VasakVali.setMaxHeight(100.0);
        TaringuRuut = new Rectangle();
        TaringuRuut.setHeight(100.0);
        TaringuRuut.setWidth(100.0);
        NuppudeAla = new VBox();
        NuppudeAla.setSpacing(10.0);
        VasakVali.getChildren().addAll((Object[])new Node[]{TaringuRuut, NuppudeAla});
        this.GameBoard.setLeft((Node)VasakVali);
    }

    private void LooManguLaud() {
        this.ManguRuudustik = new GridPane();
        this.ManguRuudustik.setPrefSize(this.ManguLauaLaius, this.ManguLauaKorgus);
        this.ManguRuudustik.setGridLinesVisible(false);
        this.ManguRuudustik.setHgap(3.0);
        this.ManguRuudustik.setVgap(3.0);
        double ruuduLaius = (this.ManguLauaLaius - this.ManguRuudustik.getHgap() * 11.0) / 10.0;
        double ruuduKorgus = (this.ManguLauaKorgus - this.ManguRuudustik.getVgap() * 13.0) / (double)(ManguRuutudeArv / 10);
        int rida = ManguRuutudeArv / 10;
        int veerg = 1;
        boolean suundTagasi = false;
        for (int i = 1; i <= ManguRuutudeArv; ++i) {
            Lauamang.ManguRuudud[i - 1] = new StackPane();
            this.Ruut = new Rectangle(ruuduLaius, ruuduKorgus);
            this.Ruut.setOpacity(0.0);
            ManguRuudud[i - 1].getChildren().add((Object)this.Ruut);
            this.ManguRuudustik.add((Node)ManguRuudud[i - 1], veerg, rida);
            veerg = suundTagasi ? --veerg : ++veerg;
            if (i % 10 != 0) continue;
            --rida;
            if (!suundTagasi) {
                suundTagasi = true;
                --veerg;
                continue;
            }
            suundTagasi = false;
            ++veerg;
        }
        ImagePattern taust = new ImagePattern(new Image("pildid/laua-taust.png"));
        Rectangle ManguLauaTaust = new Rectangle(this.ManguLauaLaius, this.ManguLauaKorgus);
        ManguLauaTaust.setArcHeight(20.0);
        ManguLauaTaust.setArcWidth(20.0);
        ManguLauaTaust.setFill((Paint)taust);
        AnchorPane ManguLaud = new AnchorPane();
        ManguLaud.getChildren().addAll((Object[])new Node[]{ManguLauaTaust, this.ManguRuudustik});
        ManguLaud.setPadding(new Insets(10.0));
        AnchorPane.setTopAnchor((Node)ManguLauaTaust, (Double)10.0);
        AnchorPane.setTopAnchor((Node)this.ManguRuudustik, (Double)10.0);
        this.GameBoard.setRight((Node)ManguLaud);
        this.LooUssidJaRedelid();
    }

    private void LooUssidJaRedelid() {
        Redelid = new HashMap();
        Redelid.put(3, 37);
        Redelid.put(5, 15);
        Redelid.put(14, 34);
        Redelid.put(21, 42);
        Redelid.put(31, 50);
        Redelid.put(38, 43);
        Redelid.put(47, 92);
        Redelid.put(57, 66);
        Redelid.put(60, 81);
        Redelid.put(74, 86);
        Redelid.put(87, 108);
        Redelid.put(95, 115);
        Ussid = new HashMap();
        Ussid.put(20, 2);
        Ussid.put(30, 10);
        Ussid.put(35, 25);
        Ussid.put(48, 28);
        Ussid.put(55, 45);
        Ussid.put(70, 52);
        Ussid.put(85, 59);
        Ussid.put(103, 82);
        Ussid.put(109, 88);
        Ussid.put(113, 107);
        Ussid.put(117, 97);
        Ussid.put(119, 103);
    }

    static {
        ManguRuutudeArv = 120;
        ManguRuudud = new StackPane[ManguRuutudeArv.intValue()];
        Mangijad = new ArrayList();
        mangLabi = false;
    }
}

