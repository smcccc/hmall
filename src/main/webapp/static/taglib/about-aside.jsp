<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<aside class="left">
	<nav class="nav">
		<ul>
			<c:forEach items="${categories}" var="ite">
				<li <c:if test="${ite.categories.contains(category)}">class="open"</c:if> ><span>${ite.category.title}<i></i></span>
					<ul>
						<c:forEach items="${ite.categories}" var="item">
							<li <c:if test="${item.id==category.id}">class="this"</c:if> >
								<a href="${baseUrl}/about?categoryId=${item.id}">${item.title}</a>
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</nav>
</aside>
<script type="text/javascript">
	$('.nav>ul>li').on('click', 'span', function() {
		var $li = $(this).parent()
		var open = $li.hasClass('open');
		if(open) {
			$li.removeClass('open');
		} else {
			$li.addClass('open').siblings('li').removeClass('open');
		}
	})
</script>