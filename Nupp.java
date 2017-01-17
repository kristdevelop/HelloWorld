/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  javafx.collections.ObservableList
 *  javafx.scene.image.Image
 *  javafx.scene.layout.StackPane
 *  javafx.scene.layout.VBox
 *  javafx.scene.paint.ImagePattern
 *  javafx.scene.paint.Paint
 *  javafx.scene.shape.Rectangle
 */
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Nupp {
    private static Image kollane = new Image("pildid/kollane.gif");
    private static ImagePattern kollaseNupuPilt = new ImagePattern(kollane);
    private static Image punane = new Image("pildid/punane.gif");
    private static ImagePattern punaseNupuPilt = new ImagePattern(punane);
    private static Image roheline = new Image("pildid/roheline.gif");
    private static ImagePattern roheliseNupuPilt = new ImagePattern(roheline);
    private static Image sinine = new Image("pildid/sinine.gif");
    private static ImagePattern siniseNupuPilt = new ImagePattern(sinine);
    private static int nupuKorgus = 30;
    private static int nupuLaius = 20;
    String nupuVarv;
    Rectangle nupp;

    public Nupp(String varvus) {
        this.nupuVarv = varvus;
        this.looNupp(this.nupuVarv);
    }

    private Rectangle looNupp(String varv) {
        if (varv.toLowerCase().equals("punane")) {
            this.nupp = new Rectangle();
            this.nupp.setHeight((double)nupuKorgus);
            this.nupp.setWidth((double)nupuLaius);
            this.nupp.setFill((Paint)punaseNupuPilt);
            return this.nupp;
        }
        if (varv.toLowerCase().equals("kollane")) {
            this.nupp = new Rectangle();
            this.nupp.setHeight((double)nupuKorgus);
            this.nupp.setWidth((double)nupuLaius);
            this.nupp.setFill((Paint)kollaseNupuPilt);
            return this.nupp;
        }
        if (varv.toLowerCase().equals("roheline")) {
            this.nupp = new Rectangle();
            this.nupp.setHeight((double)nupuKorgus);
            this.nupp.setWidth((double)nupuLaius);
            this.nupp.setFill((Paint)roheliseNupuPilt);
            return this.nupp;
        }
        if (varv.toLowerCase().equals("sinine")) {
            this.nupp = new Rectangle();
            this.nupp.setHeight((double)nupuKorgus);
            this.nupp.setWidth((double)nupuLaius);
            this.nupp.setFill((Paint)siniseNupuPilt);
            return this.nupp;
        }
        return null;
    }

    public void mineRuudule(int ruuduNumber) {
        Lauamang.ManguRuudud[ruuduNumber - 1].getChildren().add((Object)this.nupp);
    }

    public void mineLauale() {
        Lauamang.NuppudeAla.getChildren().add((Object)this.nupp);
    }
}

