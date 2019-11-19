<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>영화 리스트</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <div class="movie-list-board-cinema">
        <div class="movie-list-board-title-main">
            <h3 class="movie-board-title"></h3>
        </div>   
    <span class = "screening-list">영화 리스트 </span>
        <table class="movie-board-table">

            <!-- 바디부 -->
            <colgroup>
                <col width="15%" />
                <col width="50%" />
                <col width="15%" />
                <col width="10%" />
                
            </colgroup> 

            <thead class="thead-movie-board">
                <tr class = "tr">
                    <th> MOVIE NUM </th>
                    <th> TITLE </th>
                    <th> MOVIE_GENRE </th>
                    <th> OPENING DAY </th>
                    <th> CLOSING DAY </th>
                </tr>
            </thead>
            <div class="top-menu-wrapper">
	            <div class ="search-wrapper">
	                <select name = "movie-search-category">
	                    <option value = "">글 분류</option>
	                    <option value = "">Movie_Num</option>
	                    <option value = "">Title</option>
	                    <option value = "">Movie_Genre</option>
	                    <option value = "">Opening_Day</option>
	                    <option value = "">Closing_Day</option>
	                </select>
	                <input  type = "text" title = "검색어 입력" name = "movieSearchName" placeholder = "검색어를 입력하세요">
	                <button type = "submit" class = "movie-search-btn" onclick=""><img src="/resources/img/glass.png"></button>
	            </div>
           </div> 

            <tbody class="movie-board-detail">
            <c:forEach items="${list}" var="mnlist">
                <tr class="trboard">
                    <td class="tdMovieNo">${mnlist.movie_num}</td>
                    <td class="tdTitle"><a href="${path}/MN_Movie_Board/MN_movie_detail?movie_num=${mnlist.movie_num}">${mnlist.title}</a> </td>
                    <td class="tdMovieGenre">${mnlist.movie_genre}</td>
                    <td class="tdOpeningDay">${mnlist.opening_day}</td>
                    <td class="tdClosingDay">${mnlist.closing_day}</td>
                </tr>
            </c:forEach>  
            </tbody>
        </table> 
      
        <div class="movie-reg-button-wrapper">
            <button type = "button" class = "movie-writing-btn" onclick = "fregister()">등록</button>

       </div>
            <!--버텀부-->
        <div class="movie-board-bottom">
          
            <tfoot>
                <tr>
                   <!--  <td colspan="5" class="tdFoot">  -->
                   
                    	<c:if test="${pageMaker.prev}">
                    	<a href="${path}/MN_Movie_Board/MN_movie_list?page=${pageMaker.startPage-1}&laquo;"><</a>
                    </c:if> 
                    <c:forEach begin="${pageMaker.startPage}" end = "${pageMaker.endPage}" var = "idx">
        
                    	<%-- 	<c:out value="${pageMaker.cri.page==idx?'class=active':''}"/> --%>
	                    	<a href="${path}/MN_Movie_Board/MN_movie_list?page=${idx}">${idx}</a>
	                   
                    </c:forEach>
                  	<c:if test = "${pageMaker.next && pageMaker.endPage > 0}">
                    	<a href="${path}/MN_Movie_Board/MN_movie_list?page=${pageMaker.endPage+1}">&raquo;</a>
                    </c:if> 
                   
                 <!--   </td> -->
                </tr>
        </div>
    
    </div>
    
     <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  
    <script>
	    function fregister() {
	    	
	        window.location = "MN_movie_register";
	    }
    </script>
 
</body>
</html>