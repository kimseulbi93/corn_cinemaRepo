<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>영화 등록 페이지</title>
  <link rel="stylesheet" href="/resources/css/style.css">
</head>
 <body>
    <div class="mn-movie-register">
      <form class="mn-movie-register-form" method="POST" enctype="multipart/form-data">
  
          <div class="mn-movie-register-wrap">
            <table class="mn-movie-register-table">
              <caption class="mn-movie-register-board-title"> 영화 등록</caption>

              <tbody>

                <tr>
                    <th><label for="register-title">제  목 : </label></th>
                    <td><input type="text" title="제목" id="register-title" name="title"/></td>
                </tr>

                <tr>
                  <th><label for="register-director">감  독 : </label></th>
                  <td><input type="text"  title="register-director" id="register-director" name="director"/></td>
                </tr>

                <tr>
                  <th><label for="register-actor">출연배우 : </label></th>
                  <td><input type="text" title="register-actor"id="register-actor"name="actor"/></td>
                </tr>
                
                <tr>
                  <th><label for="register-film-grade">등  급 : </label></th>
                  <td> 
                        <select class="register-search-grade" name ="film_rate">
                          <option value="">글 분류</option>
                          <option value="전체 관람가">전체 관람가</option>
                          <option value="12세 이상 관람가">12세 이상 관람가</option>
                          <option value="15세 이상 관람가">15세 이상 관람가</option>
                          <option value="청소년 관람불가">청소년 관람불가</option>
                      </select>
                  
                </tr>

				<tr>
                  <th><label for="register-movie_genre">장  르 : </label></th>
                  <td><input type="text"title="장  르" id="register-movie_genre" name="movie_genre"/></td>
                </tr>
                <tr>
                  <th><label for="register-running-time">상영시간 : </label></th>
                  <td><input type="text"title="상영시간" id="register-running-time" name="running_time"/></td>
                </tr>
              
                <tr>
                  <th><label for="register-opening-day">개봉일자 : </label></th>
                  <td  class = "register-screening-date">
                    <input type="date" title="개봉일자" id="register-opening-date"  name="opening_day" required />
                    <label for="register-closing-day">종영일자 : </label>
                    <input type="date" title="종영일자" id="register-closing-date"  name="closing_day" required />
                  </td>
                </tr>

                <tr>
                  <th><label for="register-file">첨부파일 : </label></th>
                  <td><input type="file" title="첨부파일" id="register-file" name="files" required multiple/></td>
                </tr>

                <tr>
                  <th><label for="register-description">줄거리</label></th>
                  <td> <textarea class="register-movietext" name="story" required> </textarea></td>
                </tr>

              </tbody>
            </table>
          </div>

          <div class="register-submit-wapper">
              <button type="submit" class="register-submit-btn">등록</button>
              <input type="reset" class="register-reset-btn"></input>
          </div>

      </form>
    </div>
  </body>
</html>