package com.swen.notifications;

import android.app.Activity;
import android.app.Notification;
import android.support.v4.app.NotificationManagerCompat;

import com.unity3d.player.UnityPlayer;

/** A proxy between Android and Unity, to be called from Unity C# code
 * @author Swen Meeuwes
 */
public class NotificationsUnityProxy {
    private static Activity unityActivity = UnityPlayer.currentActivity; // Serves as 'Context' in many cases

    public static String createNotificationChannel(String id, String name, String description) {
        return NotificationChannelManager.createNotificationChannel(unityActivity, id, name, description);
    }

    public static String createNotificationChannel(String id, String name, String description, int importance, boolean lights, boolean vibration, boolean bypassDoNotDisturb) {
        return NotificationChannelManager.createNotificationChannel(unityActivity, id, name, description, importance, lights, vibration, bypassDoNotDisturb);
    }

    public static void showNotification(String notificationChannelId, int notificationId, String title, String content) {
        Notification notification = NotificationsDirector.createNotification(unityActivity, notificationChannelId, title, content);
        showNotification(notificationId, notification);
    }

    private static void showNotification(int id, Notification notification) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(unityActivity);
        notificationManager.notify(id, notification);
    }
}
