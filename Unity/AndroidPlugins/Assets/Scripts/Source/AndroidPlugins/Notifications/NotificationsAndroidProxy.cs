using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace AndroidPlugins.Notifications
{
    public class NotificationsAndroidProxy
    {
        private static AndroidJavaClass _androidJavaClass;

        public static AndroidJavaClass AndroidJavaClass
        {
            get
            {
                if (_androidJavaClass == null)
                    _androidJavaClass = new AndroidJavaClass("com.swen.notifications.NotificationsUnityProxy");

                return _androidJavaClass;
            }
        }
    }
}
