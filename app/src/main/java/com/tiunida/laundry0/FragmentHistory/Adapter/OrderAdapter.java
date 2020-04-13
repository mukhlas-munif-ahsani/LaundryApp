package com.tiunida.laundry0.FragmentHistory.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.tiunida.laundry0.R;
import com.tiunida.laundry0.FragmentHistory.Model.Model;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends FirestoreRecyclerAdapter<Model, OrderAdapter.OrderHolder> {

    private OnItemClickListener listener;

    public OrderAdapter(@NonNull FirestoreRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderHolder orderHolder, int i, @NonNull Model model) {
        orderHolder.mOrderDateTxt.setText(model.getA_time());
        orderHolder.mDoneTimeTxt.setText(model.getA_waktu_selesai());

        orderHolder.mjenis.setText(model.getA_jenis());
        if (model.getA_price2() != null) {
            Log.d("tidak ", "null");
            int priceInt = Integer.valueOf(model.getA_price2());
            int diskonInt = Integer.valueOf(model.getA_diskon());
            int hasil = priceInt * diskonInt / 100;
            int totalPrice = priceInt - hasil;
            orderHolder.mPrice.setText(String.valueOf(totalPrice));
        }

        //orderHolder.mPrice.setText(model.getA_price2());

        String string1 = "1";
        if (model.getH_accepted2().equals(string1)) {
            orderHolder.mAcceptIndicator.setBackgroundResource(R.drawable.circle_view_background);
            orderHolder.mAcceptedLine.setBackgroundResource(R.drawable.ractangle_view_birulaut);
        } else {
            orderHolder.mAcceptIndicator.setBackgroundResource(R.drawable.circle_view_border);
            orderHolder.mAcceptedLine.setBackgroundResource(R.drawable.ractangle_view_putih);
        }

        if (model.getH_on_proses2().equals(string1)) {
            orderHolder.mProsesIndicator.setBackgroundResource(R.drawable.circle_view_background);
            orderHolder.mProsesLine.setBackgroundResource(R.drawable.ractangle_view_birulaut);
        } else {
            orderHolder.mProsesIndicator.setBackgroundResource(R.drawable.circle_view_border);
            orderHolder.mProsesLine.setBackgroundResource(R.drawable.ractangle_view_putih);
        }

        if (model.getH_done2().equals(string1)) {
            orderHolder.mDoneIndicator.setBackgroundResource(R.drawable.circle_view_background);
            orderHolder.mDoneLine.setBackgroundResource(R.drawable.ractangle_view_birulaut);
        } else {
            orderHolder.mDoneIndicator.setBackgroundResource(R.drawable.circle_view_border);
            orderHolder.mDoneLine.setBackgroundResource(R.drawable.ractangle_view_putih);
        }

        if (model.getH_paid2Confirm().equals(string1)) {
            orderHolder.mPaindIndicator.setBackgroundResource(R.drawable.circle_view_background);
            orderHolder.mPaidLine.setBackgroundResource(R.drawable.ractangle_view_birulaut);
        } else {
            orderHolder.mPaindIndicator.setBackgroundResource(R.drawable.circle_view_border);
            orderHolder.mPaidLine.setBackgroundResource(R.drawable.ractangle_view_putih);
        }

        if (model.getH_delivered2Confirm().equals(string1)) {
            orderHolder.mDeliveredIndicator.setBackgroundResource(R.drawable.circle_view_background);
        } else {
            orderHolder.mDeliveredIndicator.setBackgroundResource(R.drawable.circle_view_border);
        }

        if (model.getA_jenis().equals("Biasa")) {
            switch (model.getA_weight()) {
                case "1":
                    orderHolder.mPrice.setText(setTotalPrice(3500, model.getA_diskon()));
                    break;
                case "1.1":
                    orderHolder.mPrice.setText(setTotalPrice(3850, model.getA_diskon()));
                    break;
                case "1.2":
                    orderHolder.mPrice.setText(setTotalPrice(4200, model.getA_diskon()));
                    break;
                case "1.3":
                    orderHolder.mPrice.setText(setTotalPrice(4550, model.getA_diskon()));
                    break;
                case "1.4":
                    orderHolder.mPrice.setText(setTotalPrice(4900, model.getA_diskon()));
                    break;
                case "1.5":
                    orderHolder.mPrice.setText(setTotalPrice(5250, model.getA_diskon()));
                    break;
                case "1.6":
                    orderHolder.mPrice.setText(setTotalPrice(5600, model.getA_diskon()));
                    break;
                case "1.7":
                    orderHolder.mPrice.setText(setTotalPrice(5950, model.getA_diskon()));
                    break;
                case "1.8":
                    orderHolder.mPrice.setText(setTotalPrice(6300, model.getA_diskon()));
                    break;
                case "1.9":
                    orderHolder.mPrice.setText(setTotalPrice(6650, model.getA_diskon()));
                    break;
                //-2---------------
                case "2":
                    orderHolder.mPrice.setText(setTotalPrice(7000, model.getA_diskon()));
                    break;
                case "2.1":
                    orderHolder.mPrice.setText(setTotalPrice(7350, model.getA_diskon()));
                    break;
                case "2.2":
                    orderHolder.mPrice.setText(setTotalPrice(7700, model.getA_diskon()));
                    break;
                case "2.3":
                    orderHolder.mPrice.setText(setTotalPrice(8050, model.getA_diskon()));
                    break;
                case "2.4":
                    orderHolder.mPrice.setText(setTotalPrice(8400, model.getA_diskon()));
                    break;
                case "2.5":
                    orderHolder.mPrice.setText(setTotalPrice(8750, model.getA_diskon()));
                    break;
                case "2.6":
                    orderHolder.mPrice.setText(setTotalPrice(9100, model.getA_diskon()));
                    break;
                case "2.7":
                    orderHolder.mPrice.setText(setTotalPrice(9450, model.getA_diskon()));
                    break;
                case "2.8":
                    orderHolder.mPrice.setText(setTotalPrice(9800, model.getA_diskon()));
                    break;
                case "2.9":
                    orderHolder.mPrice.setText(setTotalPrice(10150, model.getA_diskon()));
                    break;
                //-3---------------
                case "3":
                    orderHolder.mPrice.setText(setTotalPrice(10500, model.getA_diskon()));
                    break;
                case "3.1":
                    orderHolder.mPrice.setText(setTotalPrice(10850, model.getA_diskon()));
                    break;
                case "3.2":
                    orderHolder.mPrice.setText(setTotalPrice(3500, model.getA_diskon()));
                    break;
                case "3.3":
                    orderHolder.mPrice.setText(setTotalPrice(11200, model.getA_diskon()));
                    break;
                case "3.4":
                    orderHolder.mPrice.setText(setTotalPrice(11550, model.getA_diskon()));
                    break;
                case "3.5":
                    orderHolder.mPrice.setText(setTotalPrice(11900, model.getA_diskon()));
                    break;
                case "3.6":
                    orderHolder.mPrice.setText(setTotalPrice(12250, model.getA_diskon()));
                    break;
                case "3.7":
                    orderHolder.mPrice.setText(setTotalPrice(12600, model.getA_diskon()));
                    break;
                case "3.8":
                    orderHolder.mPrice.setText(setTotalPrice(12950, model.getA_diskon()));
                    break;
                case "3.9":
                    orderHolder.mPrice.setText(setTotalPrice(13300, model.getA_diskon()));
                    break;
                //-4---------------
                case "4":
                    orderHolder.mPrice.setText(setTotalPrice(13650, model.getA_diskon()));
                    break;
                case "4.1":
                    orderHolder.mPrice.setText(setTotalPrice(14000, model.getA_diskon()));
                    break;
                case "4.2":
                    orderHolder.mPrice.setText(setTotalPrice(14350, model.getA_diskon()));
                    break;
                case "4.3":
                    orderHolder.mPrice.setText(setTotalPrice(14700, model.getA_diskon()));
                    break;
                case "4.4":
                    orderHolder.mPrice.setText(setTotalPrice(15050, model.getA_diskon()));
                    break;
                case "4.5":
                    orderHolder.mPrice.setText(setTotalPrice(15400, model.getA_diskon()));
                    break;
                case "4.6":
                    orderHolder.mPrice.setText(setTotalPrice(15750, model.getA_diskon()));
                    break;
                case "4.7":
                    orderHolder.mPrice.setText(setTotalPrice(16100, model.getA_diskon()));
                    break;
                case "4.8":
                    orderHolder.mPrice.setText(setTotalPrice(16450, model.getA_diskon()));
                    break;
                case "4.9":
                    orderHolder.mPrice.setText(setTotalPrice(16800, model.getA_diskon()));
                    break;
                //-5---------------
                case "5":
                    orderHolder.mPrice.setText(setTotalPrice(17150, model.getA_diskon()));
                    break;
                case "5.1":
                    orderHolder.mPrice.setText(setTotalPrice(17500, model.getA_diskon()));
                    break;
                case "5.2":
                    orderHolder.mPrice.setText(setTotalPrice(17850, model.getA_diskon()));
                    break;
                case "5.3":
                    orderHolder.mPrice.setText(setTotalPrice(18200, model.getA_diskon()));
                    break;
                case "5.4":
                    orderHolder.mPrice.setText(setTotalPrice(18550, model.getA_diskon()));
                    break;
                case "5.5":
                    orderHolder.mPrice.setText(setTotalPrice(18900, model.getA_diskon()));
                    break;
                case "5.6":
                    orderHolder.mPrice.setText(setTotalPrice(19250, model.getA_diskon()));
                    break;
                case "5.7":
                    orderHolder.mPrice.setText(setTotalPrice(19600, model.getA_diskon()));
                    break;
                case "5.8":
                    orderHolder.mPrice.setText(setTotalPrice(19950, model.getA_diskon()));
                    break;
                case "5.9":
                    orderHolder.mPrice.setText(setTotalPrice(20300, model.getA_diskon()));
                    break;
                //-6---------------
                case "6":
                    orderHolder.mPrice.setText(setTotalPrice(20650, model.getA_diskon()));
                    break;
                case "6.1":
                    orderHolder.mPrice.setText(setTotalPrice(21000, model.getA_diskon()));
                    break;
                case "6.2":
                    orderHolder.mPrice.setText(setTotalPrice(21350, model.getA_diskon()));
                    break;
                case "6.3":
                    orderHolder.mPrice.setText(setTotalPrice(21700, model.getA_diskon()));
                    break;
                case "6.4":
                    orderHolder.mPrice.setText(setTotalPrice(22050, model.getA_diskon()));
                    break;
                case "6.5":
                    orderHolder.mPrice.setText(setTotalPrice(22400, model.getA_diskon()));
                    break;
                case "6.6":
                    orderHolder.mPrice.setText(setTotalPrice(22750, model.getA_diskon()));
                    break;
                case "6.7":
                    orderHolder.mPrice.setText(setTotalPrice(23100, model.getA_diskon()));
                    break;
                case "6.8":
                    orderHolder.mPrice.setText(setTotalPrice(23450, model.getA_diskon()));
                    break;
                case "6.9":
                    orderHolder.mPrice.setText(setTotalPrice(23800, model.getA_diskon()));
                    break;
                //-7---------------
                case "7":
                    orderHolder.mPrice.setText(setTotalPrice(24150, model.getA_diskon()));
                    break;
                case "7.1":
                    orderHolder.mPrice.setText(setTotalPrice(24500, model.getA_diskon()));
                    break;
                case "7.2":
                    orderHolder.mPrice.setText(setTotalPrice(24850, model.getA_diskon()));
                    break;
                case "7.3":
                    orderHolder.mPrice.setText(setTotalPrice(25200, model.getA_diskon()));
                    break;
                case "7.4":
                    orderHolder.mPrice.setText(setTotalPrice(25550, model.getA_diskon()));
                    break;
                case "7.5":
                    orderHolder.mPrice.setText(setTotalPrice(25900, model.getA_diskon()));
                    break;
                case "7.6":
                    orderHolder.mPrice.setText(setTotalPrice(26250, model.getA_diskon()));
                    break;
                case "7.7":
                    orderHolder.mPrice.setText(setTotalPrice(26600, model.getA_diskon()));
                    break;
                case "7.8":
                    orderHolder.mPrice.setText(setTotalPrice(26950, model.getA_diskon()));
                    break;
                case "7.9":
                    orderHolder.mPrice.setText(setTotalPrice(27300, model.getA_diskon()));
                    break;
                //-8---------------
                case "8":
                    orderHolder.mPrice.setText(setTotalPrice(27650, model.getA_diskon()));
                    break;
                case "8.1":
                    orderHolder.mPrice.setText(setTotalPrice(28000, model.getA_diskon()));
                    break;
                case "8.2":
                    orderHolder.mPrice.setText(setTotalPrice(28350, model.getA_diskon()));
                    break;
                case "8.3":
                    orderHolder.mPrice.setText(setTotalPrice(28700, model.getA_diskon()));
                    break;
                case "8.4":
                    orderHolder.mPrice.setText(setTotalPrice(29050, model.getA_diskon()));
                    break;
                case "8.5":
                    orderHolder.mPrice.setText(setTotalPrice(29400, model.getA_diskon()));
                    break;
                case "8.6":
                    orderHolder.mPrice.setText(setTotalPrice(29750, model.getA_diskon()));
                    break;
                case "8.7":
                    orderHolder.mPrice.setText(setTotalPrice(30100, model.getA_diskon()));
                    break;
                case "8.8":
                    orderHolder.mPrice.setText(setTotalPrice(30450, model.getA_diskon()));
                    break;
                case "8.9":
                    orderHolder.mPrice.setText(setTotalPrice(30800, model.getA_diskon()));
                    break;
                //-9---------------
                case "9":
                    orderHolder.mPrice.setText(setTotalPrice(31150, model.getA_diskon()));
                    break;
                case "9.1":
                    orderHolder.mPrice.setText(setTotalPrice(31500, model.getA_diskon()));
                    break;
                case "9.2":
                    orderHolder.mPrice.setText(setTotalPrice(31850, model.getA_diskon()));
                    break;
                case "9.3":
                    orderHolder.mPrice.setText(setTotalPrice(32200, model.getA_diskon()));
                    break;
                case "9.4":
                    orderHolder.mPrice.setText(setTotalPrice(32550, model.getA_diskon()));
                    break;
                case "9.5":
                    orderHolder.mPrice.setText(setTotalPrice(32900, model.getA_diskon()));
                    break;
                case "9.6":
                    orderHolder.mPrice.setText(setTotalPrice(33250, model.getA_diskon()));
                    break;
                case "9.7":
                    orderHolder.mPrice.setText(setTotalPrice(33600, model.getA_diskon()));
                    break;
                case "9.8":
                    orderHolder.mPrice.setText(setTotalPrice(33950, model.getA_diskon()));
                    break;
                case "9.9":
                    orderHolder.mPrice.setText(setTotalPrice(34300, model.getA_diskon()));
                    break;
            }
        }

        if (model.getA_jenis().equals("Express")) {
            switch (model.getA_weight()) {
                case "1":
                    orderHolder.mPrice.setText(setTotalPrice(6000, model.getA_diskon()));
                    break;
                case "1.1":
                    orderHolder.mPrice.setText(setTotalPrice(6600, model.getA_diskon()));
                    break;
                case "1.2":
                    orderHolder.mPrice.setText(setTotalPrice(7200, model.getA_diskon()));
                    break;
                case "1.3":
                    orderHolder.mPrice.setText(setTotalPrice(7800, model.getA_diskon()));
                    break;
                case "1.4":
                    orderHolder.mPrice.setText(setTotalPrice(8400, model.getA_diskon()));
                    break;
                case "1.5":
                    orderHolder.mPrice.setText(setTotalPrice(9000, model.getA_diskon()));
                    break;
                case "1.6":
                    orderHolder.mPrice.setText(setTotalPrice(9600, model.getA_diskon()));
                    break;
                case "1.7":
                    orderHolder.mPrice.setText(setTotalPrice(10200, model.getA_diskon()));
                    break;
                case "1.8":
                    orderHolder.mPrice.setText(setTotalPrice(10800, model.getA_diskon()));
                    break;
                case "1.9":
                    orderHolder.mPrice.setText(setTotalPrice(11400, model.getA_diskon()));
                    break;
                //-2---------------
                case "2":
                    orderHolder.mPrice.setText(setTotalPrice(12000, model.getA_diskon()));
                    break;
                case "2.1":
                    orderHolder.mPrice.setText(setTotalPrice(12600, model.getA_diskon()));
                    break;
                case "2.2":
                    orderHolder.mPrice.setText(setTotalPrice(13200, model.getA_diskon()));
                    break;
                case "2.3":
                    orderHolder.mPrice.setText(setTotalPrice(13800, model.getA_diskon()));
                    break;
                case "2.4":
                    orderHolder.mPrice.setText(setTotalPrice(14400, model.getA_diskon()));
                    break;
                case "2.5":
                    orderHolder.mPrice.setText(setTotalPrice(15000, model.getA_diskon()));
                    break;
                case "2.6":
                    orderHolder.mPrice.setText(setTotalPrice(15600, model.getA_diskon()));
                    break;
                case "2.7":
                    orderHolder.mPrice.setText(setTotalPrice(16200, model.getA_diskon()));
                    break;
                case "2.8":
                    orderHolder.mPrice.setText(setTotalPrice(16800, model.getA_diskon()));
                    break;
                case "2.9":
                    orderHolder.mPrice.setText(setTotalPrice(17400, model.getA_diskon()));
                    break;
                //-3---------------
                case "3":
                    orderHolder.mPrice.setText(setTotalPrice(18000, model.getA_diskon()));
                    break;
                case "3.1":
                    orderHolder.mPrice.setText(setTotalPrice(18600, model.getA_diskon()));
                    break;
                case "3.2":
                    orderHolder.mPrice.setText(setTotalPrice(19200, model.getA_diskon()));
                    break;
                case "3.3":
                    orderHolder.mPrice.setText(setTotalPrice(19800, model.getA_diskon()));
                    break;
                case "3.4":
                    orderHolder.mPrice.setText(setTotalPrice(20400, model.getA_diskon()));
                    break;
                case "3.5":
                    orderHolder.mPrice.setText(setTotalPrice(20000, model.getA_diskon()));
                    break;
                case "3.6":
                    orderHolder.mPrice.setText(setTotalPrice(20600, model.getA_diskon()));
                    break;
                case "3.7":
                    orderHolder.mPrice.setText(setTotalPrice(21200, model.getA_diskon()));
                    break;
                case "3.8":
                    orderHolder.mPrice.setText(setTotalPrice(21800, model.getA_diskon()));
                    break;
                case "3.9":
                    orderHolder.mPrice.setText(setTotalPrice(22400, model.getA_diskon()));
                    break;
                //-4---------------
                case "4":
                    orderHolder.mPrice.setText(setTotalPrice(22000, model.getA_diskon()));
                    break;
                case "4.1":
                    orderHolder.mPrice.setText(setTotalPrice(22600, model.getA_diskon()));
                    break;
                case "4.2":
                    orderHolder.mPrice.setText(setTotalPrice(23200, model.getA_diskon()));
                    break;
                case "4.3":
                    orderHolder.mPrice.setText(setTotalPrice(23800, model.getA_diskon()));
                    break;
                case "4.4":
                    orderHolder.mPrice.setText(setTotalPrice(24400, model.getA_diskon()));
                    break;
                case "4.5":
                    orderHolder.mPrice.setText(setTotalPrice(24000, model.getA_diskon()));
                    break;
                case "4.6":
                    orderHolder.mPrice.setText(setTotalPrice(24600, model.getA_diskon()));
                    break;
                case "4.7":
                    orderHolder.mPrice.setText(setTotalPrice(25200, model.getA_diskon()));
                    break;
                case "4.8":
                    orderHolder.mPrice.setText(setTotalPrice(25800, model.getA_diskon()));
                    break;
                case "4.9":
                    orderHolder.mPrice.setText(setTotalPrice(26400, model.getA_diskon()));
                    break;
                //-5---------------
                case "5":
                    orderHolder.mPrice.setText(setTotalPrice(27000, model.getA_diskon()));
                    break;
                case "5.1":
                    orderHolder.mPrice.setText(setTotalPrice(27600, model.getA_diskon()));
                    break;
                case "5.2":
                    orderHolder.mPrice.setText(setTotalPrice(28200, model.getA_diskon()));
                    break;
                case "5.3":
                    orderHolder.mPrice.setText(setTotalPrice(28800, model.getA_diskon()));
                    break;
                case "5.4":
                    orderHolder.mPrice.setText(setTotalPrice(29400, model.getA_diskon()));
                    break;
                case "5.5":
                    orderHolder.mPrice.setText(setTotalPrice(29000, model.getA_diskon()));
                    break;
                case "5.6":
                    orderHolder.mPrice.setText(setTotalPrice(29600, model.getA_diskon()));
                    break;
                case "5.7":
                    orderHolder.mPrice.setText(setTotalPrice(30200, model.getA_diskon()));
                    break;
                case "5.8":
                    orderHolder.mPrice.setText(setTotalPrice(30800, model.getA_diskon()));
                    break;
                case "5.9":
                    orderHolder.mPrice.setText(setTotalPrice(31400, model.getA_diskon()));
                    break;
                //-6---------------
                case "6":
                    orderHolder.mPrice.setText(setTotalPrice(31000, model.getA_diskon()));
                    break;
                case "6.1":
                    orderHolder.mPrice.setText(setTotalPrice(31600, model.getA_diskon()));
                    break;
                case "6.2":
                    orderHolder.mPrice.setText(setTotalPrice(32200, model.getA_diskon()));
                    break;
                case "6.3":
                    orderHolder.mPrice.setText(setTotalPrice(32800, model.getA_diskon()));
                    break;
                case "6.4":
                    orderHolder.mPrice.setText(setTotalPrice(33400, model.getA_diskon()));
                    break;
                case "6.5":
                    orderHolder.mPrice.setText(setTotalPrice(33000, model.getA_diskon()));
                    break;
                case "6.6":
                    orderHolder.mPrice.setText(setTotalPrice(33600, model.getA_diskon()));
                    break;
                case "6.7":
                    orderHolder.mPrice.setText(setTotalPrice(34200, model.getA_diskon()));
                    break;
                case "6.8":
                    orderHolder.mPrice.setText(setTotalPrice(34800, model.getA_diskon()));
                    break;
                case "6.9":
                    orderHolder.mPrice.setText(setTotalPrice(35400, model.getA_diskon()));
                    break;
                //-7---------------
                case "7":
                    orderHolder.mPrice.setText(setTotalPrice(36000, model.getA_diskon()));
                    break;
                case "7.1":
                    orderHolder.mPrice.setText(setTotalPrice(36600, model.getA_diskon()));
                    break;
                case "7.2":
                    orderHolder.mPrice.setText(setTotalPrice(37200, model.getA_diskon()));
                    break;
                case "7.3":
                    orderHolder.mPrice.setText(setTotalPrice(37800, model.getA_diskon()));
                    break;
                case "7.4":
                    orderHolder.mPrice.setText(setTotalPrice(38400, model.getA_diskon()));
                    break;
                case "7.5":
                    orderHolder.mPrice.setText(setTotalPrice(38000, model.getA_diskon()));
                    break;
                case "7.6":
                    orderHolder.mPrice.setText(setTotalPrice(38600, model.getA_diskon()));
                    break;
                case "7.7":
                    orderHolder.mPrice.setText(setTotalPrice(39200, model.getA_diskon()));
                    break;
                case "7.8":
                    orderHolder.mPrice.setText(setTotalPrice(39800, model.getA_diskon()));
                    break;
                case "7.9":
                    orderHolder.mPrice.setText(setTotalPrice(40400, model.getA_diskon()));
                    break;
                //-8---------------
                case "8":
                    orderHolder.mPrice.setText(setTotalPrice(41000, model.getA_diskon()));
                    break;
                case "8.1":
                    orderHolder.mPrice.setText(setTotalPrice(41600, model.getA_diskon()));
                    break;
                case "8.2":
                    orderHolder.mPrice.setText(setTotalPrice(42200, model.getA_diskon()));
                    break;
                case "8.3":
                    orderHolder.mPrice.setText(setTotalPrice(42800, model.getA_diskon()));
                    break;
                case "8.4":
                    orderHolder.mPrice.setText(setTotalPrice(43400, model.getA_diskon()));
                    break;
                case "8.5":
                    orderHolder.mPrice.setText(setTotalPrice(44000, model.getA_diskon()));
                    break;
                case "8.6":
                    orderHolder.mPrice.setText(setTotalPrice(44600, model.getA_diskon()));
                    break;
                case "8.7":
                    orderHolder.mPrice.setText(setTotalPrice(45200, model.getA_diskon()));
                    break;
                case "8.8":
                    orderHolder.mPrice.setText(setTotalPrice(45800, model.getA_diskon()));
                    break;
                case "8.9":
                    orderHolder.mPrice.setText(setTotalPrice(46400, model.getA_diskon()));
                    break;
                //-9---------------
                case "9":
                    orderHolder.mPrice.setText(setTotalPrice(47000, model.getA_diskon()));
                    break;
                case "9.1":
                    orderHolder.mPrice.setText(setTotalPrice(47600, model.getA_diskon()));
                    break;
                case "9.2":
                    orderHolder.mPrice.setText(setTotalPrice(48200, model.getA_diskon()));
                    break;
                case "9.3":
                    orderHolder.mPrice.setText(setTotalPrice(48800, model.getA_diskon()));
                    break;
                case "9.4":
                    orderHolder.mPrice.setText(setTotalPrice(49400, model.getA_diskon()));
                    break;
                case "9.5":
                    orderHolder.mPrice.setText(setTotalPrice(50000, model.getA_diskon()));
                    break;
                case "9.6":
                    orderHolder.mPrice.setText(setTotalPrice(50600, model.getA_diskon()));
                    break;
                case "9.7":
                    orderHolder.mPrice.setText(setTotalPrice(51200, model.getA_diskon()));
                    break;
                case "9.8":
                    orderHolder.mPrice.setText(setTotalPrice(51800, model.getA_diskon()));
                    break;
                case "9.9":
                    orderHolder.mPrice.setText(setTotalPrice(52400, model.getA_diskon()));
                    break;
            }
        }

        if (model.getA_jenis().equals("Kilat")) {
            switch (model.getA_weight()) {
                case "1":
                    orderHolder.mPrice.setText(setTotalPrice(8000, model.getA_diskon()));
                    break;
                case "1.1":
                    orderHolder.mPrice.setText(setTotalPrice(8800, model.getA_diskon()));
                    break;
                case "1.2":
                    orderHolder.mPrice.setText(setTotalPrice(9600, model.getA_diskon()));
                    break;
                case "1.3":
                    orderHolder.mPrice.setText(setTotalPrice(10400, model.getA_diskon()));
                    break;
                case "1.4":
                    orderHolder.mPrice.setText(setTotalPrice(11200, model.getA_diskon()));
                    break;
                case "1.5":
                    orderHolder.mPrice.setText(setTotalPrice(12000, model.getA_diskon()));
                    break;
                case "1.6":
                    orderHolder.mPrice.setText(setTotalPrice(12800, model.getA_diskon()));
                    break;
                case "1.7":
                    orderHolder.mPrice.setText(setTotalPrice(13600, model.getA_diskon()));
                    break;
                case "1.8":
                    orderHolder.mPrice.setText(setTotalPrice(14400, model.getA_diskon()));
                    break;
                case "1.9":
                    orderHolder.mPrice.setText(setTotalPrice(15200, model.getA_diskon()));
                    break;
                //-2---------------
                case "2":
                    orderHolder.mPrice.setText(setTotalPrice(16000, model.getA_diskon()));
                    break;
                case "2.1":
                    orderHolder.mPrice.setText(setTotalPrice(16800, model.getA_diskon()));
                    break;
                case "2.2":
                    orderHolder.mPrice.setText(setTotalPrice(17600, model.getA_diskon()));
                    break;
                case "2.3":
                    orderHolder.mPrice.setText(setTotalPrice(18400, model.getA_diskon()));
                    break;
                case "2.4":
                    orderHolder.mPrice.setText(setTotalPrice(19200, model.getA_diskon()));
                    break;
                case "2.5":
                    orderHolder.mPrice.setText(setTotalPrice(20000, model.getA_diskon()));
                    break;
                case "2.6":
                    orderHolder.mPrice.setText(setTotalPrice(20800, model.getA_diskon()));
                    break;
                case "2.7":
                    orderHolder.mPrice.setText(setTotalPrice(21600, model.getA_diskon()));
                    break;
                case "2.8":
                    orderHolder.mPrice.setText(setTotalPrice(22400, model.getA_diskon()));
                    break;
                case "2.9":
                    orderHolder.mPrice.setText(setTotalPrice(23200, model.getA_diskon()));
                    break;
                //-3---------------
                case "3":
                    orderHolder.mPrice.setText(setTotalPrice(24000, model.getA_diskon()));
                    break;
                case "3.1":
                    orderHolder.mPrice.setText(setTotalPrice(24800, model.getA_diskon()));
                    break;
                case "3.2":
                    orderHolder.mPrice.setText(setTotalPrice(25600, model.getA_diskon()));
                    break;
                case "3.3":
                    orderHolder.mPrice.setText(setTotalPrice(26400, model.getA_diskon()));
                    break;
                case "3.4":
                    orderHolder.mPrice.setText(setTotalPrice(27200, model.getA_diskon()));
                    break;
                case "3.5":
                    orderHolder.mPrice.setText(setTotalPrice(28000, model.getA_diskon()));
                    break;
                case "3.6":
                    orderHolder.mPrice.setText(setTotalPrice(28800, model.getA_diskon()));
                    break;
                case "3.7":
                    orderHolder.mPrice.setText(setTotalPrice(29600, model.getA_diskon()));
                    break;
                case "3.8":
                    orderHolder.mPrice.setText(setTotalPrice(30400, model.getA_diskon()));
                    break;
                case "3.9":
                    orderHolder.mPrice.setText(setTotalPrice(31200, model.getA_diskon()));
                    break;
                //-4---------------
                case "4":
                    orderHolder.mPrice.setText(setTotalPrice(32000, model.getA_diskon()));
                    break;
                case "4.1":
                    orderHolder.mPrice.setText(setTotalPrice(32800, model.getA_diskon()));
                    break;
                case "4.2":
                    orderHolder.mPrice.setText(setTotalPrice(33600, model.getA_diskon()));
                    break;
                case "4.3":
                    orderHolder.mPrice.setText(setTotalPrice(33400, model.getA_diskon()));
                    break;
                case "4.4":
                    orderHolder.mPrice.setText(setTotalPrice(34200, model.getA_diskon()));
                    break;
                case "4.5":
                    orderHolder.mPrice.setText(setTotalPrice(35000, model.getA_diskon()));
                    break;
                case "4.6":
                    orderHolder.mPrice.setText(setTotalPrice(35800, model.getA_diskon()));
                    break;
                case "4.7":
                    orderHolder.mPrice.setText(setTotalPrice(36600, model.getA_diskon()));
                    break;
                case "4.8":
                    orderHolder.mPrice.setText(setTotalPrice(37400, model.getA_diskon()));
                    break;
                case "4.9":
                    orderHolder.mPrice.setText(setTotalPrice(38200, model.getA_diskon()));
                    break;
                //-5---------------
                case "5":
                    orderHolder.mPrice.setText(setTotalPrice(39000, model.getA_diskon()));
                    break;
                case "5.1":
                    orderHolder.mPrice.setText(setTotalPrice(39800, model.getA_diskon()));
                    break;
                case "5.2":
                    orderHolder.mPrice.setText(setTotalPrice(40600, model.getA_diskon()));
                    break;
                case "5.3":
                    orderHolder.mPrice.setText(setTotalPrice(41400, model.getA_diskon()));
                    break;
                case "5.4":
                    orderHolder.mPrice.setText(setTotalPrice(42200, model.getA_diskon()));
                    break;
                case "5.5":
                    orderHolder.mPrice.setText(setTotalPrice(43000, model.getA_diskon()));
                    break;
                case "5.6":
                    orderHolder.mPrice.setText(setTotalPrice(43800, model.getA_diskon()));
                    break;
                case "5.7":
                    orderHolder.mPrice.setText(setTotalPrice(44600, model.getA_diskon()));
                    break;
                case "5.8":
                    orderHolder.mPrice.setText(setTotalPrice(45400, model.getA_diskon()));
                    break;
                case "5.9":
                    orderHolder.mPrice.setText(setTotalPrice(46200, model.getA_diskon()));
                    break;
                //-6---------------
                case "6":
                    orderHolder.mPrice.setText(setTotalPrice(47000, model.getA_diskon()));
                    break;
                case "6.1":
                    orderHolder.mPrice.setText(setTotalPrice(47800, model.getA_diskon()));
                    break;
                case "6.2":
                    orderHolder.mPrice.setText(setTotalPrice(48600, model.getA_diskon()));
                    break;
                case "6.3":
                    orderHolder.mPrice.setText(setTotalPrice(49400, model.getA_diskon()));
                    break;
                case "6.4":
                    orderHolder.mPrice.setText(setTotalPrice(50200, model.getA_diskon()));
                    break;
                case "6.5":
                    orderHolder.mPrice.setText(setTotalPrice(51000, model.getA_diskon()));
                    break;
                case "6.6":
                    orderHolder.mPrice.setText(setTotalPrice(51800, model.getA_diskon()));
                    break;
                case "6.7":
                    orderHolder.mPrice.setText(setTotalPrice(52600, model.getA_diskon()));
                    break;
                case "6.8":
                    orderHolder.mPrice.setText(setTotalPrice(53400, model.getA_diskon()));
                    break;
                case "6.9":
                    orderHolder.mPrice.setText(setTotalPrice(54200, model.getA_diskon()));
                    break;
                //-7---------------
                case "7":
                    orderHolder.mPrice.setText(setTotalPrice(55000, model.getA_diskon()));
                    break;
                case "7.1":
                    orderHolder.mPrice.setText(setTotalPrice(55800, model.getA_diskon()));
                    break;
                case "7.2":
                    orderHolder.mPrice.setText(setTotalPrice(56600, model.getA_diskon()));
                    break;
                case "7.3":
                    orderHolder.mPrice.setText(setTotalPrice(57400, model.getA_diskon()));
                    break;
                case "7.4":
                    orderHolder.mPrice.setText(setTotalPrice(58200, model.getA_diskon()));
                    break;
                case "7.5":
                    orderHolder.mPrice.setText(setTotalPrice(59000, model.getA_diskon()));
                    break;
                case "7.6":
                    orderHolder.mPrice.setText(setTotalPrice(59800, model.getA_diskon()));
                    break;
                case "7.7":
                    orderHolder.mPrice.setText(setTotalPrice(60600, model.getA_diskon()));
                    break;
                case "7.8":
                    orderHolder.mPrice.setText(setTotalPrice(61400, model.getA_diskon()));
                    break;
                case "7.9":
                    orderHolder.mPrice.setText(setTotalPrice(62200, model.getA_diskon()));
                    break;
                //-8---------------
                case "8":
                    orderHolder.mPrice.setText(setTotalPrice(63000, model.getA_diskon()));
                    break;
                case "8.1":
                    orderHolder.mPrice.setText(setTotalPrice(63800, model.getA_diskon()));
                    break;
                case "8.2":
                    orderHolder.mPrice.setText(setTotalPrice(64600, model.getA_diskon()));
                    break;
                case "8.3":
                    orderHolder.mPrice.setText(setTotalPrice(65400, model.getA_diskon()));
                    break;
                case "8.4":
                    orderHolder.mPrice.setText(setTotalPrice(66200, model.getA_diskon()));
                    break;
                case "8.5":
                    orderHolder.mPrice.setText(setTotalPrice(67000, model.getA_diskon()));
                    break;
                case "8.6":
                    orderHolder.mPrice.setText(setTotalPrice(67800, model.getA_diskon()));
                    break;
                case "8.7":
                    orderHolder.mPrice.setText(setTotalPrice(68600, model.getA_diskon()));
                    break;
                case "8.8":
                    orderHolder.mPrice.setText(setTotalPrice(69400, model.getA_diskon()));
                    break;
                case "8.9":
                    orderHolder.mPrice.setText(setTotalPrice(70200, model.getA_diskon()));
                    break;
                //-9---------------
                case "9":
                    orderHolder.mPrice.setText(setTotalPrice(71000, model.getA_diskon()));
                    break;
                case "9.1":
                    orderHolder.mPrice.setText(setTotalPrice(71800, model.getA_diskon()));
                    break;
                case "9.2":
                    orderHolder.mPrice.setText(setTotalPrice(72600, model.getA_diskon()));
                    break;
                case "9.3":
                    orderHolder.mPrice.setText(setTotalPrice(73400, model.getA_diskon()));
                    break;
                case "9.4":
                    orderHolder.mPrice.setText(setTotalPrice(74200, model.getA_diskon()));
                    break;
                case "9.5":
                    orderHolder.mPrice.setText(setTotalPrice(75000, model.getA_diskon()));
                    break;
                case "9.6":
                    orderHolder.mPrice.setText(setTotalPrice(75800, model.getA_diskon()));
                    break;
                case "9.7":
                    orderHolder.mPrice.setText(setTotalPrice(76600, model.getA_diskon()));
                    break;
                case "9.8":
                    orderHolder.mPrice.setText(setTotalPrice(77400, model.getA_diskon()));
                    break;
                case "9.9":
                    orderHolder.mPrice.setText(setTotalPrice(78200, model.getA_diskon()));
                    break;
            }
        }
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laundry_list, parent, false);
        return new OrderHolder(view);
    }

    class OrderHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.doneTime)
        TextView mDoneTimeTxt;
        @BindView(R.id.orderDate)
        TextView mOrderDateTxt;
        @BindView(R.id.price)
        TextView mPrice;
        @BindView(R.id.jenis)
        TextView mjenis;
        @BindView(R.id.acceptIndicator)
        View mAcceptIndicator;
        @BindView(R.id.acceptLine)
        View mAcceptedLine;
        @BindView(R.id.prosesIndicator)
        View mProsesIndicator;
        @BindView(R.id.prosesLine)
        View mProsesLine;
        @BindView(R.id.doneIndicator)
        View mDoneIndicator;
        @BindView(R.id.doneLine)
        View mDoneLine;
        @BindView(R.id.paidIndicator)
        View mPaindIndicator;
        @BindView(R.id.paidLine)
        View mPaidLine;
        @BindView(R.id.deliveredIndicator)
        View mDeliveredIndicator;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posision = getAdapterPosition();
                    if (posision != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(getSnapshots().getSnapshot(posision), posision);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public String setTotalPrice(int price, String diskon) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        int priceInt;
        int disokonInt = Integer.valueOf(diskon);
        int hasil;
        int totalPrice;
        priceInt = price;
        hasil = priceInt * disokonInt / 100;
        totalPrice = priceInt - hasil;
        return formatter.format(totalPrice);
    }
}
