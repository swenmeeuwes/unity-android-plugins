using System;
using AndroidPlugins.Notifications;
using UnityEngine;

public class NotificationExample : MonoBehaviour
{
    private string _notificationChannelId = "general";

    private void Start()
    {
        var notificationChannel = new AndroidNotificationChannel(_notificationChannelId, "General", "General notifications", 
            AndroidNotificationChannel.ChannelImportance.High);
        _notificationChannelId = notificationChannel.Register();
    }

    public void TriggerExampleNotification()
    {
        var notification = new AndroidNotification(_notificationChannelId, 0, "Example notification",
            string.Format("This is an example notification, triggered at {0}", DateTime.Now.ToShortTimeString()));
        notification.Show();
    }
}
