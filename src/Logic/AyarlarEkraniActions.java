/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Gui.AyarlarEkrani;
import Gui.KullaniciHesapEkrani;
import Gui.SifreYenilemeEkrani;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Emre
 */
public class AyarlarEkraniActions extends Actions {

    private DbTelNoYenileme dbTelNoYenileme = null;
    private boolean onaylaIcon = false; //telNoIcon'una tiklanip tiklanmadigini kontrol etmek icin
    private String yeniTelNo;

    public AyarlarEkraniActions(AyarlarEkrani ayarlarEkrani) {
        setAyarlarEkrani(ayarlarEkrani);
    }

    public void setAyarlarEkrani(AyarlarEkrani ayarlarEkrani) {
        this.ayarlarEkrani = ayarlarEkrani;
    }

    public DbTelNoYenileme getDbTelNoYenileme() {
        if (dbTelNoYenileme == null) {
            dbTelNoYenileme = new DbTelNoYenileme();
        }
        return dbTelNoYenileme;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        /*Geri Iconu*/
        if (sourceController().labelSource(ayarlarEkrani().getGeriLabel())) {
            ayarlarEkrani().getAyarlarEkraniFrame().setVisible(false);
            kullaniciHesapEkrani().getKullaniciHesapEkraniFrame().setVisible(true);
        }
        /**/
 /*Tel No Degistirme Iconu*/
        if (sourceController().labelSource(ayarlarEkrani().getTelNoDegistirIcon())) {
            if (!onaylaIcon) { //yani icon'a tiklanmamissa
                ayarlarEkrani().getTelNoText().setEditable(true);
                ayarlarEkrani().getTelNoDegistirIcon().setIcon(new ImageIcon(getClass().getResource("/Gui/Image/onaylaIcon.png")));
                this.onaylaIcon = true;
            } else {
                if (!telNoTextIsEmpty() && JTextFieldLimit.isMinLimit(ayarlarEkrani().getTelNoText())) { //eger telNoText bos degilse ve minLimit true ise                   
                    telNoYenile();
                    ayarlarEkrani().getTelNoText().setEditable(false);
                    ayarlarEkrani().getTelNoDegistirIcon().setIcon(new ImageIcon(getClass().getResource("/Gui/Image/degistirIcon.png")));
                    this.onaylaIcon = false;
                } else {
                    uyariMesajlari().uyariMesajiGoster(ayarlarEkrani().getAyarlarEkraniFrame(), "Telefon No 11 Haneli Olmalı!");
                }
            }
        }
        /**/
 /*Sifre Degistirme Iconu*/
        if (sourceController().labelSource(ayarlarEkrani().getSifreDegistirIcon())) {
            ayarlarEkrani().getAyarlarEkraniFrame().setVisible(false);
            SifreYenilemeEkrani sifreYenileme = new SifreYenilemeEkrani();
        }
        /**/
    }

    public boolean telNoTextIsEmpty() {
        return ayarlarEkrani().getTelNoText().getText().equals(""); //bos ise true donecek
    }

    public void telNoYenile() {
        yeniTelNo = ayarlarEkrani().getTelNoText().getText().trim();
        getDbTelNoYenileme().telNoYenile(this.yeniTelNo);
        Actions.getDataController().setTelNo(yeniTelNo);
        uyariMesajlari().uyariMesajiGoster(ayarlarEkrani().getAyarlarEkraniFrame(), "Telefon numaranız " + yeniTelNo + " olarak değiştirilmiştir");
    }
}
