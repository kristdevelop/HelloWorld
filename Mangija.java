/*
 * Decompiled with CFR 0_118.
 */
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Mangija {
    String nimi;
    String nupuVarv;
    private Nupp manguNupp;
    public Integer sammudeArv = 0;
    public Integer nupuasukoht = 0;

    public Mangija(String mangijaNimi, String varvus) {
        this.nimi = mangijaNimi;
        this.nupuVarv = varvus;
        this.manguNupp = new Nupp(this.nupuVarv);
        this.manguNupp.mineLauale();
    }

    public void veeretaTaringut() {
        this.sammudeArv = taring.veere();
    }

    public void liigutaNuppuEdasi(int kaikudearv) {
        this.nupuasukoht = this.nupuasukoht + kaikudearv;
        this.nupuasukoht = this.kasManguruudulOnTakistusi(this.nupuasukoht);
        if (this.nupuasukoht > Lauamang.ManguRuutudeArv) {
            this.manguNupp.mineRuudule(Lauamang.ManguRuutudeArv);
            this.nupuasukoht = Lauamang.ManguRuutudeArv - (this.nupuasukoht - Lauamang.ManguRuutudeArv);
            this.nupuasukoht = this.kasManguruudulOnTakistusi(this.nupuasukoht);
            this.manguNupp.mineRuudule(this.nupuasukoht);
        } else if (this.nupuasukoht == Lauamang.ManguRuutudeArv) {
            this.manguNupp.mineRuudule(this.nupuasukoht);
            Lauamang.mangSaiLabi();
            System.out.println("Mang sai l\u00e4bi");
        } else {
            this.manguNupp.mineRuudule(this.nupuasukoht);
        }
    }

    private Integer kasManguruudulOnTakistusi(Integer nupuasukoht) {
        int uusNupuAsukoht = nupuasukoht;
        if (Lauamang.Redelid.containsKey(nupuasukoht)) {
            uusNupuAsukoht = Lauamang.Redelid.get(nupuasukoht);
            return uusNupuAsukoht;
        }
        if (Lauamang.Ussid.containsKey(nupuasukoht)) {
            uusNupuAsukoht = Lauamang.Ussid.get(nupuasukoht);
            return uusNupuAsukoht;
        }
        for (int i = 0; i < Lauamang.Mangijad.size(); ++i) {
            if (Lauamang.Mangijad.get((int)i).nupuasukoht == nupuasukoht && !this.nupuVarv.equals(Lauamang.Mangijad.get((int)i).nupuVarv)) {
                --uusNupuAsukoht;
                continue;
            }
            if (nupuasukoht == 1) break;
        }
        return uusNupuAsukoht;
    }

    public void liigutaNuppAlgusesse() {
        this.nupuasukoht = 1;
        this.manguNupp.mineRuudule(this.nupuasukoht);
    }
}

