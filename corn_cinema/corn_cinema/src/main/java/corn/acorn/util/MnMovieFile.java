package corn.acorn.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.acorn.model.MnMovieFileDTO;
import com.acorn.model.MovieViewJoinResultDTO;

public class MnMovieFile {

	public List<MnMovieFileDTO> insertFile(MovieViewJoinResultDTO dto, MultipartFile[] files) 
			throws Exception{
		
		
		List<MnMovieFileDTO> fileList = new ArrayList<MnMovieFileDTO>();
		
		MnMovieFileDTO mnmovieFileDTO = new MnMovieFileDTO();
		
		
		/* 초기값 설정*/
		String movie_num = dto.getMovie_num();
		//관리자 아이디 생성 하며 넣기
		//String admin_id = dto.getAdmin_id(); 이런 느낌
		
		Date today = new Date();  //현재 시간 구하기
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");  // 폴더 이름 (년월일 형식)
		
		String view_name = null;
		String File_Ext = null;  //확장자 처리
		String view_path = null;
		String view_name_key = null;
		
		
		/* 파일 저장 경로 설정 */
		String TempFilePath = "C:\\app2\\temp\\tempfolder";  //임시경로
		String TargetFilePath = "C:/app2/temp/uploadfolder/"+ date.format(today);  //실제 파일 경로
		
		
		if(files != null && files.length > 0) {  // files에 값이 있거나 ㅣlength가 0보다 클때 
			File TempDirFile = new File(TempFilePath);
			File TargetDirFile = new File(TargetFilePath);
			
			//디렉토리가 없으면 생성
			TempDirFile.mkdir();  
			TargetDirFile.mkdirs();  
			
			for(MultipartFile multipartFile : files) {
				
				view_name = multipartFile.getOriginalFilename();  //OriginalFilename
			
				File fileTemp = new File(TempFilePath + "/" + view_name);  //임시 폴더 경로에 originalFilename으로 옮긴다.
				
				multipartFile.transferTo(fileTemp); //우선 임시 폴더로 
				
				if(view_name.lastIndexOf(".") < 0 ) {   //lastIndexOf() 메소드는 특정 문자열이 처음으로 나타내는 위치를 반환 
					return null; 
				} //if
				
				File_Ext = view_name.substring(view_name.lastIndexOf("."));  
				// StringsubString(start) Start 위치부터 끝까지 문자열 자르기 -확장자 짜르기
			
				
				UUID uuid = UUID.randomUUID();
				view_name_key = uuid + File_Ext;  // uuid 범용 고유 식별자를 이용하여 암호화
				
				
				//실제 저장 될 폴더의 경로 + 암호화 된 이름  으로 지정
				File fileTarget = new File(TargetDirFile + "/" + view_name_key);
				
				fileTemp.renameTo(fileTarget);
				
				mnmovieFileDTO = new MnMovieFileDTO();
				
				//1:N 
				mnmovieFileDTO.setMovie_num(movie_num);
				mnmovieFileDTO.setView_name(view_name);
				mnmovieFileDTO.setView_name_key(view_name_key);
				mnmovieFileDTO.setView_path(TargetFilePath);
				/* mnmovieFileDTO.getAdmin_id() // 관리 아이디 추가 예정 */
				
				fileList.add(mnmovieFileDTO);
				
			}  //for
			
		}  //if 
		return fileList;
	}  //insertFile
	
}  //MnMovieFile
