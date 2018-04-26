# spring-boot-demo
2018.4.23


1. 起步依赖
2. 自动配置
3. spring boot的优势 和spring的区别
   - spring boot减少了很多以前spring MVC中所需要的xml配置，配置更简单
   - spring boot中的起步依赖，利用maven的依赖传递，可以更好的构建项目，不用在向spring一样，要考虑maven的依赖的版本和版本之间的兼容或者冲突。
   - spring boot内置Tomcat容器，不用在自己部署，部署更简单
   - spring boot 可以入FreeMarker依赖
4. spring boot 


#### 2018.4.25

* 在spring boot demo中加入FreeMarker模板引擎，输出文本。

  1. 在pom.xml文件中加入FreeMarker依赖

     ```
            <dependency>
     			<groupId>org.springframework.boot</groupId>
     			<artifactId>spring-boot-starter-freemarker</artifactId>
     		</dependency>
     ```

  2. 配置application.properties

     ```
     spring.freemarker.allow-request-override=false
     spring.freemarker.cache=false #是否缓存模板
     spring.freemarker.check-template-location=true
     spring.freemarker.charset=UTF-8 #字符编码
     spring.freemarker.content-type=text/html
     spring.freemarker.expose-request-attributes=true
     spring.freemarker.expose-session-attributes=true
     spring.freemarker.expose-spring-macro-helpers=false
     spring.freemarker.request-context-attribute=request
     spring.freemarker.suffix=.ftl #后缀
     #静态资源路径
     spring.resources.static-locations=classpath:/static,classpath:/resources/static/
     spring.freemarker.template-loader-path=classpath:/templates #模板路径
     ```

  3. Controller控制层

     ```
     @RequestMapping("lists")
         public String listUser(Map<String,Object> maps){
            List<User> users = userService.listUsers();
            if (CollectionUtils.isEmpty(users)){
                return "list";
            }
            Map<String,Object> map = new HashMap<>();
            map.put("first","dddd");
            map.put("second","yyyy");
            map.put("username",new User("huang"));
            maps.put("map",map);
            maps.put("users",users);
            return "list";
         }
     ```

  4. 前端页面 list.ftl

     ```
     <body>
        <p>include引入文件</p>
        <#include "header.ftl"/>
        <hr>
         <center>用户列表显示:</center> <br>
         <table align="center">
             <tr>
                 <th>编号</th>
                 <th>用户名</th>
                 <th>密码</th>
                 <th>回答</th>
                 <th>问题</th>
                 <th>手机</th>
                 <th>邮箱</th>
                 <th>角色</th>
                 <th>操作</th>
             </tr>
             <#list users as user>
             <tr>
                 <td>${user.id}</td>
                 <td>${user.username}</td>
                 <td>${user.password}</td>
                  <td>${user.answer!" no answer"}</td>
                 <td>${user.question!" no question"}</td>
                 <td>${user.phone!""}</td>
                 <td>${user.email!""}</td>
                 <td>
                     <#if user.role==1>
                        管理员
                    <#else>
                     平民
                 </#if>
                 </td>
                 <td><a href="/user/save" >编辑</a>&nbsp;&nbsp;
                     <a href="/user/delete/${user.id}">删除</a>
                 </td>
             </tr>
             </#list>
         </table>
        <p>map使用</p>
        <#list map?keys as key >
         key---->${key}<br/>
        value -->${map[key]!"null"}<br>
        </body>
     ```

     5. 效果图

        ![页面效果图](http://img.studyhuang.cn/freemarker.jpg)

​    6.[FreeMarker的学习中常用语法]("http://studyhuang.cn/2018/04/25/1/#more")

#### 2018.4.26

