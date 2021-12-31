package org.example.springboard.user;

import org.example.springboard.Const;
import org.example.springboard.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private HttpSession hs;

    public int join(UserEntity entity) {
        String plainPw = entity.getUpw();
        String hashPw = BCrypt.hashpw(entity.getUpw(), BCrypt.gensalt());
        entity.setUpw(hashPw);
        int result = mapper.join(entity);
        entity.setUpw(plainPw);
        return result;
    }

    public int login(UserEntity entity) {
        UserEntity loginUser = null;
        try {
            loginUser = mapper.selUser(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        if(loginUser == null) {
            return 2; // 아이디 없음.
        }
        // 암호 비교.
        if(BCrypt.checkpw(entity.getUpw(), loginUser.getUpw())) { // 비밀번호 맞을때.
            loginUser.setUpw(null);
            loginUser.setRdt(null);
            hs.setAttribute(Const.LOGIN_USER, loginUser);
            return 1;
        }
        return 3; // 비밀번호 틀림.
    }
}
