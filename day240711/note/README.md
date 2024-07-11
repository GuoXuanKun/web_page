# Note 240711
## Review
### JSTL
- 默认值 
  - `<c:out value="${stu}" default="查无信息"></c:out>`
- 分支结构
  - if
    - ````
      <c:set var="age"  value="28"></c:set>

      <c:if test="${age<18}">
      未成年
      </c:if>
      <c:if test="${age<30}">
      青年
      </c:if>
  - choose 
    - ````
      <c:choose>
      <c:when test="${age<18}">
          未成年
      </c:when>
      <c:when test="${age<30}">
          青年
      </c:when>
      <c:when test="${age<60}">
          中年
      </c:when>
      <c:otherwise>
          老年
      </c:otherwise>
      </c:choose>
      
- 集合变量
  - foreach
    - index：当前迭代的索引，从0开始。
    - count：当前迭代的计数，从1开始。
    - first：如果当前迭代是第一次，返回 true。
    - last：如果当前迭代是最后一次，返回 true。
    - begin：迭代的起始索引。
    - end：迭代的结束索引。
    - step：迭代的步长。
    - ````
      JSTL（JavaServer Pages Standard Tag Library）是用于Java EE Web应用程序的标准标签库，提供了一组标签来简化常见的Web开发任务。<c:forEach> 是 JSTL 中一个常用的标签，用于迭代集合或数组。以下是 <c:forEach> 标签的一些常用属性：

      1. items

         描述：要迭代的集合、数组、Map或其他可迭代对象。
         用法：<c:forEach items="${collection}" ...>

      
      2. var
      
         描述：在每次迭代时保存当前项的变量名。
         用法：<c:forEach items="${collection}" var="item">
      
      
      3. varStatus
      
         描述：保存迭代状态的变量名。该变量是一个 LoopTagStatus 对象，提供了当前迭代的状态信息。
         用法：<c:forEach items="${collection}" var="item" varStatus="status">
      
      
      4. begin
      
         描述：指定从哪个索引开始迭代。索引从0开始。
         用法：<c:forEach items="${collection}" begin="2">
      
      
      5. end
      
         描述：指定迭代到哪个索引结束。索引从0开始。
         用法：<c:forEach items="${collection}" end="5">
      
      
      6. step
      
         描述：指定每次迭代的步长，即每次迭代时索引的增量。
         用法：<c:forEach items="${collection}" step="2">
      
  - forTokens
    - ``````
      <c:set var="msg" scope="request" value="今*天*天*气*不*错"></c:set>

      <%--    ${msg}--%>
  
      <c:forTokens items="${msg}" delims="*" var="m" varStatus="status">
      第${status.count}个: ${m}<br/>
  
      </c:forTokens>
    - 在JSTL（JavaServer Pages Standard Tag Library）中，<c:forTokens>标签用于迭代一个由分隔符分隔的字符串，并根据分隔符将其拆分为多个部分。这个标签常用的属性包括：

      items: 这是<c:forTokens>标签的必需属性，指定要迭代的字符串。通常是一个字符串变量或字符串文字。

      delims: 这是可选属性，用于指定分隔符，将字符串分割为多个部分。默认情况下，分隔符是逗号（,），但可以根据需要指定不同的字符或字符串作为分隔符。

      var: 这是必需属性，指定迭代过程中当前部分的变量名。在每次迭代中，这个变量会被赋值为当前部分的值。

      varStatus: 这是可选属性，它指定一个变量来保存迭代状态信息，例如迭代的索引或计数器。可以通过这个变量访问当前迭代的索引、计数、是否是第一个或最后一个迭代等信息。

      
