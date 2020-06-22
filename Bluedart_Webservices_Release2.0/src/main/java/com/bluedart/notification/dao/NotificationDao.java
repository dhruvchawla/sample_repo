package com.bluedart.notification.dao;

import java.util.List;

import com.bluedart.notification.dto.NotificationDto;

/*
 * @author CH848113
 */
public interface NotificationDao {
	public List<NotificationDto> getNotificationLog();
	public int deleteNotificationLog(String logId);

}
