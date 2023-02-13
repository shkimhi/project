/**
 * 
 */
 $(document).ready(function(){
 	$('#prdNoCheckBtn').on('click', function(){
 	//폼이 submit 되지 않도록 기본 기능 중단
 		event.preventDefault();
 		 		
 		// 서버에 전송하고 결과 받아서 처리
 		$.ajax({
 			type:"post",
 			url:"prdNoCheck",
 			data: {"prdNo":$('#prdNo').val()},
 			dataType:'text',
 			success:function(result){
 				if(result == "no_use"){
 					alert("사용할 수 없는 번호입니다.");
 				}else{
 					alert("사용 가능한 번호 입니다.");
 					}
 			},
 			error:function(){
 				alert("실패");
 			},
 			complete:function(){
 				// alert("작업 완료");
 			}
 		}); // ajax 종료 	
 	});// submit 종료
});
