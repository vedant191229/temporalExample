package com.temporal.resources;

import com.temporal.core.User;
import com.temporal.db.userDAO;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;


public class addUserWorkflowImpl implements addUserWorkflow {

        ActivityOptions options = ActivityOptions.newBuilder()
                .setStartToCloseTimeout(Duration.ofSeconds(60))
                .build();
        private final userDAO ADD = Workflow.newActivityStub(userDAO.class, options);

        @Override
        public void addUser(User user) {
            ADD.addUserinDB(user);
        }
}
