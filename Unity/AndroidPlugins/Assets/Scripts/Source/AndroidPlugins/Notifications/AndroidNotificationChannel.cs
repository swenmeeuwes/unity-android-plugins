using UnityEngine;

namespace AndroidPlugins.Notifications
{
    public class AndroidNotificationChannel
    {
        // Required
        public readonly string Id;
        public readonly string Name;
        public readonly string Description;

        // Defaulted
        public readonly ChannelImportance Importance;
        public readonly bool Lights;
        public readonly bool Vibration;
        public readonly bool BypassDoNotDisturb;

        public AndroidNotificationChannel(string id, string name, string description, ChannelImportance importance = ChannelImportance.Default)
        {
            Id = id;
            Name = name;
            Description = description;
            Importance = importance;
            Lights = true;
            Vibration = true;
            BypassDoNotDisturb = false;
        }

        public AndroidNotificationChannel(string id, string name, string description, ChannelImportance importance, bool lights, bool vibration, bool bypassDoNotDisturb)
        {
            Id = id;
            Name = name;
            Description = description;
            Importance = importance;
            Lights = lights;
            Vibration = vibration;
            BypassDoNotDisturb = bypassDoNotDisturb;
        }

        /// <summary>
        /// Registers the notification channel to the Android system
        /// </summary>
        /// <returns>The created Android notification channel id</returns>
        public string Register()
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            return NotificationsAndroidProxy.AndroidJavaClass.CallStatic<string>("createNotificationChannel", Id, Name, Description, (int)Importance, Lights, Vibration, BypassDoNotDisturb);
#else
            Debug.LogWarning("Android notifications are not supported on this platform");
            return null;
#endif
        }

        // For more information about importance levels: https://developer.android.com/training/notify-user/channels#importance
        public enum ChannelImportance
        {
            Unspecified = -1000,
            None = 0,
            Min = 1,
            Low = 2,
            Default = 3,
            High = 4,
            Max = 5
        }
    }
}