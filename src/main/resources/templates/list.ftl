<!DOCTYPE html>
<#setting datetime_format="yyyy-MM-dd HH:mm:ss"/>
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
            <th>创建时间</th>
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
            <#--<td>${user.createTime?string("yyyy-MM-dd")}</td>-->
            </td><td>${user.createTime!""}</td>
            <td>${user.updateTime!""}

            <td>
            <#if user.role??>
              <#if user.role==1>
                   管理员
              <#else>
                平民
              </#if>
                <#else>
                222
            </#if>

            </td>
            <td><a href="/user/save" >编辑</a>&nbsp;&nbsp;
                <a href="/user/delete/${user.id}">删除</a>
            </td>
        </tr>
        </#list>
    </table>
   <hr>
   <#assign seq = ["winter", "spring", "summer", "autumn"]>
  <#list seq as x>
    ${x_index + 1}. ${x}<#if x_has_next>,</#if>
   </#list>
   <hr>
   <#if user?exists>ss</#if>
   直接嵌套${"hello , ${seq[0]}"}
   加号${"hello , " + seq[1]}<br>
   <#assign data = "abcd1234" >
   第一个字母大写：${data?cap_first}
   所有字母小写：${data?lower_case}
   所有字母大写：${data?upper_case}
 <#assign floatData = 12.34>
   数值取整数：${floatData?int}
   获取集合的长度：${users?size}

   <#assign user='huang'> <#--定义user变量-->
   ${user[2]} ${user[1..4]}
   <hr>
   <p>map使用</p>
   <#list map?keys as key >
    key---->${key}
   value -->${map[key]!"null"}<br>
   </#list>
      <#list map?values as value >
       value:${value}
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