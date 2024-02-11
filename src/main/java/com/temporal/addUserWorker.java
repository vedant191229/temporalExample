package com.temporal;

import com.temporal.Shared;
import com.temporal.db.userDAOImpl;
import com.temporal.resources.addUserWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class addUserWorker {

    public static void main(String[] args) {

        // WorkflowServiceStubs is a gRPC stubs wrapper that talks to the local Docker instance of the Temporal server.
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);

        // Worker factory is used to create Workers that poll specific Task Queues.
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(Shared.ADD_USER_TASK_QUEUE);

        // This Worker hosts both Workflow and Activity implementations.
        // Workflows are stateful so a type is needed to create instances.

        worker.registerWorkflowImplementationTypes(addUserWorkflowImpl.class);
        // Activities are stateless and thread safe so a shared instance is used.
        worker.registerActivitiesImplementations(new userDAOImpl());
        // Start listening to the Task Queue.
        factory.start();
    }
}
