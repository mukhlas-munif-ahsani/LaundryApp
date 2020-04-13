package com.tiunida.laundry0.FirebseMessagingService;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.tiunida.laundry0.ActivityOrderDetail.View.OrderDetailActivity;
import com.tiunida.laundry0.ActivitySetup.Model.SetupRepository;
import com.tiunida.laundry0.R;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String messageTitle = remoteMessage.getNotification().getTitle();
        String messageBody = remoteMessage.getNotification().getBody();

        String click_action = remoteMessage.getNotification().getClickAction();
        String dataMessage = remoteMessage.getData().get("message");
        String dataFrom = remoteMessage.getData().get("from_user_id");
        String id = remoteMessage.getData().get("order_id");

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, getString(R.string.default_notification_channel_id))
                        .setSmallIcon(R.mipmap.laundry_u3_app)
                        .setContentTitle(messageTitle)
                        .setContentText(messageBody);

        Intent intent = new Intent(click_action);
        intent.putExtra("message", dataMessage);
        intent.putExtra("from_user_id", dataFrom);
        intent.putExtra("id", id);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        getApplicationContext(),
                        0,
                        intent,
                        PendingIntent.FLAG_CANCEL_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);

        int mNotificationId = (int) System.currentTimeMillis();

        NotificationManager mNotifMngr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        mNotifMngr.notify(mNotificationId, mBuilder.build());

    }
}
