package com.swen.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import com.unity3d.player.UnityPlayer;

public class NotificationChannelManager {
    public static final String FALLBACK_CHANNEL_ID = "FallbackChannel";

    public static final String DEFAULT_CHANNEL_ID = "All";
    public static final String DEFAULT_CHANNEL_NAME = "All";
    public static final String DEFAULT_CHANNEL_DESCRIPTION = "All notifications";

    public static String createDefaultNotificationChannel(Context context) {
        return createNotificationChannel(context, DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME, DEFAULT_CHANNEL_DESCRIPTION);
    }

    public static String createNotificationChannel(Context context, String id, String name, String description) {
        int importance = 0;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
            importance = NotificationManager.IMPORTANCE_DEFAULT; // Field is API 24 +

        return createNotificationChannel(context, id, name, description, importance, true, true, false);
    }

    public static String createNotificationChannel(Context context, String id, String name, String description, int importance, boolean lights, boolean vibration, boolean bypassDoNotDisturb) {
        // NotificationChannels are API 26+
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            return FALLBACK_CHANNEL_ID;

        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
        notificationChannel.setDescription(description);
        notificationChannel.enableLights(lights);
        notificationChannel.enableVibration(vibration);
        notificationChannel.setBypassDnd(bypassDoNotDisturb);

        // Register the channel
        // We CANNOT change the notification behaviors, like 'importance', after this
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel);

        return id;
    }
}
