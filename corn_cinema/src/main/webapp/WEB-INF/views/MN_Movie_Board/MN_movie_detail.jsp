<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title> 영화 상세 페이지( ${mnMovieRead.movie_num} )</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <div class="mn-movie-detail">
      <form class="mn-movie-detail-form" method="GET">
      
      
       <input type ="hidden" name = "movie_num" value ="${mnMovieRead.movie_num}">
       <input type ="hidden" name = "page" value ="${cri.page}">
       <input type ="hidden" name = "page" value ="${cri.page}">
   
          <div class="mn-movie-detail-wrap">
            <table class="mn-movie-detail-table">
              <caption class="mn-movie-detail-board-title">영화 상세</caption>

              <tbody>
                <tr>
                    <th><label for="detail-title"></label>제  목 : </label></th>
                    <td><input type = "text" value = "${mnMovieRead.title}" disabled /></td>
                </tr>

                <tr>
                  <th><label for="detail-director">감  독 : </label></th>
                  <td><input type = "text" value ="${mnMovieRead.director}" disabled /></td>
                </tr>

                <tr>
                  <th><label for="detail-actor">출연배우 : </label></th>
                  <td><input type = "text" value ="${mnMovieRead.actor}" disabled /></td>
                </tr>
                
                <tr>
                  <th><label for="detail-film-grade">등  급 : </label></th>
                  <td><input type = "text"  value = "${mnMovieRead.film_rate}"disabled /></td>  
                </tr>
				<tr>
                  <th><label for="detail-movie_genre">장  르 : </label></th>
                  <td><input type="text" value = "${mnMovieRead.movie_genre}"/></td>
                </tr>
                <tr>
                  <th><label for="detail-running-time">상영시간 : </label></th>
                  <td>
                      <input type = "text"  value = "${mnMovieRead.running_time}" disabled /></td>
                  </td>
                </tr>
              
                <tr>
                  <th><label for="detail-opening-day">개봉일자 : </label></th>
                  <td  class = "detail-screening-date">
                    	<input type = "text" value = "${mnMovieRead.opening_day}" disabled />
                    <label for="detail-closing-day">종영일자 : </label>
                    	<input type = "text" value ="${mnMovieRead.closing_day}" disabled />
                  </td>
                </tr>

                <tr>
                  <th><label for="detail-file">첨부파일 : </label></th>
                  <td><input type="text" value = "${mnMovieRead.view_name}"  disabled/></td>
                </tr>

                <tr>
                  <th><label for="detail-description">줄거리</label></th>
                  <td><textarea class="detail-movietext" name="detail-description" disabled>${mnMovieRead.story}</textarea></td>
                </tr>

              </tbody>
            </table>
          </div>

          <div class="detail-submit-wapper">
              <input type="button" value="목록" class="detail-list-btn"/>
              <a href = "${path}/MN_Movie_Board/MN_movie_modify?movie_num=${mnMovieRead.movie_num}" class="detail-modify-btn">수정</a>
          </div>

      </form>
    </div>
    
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script>
    
    $(".detail-list-btn").on("click", function (){
    	console.log("detail-list-btn on click ")
   		
    	.mn-movie-detail-form.attr("method", "GET");
    	/* formObJ.attr("action", "${path}/MN_Movie_Board/MN_movie_list"); */
    	formObj.submit();
    });
    
    
    </script>
    
    
  </body>
  
</html>