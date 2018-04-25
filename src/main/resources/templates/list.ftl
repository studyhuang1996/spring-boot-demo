<!DOCTYPE html>
<!--
  ~ @(#) list.html
  ~ <br> @author huang
  ~ <br> 2018-04-25 11:03:07
  -->

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
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
   </#list>
   <p>使用list遍历</p>
    <#list users as user>
      username: ${user.username}<br>
      password:${user.password}<br>
      answer:${user.answer!" 没有答案"} 不存在值判断!<br>
    <p>使用if判断</p>
    <#if user.username=='123123'>
        ${user.username}  go to fujian!!!!!!!!<br>
    <#else>
       to 叙利亚
    </#if>
    </#list>

   <#include "footer.ftl"/>
</body>
</html>