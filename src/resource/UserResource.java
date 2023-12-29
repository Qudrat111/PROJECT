package resource;

import bean.ApiResponse;
import bean.UserBean;
import repositery.DB;

public class UserResource {

    public ApiResponse register(UserBean bean) {
        UserBean user = DB.addUser(bean);
        if (user == null) {
            return new ApiResponse(400, "Failed", user);
        }
        return new ApiResponse(200, "Success", user);
    }

    public ApiResponse logIn(UserBean bean) {
        UserBean user = DB.getUser(bean);
        if (user == null) {
            return new ApiResponse(400, "Failed", user);
        }
        return new ApiResponse(200, "Success", user);

    }
}
