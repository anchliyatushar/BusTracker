package com.example.tushar.aad;

import android.app.Service;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this," HIII")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(refreshedToken)
                .setContentText(refreshedToken)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        int notificationId = (int) System.currentTimeMillis();

        notificationManager.notify(notificationId, mBuilder.build());

    }
}
