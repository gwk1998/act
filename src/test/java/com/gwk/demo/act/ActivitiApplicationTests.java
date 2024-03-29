package com.gwk.demo.act;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ActivitiApplicationTests {
    @Autowired
    private ProcessEngine processEngine;

    /**
     * 流程定义的部署
     */
    @Test
    public void createDeploy() {
        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
            .addClasspathResource("processes/holiday.bpmn")//添加bpmn资源
            .name("请假申请单流程")
            .deploy();

        log.info("流程部署id:" + deployment.getName());
        log.info("流程部署名称:" + deployment.getId());
    }
}
