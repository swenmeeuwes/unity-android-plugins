package com.swen.notifications;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

public class NotificationsDirector {
    public static Notification createNotification(Context context, String notificationChannelId, String title, String content) {
        return new NotificationCompat.Builder(context, notificationChannelId)
            .setAutoCancel(true)
            .setSmallIcon(getSmallNotificationIcon(context)) //
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)
            .build();
    }

    public static Notification createNotification(Context context, String title, String content) {
        return new NotificationCompat.Builder(context)
                .setAutoCancel(true)
                .setSmallIcon(getSmallNotificationIcon(context))
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)
                .build();
    }

    private static int getSmallNotificationIcon(Context context) {
        return context.getResources()
                .getIdentifier("notification_icon_small", "drawable", context.getPackageName());
    }
}
