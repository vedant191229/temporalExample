package com.temporal.resources;

import com.temporal.core.User;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface addUserWorkflow {

    @WorkflowMethod
    void addUser(User user);
}
