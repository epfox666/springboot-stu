package com.epfox.config;

import com.epfox.pojo.User;
import com.epfox.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        //获取当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;


//        //用户名、密码 去数据库中取
//        String name = "root";
//        String password="123456";
//        if(!userToken.getUsername().equals(name)){
//            return null;//抛出异常 UnknownAccountException
//        }
//
//        //密码认证 shiro做!
//        return new SimpleAuthenticationInfo("",password,"");


        //连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());

        if(user==null){ //没有这个人
            return null;//抛出异常 UnknownAccountException
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);


        //密码认证 shiro做!
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
