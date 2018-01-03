package com.webonise.rbs.serviceImpl;

import com.webonise.rbs.entity.Event;
import com.webonise.rbs.repository.EventRepository;
import com.webonise.rbs.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() throws Exception {
        try {
            return eventRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error in listing all events.");
            throw ex;
        }
    }
}

