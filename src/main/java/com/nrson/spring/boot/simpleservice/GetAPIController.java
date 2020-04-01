package com.nrson.spring.boot.simpleservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
/** 
 * Get Request 예제  
 * localhost:8000/api/getRequest 으로 접근시 status 200에 this is getRequest라는 응답 나오는지 확인 
 * @author junyoung
 *
 */

@RestController 		// 여기가 컨트롤러라고 알려주는 RestController 어노테이션 사용 
@RequestMapping("/api") // 여기로 들어올 path를 지정할 @RequstMapping 어노테이션 사용 localhost:8000/api
public class GetAPIController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/getRequest") //localhost:8000/api/getRequest
	public Map<String, String> getRequest()
	{			
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("name", "111"); 
		map.put("age", "111");
		return map;
	}
}
