package com.tiunida.laundry0.ActivityOrder.biasa.Interactor;

import com.tiunida.laundry0.ActivityOrder.biasa.Model.BiasaRepository;
import com.tiunida.laundry0.ActivityOrder.biasa.Model.BiasaRepositoryMvp;

public class BiasaInteractor implements BiasaInteractorMvp {
    private BiasaRepositoryMvp mOrderRepositoryMvp;
    public BiasaInteractor(){
        mOrderRepositoryMvp = new BiasaRepository();
    }

    @Override
    public void getAkadData() {
        mOrderRepositoryMvp.getAkadData();
    }

    @Override
    public void getProfileData() {
        mOrderRepositoryMvp.getProfileData();
    }

    @Override
    public void doInputs(String desc, String time, String uniqId, String timeDone, String bandana, String topi, String masker, String kupluk, String krudung, String peci, String lainLainHead, String kaos, String kaos_dalam, String kemeja, String baju_muslim, String jaket, String sweter, String gamis, String handuk, String lainLainBody, String sarung_tangan, String sapu_tangan, String lainLainHand, String celana, String celana_dalam, String celana_pendek, String sarung, String celana_olahraga, String rok, String celana_levis, String kaos_kaki, String lainLainFeet, String jas_almamater, String jas, String selimut_kecil, String selimut_besar, String bag_cover, String gordeng_kecil, String gordeng_besar, String sepatu, String bantal,
                         String tas_kecil, String tas_besar, String sprei_kecil, String sprei_besar) {
        mOrderRepositoryMvp.storeFirestore(desc, time, uniqId, timeDone, bandana, topi, masker, kupluk, krudung, peci, lainLainHead, kaos, kaos_dalam, kemeja, baju_muslim, jaket, sweter, gamis, handuk, lainLainBody, sarung_tangan, sapu_tangan, lainLainHand, celana, celana_dalam, celana_pendek, sarung, celana_olahraga, rok, celana_levis, kaos_kaki, lainLainFeet, jas_almamater, jas, selimut_kecil, selimut_besar, bag_cover, gordeng_kecil, gordeng_besar, sepatu, bantal, tas_kecil, tas_besar, sprei_kecil, sprei_besar);
    }
}
