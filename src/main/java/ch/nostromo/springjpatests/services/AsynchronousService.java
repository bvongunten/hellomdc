package ch.nostromo.springjpatests.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {
    private final Logger LOG = LoggerFactory.getLogger(AsynchronousService.class);

    @Async
    public void asynchronousMethod() {
        LOG.info("Hello from asynchronous method :)");
    }
}
