package io.github.kongeor.p4n.util;

import com.intellij.notification.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;

public class MessageUtil {

    private static final NotificationGroup GROUP_DISPLAY_ID_INFO =
	new NotificationGroup("p4n notifications",
	    NotificationDisplayType.BALLOON, true);

    private static void showMessage(String message, NotificationType type) {
	ApplicationManager.getApplication().invokeLater(() -> {
	    Notification notification = GROUP_DISPLAY_ID_INFO.createNotification(message, type);
	    Project[] projects = ProjectManager.getInstance().getOpenProjects();
	    Notifications.Bus.notify(notification, projects[0]);
	});
    }

    public static void showInfo(String message) {
        showMessage(message, NotificationType.INFORMATION);
    }

    public static void showError(String message) {
	showMessage(message, NotificationType.ERROR);
    }
}
