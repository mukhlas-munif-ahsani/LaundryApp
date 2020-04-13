package com.tiunida.laundry0.ActivityOrderDetail.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.tiunida.laundry0.EventBus.EventBus;
import com.tiunida.laundry0.EventBus.GreenRobotEventBus;
import com.tiunida.laundry0.ActivityOrderDetail.events.OrderDetailEvents;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class OrderDetailRepository implements OrderDetailReposritoryMvp {
    private StorageReference storageReference;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;
    private String user_id;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String mNowTime;

    public OrderDetailRepository() {
        storageReference = FirebaseStorage.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        mFirestore = FirebaseFirestore.getInstance();
    }

    @Override
    public void getUserData() {
        mFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    Log.d("repo onComplete suc:", "masuk");

                    if (task.getResult().exists()) {
                        String room = task.getResult().getString("3 room");
                        String dormitory = task.getResult().getString("2 dormitory");
                        String test = task.getResult().getString("done");

                        Log.d("dona data ", "" + test);

                        //postEvent(OrderDetailEvents.onGetDataSuccess, null, dormitory, room);
                    }
                } else {
                    String errorMessage = task.getException().getMessage();
                    postEvent(OrderDetailEvents.onGetDataError, errorMessage);
                }
            }
        });
    }

    public void getNowTime() {
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("EEE, d MMM, yyyy '|' HH:mm:ss");
        mNowTime = dateFormat.format(calendar.getTime());
    }

    @Override
    public void updatePaid(String order_id) {
        Map<String, Object> userMap2 = new HashMap<>();
        userMap2.put("h_paid2", "1");

        getNowTime();

        Map<String, Object> notificationsMessage = new HashMap<>();
        notificationsMessage.put("order_id", order_id);
        notificationsMessage.put("message_name", "Weighted");
        notificationsMessage.put("message", "Konfirmasi telah dibayar");
        notificationsMessage.put("from", user_id);
        notificationsMessage.put("notif_time", mNowTime);

        mFirestore.collection("Orders").document(order_id).update(userMap2).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mFirestore.collection("Orders").document(order_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            String user_id = task.getResult().getString("a_user_id");
                            String accept = task.getResult().getString("h_accepted2");
                            String onProses = task.getResult().getString("h_on_proses2");
                            String done = task.getResult().getString("h_done2");
                            String paid = task.getResult().getString("h_paid2");
                            String paidConfirm = task.getResult().getString("h_paid2Confirm");
                            String delivered = task.getResult().getString("h_delivered2");
                            String deliveredConfirm = task.getResult().getString("h_delivered2Confirm");

                            mFirestore.collection("Users").document("T5jCCL93vJPUUCxTUXlO42CpTln1").collection("Notifications").add(notificationsMessage).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    postEvent(OrderDetailEvents.onUpdateDataSuccess, accept, onProses, done, paid, paidConfirm, delivered, deliveredConfirm);
                                }
                            });
                        }
                    }
                });
