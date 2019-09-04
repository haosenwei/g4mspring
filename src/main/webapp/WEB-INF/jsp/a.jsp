<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>lcd</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>你好，世界！</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form id="form" class="form-inline">
                <div class="row">
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v0" type="checkbox">0
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v1" type="checkbox">1
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v2" type="checkbox">2
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v3" type="checkbox">3
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v4" type="checkbox">4
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v5" type="checkbox">5
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v6" type="checkbox">6
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v7" type="checkbox">7
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="v8" type="checkbox">8
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="vrs" type="checkbox">rs
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="checkbox">
                            <label>
                                <input name="vrw" type="checkbox">
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <button type="button" id="sendValue" class="btn btn-default">发送</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5">
                        <div>
                            <label>
                                <input name="textValue" type="text" value="0,0,0,0,0,0,0,0,0,0">
                            </label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <button type="button" id="sendValue2" class="btn btn-default">发送</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th>data0</th>
                        <th>data1</th>
                        <th>data2</th>
                        <th>data3</th>
                        <th>data4</th>
                        <th>data5</th>
                        <th>data6</th>
                        <th>data7</th>
                        <th>rs</th>
                        <th>rw</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

</body>

<script type="text/javascript">
    $("#sendValue").click(function function_name() {
        var value = "";
        var v0 = $("input[name='v0']:checked").val() ? 1 : 0;
        var v1 = $("input[name='v1']:checked").val() ? 1 : 0;
        var v2 = $("input[name='v2']:checked").val() ? 1 : 0;
        var v3 = $("input[name='v3']:checked").val() ? 1 : 0;
        var v4 = $("input[name='v4']:checked").val() ? 1 : 0;
        var v5 = $("input[name='v5']:checked").val() ? 1 : 0;
        var v6 = $("input[name='v6']:checked").val() ? 1 : 0;
        var v7 = $("input[name='v7']:checked").val() ? 1 : 0;
        var vrs = $("input[name='vrs']:checked").val() ? 1 : 0;
        var vrw = $("input[name='vrw']:checked").val() ? 1 : 0;
        value = v0 + "," + v1 + "," + v2 + "," + v3 + "," + v4 + "," + v5 + "," + v6 + "," + v7 + "," + vrs + "," + vrw;
        console.log(value);
        send(value);
    });

    function send(textValue) {
        var date = $.ajax({url: "/lcdOperation?id=" + textValue, async: false});
        console.log(date)
        var split = textValue.split(",", 10);
        var html = "<tr>";
        html += "<td>" + split[0] + "</td>";
        html += "<td>" + split[1] + "</td>";
        html += "<td>" + split[2] + "</td>";
        html += "<td>" + split[3] + "</td>";
        html += "<td>" + split[4] + "</td>";
        html += "<td>" + split[5] + "</td>";
        html += "<td>" + split[6] + "</td>";
        html += "<td>" + split[7] + "</td>";
        html += "<td>" + split[8] + "</td>";
        html += "<td>" + split[9] + "</td>";
        html += "<td onclick=\"send('" + textValue + "')\">重发</td>";
        html += "</tr>";
        $("table > tbody").append(html);


    }

    $("#sendValue2").click(function () {
        var textValue = $("input[name='textValue']").val()
        console.log(textValue);
        send(textValue);
    });

</script>
</html>