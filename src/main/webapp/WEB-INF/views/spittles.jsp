<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>Spittr</title>

  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">

  <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
  <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
  <!--[if lt IE 9]>
  <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container">
  <div class="spittleForm">
    <h1>Spit it out...</h1>
    <form method="POST" class="form-group">
      <input type="hidden" name="latitude">
      <input type="hidden" name="longitude">
      <textarea name="message" cols="80" rows="5" class="form-control"></textarea><br/>
      <button type="submit" value="Add" class="btn btn-default" >Add</button>
    </form>
  </div>
  <div class="listTitle">
    <h1>Recent Spittles</h1>
    <ul class="list-group">
      <c:forEach items="${spittleList}" var="spittle" >
        <li id="spittle_<c:out value="spittle.id"/>" class="list-group-item">
          <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
          <div>
            <span class="spittleTime"><c:out value="${spittle.time}" /></span>
            <c:if test="spittle.latitude!=null&&spittle.longitude!=null">
              <span class="spittleLocation">(<c:out value="${spittle.latitude}" />, <c:out value="${spittle.longitude}" />)</span>
            </c:if>
          </div>
        </li>
      </c:forEach>
    </ul>
    <c:if test="${fn:length(spittleList) gt 20}">
      <hr />
      <s:url value="/spittles?count=${nextCount}" var="more_url" />
      <a href="${more_url}">Show more</a>
    </c:if>
  </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>