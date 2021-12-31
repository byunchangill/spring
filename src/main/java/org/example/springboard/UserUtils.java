package org.example.springboard;

import org.example.springboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

import static org.example.springboard.Const.LOGIN_USER;

@Component
public class UserUtils {
    @Autowired
    private HttpSession session;

    public int getLoginUserPk() {
        return getLoginUser() == null ? 0 : getLoginUser().getIuser();
    }

    public UserEntity getLoginUser() {
        return (UserEntity) session.getAttribute(Const.LOGIN_USER);
    }
}
