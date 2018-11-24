<#ftl encoding="utf-8">
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>
    hello freemarker
</h1>
<p>
number:${number}<br>
<#list list as i>
    item: i<br>
</#list>
<br>

string:${string}<br>

bool:${boolean?c}<br>


</body>
</html>