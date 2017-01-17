/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  javafx.scene.image.Image
 *  javafx.scene.paint.ImagePattern
 *  javafx.scene.paint.Paint
 *  javafx.scene.shape.Rectangle
 */
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class taring {
    private static Image number1 = new Image("pildid/taring-1.png");
    private static ImagePattern taringNumber1 = new ImagePattern(number1);
    private static Image number2 = new Image("pildid/taring-2.png");
    private static ImagePattern taringNumber2 = new ImagePattern(number2);
    private static Image number3 = new Image("pildid/taring-3.png");
    private static ImagePattern taringNumber3 = new ImagePattern(number3);
    private static Image number4 = new Image("pildid/taring-4.png");
    private static ImagePattern taringNumber4 = new ImagePattern(number4);
    private static Image number5 = new Image("pildid/taring-5.png");
    private static ImagePattern taringNumber5 = new ImagePattern(number5);
    private static Image number6 = new Image("pildid/taring-6.png");
    private static ImagePattern taringNumber6 = new ImagePattern(number6);

    public taring() {
        taring.kujutaTaringut(taring.RandomTaringuNumber());
    }

    private static int RandomTaringuNumber() {
        return (int)(Math.random() * 6.0) + 1;
    }

    private static void kujutaTaringut(int taringuNumber) {
        switch (taringuNumber) {
            case 1: {
                Lauamang.TaringuRuut.setFill((Paint)taringNumber1);
                break;
            }
            case 2: {
                Lauamang.TaringuRuut.setFill((Paint)taringNumber2);
                break;
            }
            case 3: {
                Lauamang.TaringuRuut.setFill((Paint)taringNumber3);
                break;
            }
            case 4: {
                Lauamang.TaringuRuut.setFill((Paint)taringNumber4);
                break;
            }
            case 5: {
                Lauamang.TaringuRuut.setFill((Paint)taringNumber5);
                break;
            }
            case 6: {
                Lauamang.TaringuRuut.setFill((Paint)taringNumber6);
            }
        }
    }

    public static int veere() {
        int taringuNumber = taring.RandomTaringuNumber();
        taring.kujutaTaringut(taringuNumber);
        return taringuNumber;
    }
}

