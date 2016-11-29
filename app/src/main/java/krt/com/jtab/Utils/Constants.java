package krt.com.jtab.Utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import krt.com.jtab.Models.ArtistModel;
import krt.com.jtab.Models.SongModel;

/**
 * Created by bryden on 11/27/16.
 */

public class Constants {
    public static List<SongModel> listSongs;
    public static List<ArtistModel> listArtists;
    public static void initData()
    {
        SongModel model1, model2, model3, model4, model5, model6, model7, model8, model9, model10, model11,
                model12, model13, model14, model15, model16, model17, model18, model19, model20, model21, model22,
                model23, model24, model25, model26, model27, model28, model29, model30, model31, model32, model33,
                model34, model35, model36, model37, model38, model39, model40, model41, model42, model43, model44;
        listSongs = new ArrayList<>();
        listArtists = new ArrayList<>();
        ArtistModel artistModel = new ArtistModel("Abie Rotenberg", "abierotenberg");
        model1 = new SongModel("Acheinu", "acheinuabierotenberg");
        model1.setArtistModel(artistModel);
       ;//, new SongModel[]{model});
        artistModel.setArraySong(new SongModel[] {model1});
        listSongs.add(model1);
        listArtists.add(artistModel);
        artistModel = new ArtistModel("Baruch Levine", "baruchlevine");
        model1 = new SongModel("Lecha Dodi", "lechadodibaruchlevine");
        model2 = new SongModel("Vehu Keili", "vehukeili");
        model3 = new SongModel("Vizakeini", "vizakeini");
        model1.setArtistModel(artistModel);
        model2.setArtistModel(artistModel);
        model3.setArtistModel(artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2, model3});
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
//        listSongs.add(model1);

        listArtists.add(artistModel);
        artistModel =  new ArtistModel("Belz", "belz");
        model1 = new SongModel("Ein Aroch Lecha", "einarochlecha");
        artistModel.setArraySong(new SongModel[]{model1});
        model1.setArtistModel(artistModel);
        listArtists.add(artistModel);
        listSongs.add(model1);


