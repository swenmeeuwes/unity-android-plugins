using UnityEngine;

namespace AndroidPlugins.Notifications
{
    public class AndroidNotification
    {
        private readonly string _channelId;
        private readonly int _id;
        private readonly string _title;
        private readonly string _content;

        public AndroidNotification(string channelId, int id, string title, string content)
        {
            _channelId = channelId;
            _id = id;
            _title = title;
            _content = content;
        }

        public void Show()
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            NotificationsAndroidProxy.AndroidJavaClass.CallStatic("showNotification", _channelId, _id, _title, _content);
#else
            Debug.LogWarning("Android notifications are not supported on this platform");
#endif
        }
    }
}