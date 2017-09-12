package io.pivotal.pal.tracker.allocations;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestOperations;

public class ProjectClient {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RestOperations restOperations;
    private final String registrationServerEndpoint;

    public ProjectClient(RestOperations restOperations, String registrationServerEndpoint) {
        this.restOperations= restOperations;
        this.registrationServerEndpoint = registrationServerEndpoint;
    }

    public ProjectInfo getProject(long projectId) {
        logger.info("Allocations 获取Projects= {}/projects/{}",registrationServerEndpoint,projectId);

        return restOperations.getForObject(registrationServerEndpoint + "/projects/" + projectId, ProjectInfo.class);
    }
}
