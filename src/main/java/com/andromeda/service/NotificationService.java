package com.andromeda.service;

import com.andromeda.dto.NotificationDTO;
import com.andromeda.entity.Notification;
import com.andromeda.repository.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public NotificationDTO saveNotification(NotificationDTO notificationDTO) {
        Notification notification = modelMapper.map(notificationDTO, Notification.class);
        notification = notificationRepository.save(notification);
        return modelMapper.map(notification, NotificationDTO.class);
    }

    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(notification -> modelMapper.map(notification, NotificationDTO.class))
                .collect(Collectors.toList());
    }

    public NotificationDTO getNotificationById(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        return notification.map(value -> modelMapper.map(value, NotificationDTO.class)).orElse(null);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
