# Note 240712
## Review
### JSPT
- 分支 结构
  - choose
    - ````
      <c:choose>
        <c:when test="${pageInfo.pageIndex>1}">
            <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.pageIndex-1}" >上一页</a>
        </c:when>
        <c:otherwise>
             上一页
        </c:otherwise>
      </c:choose>