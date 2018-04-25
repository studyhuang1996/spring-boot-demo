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
            <th>用户名</th>
            <th>密码</th>
            <th>回答</th>
            <th>用户名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
             <td>${user.answer!" no answer"}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><button type="button" >编辑</button>&nbsp;&nbsp;
                <button type="button" onclick="" >删除</button>
            </td>
        </tr>
        </#list>
    </table>
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
   <p>map使用</p>
   <#list map?keys as key >
    key---->${key}<br/>
   value -->${map[key]!"null"}<br>
   </#list>
   <#include "footer.ftl"/>
</body>
</html>