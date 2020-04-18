package com.tiunida.laundry0.FirebseMessagingService;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.tiunida.laundry0.R;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private NotificationManager mNotifMngr;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        mNotifMngr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        String channelId = getString(R.string.default_notification_channel_id);
        String channelName = getString(R.string.default_notification_channel_name);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(channelId, channelName);
        }

        createNotificationBuilder(channelId, remoteMessage);

    }

    private void createNotificationBuilder(String channelId, RemoteMessage remoteMessage) {

        int mNotificationId = (int) System.currentTimeMillis();

        String messageTitle = remoteMessage.getNotification().getTitle();
        String messageBody = remoteMessage.getNotification().getBody();
        String click_action = remoteMessage.getNotification().getClickAction();

        String dataMessage = remoteMessage.getData().get("message");
        String dataFrom = remoteMessage.getData().get("from_user_id");
        String id = remoteMessage.getData().get("order_id");

        Intent intent = new Intent(click_action);
        intent.putExtra("message", dataMessage);
        intent.putExtra("from_user_id", dataFrom);
        intent.putExtra("order_id", id);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        getApplicationContext(),
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.mipmap.laundry_u3_app)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);

        mNotifMngr.notify(mNotificationId, mBuilder.build());

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName) {
        String description = "LaundryChannel";

        NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        channel.setDescription(description);
        channel.enableVibration(true);
        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        mNotifMngr.createNotificationChannel(channel);
    }
}
