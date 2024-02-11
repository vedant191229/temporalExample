package com.temporal.db;

import com.temporal.core.User;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface userDAO {

    @ActivityMethod
    void addUserinDB(User user);

//    User getUserDetails(String email);
}
