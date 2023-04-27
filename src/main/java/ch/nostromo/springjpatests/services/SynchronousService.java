package ch.nostromo.springjpatests.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SynchronousService {
    private final Logger LOG = LoggerFactory.getLogger(SynchronousService.class);

    public void synchronousMethod() {
        LOG.info("Hello from synchronous method :)");
    }
}