//                postEvent(OrderDetailEvents.onUpdateDataSuccess);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                postEvent(OrderDetailEvents.onUpdateDataError, e.getLocalizedMessage());
            }
        });
    }

    @Override
    public void updateDeliver(String order_id) {
        Map<String, Object> userMap2 = new HashMap<>();
        userMap2.put("h_delivered2Confirm", "1");

        getNowTime();

        Map<String, Object> notificationsMessage = new HashMap<>();
        notificationsMessage.put("order_id", order_id);
        notificationsMessage.put("message_name", "Weighted");
        notificationsMessage.put("message", "Pakaian telah diterima pelanggan");
        notificationsMessage.put("from", user_id);
        notificationsMessage.put("notif_time", mNowTime);

        mFirestore.collection("Orders").document(order_id).update(userMap2).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mFirestore.collection("Orders").document(order_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            String user_id = task.getResult().getString("a_user_id");
                            String accept = task.getResult().getString("h_accepted2");
                            String onProses = task.getResult().getString("h_on_proses2");
                            String done = task.getResult().getString("h_done2");
                            String paid = task.getResult().getString("h_paid2");
                            String paidConfirm = task.getResult().getString("h_paid2Confirm");
                            String delivered = task.getResult().getString("h_delivered2");
                            String deliveredConfirm = task.getResult().getString("h_delivered2Confirm");

                            mFirestore.collection("Users").document("T5jCCL93vJPUUCxTUXlO42CpTln1").collection("Notifications").add(notificationsMessage).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    postEvent(OrderDetailEvents.onUpdateDataSuccess, accept, onProses, done, paid, paidConfirm, delivered, deliveredConfirm);
                                }
                            });
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                postEvent(OrderDetailEvents.onUpdateDataError, e.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getOrdersData(String order_id) {
        mFirestore.collection("Orders").document(order_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    Log.d("repo onComplete suc:", "masuk");

                    if (task.getResult().exists()) {
                       // String orderId = task.getResult().getString("");
                        String desc = task.getResult().getString("a_catatan");
                        String timeNow = task.getResult().getString("a_time");
                        String timeDone = task.getResult().getString("a_waktu_selesai");
                        String jenis = task.getResult().getString("a_jenis");
                        String weight = task.getResult().getString("a_weight");
                        String price = task.getResult().getString("a_price2");
                        String priceDiskon = task.getResult().getString("a_price_diskon");
                        String diskon = task.getResult().getString("a_diskon");
                        Log.d("coba:", "" + timeNow);
                        String bandana = task.getResult().getString("b_bandana");
                        String topi = task.getResult().getString("b_topi");
                        String masker = task.getResult().getString("b_masker");
                        String kupluk = task.getResult().getString("b_kupluk");
                        String krudung = task.getResult().getString("b_krudung");
                        String peci = task.getResult().getString("b_peci");

                        String kaos = task.getResult().getString("c_kaos");
                        String kaosDalam = task.getResult().getString("c_kaos_dalam");
                        String kemeja = task.getResult().getString("c_kemeja");
                        String bajuMuslim = task.getResult().getString("c_baju_muslim");
                        String jaket = task.getResult().getString("c_jaket");
                        String sweter = task.getResult().getString("c_sweter");
                        String gamis = task.getResult().getString("c_gamis");
                        String handuk = task.getResult().getString("c_handuk");

                        String sarungTangan = task.getResult().getString("d_sarung_tangan");
                        String sapuTangan = task.getResult().getString("d_sapu_tangan");

                        String celana = task.getResult().getString("f_celana");
                        String celanaDalam = task.getResult().getString("f_celana_dalam");
                        String celanaPendek = task.getResult().getString("f_celana_pendek");
                        String sarung = task.getResult().getString("f_sarung");
                        String celanaOlahraga = task.getResult().getString("f_celana_olahraga");
                        String rok = task.getResult().getString("f_rok");
                        String celanaLevis = task.getResult().getString("f_celana_evis");
                        String kaosKaki = task.getResult().getString("f_kaos_kaki");

                        String jasAlmamater = task.getResult().getString("g_jas_almamater");
                        String jas = task.getResult().getString("g_jas");
                        String selimutKecil = task.getResult().getString("g_selimut_kecil");
                        String selimutBesar = task.getResult().getString("g_selimut_besar");
                        String bagCover = task.getResult().getString("g_bag_cover");
                        String gordengKecil = task.getResult().getString("g_gordeng_kecil");
                        String gordengBesar = task.getResult().getString("g_gordeng_besar");
                        String sepatu = task.getResult().getString("g_sepatu");
                        String bantal = task.getResult().getString("g_bantal");
                        String tasKecil = task.getResult().getString("g_tas_kecil");
                        String tasBesar = task.getResult().getString("g_tas_besar");
                        String spreiKecil = task.getResult().getString("g_sprei_kecil");
                        String spreiBesar = task.getResult().getString("g_sprei_besar");

                        String accept = task.getResult().getString("h_accepted2");
                        String onProses = task.getResult().getString("h_on_proses2");
                        String done = task.getResult().getString("h_done2");
                        String paid = task.getResult().getString("h_paid2");
                        String paidConfirm = task.getResult().getString("h_paid2Confirm");
                        String delivered = task.getResult().getString("h_delivered2");
                        String deliveredConfirm = task.getResult().getString("h_delivered2Confirm");

                        //Log.d("dona data ", "" + test);

                        postEvent(OrderDetailEvents.onGetDataSuccess, null, jenis, desc, timeNow, timeDone, weight, price, priceDiskon, diskon, bandana, topi, masker, kupluk, krudung, peci,
                                kaos, kaosDalam, kemeja, bajuMuslim, jaket, sweter, gamis, handuk, sarungTangan, sapuTangan, celana, celanaDalam, celanaPendek, sarung,
                                celanaOlahraga, rok, celanaLevis, kaosKaki, jasAlmamater, jas, selimutBesar, selimutKecil, bagCover, gordengKecil, gordengBesar, sepatu,
                                bantal, tasKecil, tasBesar, spreiKecil, spreiBesar, accept, onProses, done, paid, paidConfirm, delivered, deliveredConfirm);
                    }
                } else {
                    String errorMessage = task.getException().getMessage();
                    postEvent(OrderDetailEvents.onGetDataError, errorMessage);
                }
            }
        });
    }

    @Override
    public void postEvent(int type, String errorMessage, String jenis, String desc, String timeNow, String timeDpne, String weight, String price, String priceDiskon, String diskon, String dataBandana, String dataTopi, String dataMasker, String dataKupluk, String dataKrudung, String dataPeci,
                          String dataKaos, String dataKaosDalam, String dataKemeja, String dataBajuMuslim, String dataJaket, String dataSweter, String dataGamis,
                          String dataHanduk,
                          String dataSarungTangan, String dataSapuTangan,
                          String dataCelana, String dataCelanaDalam, String dataCelanaPendek, String dataSrung, String dataCelanaOlahraga, String dataRok,
                          String dataCelanaLevis, String dataKaosKaki,
                          String dataJasAlmamater, String dataJas, String dataSelimutBesar, String dataSelimutKecil, String dataBagCover,
                          String dataGordengKecil, String dataGordengBesar, String dataSepatu, String dataBantal, String dataTasKecil, String dataTasBesar,
                          String dataSpreiKecil, String dataSpreiBesar, String dataAccept, String dataOnProses, String dataDone, String dataPaid, String dataPaidConfirm, String delivered, String deliveredConfirm) {
        OrderDetailEvents orderDetailEvents = new OrderDetailEvents();
        orderDetailEvents.setEventType(type);
        Log.d("masuk post", "masuk post event succes not null");
        if (errorMessage == null) {
            orderDetailEvents.setErrorMessage(errorMessage);
        }

        orderDetailEvents.setDataJenis(jenis);
        orderDetailEvents.setDataDesc(desc);
        orderDetailEvents.setDataTimeNow(timeNow);
        orderDetailEvents.setDataTimeDone(timeDpne);
        orderDetailEvents.setDataWeight(weight);
        orderDetailEvents.setDataPrice(price);
        orderDetailEvents.setDataPriceDiskon(priceDiskon);
        orderDetailEvents.setDataDiskon(diskon);
        orderDetailEvents.setDataBandana(dataBandana);
        orderDetailEvents.setDataTopi(dataTopi);
        orderDetailEvents.setDataMasker(dataMasker);
        orderDetailEvents.setDataKupluk(dataKupluk);
        orderDetailEvents.setDataKrudung(dataKrudung);
        orderDetailEvents.setDataPeci(dataPeci);
        orderDetailEvents.setDataKaos(dataKaos);
        orderDetailEvents.setDataKaosDalam(dataKaosDalam);
        orderDetailEvents.setDataKemeja(dataKemeja);
        orderDetailEvents.setDataBajuMuslim(dataBajuMuslim);
        orderDetailEvents.setDataJaket(dataJaket);
        orderDetailEvents.setDataSweter(dataSweter);
        orderDetailEvents.setDataGamis(dataGamis);
        orderDetailEvents.setDataHanduk(dataHanduk);
        orderDetailEvents.setDataSarungTangan(dataSarungTangan);
        orderDetailEvents.setDataSapuTangan(dataSapuTangan);
        orderDetailEvents.setDataCelana(dataCelana);
        orderDetailEvents.setDataCelanaDalam(dataCelanaDalam);
        orderDetailEvents.setDataCelanaPendek(dataCelanaPendek);
        orderDetailEvents.setDataSrung(dataSrung);
        orderDetailEvents.setDataCelanaOlahraga(dataCelanaOlahraga);
        orderDetailEvents.setDataRok(dataRok);
        orderDetailEvents.setDataCelanaLevis(dataCelanaLevis);
        orderDetailEvents.setDataKaosKaki(dataKaosKaki);
        orderDetailEvents.setDataJasAlmamater(dataJasAlmamater);
        orderDetailEvents.setDataJas(dataJas);
        orderDetailEvents.setDataSelimutBesar(dataSelimutBesar);
        orderDetailEvents.setDataSelimutKecil(dataSelimutKecil);
        orderDetailEvents.setDataBagCover(dataBagCover);
        orderDetailEvents.setDataGordengKecil(dataGordengKecil);
        orderDetailEvents.setDataGordengBesar(dataGordengBesar);
        orderDetailEvents.setDataSepatu(dataSepatu);
        orderDetailEvents.setDataBantal(dataBantal);
        orderDetailEvents.setDataTasKecil(dataTasKecil);
        orderDetailEvents.setDataTasBesar(dataTasBesar);
        orderDetailEvents.setDataSpreiKecil(dataSpreiKecil);
        orderDetailEvents.setDataSpreiBesar(dataSpreiBesar);
        orderDetailEvents.setDataAccept(dataAccept);
        orderDetailEvents.setDataOnProses(dataOnProses);
        orderDetailEvents.setDataDone(dataDone);
        orderDetailEvents.setDataPaid(dataPaid);
        orderDetailEvents.setDataPaidConfirm(dataPaidConfirm);
        orderDetailEvents.setDataDelivered(delivered);
        orderDetailEvents.setDataDeliveredConfirm(deliveredConfirm);

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(orderDetailEvents);
    }

    public void postEvent(int type, String dataAccept, String dataOnProses, String dataDone, String dataPaid, String dataPaidConfirm, String delivered, String deliveredConfirm) {
        postEvent(type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, dataAccept, dataOnProses, dataDone, dataPaid, dataPaidConfirm, delivered, deliveredConfirm);
    }

    @Override
    public void postEvent(int type, String errorMessage) {
        postEvent(type, errorMessage, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    @Override
    public void postEvent(int type) {
        postEvent(type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

}
