<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login">
    <form action="/login" method="post">
        <fieldset>
            <legend>输入用户名和密码</legend>
            <ul>
                <li>
                    <label for="userName">用户名</label>
                    <input id="userName" name="userName" type="text"/>
                </li>
                <li>
                    <label for="password">密  码</label>
                    <input id="password" name="password" type="password"/>
                </li>
                <li>
                    <label for="submitBtn"></label>
                    <input id="submitBtn" type="submit" value="提交">
                </li>
            </ul>
        </fieldset>
    </form>
</div>

<script>
    $(function () {

    });

    function submit() {
        var data = $(this).serialize();
        $.ajax({
            url: "/login",
            type: "post",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data),
            success: function () {
                alert("success")
            },
            error: function () {
                alert("error");
            }
        })
    }


</script>