        artistModel = new ArtistModel("Benny Friedman", "bennyfriedman");
        model1 = new SongModel("B’sheim Hashem", "bsheimhashembennyfriedman");
        model2 = new SongModel("Yesh Tikvah", "yeshtikvah");
        model1.setArtistModel(artistModel);
        model2.setArtistModel(artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2});
        listSongs.add(model1);
        listSongs.add(model2);
        listArtists.add(artistModel);
        artistModel = new ArtistModel("Breslov", "breslov");
        model1 = new SongModel("Oz Vehadar", "ozvehadar");
        model1.setArtistModel(artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);


        artistModel = new ArtistModel("Chabad", "chabad");
        model1 = new SongModel("Anim Zemiros", "animzemiros");
        model2 = new SongModel("Chabadsker Niggun", "chabadskerniggun");
        model3 = new SongModel("Keli Ata", "keliata");
        model4 = new SongModel("Utzu Eitza", "utzueitza");
        model5 = new SongModel("Yifrach", "yifrach");
        model1.setArtistModel(artistModel);
        model2.setArtistModel(artistModel);
        model3.setArtistModel(artistModel);
        model4.setArtistModel(artistModel);
        model5.setArtistModel(artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2, model3, model4, model5});
        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);
        listSongs.add(model5);

        artistModel = new ArtistModel("The Chevra", "thechevra");
        model1 = new SongModel("Odcha", "odchathechevra");
        model2 = new SongModel("Shema", "shemathechevra");
        model1.setArtistModel(artistModel);
        model2.setArtistModel(artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2});
        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);

        artistModel = new ArtistModel("D'veykus", "dveykus");
        model1 = new SongModel("Haben Yakir Li", "habenyakirli");
        model2 = new SongModel("Lev Tahor", "levtahor");
        model3 = new SongModel("Na’ar Hayiti", "naarhayiti");
        model4 = new SongModel("Shema Koleinu", "shemakoleinu");
        model1.setArtistModel(artistModel);
        model2.setArtistModel(artistModel);
        model3.setArtistModel(artistModel);
        model4.setArtistModel(artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2, model3, model4});
        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);

        artistModel = new ArtistModel("Eitan Katz", "eitankatz");
        model1 = new SongModel("Ani L’dodi", "anildodi", artistModel);
        model2 = new SongModel("Boruch Hu", "boruchhu", artistModel);
        model3 = new SongModel("Dminor Niggun", "dminorniggun", artistModel);
        model4 = new SongModel("Elul Nigun", "elulnigun", artistModel);
        model5 = new SongModel("Kol Atzmosai", "kolatzmosai", artistModel);
        model6 = new SongModel("L’maancha", "lmaancha", artistModel);
        model7 = new SongModel("Nigun", "nigun", artistModel);
        model8 = new SongModel("Od Yishama", "odyishamaeitankatz", artistModel);
        model9 = new SongModel("Ye’erav Na", "yeeravna", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2
        , model3, model4, model5, model6, model7, model8, model9});
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);
        listSongs.add(model5);
        listSongs.add(model6);
        listSongs.add(model7);
        listSongs.add(model8);
        listSongs.add(model9);
        listArtists.add(artistModel);

        artistModel = new ArtistModel("Eitan Katz (Shlomo Carlebach)", "eitankatzshlomocarlebach");
        model1 = new SongModel("Al Tira", "altira", artistModel);
        model2 = new SongModel("Ani Ma’amin", "animaamineitankatzshlomocarlebach", artistModel);
        model3 = new SongModel("Asher Bara", "asherbaraeitankatzshlomocarlebach", artistModel);
        model4 = new SongModel("Barcheinu Avinu", "barcheinuavinu", artistModel);
        model5 = new SongModel("Bo’ee B’shalom", "boeebshalom", artistModel);
        model6 = new SongModel("Licha Ezbach", "lichaezbach", artistModel);
        model7 = new SongModel("Niggun Neshama", "niggunneshama", artistModel);
        model8 = new SongModel("Odcha", "odchaeitankatzshlomocarlebach", artistModel);
        model9 = new SongModel("Shomer Yisroel", "shomeryisroeleitankatzshlomocarlebach", artistModel);
        model10 = new SongModel("Yisborach Shimcha", "yisborachshimcha", artistModel);
        artistModel.setArraySong(new SongModel[]{
                model1, model2,
        model3, model4,
        model5, model6,
        model7, model8,
        model9, model10});
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);
        listSongs.add(model5);
        listSongs.add(model6);
        listSongs.add(model7);
        listSongs.add(model8);
        listSongs.add(model9);
        listSongs.add(model10);
        listArtists.add(artistModel);



        artistModel = new ArtistModel("Gad Elbaz", "gadelbaz");
        model1 = new SongModel("Hashem Melech", "hashemmelech", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listSongs.add(model1);
        listArtists.add(artistModel);

        artistModel = new ArtistModel("Kol B'seder", "kolbseder");
        model1 = new SongModel("Lo Alecha", "loalecha", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listSongs.add(model1);
        listArtists.add(artistModel);

        artistModel = new ArtistModel("Lev Tahor", "levtahor");
        model1 = new SongModel("U’vnei Yerushalayim", "uvneiyerushalayimlevtahor", artistModel);
        model2 = new SongModel("Yedid Nefesh", "yedidnefesh", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2});
        listSongs.add(model1);listSongs.add(model2); listArtists.add(artistModel);

        artistModel = new ArtistModel("Miami Boys Choir", "miamiboyschoir");
        model1 = new SongModel("Ya’aleh Viyavo", "yaalehviyavo", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Mordechai Shapiro", "mordechaishapiro");
        model1 = new SongModel("Ani Ma’amin", "animaaminmordechaishapiro", artistModel);
        model2 = new SongModel("Chizku", "chizku", artistModel);
        model3 = new SongModel("Kol Haderech", "kolhaderech", artistModel);
        model4 = new SongModel("Schar Mitzvah", "scharmitzvah", artistModel);
        model5 = new SongModel("Shir Hamaalot", "shirhamaalot", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2, model3, model4, model5});
        listArtists.add(artistModel);
        listSongs.add(model1); listSongs.add(model2); listSongs.add(model3);
        listSongs.add(model4); listSongs.add(model5);


        artistModel = new ArtistModel("Debbie Friedman", "debbiefriedman");
        model1 = new SongModel("Havdalah", "havdalah", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Moshav Band", "moshavband");
        model1 = new SongModel("Eliyahu Hanavi", "eliyahuhanavi", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Nachman", "nachman");
        model1 = new SongModel("Amar Rabi Akiva", "amarrabiakiva", artistModel);
        model2 = new SongModel("Ashreinu Ashreinu Ashreinu", "ashreinuashreinuashreinu", artistModel);
        model3 = new SongModel("Ata Bichartanu", "atabichartanu", artistModel);
        model4 = new SongModel("Ashreinu Ma Tov Chelkeinu", "ashreinumatovchelkeinu", artistModel);
        model5 = new SongModel("Ever Kayona", "everkayona", artistModel);
        model6 = new SongModel("Rabbeinu Tzaak", "rabbeinutzaak", artistModel);
        model7 = new SongModel("Shir Hagiulah", "shirhagiulah", artistModel);
        model8 = new SongModel("Slichot", "slichot", artistModel);
        model9 = new SongModel("Uman Rosh Hashana Sheli (Ki Hirbaisa)", "umanroshhashanashelikihirbaisa", artistModel);
        model10 = new SongModel("Uvichen Tzadikim", "uvichentzadikimnachman", artistModel);
        model11 = new SongModel("Viamartem Ko Lechi", "viamartemkolechi", artistModel);

        artistModel.setArraySong(new SongModel[]{model1,
        model2, model3, model4, model5, model6,
                model7, model8, model9, model10, model11});
        listArtists.add(artistModel);
        listSongs.add(model1); listSongs.add(model2);listSongs.add(model3); listSongs.add(model4);listSongs.add(model5);
        listSongs.add(model6); listSongs.add(model7);listSongs.add(model8);listSongs.add(model9);listSongs.add(model10);
        listSongs.add(model11);

        artistModel = new ArtistModel("Ohad", "ohad");
        model1 = new SongModel("Birchas Habayis", "birchashabayis", artistModel);
        model2 = new SongModel("Birchos Habonim", "birchoshabonim", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2});
        listSongs.add(model1); listArtists.add(artistModel); listSongs.add(model2);

        artistModel = new ArtistModel("Omek Hadavar", "omekhadavar");
        model1 = new SongModel("Shomer Yisroel", "shomeryisroelomekhadavar", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listSongs.add(model1);
        listArtists.add(artistModel);

        artistModel = new ArtistModel("Rav Hutner", "ravhutner");
        model1 = new SongModel("Vihaviosim", "vihaviosim", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Rav Shalom Arush", "ravshalomarush");
        model1 = new SongModel("Ma Shehaya Haya", "mashehayahaya", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Rav Shmuel Brazil", "ravshmuelbrazil");
        model1 = new SongModel("Kichu", "kichu", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Rebbe Levi Yitzchak", "rebbeleviyitzchak");
        model1 = new SongModel("Berdichever Niggun", "berdicheverniggun", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Shlomo Carlebach", "shlomocarlebach");
        model1 = new SongModel("Am Yisroel Chai", "amyisroelchai", artistModel);
        model2 = new SongModel("Ana Hashem", "anahashemshlomocarlebach", artistModel);
        model3 = new SongModel("B’sheim Hashem", "bsheimhashemshlomocarlebach", artistModel);
        model4 = new SongModel("Dovid Melech", "dovidmelech", artistModel);
        model5 = new SongModel("Elecha", "elecha", artistModel);
        model6 = new SongModel("Esa Einai", "esaeinaishlomocarlebach", artistModel);
        model7 = new SongModel("Hamavir Banav", "hamavirbanav", artistModel);
        model8 = new SongModel("Harachaman Hu Yizakeinu", "harachamanhuyizakeinu", artistModel);
        model9 = new SongModel("Hashem Oz", "hashemoz", artistModel);
        model10 = new SongModel("Hashiveinu", "hashiveinushlomocarlebach", artistModel);
        model11 = new SongModel("Im Eshkachech", "imeshkachechshlomocarlebach", artistModel);
        model12 = new SongModel("Ki Mitzion", "kimitzionshlomocarlebach", artistModel);
        model13 = new SongModel("Ki Va Moed", "kivamoed", artistModel);
        model14 = new SongModel("Kol Ha’olam Kulo", "kolhaolamkulo", artistModel);
        model15 = new SongModel("Krakow Niggun", "krakowniggun", artistModel);
        model16 = new SongModel("L’maan Achai", "lmaanachai", artistModel);
        model17 = new SongModel("Lecha Dodi", "lechadodishlomocarlebach", artistModel);
        model18 = new SongModel("Leshana Haba", "leshanahaba", artistModel);
        model19 = new SongModel("Lo Tevoshi", "lotevoshi", artistModel);
        model20 = new SongModel("Meheira", "meheirashlomocarlebach", artistModel);
        model21 = new SongModel("Mekimi", "mekimi", artistModel);
        model22 = new SongModel("Mimkomcha", "mimkomcha", artistModel);
        model23 = new SongModel("Mimkomcha (V’shamru)", "mimkomchavshamru", artistModel);
        model24 = new SongModel("Od Yishama", "odyishamashlomocarlebach", artistModel);
        model25 = new SongModel("Odcha", "odchashlomocarlebach", artistModel);
        model26 = new SongModel("Oseh Shalom", "osehshalom", artistModel);
        model27 = new SongModel("Pischu Li", "pischulishlomocarlebach", artistModel);
        model28 = new SongModel("Shalom Aleichem", "shalomaleichem", artistModel);
        model29 = new SongModel("Shifchi Kamayim", "shifchikamayim", artistModel);
        model30 = new SongModel("Shomrim", "shomrim", artistModel);
        model31 = new SongModel("Simcha Le’artzecha", "simchaleartzecha", artistModel);
        model32 = new SongModel("Tov Lehodot", "simchaleartzecha", artistModel);
        model33 = new SongModel("U’vnei Yerushalayim", "uvneiyerushalayimshlomocarlebach", artistModel);
        model34 = new SongModel("Uvau Haovdim", "uvauhaovdim", artistModel);
        model35 = new SongModel("V’lirushalayim", "vlirushalayim", artistModel);
        model36 = new SongModel("V’shamru (Mimkomcha)", "vshamrumimkomcha", artistModel);
        model37 = new SongModel("Vehoair Eineinu", "vehoaireineinu", artistModel);
        model38 = new SongModel("Vinisgav", "vinisgav", artistModel);
        model39 = new SongModel("Yehi Shalom Bichelech", "vinisgav", artistModel);
        model40 = new SongModel("Vinisgav", "yehishalombichelech", artistModel);
        model41 = new SongModel("Yibaneh", "yibaneh", artistModel);
        model42 = new SongModel("Yibaneh Hamikdash", "yibanehhamikdash", artistModel);


        artistModel.setArraySong(new SongModel[]{model1, model2, model3, model4, model5, model6, model7, model8, model9, model10, model11,
                model12, model13, model14, model15, model16, model17, model18, model19, model20, model21, model22,
                model23, model24, model25, model26, model27, model28, model29, model30, model31, model32, model33,
                model34, model35, model36, model37, model38, model39, model40, model41, model42});

        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);
        listSongs.add(model5);
        listSongs.add(model6);
        listSongs.add(model7);
        listSongs.add(model8);
        listSongs.add(model9);
        listSongs.add(model10);
        listSongs.add(model11);
        listSongs.add(model12);
        listSongs.add(model13);
        listSongs.add(model14);
        listSongs.add(model15);
        listSongs.add(model16);
        listSongs.add(model17);
        listSongs.add(model18);
        listSongs.add(model19);
        listSongs.add(model20);
        listSongs.add(model21);
        listSongs.add(model22);
        listSongs.add(model23);
        listSongs.add(model24);
        listSongs.add(model25);
        listSongs.add(model26);
        listSongs.add(model27);
        listSongs.add(model28);
        listSongs.add(model29);
        listSongs.add(model30);
        listSongs.add(model31);
        listSongs.add(model32);
        listSongs.add(model33);
        listSongs.add(model34);
        listSongs.add(model35);
        listSongs.add(model36);
        listSongs.add(model37);
        listSongs.add(model38);
        listSongs.add(model39);
        listSongs.add(model40);
        listSongs.add(model41);
        listSongs.add(model42);


        artistModel = new ArtistModel("Shlomo Katz", "shlomokatz");
        model1 = new SongModel("Niggun Nevo", "niggunnevo", artistModel);
        model2 = new SongModel("Yismichu", "yismichu", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2});
        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);

        artistModel = new ArtistModel("Simcha Leiner", "simchaleiner");
        model1 = new SongModel("Kol Berama", "kolberama", artistModel);
        model2 = new SongModel("Pischi Li", "pischili", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2});
        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);

        artistModel = new ArtistModel("Six13", "six13");
        model1 = new SongModel("Al Hanissim", "alhanissimsix13", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Traditional", "traditional");
        model1 = new SongModel("Ach Tov Vachesed", "achtovvachesed", artistModel);
        model2 = new SongModel("Ahalelu", "ahalelu", artistModel);
        model3 = new SongModel("Al Hanissim", "alhanissimtraditional", artistModel);
        model4 = new SongModel("Ani Ma’amin", "animaamintraditional", artistModel);
        model5 = new SongModel("Asher Bara", "asherbaratraditional", artistModel);
        model6 = new SongModel("Baruch Hagever", "baruchhagever", artistModel);
        model7 = new SongModel("Esa Einai", "esaeinaitraditional", artistModel);
        model8 = new SongModel("Etz Chaim", "etzchaim", artistModel);
        model9 = new SongModel("Hamalach Hago’el Oti", "hamalachhagoeloti", artistModel);
        model10 = new SongModel("Hatikvah", "hatikvah", artistModel);
        model11 = new SongModel("Hoshiah Et Amecha", "hoshiahetamecha", artistModel);
        model12 = new SongModel("Im Eshkachech", "imeshkachechtraditional", artistModel);
        model13 = new SongModel("Ivdu", "ivdu", artistModel);
        model14 = new SongModel("Kah Echsof", "kahechsof", artistModel);
        model15 = new SongModel("Keitzad Mirakdim", "keitzadmirakdim", artistModel);
        model17 = new SongModel("Ki Hirbaisa (Uman Rosh Hashana Sheli)", "kihirbaisaumanroshhashanasheli", artistModel);
        model18 = new SongModel("Ki Mitzion", "kimitziontraditional", artistModel);
        model19 = new SongModel("Layihudim Layihudim Hayta Ora", "layihudimlayihudimhaytaora", artistModel);
        model20 = new SongModel("Lev Tahor Bira Lee", "levtahorbiralee", artistModel);
        model22 = new SongModel("Ma’aminim", "maaminim", artistModel);
        model23 = new SongModel("Maoz Tzur", "maoztzur", artistModel);
        model24 = new SongModel("Mishe Nichnas Adar Marbim Bisimcha", "mishenichnasadarmarbimbisimcha", artistModel);
        model25 = new SongModel("Od Yavo Shalom", "odyavoshalom", artistModel);
        model26 = new SongModel("Od Yishama", "odyishamatraditional", artistModel);
        model27 = new SongModel("Shoshanat Yaakov", "shoshanatyaakov", artistModel);
        model28 = new SongModel("Siman Tov", "simantov", artistModel);
        model29 = new SongModel("Siman Tov (Dovid Melech)", "simantovumazaltov", artistModel);
        model30 = new SongModel("Siu Shiarim", "siushiarim", artistModel);
        model31 = new SongModel("Toras Hashem Temima", "torashashemtemima", artistModel);
        model32 = new SongModel("Tov Lehodot", "tovlehodottraditional", artistModel);
        model33 = new SongModel("Uvichen Tzadikim", "uvichentzadikimtraditional", artistModel);
        model34 = new SongModel("Vayehi Bishurun Melech", "vayehibishurunmelech", artistModel);
        model35 = new SongModel("Veyiyu Rachamecha", "veyiyurachamecha", artistModel);
        model36 = new SongModel("Visamachta Bichagecha", "visamachtabichagecha", artistModel);
        model37 = new SongModel("Vitahair Libeinu", "vitahairlibeinu", artistModel);
        model38 = new SongModel("Viyazor Viyagen", "viyazorviyagen", artistModel);
        model39 = new SongModel("Yachad", "yachad", artistModel);
        model40 = new SongModel("Yasis Alayich Elokayich", "yasisalayichelokayich", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2, model3, model4, model5, model6, model7, model8, model9, model10, model11,
                model12, model13, model14, model15, model17, model18, model19, model20, model22,
                model23, model24, model25, model26, model27, model28, model29, model30, model31, model32, model33,
                model34, model35, model36, model37, model38, model39, model40});

        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);
        listSongs.add(model5);
        listSongs.add(model6);
        listSongs.add(model7);
        listSongs.add(model8);
        listSongs.add(model9);
        listSongs.add(model10);
        listSongs.add(model11);
        listSongs.add(model12);
        listSongs.add(model13);
        listSongs.add(model14);
        listSongs.add(model15);
        listSongs.add(model17);
        listSongs.add(model18);
        listSongs.add(model19);
        listSongs.add(model20);
        listSongs.add(model22);
        listSongs.add(model23);
        listSongs.add(model24);
        listSongs.add(model25);
        listSongs.add(model26);
        listSongs.add(model27);
        listSongs.add(model28);
        listSongs.add(model29);
        listSongs.add(model30);
        listSongs.add(model31);
        listSongs.add(model32);
        listSongs.add(model33);
        listSongs.add(model34);
        listSongs.add(model35);
        listSongs.add(model36);
        listSongs.add(model37);
        listSongs.add(model38);
        listSongs.add(model39);
        listSongs.add(model40);

        artistModel = new ArtistModel("Viznitz", "viznitz");
        model1 = new SongModel("Tzama Lecha Nafshi", "tzamalechanafshi", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Yaakov Shwekey", "yaakovshwekey");
        model1 = new SongModel("Am Yisrael", "amyisrael", artistModel);
        model2 = new SongModel("Boee Beshalom", "boeebeshalom", artistModel);
        model3 = new SongModel("Eishes Chayil", "eisheschayil", artistModel);
        model4 = new SongModel("Im Eshkachech", "imeshkachechyaakovshwekey", artistModel);
        model5 = new SongModel("Meheira", "meheirayaakovshwekey", artistModel);
        model6 = new SongModel("Mi Adir", "miadir", artistModel);
        model7 = new SongModel("Mi Bon Siach", "mibonsiach", artistModel);
        model8 = new SongModel("Rachem", "rachem", artistModel);
        model9 = new SongModel("Shema", "shemayaakovshwekey", artistModel);
        model10 = new SongModel("Vehi Sheomda", "vehisheomda", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2, model3, model4, model5, model6, model7, model8, model9, model10});
        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);
        listSongs.add(model5);
        listSongs.add(model6);
        listSongs.add(model7);
        listSongs.add(model8);
        listSongs.add(model9);
        listSongs.add(model10);

        artistModel = new ArtistModel("Yeedle", "yeedle");
        model1 = new SongModel("Shiru Lamelech", "shirulamelech", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Yehuda Green", "yehudagreen");
        model1 = new SongModel("Hashiveinu", "hashiveinuyehudagreen", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Yehuda!", "yehuda");
        model1 = new SongModel("Acheinu", "acheinuyehuda", artistModel);
        model2 = new SongModel("Mi Bon", "mibon", artistModel);
        model3 = new SongModel("Vehoair", "vehoair", artistModel);
        artistModel.setArraySong(new SongModel[]{model1, model2, model3});
        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);


        artistModel = new ArtistModel("Yitzchak Fuchs", "yitzchakfuchs");
        model1 = new SongModel("Lashem Ha’aretz", "lashemhaaretz", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Yoeli Klein", "yoeliklein");
        model1 = new SongModel("Viafilu", "viafilu", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);


        artistModel = new ArtistModel("Yosef Karduner", "yosefkarduner");
        model1 = new SongModel("Shir Lamaalot", "shirlamaalot", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Yossi Green", "yossigreen");
        model1 = new SongModel("Anavim Anavim", "anavimanavim", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);

        artistModel = new ArtistModel("Zusha", "zusha");
        model1 = new SongModel("Ana Hashem", "anahashemzusha", artistModel);
        model2 = new SongModel("Beis", "beis", artistModel);
        model3 = new SongModel("Binyan Ariel", "binyanariel", artistModel);
        model4 = new SongModel("Child", "child", artistModel);
        model5 = new SongModel("Dov Bear", "dovbear", artistModel);
        model6 = new SongModel("East Shtetl", "eastshtetl", artistModel);
        model7 = new SongModel("Festival", "festival", artistModel);
        model8 = new SongModel("Forever", "forever", artistModel);
        model9 = new SongModel("Hamavdil", "hamavdil", artistModel);
        model10 = new SongModel("Ikvisa", "ikvisa", artistModel);
        model11 = new SongModel("Lishem Yichud", "lishemyichud", artistModel);
        model12 = new SongModel("Mashiach", "mashiach", artistModel);
        model13 = new SongModel("Pashut", "pashut", artistModel);
        model14 = new SongModel("Peace", "peace", artistModel);
        model15 = new SongModel("Pischu Li", "pischulizusha", artistModel);
        model16 = new SongModel("Question", "question", artistModel);
        model17 = new SongModel("Shuva", "shuva", artistModel);
        model18 = new SongModel("Tzion", "tzion", artistModel);
        model19 = new SongModel("V’shamru", "vshamru", artistModel);
        model20 = new SongModel("Yisgadal", "yisgadal", artistModel);
        model21 = new SongModel("Yoel's Niggun", "yoelsniggun", artistModel);

        artistModel.setArraySong(new SongModel[]{model1, model2, model3, model4, model5, model6, model7, model8, model9, model10, model11,
                model12, model13, model14, model15, model16, model17, model18, model19, model20, model21});

        listArtists.add(artistModel);
        listSongs.add(model1);
        listSongs.add(model2);
        listSongs.add(model3);
        listSongs.add(model4);
        listSongs.add(model5);
        listSongs.add(model6);
        listSongs.add(model7);
        listSongs.add(model8);
        listSongs.add(model9);
        listSongs.add(model10);
        listSongs.add(model11);
        listSongs.add(model12);
        listSongs.add(model13);
        listSongs.add(model14);
        listSongs.add(model15);
        listSongs.add(model16);
        listSongs.add(model17);
        listSongs.add(model18);
        listSongs.add(model19);
        listSongs.add(model20);
        listSongs.add(model21);

        artistModel = new ArtistModel("Zusha & C Lanzbom", "zushaclanzbom");
        model1 = new SongModel("Brother", "brother", artistModel);
        artistModel.setArraySong(new SongModel[]{model1});
        listArtists.add(artistModel);
        listSongs.add(model1);
    }
  public static Bitmap getBitmapFromAsset(Context context, String strName)
  {
      String imgPath =  strName + ".jpg";
      Log.d("image", imgPath);
      AssetManager assetManager = context.getAssets();
      InputStream istr = null;
      try {
         istr = assetManager.open(imgPath);
      } catch (IOException e) {
          e.printStackTrace();
      }
      Bitmap bitmap = BitmapFactory.decodeStream(istr);
      return bitmap;
  }

}
